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
public class GuerreiroTest {
	
	private Guerreiro guerreiro;
	
	@BeforeEach
	void setup() throws Exception {
		guerreiro = new Guerreiro();		
	}
	
	@Test
	void aoSubirDeNivelDeveAumentarAtributosForcaEVidaSobeMais() throws Exception {
		
		guerreiro.lvlUp();
		
		assertAll("Deve retornar os atributos do guerreiro após o lvlUp",
				() -> assertEquals(1, guerreiro.getLevel()),
				() -> assertEquals(3, guerreiro.getForca()),
				() -> assertEquals(2, guerreiro.getInteligencia()),
				() -> assertEquals(2, guerreiro.getMana()),
				() -> assertEquals(3, guerreiro.getVida()));			
	}
	
	@Test
	void deveRetornarOValorDoAttack() throws Exception {	
		mockStatic(GeradorNumeroRandonico.class);
		guerreiro.setForca(10);
		guerreiro.setLevel(10);
		when(GeradorNumeroRandonico.gerarNumeroRandonico()).thenReturn(10);
		
		assertEquals(110, guerreiro.attack());
	}
	
	@Test
	void deveAdicionarUmaHabilidadeAListaDeHabilidades() throws Exception {
		guerreiro.aprenderHabilidade("Espiral");
		
		assertEquals("Espiral", guerreiro.getHabilidade().get(0));
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeDeHabilidadeVaziaNaListaDeMagias() throws Exception {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> guerreiro.aprenderHabilidade(""));
		
		assertEquals("O nome da habilidade não pode ser nulo ou em branco.", exception.getMessage());
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeDeHabilidadeEmBrancoNaListaDeMagias() throws Exception {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> guerreiro.aprenderHabilidade("    "));
		
		assertEquals("O nome da habilidade não pode ser nulo ou em branco.", exception.getMessage());
	}
	
	@Test
	void deveRetornarExceptionAoAdicionarUmNomeNuloNaListaDeHabilidades() throws Exception {
		assertThrows(NullPointerException.class, () -> guerreiro.aprenderHabilidade(null));
	}	

}
