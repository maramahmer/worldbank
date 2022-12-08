/**
* The class responsible for the main interface the user interacts with and its associated actions
* @author Group 1 CS2212
*/
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MainUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private static MainUI instance;
	private Selection currSelection = new Selection(2000, 2004, "CAN", "AGEE");
    private ComputationalServer computationalServer = ComputationalServer.getInstance(currSelection);
    private Analysis currAnalysis;
	private JComboBox fromList, toList, viewsList, methodsList, countriesList;
	private ChartPanel barPanel, linePanel, timePanel, scatterPanel;
    private JScrollPane reportPanel; 
	private JButton recalculate, addView, removeView;
    private JPanel west, picturePanel;
    private String command, currentView = "Line Chart";
    

	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}
	
    /**
    * @param action event of button pressed
    * depending on button pressed on ui, actions will be preformed
    */
	public void actionPerformed(ActionEvent e) {
		//String command = e.getActionCommand();
		String command;
  
        if (e.getSource() instanceof JButton) {
        	command = e.getActionCommand();
        	
            //If the user selects the recalculate button
            if(command.equals("Recalculate")){
                
		        computationalServer.doSelection(currSelection); //sets results
                currAnalysis = computationalServer.getResults(); //currAnalysis set to populated analysis
                
                System.out.println(currAnalysis.getSelection().getStartYear() + " " + 
                currAnalysis.getSelection().getEndYear() + " " + currAnalysis.getSelection().getCountry() + " "
                + currAnalysis.getSelection().getAnalysisType());
                
    
                west.removeAll();
                west.repaint();
                west.revalidate();
                
                //Creates new graphs for the new analysis
                barPanel = new ViewerBar(currAnalysis).createBar();
                linePanel = new ViewerLine(currAnalysis).createLine();
                scatterPanel = new ViewerScatter(currAnalysis).createScatter();
                timePanel = new ViewerTimeSeries(currAnalysis).createTimeSeries();
                reportPanel = new ViewerReport(currAnalysis).createReport(); 

                //Removes all current graphs from previous analysis
                west.add(timePanel);
        		timePanel.setVisible(false);
        		west.add(barPanel);
        		barPanel.setVisible(false);
        		west.add(linePanel);
        		linePanel.setVisible(false);
        		west.add(scatterPanel);
        		scatterPanel.setVisible(false);
        		west.add(picturePanel);
                west.add(reportPanel);
                reportPanel.setVisible(false);
                
                west.revalidate();
            }

            //If the user selects the add viewer button, add the viewer based on the selection from the drop down menu
            else if(command.equals("+")) {
                if(currentView.equals("Line Chart")) 
                    linePanel.setVisible(true);
                else if (currentView.equals("Bar Chart"))
                    barPanel.setVisible(true);
                else if (currentView.equals("Scatter Chart"))
                    scatterPanel.setVisible(true);
                else if (currentView.equals("Time Series"))
                    timePanel.setVisible(true);
               else if (currentView.equals("Report"))
                    reportPanel.setVisible(true);
            }

            //If the user selects the remove viewer button, remove the viewer based on the selection from the drop down menu
            else if (command.equals("-")){
                if(currentView.equals("Line Chart"))
                    linePanel.setVisible(false);
                else if (currentView.equals("Bar Chart"))
                    barPanel.setVisible(false);
                else if (currentView.equals("Scatter Chart"))
                    scatterPanel.setVisible(false);
                else if (currentView.equals("Time Series"))
                    timePanel.setVisible(false);
                else if (currentView.equals("Report"))
                    reportPanel.setVisible(false);
            }
        }   
	}
	
    //Creates the main interface and its buttons
	private MainUI() {
		// Set window title
		super("Global Statistics");
        
        //initialize the viewer panels
        barPanel = new ViewerBar(new AGEEAnalysis(new Selection(2000, 2004, "CAN", "AGEE"))).createBar();
        linePanel = new ViewerLine(new AGEEAnalysis(new Selection(2000, 2004, "CAN", "AGEE"))).createLine();
        scatterPanel = new ViewerScatter(new AGEEAnalysis(new Selection(2000, 2004, "CAN", "AGEE"))).createScatter();
        timePanel = new ViewerTimeSeries(new AGEEAnalysis(new Selection(2000, 2004, "CAN", "AGEE"))).createTimeSeries();

		//COUNTRY BOX
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");
		Vector<String> countriesNames = new Vector<String>();
		countriesNames.add("Canada");
		countriesNames.add("USA");
		countriesNames.add("France");
		countriesNames.add("China");
		countriesNames.add("Brazil");
        countriesNames.add("Italy");
        countriesNames.add("Uganda");
        countriesNames.add("Japan");
        countriesNames.add("India");
		countriesNames.sort(null);
		
        //sets country selected
        countriesList = new JComboBox<String>(countriesNames);
		countriesList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                command = (String)((JComboBox)e.getSource()).getSelectedItem();
                
                if(command.equals("USA")){
                    currSelection.setCountry("USA");
                }
                else if(command.equals("Canada")){
                    currSelection.setCountry("CAN");
                }
                else if (command.equals("France")){
                    currSelection.setCountry("FRA");
                }
                else if (command.equals("Japan")){
                    currSelection.setCountry("JPN");
                }
                else if (command.equals("Uganda")){
                    currSelection.setCountry("UGA");
                }
                else if (command.equals("Italy")){
                    currSelection.setCountry("ITA");
                }
                else if (command.equals("Brazil")){
                    currSelection.setCountry("BRA");
                }
                else if (command.equals("India")) {
                    currSelection.setCountry("IND");
                }
                else if (command.equals("China")){
                    currSelection.setCountry("CHN");
                }
            }

        });

		
		//START AND END YEAR BOXES
		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");
		Vector<String> years = new Vector<String>();
		for (int i = 2021; i >= 1962; i--) {
			years.add("" + i);
		}
        //sets years selected
		fromList = new JComboBox<String>(years);
		fromList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                command = (String)((JComboBox)e.getSource()).getSelectedItem();
                currSelection.setStartYear(Integer.parseInt(command));    
            }

        });

		toList = new JComboBox<String>(years);
		toList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                command = (String)((JComboBox)e.getSource()).getSelectedItem(); 
                currSelection.setEndYear(Integer.parseInt(command));
            }

        });

		//Add Country box and years to top
		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);
		north.setBackground(Color.white);

		//RECALCULATE BUTTON
		recalculate = new JButton("Recalculate");
		recalculate.addActionListener(this);

		JLabel viewsLabel = new JLabel("Available Views: ");

        //analysis types available
		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chart");
        viewsNames.add("Time Series");
		viewsNames.add("Report");
		viewsList = new JComboBox<String>(viewsNames);
        viewsList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                command = (String)((JComboBox)e.getSource()).getSelectedItem();
                currentView = command;
            }

        });

        //toggle on and off viewers
		addView = new JButton("+");
        addView.addActionListener(this);
		removeView = new JButton("-");
        removeView.addActionListener(this);

		JLabel methodLabel = new JLabel("        Choose analysis method: ");

        //analysis methods available
		Vector<String> methodsNames = new Vector<String>();
		methodsNames.add("Average of Government Expenditure on Education");
		methodsNames.add("CO2 Emissions vs Energy Use vs PM 2.5 Air Pollution");
		methodsNames.add("Ratio of Government Expenditure on Education vs Current Health Expenditure");
		methodsNames.add("Current Health Expenditure per capita vs Mortality Rate");
		methodsNames.add("Average Forest Area");
		methodsNames.add("PM2.5 Air Polloution vs Forest Area");
        methodsNames.add("Ratio of CO2 Emissions vs GDP");
        methodsNames.add("Ratio of Hospital Beds vs Current Health Expenditure");

        //set analysis type according to user selection
		methodsList = new JComboBox<String>(methodsNames);
        methodsList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                command = (String)((JComboBox)e.getSource()).getSelectedItem();
               
                if(command.equals("CO2 Emissions vs Energy Use vs PM 2.5 Air Pollution")) 
                    currSelection.setAnalysisType("CDEPM");
                else if(command.equals("Ratio of Government Expenditure on Education vs Current Health Expenditure"))
                    currSelection.setAnalysisType("GEECHE");
                else if (command.equals("Current Health Expenditure per capita vs Mortality Rate"))
                    currSelection.setAnalysisType("HECMR");
                else if (command.equals("Average of Government Expenditure on Education"))
                    currSelection.setAnalysisType("AGEE");
                else if (command.equals("Ratio of Hospital Beds vs Current Health Expenditure"))
                    currSelection.setAnalysisType("HBHE");
                else if(command.equals("Average Forest Area"))
                    currSelection.setAnalysisType("FA");
                else if (command.equals("PM2.5 Air Polloution vs Forest Area"))
                    currSelection.setAnalysisType("PMFA");
                else if(command.equals("Ratio of CO2 Emissions vs GDP"))
                    currSelection.setAnalysisType("CDGDP");
            }

        });

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);
		south.setBackground(Color.white);

		JPanel east = new JPanel();
		east.setLayout(new GridLayout(2, 0));

		// Set charts region
		west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		
		computationalServer.doSelection(currSelection); //sets results
        currAnalysis = computationalServer.getResults();
        barPanel = new ViewerBar(currAnalysis).createBar();
        linePanel = new ViewerLine(currAnalysis).createLine();
        scatterPanel = new ViewerScatter(currAnalysis).createScatter();
        timePanel = new ViewerTimeSeries(currAnalysis).createTimeSeries();
        reportPanel = new ViewerReport(currAnalysis).createReport();
        
        //PICTURE PANEL
        try {
            BufferedImage image = ImageIO.read(new File("./globe.png"));
            JLabel picture = new JLabel(new ImageIcon(image));
            picturePanel = new JPanel();
            picturePanel.add(picture);
            picturePanel.setPreferredSize(new Dimension(400, 300));
            picturePanel.setBackground(Color.white);
            //picturePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        }
        catch(IOException e) {
        	System.out.println("image not found");
        }

        west.add(timePanel);
		timePanel.setVisible(false);
		west.add(barPanel);
		barPanel.setVisible(false);
		west.add(linePanel);
		linePanel.setVisible(false);
		
		west.add(scatterPanel);
		scatterPanel.setVisible(false);
		west.add(picturePanel);
        west.add(reportPanel);
        reportPanel.setVisible(false);
		
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);
	}


	/**
    * @param bool value
    * if true, toggle visibility of graph on
    * if false, toggle visibility off
    */
	public void toggleVisibility(boolean value) {
		
		JFrame frame = MainUI.getInstance();
		frame.setSize(900, 600);
		frame.pack();
		frame.setVisible(value);
	}

	public static void main(String[] args) {
		
		
		MainUI.getInstance().toggleVisibility(true);
		
	}
	// TODO Auto-generated method stub
}
