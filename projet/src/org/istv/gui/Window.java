package org.istv.gui;

import java.awt.color.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {
	private JPanel contentPane;
	private JSlider sliderParam;
	
	
	
	
	public Window() {
		
		// Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 120, 453, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Jlabel
		JLabel lblAdrMail = new JLabel("Adresse Gmail");
		lblAdrMail.setBounds(10, 11, 88, 14);
		
		//Jslider

		JLabel lslider = new JLabel("Parametre");
		lslider.setBounds(10, 126, 239, 20);
	
		contentPane.add(lslider);
		sliderParam = new JSlider(JSlider.VERTICAL);
		sliderParam.setBounds(108, 15, 23, 209);
		contentPane.add(lslider);
		
		
		
		JButton setupBtn = 	new JButton("Test");
		
		setupBtn.setBounds(338, 438, 89, 23);
		contentPane.add(setupBtn);
	}
	
	
}
