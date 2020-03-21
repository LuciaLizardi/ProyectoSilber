package librerias;
/*
 * Autor: Lucía Lizardi
 * Clave: 181036
 * Versión 1
 * Nota:Clase que define los atributos métodos y funciones de un cuidador de adultos mayores.
 * */
public class Cuidador implements Comparable<Cuidador> {
	private String nombre;
	private int edad; 
	private String id;
	private static String cont="CU"+0;
	private String tel;
	private String recomendable; //La da el usuario que contrata al cuidador. Se puede cambiar.
	
	
	
	
	public Cuidador(String nombre, int edad,  String recomendable, String tel) {
		this.nombre = nombre;
		this.edad = edad;
		this.recomendable = recomendable;
		this.tel=tel;
		id=cont+this.nombre.substring(0, 2)+edad;
		//El ID se forma con "CU0"+Las primeras 3 letras del nombre del  cuidador y su edad.
		
	}

								//GETTERS Y SETTERS NECESARIOS
	public String getTel() {
		return tel;
	}
	

	public String getRecomendable() {
		return recomendable;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	


	public String getId() {
		return id;
	}

	public int compareTo(Cuidador c) {
		return id.compareTo(c.id);
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuidador other = (Cuidador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public String toString() {
		StringBuilder cad = new StringBuilder();
		cad.append("ID: "+id);
		cad.append("\n"+"El nombre es: "+nombre);
		cad.append("\n"+"Edad: "+edad);
		cad.append("\n"+"Recomendable: "+recomendable);
		cad.append("\n"+"Telefono: "+tel);
		return cad.toString();

	}

	
	
	
}
