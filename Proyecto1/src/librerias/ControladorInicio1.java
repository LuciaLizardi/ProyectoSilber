package librerias;
/*
 * Autor: Lucía Lizardi
 * Clave: 181036
 * Versión 2
 * Nota: Controlador de la GUI "VistaInicio1"
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

						/*Clase "ControladorInicio1" que se extiende a la clase "VistaInicio1" 
						 *Esta clase le da funcionalidad a la vista "VistaInicio1"
						 *Es la ventana de "BIENVENIDA" En dónde se da una breve introducción de lo que se puede realizar
						 *con el programa */
						
public class ControladorInicio1 extends VistaInicio1{
	
					/*CONSTRUCTOR DEL CONTROLADOR
					 * Solo se necesitará que un botón tenga funcionalidad; el botón btAlta
			 		* */
	
	public ControladorInicio1(String s) {
		super(s);
		btAlta.addActionListener(new EscuchaAlta()); 	
	}
	

					/*CLASES PARA LOS BOTONES:
				 * Se crean las clases de los escucha con un IMPLEMENTS "ActionListener"
				 * y un actionPerformed para poder instanciarlas en el constructor
				 * */
	
	
	public class EscuchaAlta implements ActionListener{
		/*ESCUCHA ALTA:
		 * Al presionar el botón btAlta, se abrirá una nueva ventana; el ControladorGral, donde podrá proporcionar todos los datos para darse de ata y 
		 * utilizar más funciones
		 * Véase ControladorGral para mayor información*/
		public void actionPerformed(ActionEvent ae) {
			ControladorGral ca= new ControladorGral("ALTA");
			
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorInicio1 ci= new ControladorInicio1("BIENVENIDA");
	}

}
