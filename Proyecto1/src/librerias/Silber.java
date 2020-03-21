package librerias;
import java.util.ArrayList;

import librerias.Cuidador;
import librerias.Gral;
/*
 * Autor: Lucía Lizardi

 * Clave: 181036
 * Versión 1
 * Nota: Nombre inspirado de SIlvia y Bertha.
 * Clase que simula un programa en el cual se pueda mantener un control de cuidadores
 * y adultos mayores 
 * 
 * */

public class Silber extends Gral{

	private String tel;
	private String correo;
	private Gral[] usuarios;
	private Cuidador[] cuidadores;
	private final int MAX=50;
	//CONTADORES DE USUARIOS Y CUIDADORES:
	private int numus=0; 
	private int numcu=0;
	
	/*CONSTRUCTORES:
	 * Existe un constructor "Vació" en donde se instancian los arreglos de cuidadores y usuarios.
	 * */

	public Silber() {
	usuarios= new Gral[MAX];
	cuidadores= new Cuidador[MAX];
	
	}

	public Silber(String correo, String tel) {
		this();
		this.correo = correo;
		this.tel = tel;
	}

	//GETTERS Y SETTERS CORRESPONDIENTES
	public int getNumus() {
		return numus;
	}

	public void setNumus(int numus) {
		this.numus = numus;
	}

	public int getNumcu() {
		return numcu;
	}

	public void setNumcu(int numcu) {
		this.numcu = numcu;
	}

	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
													/*FUNCIONES PROPIAS DE LA CLASE:
													 * -Alta Gral (adulto mayor).
													 * -Buscar Posición del adulto mayor
													 * -Baja Gral.
													 * -Alta Cuidador
													 * -Encuentra adulto mayor(utilizando la busqueda de posición)
													 * -Asignar Cuidador a Gral
													 * -Dar de alta medicinas.
													 * -Dar de alta cuidados especiales.
													 * -
													 * */
	
	/*FUNCIÓN ALTA GRAL:
	 *Esta función recibe como parámetro todos los atributos de un Gral menos el ID. 
	 *Lo primero que hace es comprobar que exista espacio en el arreglo de adultos mayores
	 *Después se instancia un nuevo adulto mayor con los atributos proporcionados en los parámetros
	 *Se agrega en el arreglo en la posición que de el contador numus vaya dando
	 *aumenta 1 el contador 
	 *Se regresa el ID generado.
	 * */
	public int altaGral(String nombre,String genero, int edad, String necesitaMedicinas, String cuidadosEsp) {
	int res=-1;
	Gral g;
	if(numus<MAX) {
		g= new Gral(nombre,genero,edad,necesitaMedicinas, cuidadosEsp);
		usuarios[numus]= g;
		numus++;
		res=g.getId();
	}
	return res;
	}
	
	/*FUNCIÓN BUSCAR POSICIÓN:
	 *Esta función recibe como parámetro el ID del adulto mayor que se desea buscar. 
	 *Se inicia la variablre pos con -1,
	 *Por medio de un while, se busca el usuario por Id.
	 *regresa el índice del elemento si lo encontró.
	 * */
	public int buscaPos(int idGral) {
		int pos=-1;
		int i=0;
		while(i<numus && usuarios[i].getId()!=idGral)
			i++;
			if(usuarios[i].getId()==idGral) {
				pos=i;
			}
		return pos;
	}


	/*FUNCIÓN BAJA GRAL:
	 *Esta función recibe como parámetro el ID del adulto mayor que se quiere dar de baja. 
	 *Lo primero que hace es buscar al usuario por medio de la función buscaPos. 
	 *Si la función anterior regresa un número positivo, se elimina al usuario recorriendo a la izquierda el arreglo
	 *Se resta 1 el contador
	 *Se regresa un mensaje si se dio de baja
	 * */
	public String bajaGral(int idGral) {
		String res="*";
		int i;
		i=buscaPos(idGral);		 
				for (int j=i; j<numus; j++) {
						usuarios[j]=usuarios[j+1];
						numus--;
					res="SE DIO DE BAJA";
				}
				return res;

		}

	/*FUNCIÓN ALTA CUIDADOR:
	 *Esta función recibe como parámetro todos los atributos de un Cuidador menos el ID. 
	 *Lo primero que hace es comprobar que exista espacio en el arreglo de cuidadores
	 *Después se instancia un nuevo cuidador con los atributos proporcionados en los parámetros
	 *Se agrega en el arreglo en la posición que de el contador numcu vaya dando
	 *aumenta 1 el contador 
	 *Se regresa el ID generado.
	 * */
	public String altaCuid(String nombre, int edad, String recomendable, String tel) {
		String res="-1";
		Cuidador c;
		if(numcu<MAX) {
			c= new Cuidador(nombre,edad,recomendable,tel);
			cuidadores[numcu]= c;
			numcu++;
			res=c.getId();
		}
		return res;
		}
	
	
	/*FUNCIÓN BUSCA GRAL:
	 *Esta función recibe como parámetro el ID del adulto mayor que se desea encontrar. 
	 *Se utiliza la función buscaPos y se imprimen los datos del adulto mayor buscado.
	 * */
	public String encuentraGral(int idGral) {

		String res="";
		int pos;
		pos=buscaPos(idGral);
		if(pos>=0) {
		res=usuarios[pos].toString();
		}	
		return res;
		
	}
	
	/*FUNCIÓN ASIGNAR CUIDADOR.
	 * Esta función recibe como parámetro el ID del Gral
	 * Se utiliza la función buscaPos.
	 * Si el elemento del arreglo en esa posición no está vacio
	 * se asigna un cuidador que se encuentre en la misma posición pero del arreglo cuidadores.
	 * Se regresa un mensaje adecuado si no existe el usuario
	 * */
	public String asignarCuidador(int idGral) {
		String res="";
		int pos;
		pos=buscaPos(idGral);
			if(pos<MAX && usuarios[pos]!=null) {
				res=cuidadores[pos].toString();
			}
			else
				res="NO EXISTE EL USUARIO, NO SE LE PUEDE ASIGNAR UN CUIDADOR";
			return res;

		}
	
	/*FUNCIÓN ALTA MEDICINAS:
	 * Se recibe como parámetro el ID del adulto mayor; el día, la hora, y el nombre de las medicinas que se quieren dar de alta.
	 * Se utiliza la función buscaPos y se agregan las medicinas a la matriz del elemento (ADULTO MAYOR) que se encuentra en la posición 
	 * dada por la función anterior.
	 * Regresa un mensaje adecuado si se logró dar de alta.
	 * */
	public String altaMedicinas(int id,int hora, int dia, String medicinas) {
		String res="";
		int pos;
		pos=buscaPos(id);
		usuarios[pos].altaMedicinas(hora, dia, medicinas);
		return res;

		}

	/*FUNCIÓN ALTA CUIDADOS ESPECIALES:
	 *Esta función recibe como parámetros los cuidados que se desean agregar y el ID del adulto mayor al que se desea agregar
	 *cuidados especiales
	 *Se busca el adulto por medio de la función buscaPos
	 *Se llama a la función de Gral "agregarCuidados" y si cumple con la condición
	 *se agregan los cuidados al ArrayList del adulto mayor.
	 *Se regresa un mensaje adecuado si se logró dar de alta
	 * */
	public String agregarCuidados(String cuidados, int id) {
		String res="No se pudieron dar de alta los cuidados";
		int i; 
		i=buscaPos(id);
			if(usuarios[i].agregarCuidados(cuidados));
			res="Se dieron de alta";
			return res;

		}
		

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Silber other = (Silber) obj;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		cad.append("****DATOS DE SILBER*****");
		cad.append("\n"+"EL CORREO ES: "+correo);
		cad.append("\n"+"EL TELÉFONO ES: "+tel);
		cad.append("\n");
		cad.append("\n"+"LOS USUARIOS SON: ");
		for(int u=0; u<MAX; u++) { 
			if(usuarios[u]!=null) {
			cad.append("\n");
			cad.append("\n"+usuarios[u].toString());
			}
		}
		cad.append("\n");
		cad.append("\n"+"LOS CUIDADORES SON: ");
		for(int c=0; c<MAX; c++) {
			if(cuidadores[c]!=null)
			cad.append("\n"+cuidadores[c].toString());
		}
		return cad.toString();
	}
	
	}
	
	
	
	
	
	
