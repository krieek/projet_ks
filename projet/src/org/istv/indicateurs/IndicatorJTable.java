package org.istv.indicateurs;

import java.awt.Color;
import java.awt.Component;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class IndicatorJTable {

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
    
    
	String test1;
	String test2;
	String test3;
	String test4;

    private JFrame f;
    private JTable table;

    
    protected void initUI() {
        //Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<Vector> data = new Vector<Vector>();
        Vector<String> columNames = new Vector<String>();
        columNames.add("Test1");
        columNames.add("Test2");
        columNames.add("Test3");
        columNames.add("Synthèse");
        

    	Files file = new Files();
    	String line;
        line = file.output();
        
        String lines[] = line.split("\n");
        
        
        
      for (String str : lines) {
        	
        	String[] parts = str.split(" ");
        	
        	switch (parts[0]) {
			case "0":
				test1 = "Warning";
				break;
			case "50":
				test1 = "Succes";
				break;
			case "100":
				test1 = "Critical"; 
				break;				
			default:
				test1 = "Other"; 
				break;
			}
        	
        	switch (parts[1]) {
			case "0":
				test2 = "Warning";
				break;
			case "50":
				test2 = "Succes";
				break;
			case "100":
				test2 = "Critical"; 
				break;				
			default:
				test2 = "Other"; 
				break;
			}
        	
        	switch (parts[2]) {
			case "0":
				test3 = "Warning";
				break;
			case "50":
				test3 = "Succes";
				break;
			case "100":
				test3 = "Critical"; 
				break;				
			default:
				test3 = "Other"; 
				break;
			}

        	switch (parts[3]) {
			case "0":
				test4 = "Warning";
				break;
			case "50":
				test4 = "Succes";
				break;
			case "100":
				test4 = "Critical"; 
				break;				
			default:
				test4 = "Other"; 
				break;
			}
        	
            Vector<String> row = new Vector<String>();
            row.addElement(test1);
            row.addElement(test2);
            row.addElement(test3);
            row.addElement(test4);
            
            data.addElement(row);
      }
        

        
        table = new JTable(new DefaultTableModel(data, columNames));
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new MyTableCellRenderer());
        }
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(table));
        f.pack();
        f.setVisible(true);

 
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new IndicatorJTable().initUI();
            }
        });
    }

}