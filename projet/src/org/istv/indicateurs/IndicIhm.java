package org.istv.indicateurs;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IndicIhm extends JFrame {

    public IndicIhm() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Indicateurs de criticité");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
            	IndicIhm ex = new IndicIhm();
            	
            	ex.add(new JLabel(new ImageIcon("valid.png")));
            	ex.add(new JLabel(new ImageIcon("red_warn.png")));
            	ex.add(new JLabel(new ImageIcon("yellow_warn.png")));
                ex.setVisible(true);
            }
        });
    }
}