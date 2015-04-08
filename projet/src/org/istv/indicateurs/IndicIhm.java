package org.istv.indicateurs;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IndicIhm extends JFrame {

    public IndicIhm() {

        initUI();
    }

    private void initUI() {
    	
        setTitle("Indicateurs de criticité");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        setLayout(new FlowLayout());

        JPanel pnl_date = new JPanel();
        JLabel lbl_date = new JLabel("X");
        pnl_date.add(lbl_date);
        add(pnl_date);


        JPanel pnl_activities = new JPanel();
        JLabel lbl_act = new JLabel("Y");
        pnl_activities.add(lbl_act);
        add(pnl_activities);
        
        
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
            	IndicIhm ex = new IndicIhm();
            	Files f = new Files();
            	String line;
                line = f.output();
                
            	JLabel jlbLabel1;
            	jlbLabel1 = new JLabel(line, new ImageIcon("yellow_warn.png"), JLabel.CENTER);
            	
            	
            	ex.add(new JLabel(new ImageIcon("valid.png")));
            	ex.add(jlbLabel1);
                ex.setVisible(true);
                
        		

            }
        });
    }
}