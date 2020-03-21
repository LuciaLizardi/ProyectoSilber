package librerias;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//MODIFICAR NECESITA MEDICINAS O CUIDADOS
/*
 * Autor: Lucía Lizardi
 * Clave: 181036
 * Versión 1
 * Controlador de la GUI "VistaGral"
 * */

public class ControladorGral extends VistaGral {
	Silber s= new Silber("55-22-00","silber@gmail.com");	

	
	Scanner archivo;
	int num,edad;
	String res;
	String nombre, recomendable, tel;
						/*LECTURA DE ARCHIVO PARA CUIDADORES:
						 * 
						 */
	{
	try {
		archivo= new Scanner(new File("Cuidadores.txt"));//Se lee el archivo "Cuidadores.txt"
		num=archivo.nextInt();
		for(int i=0; i<num; i++) {
			nombre=archivo.next();
			edad=archivo.nextInt();
			recomendable=archivo.next();
			tel=archivo.next();
			res=s.altaCuid(nombre.toUpperCase(), edad,  recomendable,tel);
			System.out.println("SE DIO DE ALTA"); //Se imprime en la consola si se dierón de alta los cuidadores. 

	}
	}
		catch(FileNotFoundException fnfe) {//Si no se encontró el archivo se manda un  mensaje adecuado.
		System.out.println(fnfe);
		System.exit(-1);
	}
	}
	

	/*Constructor del controlador
	 * aquí se instancian los objetos previamente declarados en la VistaGral
	 * será necesario crear las clases de los "escucha"
	 * */
	public ControladorGral(String titulo) {
		super(titulo);
		btAlta.addActionListener(new EscuchaAlta());
		btCu.addActionListener(new EscuchaCuidador());
		btMues.addActionListener(new EscuchaMuestra());
		btMedAl.addActionListener(new EscuchaMedi());
		btBaja.addActionListener(new EscuchaBaja());
		btAltaCuidados.addActionListener(new EscuchaCuidados());
	}
		
														/*CLASES PARA LOS BOTONES:
														 * Se crean las clases de los escucha con un IMPLEMENTS "ActionListener"
														 * y un actionPerformed para poder instanciarlas en el constructor
														 * */
	
	
	public class EscuchaBaja implements ActionListener{
			/*ESCUCHA BAJA:
			 * Se le da acción al boton btBaja
			 */
		public void actionPerformed(ActionEvent ae) {
			/*
			 * se manda a llamar la función bajaGral de la clase "Silber"
			 * la respuesta se introduce en el JTextArea "taRespuestas"*/
			String res="";
			res=s.bajaGral(Integer.parseInt(tfId.getText()));
			taRespuestas.setText(res);
		}
	}
	
	public class EscuchaAlta implements ActionListener{
		/* ESUCHA ALTA:
		 * Se le impementa acción al boton btAlta
		 */
		public void actionPerformed(ActionEvent ae) {
			/*Se manda a llamar la función altaGral previamente creada en la clase "Silber" Esta función regresa un ID
			 * el cual es generado automáticamente y es entero.
			 * si la respuesta es mayor a 0, en el TextArea "taRespuestas" aparace un mensaje que confirma el alta. 
			 * COMO SERÁ NECESARIO UTILIZAR EL ID PARA LAS DEMÁS FUNCIONES, SE MANDA UN MENSAJE DICIENDO QUE ES IMPORTANTE ANOTAR EL ID.
			 * */
			int res;
			tfId.setText("");
			res=s.altaGral(tfNom.getText(), cbGe.getSelectedItem().toString(), Integer.parseInt(tfEd.getText()), cbMed.getSelectedItem().toString().toUpperCase(), cbCuE.getSelectedItem().toString().toUpperCase());
			if(res>0) {
				taRespuestas.setText("¡Se dio de alta!"+"\n"+"su Id es"+res+"Escriba otros datos para dar a otro usuario de alta."+"\n"+"Recuerde anotar el ID");
				tfId.setText(res+"");
				System.out.println(res);
			}
			else
				taRespuestas.setText("No se pudo dar de alta");
		}
	}
	
	public class EscuchaCuidador implements ActionListener {
		/*ESCUCHA CUIDADOR:
		 * Se le implementa acción al boton btCu
		 * */
		public void actionPerformed(ActionEvent ae) {
			/*La funcionalidad de este botón se da a la función "asignarCuidador" 
			 * previamente definida en la clase "Gral"
			 * esta función imprime los datos de un Cuidador 
			 * estos datos los muestra en el JTextArea "taRespuestas"
			 * Para mayor información sobre la función "asignarCuidador" vaya a la clase Silber
			 * */
			String res1="";
			int res=Integer.parseInt(tfId.getText());
			res1=s.asignarCuidador(res);
			taRespuestas.setText(res1);
		}
	}	
	
	public class EscuchaMuestra implements ActionListener{
		/*ESCUCHA MUESTRA:
		 * se le implementa acción al botón btMues
		 * */
		public void actionPerformed(ActionEvent ae) {
			/*La funcionalidad de este botón es dada por la función encuentraGral previamente definida en la clase "Silber"
			 * Al presionar este botón se imprimirán los datos del adultoMayor en el JTextArea "taRespuestas"
			 * */
			String res=s.encuentraGral(Integer.parseInt(tfId.getText()));
			taRespuestas.setText(res);
		}
	}
	
	public class EscuchaMedi implements ActionListener{
		/*ESCUCHA MEDICINAS:
		 * Se le implementa acción al botón btMedAlta
		 * */
		public void actionPerformed(ActionEvent ae) {
			/*La funcionalidad de este botón es dada por la función altaMedicinas previamente definida en la clase "Silber"
			 * Al presionar este botón se darán de alta medicinas 
			 * LAS CUALES TENDRÁN QUE ESTAR ESCRITAS EN EL JTextArea "taRespuestas" Y SE TENDRÁ QUE ESPECIFICAR EL 
			 * DÍA Y LA HORA QUE SE QUIERAN DAR DE ALTA.
			 * Para mayor información sobre la función altaMedicinas, vaya a la clase "Silber"
			 *
			 * */
			String res;
			int id;
			res=taRespuestas.getText();
			id=Integer.parseInt(tfId.getText());
			s.altaMedicinas(id, Integer.parseInt(tfHor.getText()), Integer.parseInt(tfDi.getText()), res);
			taRespuestas.setText("SE DIERON DE ALTA");
			
		}
	}
	
	public class EscuchaCuidados implements ActionListener{
		/*ESCUCHA CUIDADOS:
		 * Se le implementa acción al botón btAltaCuidados
		 * */
		public void actionPerformed(ActionEvent ae) {
			/*La funcionalidad de este botón es dada por la función agregarCuidados previamente definida en la clase "Silber"
			 * la cual recibe los cuiados como parámetro. 
			 * ES NECESARIO QUE EL USUARIO ESCRIBA LOS CUIDADOS EN EL JTextArea "taRespuestas", la información proporcionada ahí
			 * será el parámetro de la función
			 * Al presionar el botón, se imprime un mensaje que confirma se se dieron de alta los cuidados el cual 
			 * se imprimirá en el JTextArea "taRespuestas"
			 * */
			String cui,res;
			int p;
			cui=taRespuestas.getText();
			res=s.agregarCuidados(cui, Integer.parseInt(tfId.getText()));
			taRespuestas.setText(res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ControladorGral cg= new ControladorGral("FSF");
	}

}
