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
	
	Object[] donnee;
	Object[][] donnees;
	
    Vector vecto = new Vector<String>();

    Vector entetes = new Vector<String>();
    
    
    public JTableEvents() {
        super();
 
        setTitle("Indicateur de criticité");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	Files f = new Files();
    	String line;
        line = f.output();
        
        String lines[] = line.split("\n");

        
        for (String str : lines) {
            test1 = str.substring(0, 2);
            test2 = str.substring(3, 5);
            test3 = str.substring(6, 8);
            test4 = str.substring(9, 11);
          
            
            
         //   Object[] donnees = {test1, test2, test3, test4, Sport.TENNIS};
          //  vecto.add(donnees);
            
           
            
            

		}
        
        vecto.add(test1);
        vecto.add(test2);
        vecto.add(test3);
        vecto.add(test4);
 
       // Object[] entet = {"Test1", "Test2", "Test3", "Test4", "Sport"};
        //entetes.add(entet);
        
        
        entetes.add("test1");
        entetes.add("test2");
        entetes.add("test3");
        entetes.add("test4");
        
        
        JTable tableau = new JTable(vecto, entetes);
        		
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
 
        pack();
    }
 
    public static void main(String[] args) {
        new JTableEvents().setVisible(true);
    }
}