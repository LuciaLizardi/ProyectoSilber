package librerias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class VistaInicio1 extends JFrame{
	

	private ImageIcon  iiLogo, iiAba, iiAbo;
	private JLabel lbWel, lbTex, lbTex1;
	protected JButton btAlta;
	
	private JPanel p, p1,p2, p3;
	
	public VistaInicio1(String s) {
		super(s); 
		setContentPane(new JLabel(new ImageIcon("fondobueno.jpg")));
		iiLogo= new ImageIcon("logo.png"); 
		iiAba= new ImageIcon("aba1.png");
		iiAbo= new ImageIcon("abo1.png");
		lbWel= new JLabel("Bienvenido a Silber");
		lbWel.setFont(new Font("Century Gothic",0,16));
		lbTex= new JLabel("Aquí podrá llevar un control de sus medicinas");
		lbTex.setFont(new Font("Century Gothic",0,16));
		lbTex1= new JLabel("También podrá tener contacto con un cuidador designado");
		lbTex1.setFont(new Font("Century Gothic",0,16));
		btAlta= new JButton("Darse de Alta");
		btAlta.setFont(new Font("Century Gothic",0,16));

		this.setLayout(new FlowLayout());

		p= new JPanel();
		p.setLayout(new GridLayout(1,1));
		Border b= BorderFactory.createEmptyBorder(5, 5, 5, 5);
		p.setBorder(b);
		p.add(new JLabel(iiLogo), BorderLayout.NORTH);
		p.setBackground(new Color(0,0,0,0));
		
		p1= new JPanel();
		p1.setLayout(new GridLayout(3,1));
		Border b1= BorderFactory.createEmptyBorder(5, 5, 5, 5);
		p1.setBorder(b1);
		p1.add(lbWel);
		p1.add(lbTex);
		p1.add(lbTex1);
		p1.setBackground(new Color(0,0,0,0));

		p2= new JPanel();
		p2.setLayout(new GridLayout(1,1));
		Border b2= BorderFactory.createEmptyBorder(10, 10, 10, 10);
		p2.add(new JLabel(iiAba), BorderLayout.NORTH);
		p2.add(new JLabel(iiAbo), BorderLayout.NORTH);
		p2.setBorder(b2);
		p2.setBackground(new Color(0,0,0,0));

		p3= new JPanel();
		p3.setLayout(new GridLayout(1,1));
		Border b3= BorderFactory.createEmptyBorder(10, 10, 10, 10);
		p3.add(btAlta);

		
		this.add(p);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setBounds(500,500,500,470);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VistaInicio1 vc= new VistaInicio1("CUIDADOR");
	}

}
