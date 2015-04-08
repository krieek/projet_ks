package org.istv.main;

import org.istv.gui.Window;
import org.istv.indicateurs.Files;
import org.istv.indicateurs.IndicIhm;
import org.istv.indicateurs.JTableEvents;

public class Main {

	public String st;
	
	public static void main(String[] args) {
		
		//Window window = new Window();
		//window.setVisible(true);
		
		IndicIhm ic = new IndicIhm();		
		ic.setVisible(true);
		
		JTableEvents jt = new JTableEvents();
		jt.dataTable();
		jt.setVisible(true);
		

		JTableEvents jt2 = new JTableEvents();
		jt2.stateTable();
		jt2.setVisible(true);
	}

}
