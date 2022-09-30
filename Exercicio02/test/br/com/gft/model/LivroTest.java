package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LivroTest {	

	@Test
	void deveRetorna0AoCalcularImpostoSobreLivroEducativo() throws Exception {
		Livro livro = new Livro("Livro teste", 40, 50, "teste", "educativo", 300);
		
		assertEquals(0, livro.calcularImposto());
	}

	@Test
	void deveCalcular10PorcentoDeImpostoSobreLivroNaoEducativo() throws Exception {
		Livro livro = new Livro("Livro teste", 40, 50, "teste", "ficção", 300);
		
		assertEquals(4, livro.calcularImposto());
	}

}
