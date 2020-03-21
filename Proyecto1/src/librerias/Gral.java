package librerias;
import java.util.Scanner;


import java.util.ArrayList;

/*
 * Autor: Lucía Lizardi
 * Clave: 181036
 * Versión 2
 * Nota: Gral es la forma de llamar a una persona de la tercera edad. Inspirado en
 * GRaciano y Luis.
 * Clase que define los atributos de una persona mayor.
 * */
public class Gral implements Comparable <Gral>{
	 

	private int id; 
	private static int folio=1000;
	private String nombre; //NOMBRE DEL ADULTO MAYOR
	private int edad; //EDAD DEL ADULTO MAYOR 
	private String genero;
	private String necesitaMedicinas; //SI EL ADULTO NECESITA MEDICAMENTOS
	private String [][] medicinas;//MATRIZ DE MEDICINAS
	private final int DIA=8;//NUMERO DE COLUMNAS DE LA MATRIZ (24 HORAS)
	private final int HORA=25;// NUMERO DE RENGLONES DE LA MATRIZ (7 DÍAS DE LA SEMANA)
	private String cuidadosEspeciales; //SI EL ADULTO NECESITA CUIDADOS ESPECIALES
	private ArrayList<String> cuidE;
	
	
	public Gral() {
		//CADA ADULTO MAYOR "GRAL" TIENE UN FOLIO ÚNICO QUE SE GENERA AUTOMATICAMENTE AUMENTANDO DE 1 EN 1.
		id=folio;	
		folio++;

	}
	
	public Gral(String nombre,String genero, int edad, 	String necesitaMedicinas, String cuidadosEspeciales) {
		this();//SE MANDA A LLAMAR AL CONSTRUCTOR VACÍO QUE GENERA EL FOLIO ÚNICO.
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.cuidadosEspeciales= cuidadosEspeciales;
		cuidadosEspeciales.toUpperCase();
		this.necesitaMedicinas=necesitaMedicinas;
		if(necesitaMedicinas=="SI") { //SE ABRE LA CONDICIÓN Y SI EL USUARIO NECESITA MEDICINAS.
		medicinas= new String[HORA][DIA];//SE INSTANCIA LA MATRIZ DE 7 RENGLONES (DÍAS) Y 12 COLUMNAS (HORAS)
		for(int r=0; r<HORA; r++) { //CICLO QUE RECORRE RENGLONES
			for( int c=0; c<DIA; c++) { // CICLO QUE RECORRE COLUMNAS
				if(c==0) {
					medicinas[r][0]=r+"";
				} 
				if(r==0) {
					medicinas[0][r+1]="L  ";
					medicinas[0][r+2]="  M  ";
					medicinas[0][r+3]="  MI ";
					medicinas[0][r+4]="  J  ";
					medicinas[0][r+5]="  V ";
					medicinas[0][r+6]="  S";
					medicinas[0][r+7]="  D";	
					}
				}
			}
		if(cuidadosEspeciales.equals("SI")) {
			cuidE= new ArrayList<String>();

		}
		} 
		
	}
		

	public String getGenero() {
		return genero;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	
	public int getId() {
		return id;
	}

	public String getNecesitaMedicinas() {
		return necesitaMedicinas;
	}

	public void setNecesitaMedicinas(String necesitaMedicinas) {
		this.necesitaMedicinas = necesitaMedicinas;
	}

	public String getCuidadosEspeciales() {
		return cuidadosEspeciales;
	}

	public void setCuidadosEspeciales(String cuidadosEspeciales) {
		this.cuidadosEspeciales = cuidadosEspeciales;
	}
//Set edad

	public String altaMedicinas(int hr, int dia, String nombremedicinas) {
		String res=". ";
		if(hr<=24 && hr>0) {
			if(dia>0 && dia<=7){
					if(medicinas[hr][dia]==null) {
						medicinas[hr][dia]=nombremedicinas;
						//5 DIC^ hr estaba en hr+1
						res="Se dieron de alta las medicinas";
					}
			}
		}
						return res;

				}

			
	//SI EL USUARIO QUIERE VER SU CALENDARIO DE MEDICINAS COMPLETO
	public String mostrarCalendarioMed() { //SE IMPRIME TODA LA MATRIZ
		String res="";
		for(int ren=0; ren<HORA; ren++) {
			res=res+"\n";
			for(int col=0; col<DIA; col++) {
			res+=medicinas[ren][col]+"  ";	
			}
				
			
				
		} 
		return res;

	}



	public boolean agregarCuidados(String cuidados) {
		boolean res=false;
		if(cuidadosEspeciales.equals("SI")) {
			cuidE.add(cuidados);
			res=true;
		}
		
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
		Gral other = (Gral) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int compareTo(Gral c) {
		return id-c.id;
	}
 
	public String toString() {
		StringBuilder cad= new StringBuilder();
		cad.append("ID: "+id);
		cad.append("\n"+"EL NOMBRE ES: "+nombre);
		cad.append("\n"+"EDAD: "+edad);
		cad.append("\n"+"GENERO: "+genero);
		cad.append("\n"+"NECESITA MEDICINAS: "+necesitaMedicinas);
		cad.append("\n"+"NECESITA CUIDADOS ESPECIALES: "+cuidadosEspeciales);
		cad.append("\n"+"LAS MEDICINAS SON: ");
		if(necesitaMedicinas.equals("SI")){
		cad.append(mostrarCalendarioMed());
		}
		else
			cad.append("SE ESPECIFICÓ QUE NO SERÍAN NECESARIAS MEDICINAS");
		cad.append("\n"+"LOS CUIDADOS ESPECIALES SON: ");
		cad.append(cuidE);
		return cad.toString();
	}
	}
	

	


