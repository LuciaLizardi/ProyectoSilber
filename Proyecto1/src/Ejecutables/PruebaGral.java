package Ejecutables;

import librerias.Gral;

public class PruebaGral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gral g= new Gral("Mariano", "Masculino", 94, "SI", "NO");
		System.out.println(g.toString());
		System.out.println(g.altaMedicinas(9, 5, "PARACETAMOL"));
		System.out.println(g.agregarCuidados("bañar,comer,cenar"));
		System.out.println(g.toString());
	}

}
