package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gft.service.GeradorNumeroRandonico;

@ExtendWith(MockitoExtension.class)
public class MagoTest {
	
	private Mago mago;
	
	
	@BeforeEach
	void setup() throws Exception {
		mago = new Mago();				
	}
	
	@Test
	void aoSubirDeNivelDeveAumentarAtributosManaEIntSobeMais() throws Exception {
		
		mago.lvlUp();
		
		assertAll("Deve retornar os atributos do mago após o lvlUp",
				() -> assertEquals(1, mago.getLevel()),
				() -> assertEquals(2, mago.getForca()),
				() -> assertEquals(3, mago.getInteligencia()),
				() -> assertEquals(3, mago.getMana()),
				() -> assertEquals(2, mago.getVida()));		
	}
	
	@Test
	void deveRetornarOValorDoAttack() throws Exception {	
		mockStatic(GeradorNumeroRandonico.class);
		mago.setInteligencia(10);
		mago.setLevel(10);
		when(GeradorNumeroRandonico.gerarNumeroRandonico()).thenReturn(10);
		
		assertEquals(110, mago.attack());		
	}
	
	@Test
	void deveAdicionarUmaMagiaAListaDeMagias() throws Exception {
		mago.aprenderMagia("Zaapts");
		
		assertEquals("Zaapts", mago.getMagia().get(0));
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeDeMagiaVaziaNaListaDeMagias() throws Exception {		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> mago.aprenderMagia(""));
		
		assertEquals("O nome da magia não pode ser nulo ou em branco.", exception.getMessage());
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeDeMagiaEmBrancoNaListaDeMagias() throws Exception {		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> mago.aprenderMagia("    "));
		
		assertEquals("O nome da magia não pode ser nulo ou em branco.", exception.getMessage());
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeNuloNaListaDeMagias() throws Exception {
		assertThrows(NullPointerException.class, () -> mago.aprenderMagia(null));		
	}	

}
