package org.iesalandalus.programacion.damas.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class DireccionTest {
	
	private static final String NOMBRE_NO_VALIDO = "El nombre de la dirección no es válido.";

	@Test
	void nombresValidosDirecciones() {
		assertEquals("Noreste", Direccion.NORESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("Sureste", Direccion.SURESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("Suroeste", Direccion.SUROESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("Noroeste", Direccion.NOROESTE.toString(), NOMBRE_NO_VALIDO);
	}

}
