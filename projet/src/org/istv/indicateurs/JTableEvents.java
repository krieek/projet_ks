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
	String output;
	

    @SuppressWarnings("rawtypes")
	public JTableEvents() {
        super();
 
        setTitle("Indicateur de criticité");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	Files f = new Files();
        output = f.output();
        
    }
    
    
    
    public String etat(String value)
    {
    	switch (value) {
		case "0":
			return "Warning";
		case "50":
			return  "Succes";
		case "100":
			return "Critical"; 
		default:
			return "Other"; 

		}
    }
    
    
    public Vector listEtats()
    {

        Vector<Vector> rowData = new Vector<Vector>();
        String lines[] = output.split("\n");
        Vector<String> row = new Vector<String>();   
        for (String str : lines) {
         	String[] parts = str.split(" ");           
             row.addElement(test1);
             row.addElement(test2);
             row.addElement(test3);
             row.addElement(test4);        
      		}
    	 

         rowData.addElement(row);
    	    return rowData;
         
    }
    
    public Vector listValue()
    {
    	   Vector<Vector> rowData = new Vector<Vector>();
           String lines[] = output.split("\n"); 
           Vector<String> row = new Vector<String>();  
           for (String str : lines) {
            	String[] parts = str.split(" ");
                row.addElement(parts[0]);
                row.addElement(parts[1]);
                row.addElement(parts[2]);
                row.addElement(parts[3]);        
         		}
            rowData.addElement(row);
       	    return rowData;	
    }
 
    public Vector listEntetes()
    {
    	 Vector<Vector> rowHeads = new Vector<Vector>();
         Vector<String> row = new Vector<String>();           
              row.addElement("indicateur 1");
              row.addElement("indicateur 2");
              row.addElement("indicateur 3");
              row.addElement("Synthese");        
       		
     	 

          rowHeads.addElement(row);
     	    return row;
    }
    
    public void dataTable()
    {
    	Vector<Vector> rowData = listValue();
    	Vector<Vector> columnNames = listEntetes();
    	
        JTable tableau = new JTable(rowData, columnNames);

        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
        tableau.setBounds(200, 200, 200, 200);
        pack();
    }
    
    
    public void stateTable()
    {
    	Vector<Vector> rowData = listEtats();
    	Vector<Vector> columnNames = listEntetes();
        JTable tableau = new JTable(rowData, columnNames);

        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.WEST);
        tableau.setLocation(50, 250);
        pack();
    }
    
    public static void main(String[] args) {
        new JTableEvents().setVisible(true);
    }
}