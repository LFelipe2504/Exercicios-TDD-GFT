package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GerenteTest {
	
	@Test
	void deveCalcularBonificacao() throws Exception {
		Gerente gerente = new Gerente("Lucas", 30, 3000.00);
		
		assertEquals(13000, gerente.bonificacao());		
	}

}
