package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MagoTest {
	
	private Mago mago;
	@Mock
	private Mago magoTestAttack;	
	
	@BeforeEach
	void setup() throws Exception {
		mago = new Mago();		
	}
	
	@Test
	void aoSubirDeNivelDeveAumentarAtributosManaEIntSobeMais() throws Exception {
		
		mago.lvlUp();
		
		assertEquals(1, mago.getLevel()); 
		assertEquals(2, mago.getForca()); 
		assertEquals(3, mago.getInteligencia()); 
		assertEquals(3, mago.getMana()); 
		assertEquals(2, mago.getVida()); 		
	}
	
	@Test
	void deveRetornarOValorDoAttack() throws Exception {	
		when(magoTestAttack.attack()).thenReturn(150);
		assertEquals(150, magoTestAttack.attack());
	}
	
	@Test
	void deveAdicionarUmaMagiaAListaDeMagias() throws Exception {
		mago.aprenderMagia("Zaapts");
		
		assertEquals("Zaapts", mago.getMagia().get(0));
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeDeMagiaVaziaOuEmBrancoNaListaDeMagias() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> mago.aprenderMagia(""));
		assertThrows(IllegalArgumentException.class, () -> mago.aprenderMagia("    "));
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeNuloNaListaDeMagias() throws Exception {
		assertThrows(NullPointerException.class, () -> mago.aprenderMagia(null));
	}	

}
