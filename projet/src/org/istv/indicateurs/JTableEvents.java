package org.istv.indicateurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class JTableEvents extends JFrame {
	String test1;
	String test2;
	String test3;
	String test4;
	

    @SuppressWarnings("rawtypes")
	public JTableEvents() {
        super();
 
        setTitle("Indicateur de criticité");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	Files f = new Files();
    	String line;
        line = f.output();
        
        String lines[] = line.split("\n");

        Vector<Vector> rowData = new Vector<Vector>();
        
        for (String str : lines) {
        	
        	String[] parts = str.split(" ");
        	
            test1 = parts[0];
            test2 = parts[1];
            test3 = parts[2];
            test4 = parts[3];
            
            Vector<String> row = new Vector<String>();
            row.addElement(test1);
            row.addElement(test2);
            row.addElement(test3);
            row.addElement(test4);
            
            rowData.addElement(row);

		}
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Test1");
        columnNames.addElement("Test2");
        columnNames.addElement("Test3");
        columnNames.addElement("Synthèse");
        
        JTable tableau = new JTable(rowData, columnNames);
        
        		
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
 
        pack();
    }
 
    public static void main(String[] args) {
        new JTableEvents().setVisible(true);
    }
}