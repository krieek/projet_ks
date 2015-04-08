package org.istv.indicateurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.istv.indicateurs.IndicatorJTable.MyTableCellRenderer;

public class JTableEvents extends JFrame implements Runnable{
	String output;
	
	  public class MyTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

	    	@Override
	        public Component getTableCellRendererComponent(
	           JTable table, Object value, 
	           boolean isSelected, boolean hasFocus, 
	           int row, int col)  
	        {
	           // get the DefaultCellRenderer to give you the basic component
	           Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	           // apply your rules
	           
	           if (value.toString().equals("Succes"))
	               c.setBackground(Color.GREEN);
	           
	           else if (value.toString().equals("Warning"))
	               c.setBackground(Color.YELLOW);
	           else if (value.toString().equals("Critical"))
	              c.setBackground(Color.RED);
	           else  
	              c.setBackground(Color.GRAY);
	           return c;
	        }

	    }
	
	

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
        for (String str : lines) {

            Vector<String> row = new Vector<String>(); 
         	String[] parts = str.split(" ");           
             row.addElement(etat(parts[0]));
             row.addElement(etat(parts[1]));
             row.addElement(etat(parts[2]));
             row.addElement(etat(parts[3]));      

             rowData.addElement(row);
      		}
    	 

    	    return rowData;
         
    }
    
    public Vector listValue()
    {
    	   Vector<Vector> rowData = new Vector<Vector>();
           String lines[] = output.split("\n"); 
           for (String str : lines) {

               Vector<String> row = new Vector<String>();  
            	String[] parts = str.split(" ");
                row.addElement(parts[0]);
                row.addElement(parts[1]);
                row.addElement(parts[2]);
                row.addElement(parts[3]);        
                rowData.addElement(row);
         		}
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

        tableau = new JTable(new DefaultTableModel(rowData, columnNames));
        Enumeration<TableColumn> en = tableau.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new MyTableCellRenderer());
        }
        
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.WEST);
        pack();
    }
    
    public static void main(String[] args) {
        new JTableEvents().setVisible(true);
    }



	@Override
	public void run() {
		while(true)
		{
			
		}
		
	}
	
}