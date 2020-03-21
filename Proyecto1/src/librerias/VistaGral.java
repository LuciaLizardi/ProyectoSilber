package librerias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
/*
 * Autor: Lucía Lizardi
 * Clave: 181036
 * Versión 1
 * Vista de la GUI "GRAL"
 * */ 
public class VistaGral extends JFrame {
	
		private ImageIcon ii1;
		private JLabel lbNom, lbGe, lbEd, lbMed, lbCuE, lbIm, lbId,lbMedi, lbHor;
		private JLabel lbDi;
		protected JTextField tfNom, tfEd, tfId, tfMed, tfHor, tfDi;
		protected JComboBox cbGe, cbMed, cbCuE;
		protected JTextArea taRespuestas;
		private String genero[]= {"Femenino","Masculino"};
		private String resp[]= {"SI","NO"}; 
		protected JButton btAlta, btMedAl, btMues, btMed, btCu, btBaja, btAltaCuidados;
 
		 
		public VistaGral(String s) {
			super(s);
			setContentPane(new JLabel(new ImageIcon("fondobueno.jpg")));
			ii1= new ImageIcon("logo4.png");
			lbIm= new JLabel(ii1);
			lbNom= new JLabel("Nombre: ");
			lbNom.setFont(new Font("Century Gothic",1,16));
			tfNom= new JTextField(16);
			lbGe= new JLabel("Género: ");
			lbGe.setFont(new Font("Century Gothic",1,16));
			cbGe= new JComboBox(genero);
			lbEd= new JLabel("Edad: ");
			lbEd.setFont(new Font("Century Gothic",1,16));
			tfEd= new JTextField(3);
			lbMed= new JLabel("¿Requiere Medicinas?: ");
			lbMed.setFont(new Font("Century Gothic",1,16));
			cbMed= new JComboBox(resp);
			lbMedi= new JLabel("Escribe las medicinas: ");
			tfMed= new JTextField(500);
			lbCuE= new JLabel("Requiere Cuidados Especiales: ");
			lbCuE.setFont(new Font("Century Gothic",1,16));
			cbCuE= new JComboBox(resp); 
			taRespuestas= new JTextArea(10,50);
			lbId= new JLabel("ID: ");
			lbId.setFont(new Font("Century Gothic",1,14));
			tfId= new JTextField(16);
			btAlta= new JButton("ALTA");
			btAlta.setBackground((new Color(0,0,0,0)));
			btMedAl= new JButton("ALTA MEDICINAS");
			btMedAl.setFont(new Font("Century Gothic",0,14));
			btMedAl.setBackground((new Color(0,0,0,0)));
			btMues= new JButton("MOSTRAR PERFIL DE USUARIO");
			btMues.setFont(new Font("Century Gothic",0,14));
			btMues.setBackground((new Color(0,0,0,0)));
			//2 DIC. AGREGUÉ
			btCu= new JButton("BUSCA CUIDADOR");
			btCu.setFont(new Font("Century Gothic",0,14));
			//AGREGUE 4 DIC.
			btBaja= new JButton("CANCELAR SUSCRIPCIÓN");
			btBaja.setFont(new Font("Century Gothic",0,14));
			btAltaCuidados= new JButton("ALTA CUIDADOS");
			btAltaCuidados.setFont(new Font("Century Gothic",0,14));


			lbHor= new JLabel("HORA 1-24");
			lbHor.setFont(new Font("Century Gothic",0,14));
			tfHor= new JTextField(2);
			lbDi= new JLabel("DÍA 1-7");
			lbDi.setFont(new Font("Century Gothic",0,14));
			tfDi= new JTextField(1);
			

 
			this.setLayout(new FlowLayout());

			JPanel p= new JPanel();
			p.setLayout(new GridLayout(1,1));
			Border b= BorderFactory.createEmptyBorder(10, 10, 10, 10);
			p.setBorder(b);
			p.add(new JLabel(ii1), BorderLayout.NORTH);
			p.setBackground(new Color(0,0,0,0));

			JPanel p1= new JPanel();
			Border b1= BorderFactory.createEmptyBorder(5, 5, 5, 5);
			p1.setBorder(b1);
			p1.setLayout(new GridLayout(6,2));
			p1.add(lbNom);
			p1.add(tfNom);
			p1.add(lbEd);
			p1.add(tfEd);
			p1.add(lbGe);
			p1.add(cbGe);
			p1.add(lbMed);
			p1.add(cbMed);
			p1.add(lbCuE);
			p1.add(cbCuE);
			p1.add(lbId);
			p1.add(tfId);
			p1.setBackground(new Color(0,0,0,0));
			
			JPanel p2= new JPanel();
			p2.add(taRespuestas);
			p2.add(new JScrollPane(taRespuestas));
			p2.setBackground(new Color(0,0,0,0));

			JPanel p3= new JPanel();
			Border b3= BorderFactory.createEmptyBorder(10, 10, 10, 10);
			p3.setLayout(new GridLayout(3,2));
			p3.setBorder(b3);
			p3.add(btMues);
			p3.add(btCu);
			p3.add(btAltaCuidados);
			p3.add(btMedAl);
			p3.add(btAlta);
			p3.add(btBaja);

			
			JPanel p5= new JPanel();
			p5.setLayout(new GridLayout(2,2));
			p5.add(lbHor);
			p5.add(tfHor);
			p5.add(lbDi);
			p5.add(tfDi);
			p5.setBackground(new Color(0,0,0,0));

			JPanel p6= new JPanel();
			p6.setLayout(new GridLayout(1,1));
			Border b6= BorderFactory.createEmptyBorder(10, 10, 10, 10);
			p6.setBorder(b6);
			p6.setBackground(new Color(0,0,0,0));
			
			this.add(p);
			this.add(p1);
			this.add(p3);
			this.add(p2);
			this.add(p5);
			this.add(p6);
		
			this.setBounds(500,500,670,900);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VistaGral vg= new VistaGral("GRAL");
		
	}

}
