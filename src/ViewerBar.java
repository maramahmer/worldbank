import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.*;

import javax.swing.BorderFactory;
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
/**
* Create and display bar graph
* @author Group 1 CS2212
*/
public class ViewerBar extends Viewer{
    
    /**
    * @param analysis
    */
    public ViewerBar(Analysis anlys) {
		super(anlys);
	}
    /**
    * sets values based on analysis and draws the bar graph
    * @return chart panel
    */
    public ChartPanel createBar() {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	analysis = getAnalysis();
        int range;

        //depending on analysis type, set the variables
        //single variable bar charts here
        if(analysis instanceof AGEEAnalysis || analysis instanceof FAAnalysis) {
            String dataType;
            
            if(analysis instanceof AGEEAnalysis){
                range = ((AGEEAnalysis)analysis).getGovExpendEdu().getYears().length - 1;
                dataType = ((AGEEAnalysis)analysis).getGovExpendEdu().getDataType();
	                
                int year;
                for(int i = range; i >= 0; i--){
            	 	year = (((AGEEAnalysis)analysis).getGovExpendEdu().getYears())[i]; 
            	    dataset.setValue((((AGEEAnalysis)analysis).getGovExpendEdu().getValues())[i], dataType, "" + year);
	                }
            }

            else{ //Is FAAnalysis
                range = ((FAAnalysis)analysis).getForestArea().getYears().length - 1;
                dataType = ((FAAnalysis)analysis).getForestArea().getDataType();
	
                for(int i = range; i >= 0; i--){
                	dataset.setValue((((FAAnalysis)analysis).getForestArea().getValues())[i], dataType,
            			"" +(((FAAnalysis)analysis).getForestArea().getYears())[i]);
	            }
            }
            //Draw the single variable bar chart
            CategoryPlot plot = new CategoryPlot();
	        BarRenderer barrenderer = new BarRenderer();

	        plot.setDataset(0, dataset);
            plot.setRenderer(0, barrenderer);
	        CategoryAxis domainAxis = new CategoryAxis("Year");
	        plot.setDomainAxis(domainAxis);
	        plot.setRangeAxis(new NumberAxis(""));

            plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
	        
	        JFreeChart barChart = new JFreeChart(dataType,
			new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
           

            ChartPanel chartPanel = new ChartPanel(barChart);
	        chartPanel.setPreferredSize(new Dimension(400, 300));
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        return chartPanel;
           
		}
		//analysis types with two variables, set and draw
		if(analysis instanceof CDGDPAnalysis || analysis instanceof GEECHEAnalysis 
			|| analysis instanceof HBHEAnalysis || analysis instanceof HECMRAnalysis || analysis instanceof PMFAAnalysis){
	        String dataType1, dataType2;
	        
	        if(analysis instanceof CDGDPAnalysis){
	            range = ((CDGDPAnalysis)analysis).getCDEmissions().getYears().length - 1;
	            dataType1 = ((CDGDPAnalysis)analysis).getCDEmissions().getDataType();
	            dataType2 = ((CDGDPAnalysis)analysis).getGDP().getDataType();
	        
	            for(int i = range; i >= 0; i--){ //FIRST SERIES: CDEmissions
	                dataset.setValue((((CDGDPAnalysis)analysis).getCDEmissions().getValues())[i], dataType1, 
	                		"" +((((CDGDPAnalysis)analysis).getCDEmissions().getYears())[i]) );
	                dataset.setValue((((CDGDPAnalysis)analysis).getGDP().getValues())[i], dataType2, 
	                		"" +((((CDGDPAnalysis)analysis).getGDP().getYears())[i]));
	            }

	        }
	    
	        else if(analysis instanceof GEECHEAnalysis){
	            range = ((GEECHEAnalysis)analysis).getGovExpend().getYears().length - 1;
	            dataType1 = ((GEECHEAnalysis)analysis).getGovExpend().getDataType();
	            dataType2 = ((GEECHEAnalysis)analysis).getHealthExpend().getDataType();
	
	            for(int i = range; i >= 0; i--){
	                dataset.setValue((((GEECHEAnalysis)analysis).getGovExpend().getValues())[i], dataType1, 
                    "" + ((((GEECHEAnalysis)analysis).getGovExpend().getYears())[i]));
	                dataset.setValue(((((GEECHEAnalysis)analysis).getHealthExpend().getValues())[i]), dataType2, 
	    	                "" + (((GEECHEAnalysis)analysis).getHealthExpend().getYears())[i]);
	    	            }
	        }
	         
	
	        else if(analysis instanceof HBHEAnalysis){
	            range = ((HBHEAnalysis)analysis).getHospBeds().getYears().length - 1;
	            dataType1 = ((HBHEAnalysis)analysis).getHospBeds().getDataType();
	            dataType2 = ((HBHEAnalysis)analysis).getHealthExpend().getDataType();
	                            
	            for(int i = range; i >= 0; i--){
	                dataset.setValue((((HBHEAnalysis)analysis).getHospBeds().getValues())[i], dataType1, 
	                		"" +((((HBHEAnalysis)analysis).getHospBeds().getYears())[i]));
	                dataset.setValue(((((HBHEAnalysis)analysis).getHealthExpend().getValues())[i]), dataType2, 
	                		""+(((HBHEAnalysis)analysis).getHealthExpend().getYears())[i]);
	            }
	        
	        }
	
	        else if(analysis instanceof HECMRAnalysis){
                range = ((HECMRAnalysis)analysis).getHealthExpendCap().getValues().length - 1;
	            dataType1 = ((HECMRAnalysis)analysis).getHealthExpendCap().getDataType();
	            dataType2 = ((HECMRAnalysis)analysis).getMortalityRate().getDataType();
	            
	            for(int i = range; i >= 0; i--){
	                dataset.setValue(((((HECMRAnalysis)analysis).getHealthExpendCap().getValues())[i]), dataType1, 
	                		""+(((HECMRAnalysis)analysis).getHealthExpendCap().getYears())[i]);
	                dataset.setValue((((HECMRAnalysis)analysis).getMortalityRate().getValues())[i], dataType2,
	                        ""+((((HECMRAnalysis)analysis).getMortalityRate().getYears())[i]));
	            }

	        }
	        
	        else{//PMFAAnalysis
	            range = ((PMFAAnalysis)analysis).getPMPollution().getYears().length - 1;
	            dataType1 = ((PMFAAnalysis)analysis).getPMPollution().getDataType();
	            dataType2 = ((PMFAAnalysis)analysis).getForestArea().getDataType();

	            for(int i = range; i >= 0; i--){
	                dataset.setValue((((PMFAAnalysis)analysis).getPMPollution().getValues())[i], dataType1,
                    ""+((((PMFAAnalysis)analysis).getPMPollution().getYears())[i]));
	                dataset.setValue((((PMFAAnalysis)analysis).getForestArea().getValues())[i], dataType2, 
	                        ""+((((PMFAAnalysis)analysis).getForestArea().getYears())[i]));
	            }
	        }
	
            CategoryPlot plot = new CategoryPlot();
	        BarRenderer barrenderer = new BarRenderer();

	        plot.setDataset(0, dataset);
            plot.setRenderer(0, barrenderer);
	        CategoryAxis domainAxis = new CategoryAxis("Year");
	        plot.setDomainAxis(domainAxis);
	        plot.setRangeAxis(new NumberAxis(""));

            plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
	        
	        JFreeChart barChart = new JFreeChart(dataType1 + " vs " + dataType2,
			new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
           

            ChartPanel chartPanel = new ChartPanel(barChart);
	        chartPanel.setPreferredSize(new Dimension(400, 300));
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        return chartPanel;
	        
	    }
        //analysis type with 3 variables, set and draw
        if(analysis instanceof CDEPMAnalysis){
            range = ((CDEPMAnalysis)analysis).getCO2Data().getYears().length - 1;
            String dataType1, dataType2, dataType3;

            dataType1 = ((CDEPMAnalysis)analysis).getCO2Data().getDataType();
            dataType2 = ((CDEPMAnalysis)analysis).getEnergyUseData().getDataType();
            dataType3 = ((CDEPMAnalysis)analysis).getPMData().getDataType();
            
            for(int i = range; i >= 0; i--){
                dataset.setValue(((((CDEPMAnalysis)analysis).getCO2Data().getValues())[i]), dataType1, 
                		""+(((CDEPMAnalysis)analysis).getCO2Data().getYears())[i]);
                dataset.setValue(((((CDEPMAnalysis)analysis).getEnergyUseData().getValues())[i]), dataType2, 
                		""+(((CDEPMAnalysis)analysis).getEnergyUseData().getYears())[i]);
                dataset.setValue((((CDEPMAnalysis)analysis).getPMData().getValues())[i], dataType3, 
                		""+((((CDEPMAnalysis)analysis).getPMData().getYears())[i]));
            }
         
            CategoryPlot plot = new CategoryPlot();
            BarRenderer barrenderer = new BarRenderer();

            //plotting graph
            plot.setDataset(0, dataset);
            plot.setRenderer(0, barrenderer);
            CategoryAxis domainAxis = new CategoryAxis("Year");
            plot.setDomainAxis(domainAxis);
            plot.setRangeAxis(new NumberAxis(""));

            plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
    
            JFreeChart barChart = new JFreeChart(dataType1 + " vs " + dataType2,
            new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
            
            //setting dimensions and details
            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(400, 300));
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);
            return chartPanel;
        
        }
        
        else{
        	return null;
        }
	}

    

}