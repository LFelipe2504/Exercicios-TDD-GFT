package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VideoGameTest {	

	@Test
	void deveCalcular45PorcentoDeImpostoSobreVideoGameNovo() throws Exception {		
		VideoGame ps4 = new VideoGame("PS4", 1000, 100, "Sony", "Slim", false);
		
		assertEquals(450, ps4.calcularImposto());
	}

	@Test
	void deveCalcular25PorcentoDeImpostoSobreVideoGameUsado() throws Exception {
		VideoGame ps4 = new VideoGame("PS4", 1000, 100, "Sony", "Slim", true);
		
		assertEquals(250, ps4.calcularImposto());
	}

}
