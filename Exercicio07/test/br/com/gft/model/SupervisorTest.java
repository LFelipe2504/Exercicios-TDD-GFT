package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SupervisorTest {
	
	@Test
	void deveCalcularBonificacao() throws Exception { 
		Supervisor supervisor = new Supervisor("Luiz", 30, 2500.00);
		
		assertEquals(7500, supervisor.bonificacao());
		
		
	}

}
