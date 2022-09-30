package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VendedorTest {
	
	@Test
	void deveCalcularBonificacao() throws Exception {
		Vendedor vendedor = new Vendedor("João", 30, 1800.00);
		
		assertEquals(4800, vendedor.bonificacao());
		
		
	}

}
