package Ejecutables;

import librerias.ControladorGral;
import librerias.Silber;

public class PruebaSilber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Silber s= new Silber("silber@correo.com","55-00-00");
	System.out.println(s.altaCuid("Jorge", 30, "SI", "55-00"));
	System.out.println(s.altaGral("Mariano", "Masculino", 94, "SI", "SI"));
	System.out.println(s.altaGral("Josefina", "Femenino", 84, "SI", "SI"));

	System.out.println(s.altaGral("Hector", "Perez", 95, "SI", "SI"));
	System.out.println(s.buscaPos(1002));
	System.out.println(s.encuentraGral(1002));
	System.out.println(s.agregarCuidados("asjmas", 1002));
	System.out.println(s.toString());

	
	
	
	
	
	
	}

}


