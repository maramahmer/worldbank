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
import javax.swing.ScrollPaneConstants;

/**
* Create and display report
* @author Group 1 CS2212
*/
public class ViewerReport extends Viewer{

    /**
    * @param analysis
    */
    public ViewerReport(Analysis anlys){
        super(anlys);
    }

    /**
    * @return JScrollPane to display report
    */
    public JScrollPane createReport() {
            //set dimensions
            JTextArea report = new JTextArea();
            report.setEditable(false);
            report.setSize(400, 300);
            report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            report.setBackground(Color.white);
            String reportMessage;

            //using toString method defined for each analysis, generate report
            reportMessage = analysis.toString();

            //make pane scrollable if needed
            report.setText(reportMessage);
            JScrollPane outputScrollPane = new JScrollPane(report);
            outputScrollPane.setSize(400, 300);
            outputScrollPane.getVerticalScrollBar().setUnitIncrement(10);
            outputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            return outputScrollPane;
    }
}