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
* Create and display line graph
* @author Group 1 CS2212
*/
public class ViewerLine extends Viewer{
    
    /**
    * @param analysis
    */
    public ViewerLine(Analysis anlys) {
		super(anlys);
	}

    /**
    * sets values based on analysis and draws the line graph
    * @return chart panel
    */
    public ChartPanel createLine() {
    	analysis = getAnalysis();
    	
        //single variable analyses
		if(analysis instanceof AGEEAnalysis || analysis instanceof FAAnalysis) {
				XYSeries series1;
				String dataType;
	        
				if(analysis instanceof AGEEAnalysis){
					int range = ((AGEEAnalysis)analysis).getGovExpendEdu().getYears().length - 1;
					dataType = ((AGEEAnalysis)analysis).getGovExpendEdu().getDataType();
					series1 = new XYSeries(dataType);
	            
		             for(int i = range; i >= 0; i--){
		            	 int year = (((AGEEAnalysis)analysis).getGovExpendEdu().getYears())[i];
		            	 series1.add(year, (((AGEEAnalysis)analysis).getGovExpendEdu().getValues())[i]);  
		             }
				}
	
		        else{
		            int range = ((FAAnalysis)analysis).getForestArea().getYears().length - 1;
		            dataType = ((FAAnalysis)analysis).getForestArea().getDataType();
		            series1 = new XYSeries(((FAAnalysis)analysis).getForestArea().getDataType());
		
		             for(int i = range; i >= 0; i--){
		                series1.add((((FAAnalysis)analysis).getForestArea().getYears())[i], (((FAAnalysis)analysis).getForestArea().getValues())[i]);
		            }
		        }
                
                //return chart panel with drawn chart
		        XYSeriesCollection dataset = new XYSeriesCollection();
		        dataset.addSeries(series1);
		
		        JFreeChart chart = ChartFactory.createXYLineChart(dataType, "", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		        XYPlot plot = chart.getXYPlot();
		        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		        renderer.setSeriesPaint(0, Color.RED);
		        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		
		        plot.setRenderer(renderer);
		        plot.setBackgroundPaint(Color.white);
		        plot.setRangeGridlinesVisible(true);
		        plot.setRangeGridlinePaint(Color.BLACK);
		        plot.setDomainGridlinesVisible(true);
		        plot.setDomainGridlinePaint(Color.BLACK);
		
		        chart.getLegend().setFrame(BlockBorder.NONE);
		
		        chart.setTitle(
				new TextTitle(dataType, new Font("Serif", java.awt.Font.BOLD, 18)));
		
		        ChartPanel chartPanel = new ChartPanel(chart);
		        chartPanel.setPreferredSize(new Dimension(400, 300));
		        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		        chartPanel.setBackground(Color.white);
		        return chartPanel; 
			}
		
        //double variable analyses
		if(analysis instanceof CDGDPAnalysis || analysis instanceof GEECHEAnalysis 
		  || analysis instanceof HBHEAnalysis || analysis instanceof HECMRAnalysis || analysis instanceof PMFAAnalysis){
	        XYSeries series1, series2;
	        String dataType1, dataType2;
	        int range;
	
	        if(analysis instanceof CDGDPAnalysis){
	            range = ((CDGDPAnalysis)analysis).getCDEmissions().getYears().length - 1;
	            dataType1 = ((CDGDPAnalysis)analysis).getCDEmissions().getDataType();
	            dataType2 = ((CDGDPAnalysis)analysis).getGDP().getDataType();
	            series1 = new XYSeries(dataType1);
	            series2 = new XYSeries(dataType2);
	            
	             for(int i = range; i >= 0; i--){ //FIRST SERIES: CDEmissions
	                series1.add(((((CDGDPAnalysis)analysis).getCDEmissions().getYears())[i]), (((CDGDPAnalysis)analysis).getCDEmissions().getValues())[i]);
	                series2.add(((((CDGDPAnalysis)analysis).getGDP().getYears())[i]), (((CDGDPAnalysis)analysis).getGDP().getValues())[i]);
	             }
	        }
	    
	        else if(analysis instanceof GEECHEAnalysis){
	            range = ((GEECHEAnalysis)analysis).getGovExpend().getYears().length - 1;
	            dataType1 = ((GEECHEAnalysis)analysis).getGovExpend().getDataType();
	            dataType2 = ((GEECHEAnalysis)analysis).getHealthExpend().getDataType();
	            series1 = new XYSeries(dataType1);
	            series2 = new XYSeries(dataType2);
	
	            for(int i = range; i >= 0; i--){
	                series1.add(((((GEECHEAnalysis)analysis).getGovExpend().getYears())[i]), 
	                (((GEECHEAnalysis)analysis).getGovExpend().getValues())[i]);
	                series2.add(((((GEECHEAnalysis)analysis).getHealthExpend().getYears())[i]), 
	                        (((GEECHEAnalysis)analysis).getHealthExpend().getValues())[i]);
	            }
	        }
	
	        else if(analysis instanceof HBHEAnalysis){
	            range = ((HBHEAnalysis)analysis).getHospBeds().getYears().length - 1;
	            dataType1 = ((HBHEAnalysis)analysis).getHospBeds().getDataType();
	            dataType2 = ((HBHEAnalysis)analysis).getHealthExpend().getDataType();
	            series1 = new XYSeries(dataType1);
	            series2 = new XYSeries(dataType2);
	                            
	            for(int i = range; i >= 0; i--){
	                series1.add(((((HBHEAnalysis)analysis).getHospBeds().getYears())[i]), 
	                		(((HBHEAnalysis)analysis).getHospBeds().getValues())[i]);
	                series2.add(((((HBHEAnalysis)analysis).getHealthExpend().getYears())[i]), 
	                		(((HBHEAnalysis)analysis).getHealthExpend().getValues())[i]);
	            }
	        
	        }
	
	        else if(analysis instanceof HECMRAnalysis){
	        	range = ((HECMRAnalysis)analysis).getHealthExpendCap().getValues().length - 1;
	            dataType1 = ((HECMRAnalysis)analysis).getHealthExpendCap().getDataType();
	            dataType2 = ((HECMRAnalysis)analysis).getMortalityRate().getDataType();
	            series1 = new XYSeries(dataType1);
	            series2 = new XYSeries(dataType2);
	            
	            for(int i = range; i >= 0; i--){
	                series1.add(((((HECMRAnalysis)analysis).getHealthExpendCap().getYears())[i]), 
	                		(((HECMRAnalysis)analysis).getHealthExpendCap().getValues())[i]);
	                series2.add(((((HECMRAnalysis)analysis).getMortalityRate().getYears())[i]), 
	                		(((HECMRAnalysis)analysis).getMortalityRate().getValues())[i]);
	            }
	        }
	        
	        else{//PMFAAnalysis
	            range = ((PMFAAnalysis)analysis).getPMPollution().getYears().length - 1;
	            dataType1 = ((PMFAAnalysis)analysis).getPMPollution().getDataType();
	            dataType2 = ((PMFAAnalysis)analysis).getForestArea().getDataType();
	            series1 = new XYSeries(dataType1);
	            series2 = new XYSeries(dataType2);
	
	            for(int i = range; i >= 0; i--){
	                series1.add(((((PMFAAnalysis)analysis).getPMPollution().getYears())[i]), 
	                		(((PMFAAnalysis)analysis).getPMPollution().getValues())[i]);
	                series2.add(((((PMFAAnalysis)analysis).getForestArea().getYears())[i]), 
	                		(((PMFAAnalysis)analysis).getForestArea().getValues())[i]);
	            }
	        }

            //return chart panel with drawn chart
	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series1);
	        dataset.addSeries(series2);
	
	        JFreeChart chart = ChartFactory.createXYLineChart(dataType1, dataType2, "", dataset,
	        PlotOrientation.VERTICAL, true, true, false);
	
	        XYPlot plot = chart.getXYPlot();
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
	
	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(Color.white);
	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);
	        plot.setDomainGridlinesVisible(true);
	        plot.setDomainGridlinePaint(Color.BLACK);
	
	        chart.getLegend().setFrame(BlockBorder.NONE);
	
	        chart.setTitle(
	        new TextTitle(dataType1 + " vs " + dataType2, new Font("Serif", java.awt.Font.BOLD, 18)));
	
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setPreferredSize(new Dimension(400, 300));
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        return chartPanel;
	        
	    }
	    
        //triple variable analysis
	    if(analysis instanceof CDEPMAnalysis){
	        int range = ((CDEPMAnalysis)analysis).getCO2Data().getYears().length - 1;
	        XYSeries series1, series2, series3;
	        String dataType1, dataType2, dataType3;
	
	        dataType1 = ((CDEPMAnalysis)analysis).getCO2Data().getDataType();
	        dataType2 = ((CDEPMAnalysis)analysis).getEnergyUseData().getDataType();
	        dataType3 = ((CDEPMAnalysis)analysis).getPMData().getDataType();
	        
	        series1 = new XYSeries(dataType1);
	        series2 = new XYSeries(dataType2);
	        series3 = new XYSeries(dataType3);
	    
	        for(int i = range; i >= 0; i--){
	            series1.add(((((CDEPMAnalysis)analysis).getCO2Data().getYears())[i]), 
	            		(((CDEPMAnalysis)analysis).getCO2Data().getValues())[i]);
	            series2.add(((((CDEPMAnalysis)analysis).getEnergyUseData().getYears())[i]), 
	            		(((CDEPMAnalysis)analysis).getEnergyUseData().getValues())[i]);
	            series3.add(((((CDEPMAnalysis)analysis).getPMData().getYears())[i]), 
	            		(((CDEPMAnalysis)analysis).getPMData().getValues())[i]);
	        }
	            
	        //return chart panel with drawn chart
	        XYSeriesCollection dataset = new XYSeriesCollection();
		    dataset.addSeries(series1);
	        dataset.addSeries(series2);
	        dataset.addSeries(series3);
	
	        XYPlot plot = new XYPlot();
		    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true);
	        renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
	
	        JFreeChart chart = ChartFactory.createXYLineChart(dataType1, dataType2, dataType3, dataset,
	        PlotOrientation.VERTICAL, true, true, false);
	 
	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(Color.white);
	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);
	        plot.setDomainGridlinesVisible(true);
	        plot.setDomainGridlinePaint(Color.BLACK);
	
	        chart.getLegend().setFrame(BlockBorder.NONE);
	
	        chart.setTitle(
	        new TextTitle(dataType1 + " vs " + dataType2 + " vs " + dataType3, new Font("Serif", java.awt.Font.BOLD, 18)));
	
	        ChartPanel chartPanel = new ChartPanel(chart);
		    chartPanel.setPreferredSize(new Dimension(400, 300));
		    chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		    chartPanel.setBackground(Color.white);
		    return chartPanel;
	    
	    }
	    return null; 
    }

}
