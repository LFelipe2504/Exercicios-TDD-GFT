package br.com.gft.model; 

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gft.model.Veiculo;

import br.com.gft.exception.QuantidadeDeCombustivelAcimaDaCapacidadeException;
import br.com.gft.exception.QuantidadeDeCombustivelInvalidaException;
import br.com.gft.exception.VeiculoEmMovimentoException;
import br.com.gft.exception.VeiculoEstaDesligadoException;
import br.com.gft.exception.VeiculoEstaLigadoException;
import br.com.gft.exception.VeiculoEstaParadoException;

public class VeiculoTest {
	
	private Veiculo veiculo;
	
	@BeforeEach
	void setup() throws Exception {
		 veiculo = new Veiculo();		
	}
	
	@Test
	void deveAbastecerOVeiculoDentroDaCapacidadeDoTanque() throws Exception {
		veiculo.abastecer(31);
		
		assertEquals(31, veiculo.getLitrosCombustivel());		
	}
	
	@Test
	void deveRetornarExceptionAoTentarAbastecerAcimaDoLimiteDoTanqueDeCombustivel() throws Exception {		
		assertThrows(QuantidadeDeCombustivelAcimaDaCapacidadeException.class, () -> veiculo.abastecer(61));			
	}
	
	@Test
	void deveRetornarExceptionAoTentarAbastecerComValorNegativo() throws Exception {
		assertThrows(QuantidadeDeCombustivelInvalidaException.class,() -> veiculo.abastecer(-10));
	}
	
	@Test
	void deveLigarVeiculoQuandoCarroDesligado() throws Exception {
		veiculo.ligar();
		
		assertTrue(veiculo.getIsLigado());
	}
	
	@Test
	void deveRetornarExceptionAoLigarVeiculoQuandoCarroLigado() throws Exception {
		veiculo.ligar();
		
		assertThrows(VeiculoEstaLigadoException.class,() -> veiculo.ligar());
	}
	
	@Test
	void deveDesligarVeiculoQuandoCarroLigado() throws Exception {
		veiculo.ligar();
		veiculo.desligar();
		
		assertFalse(veiculo.getIsLigado());
	}
	
	@Test
	void deveRetornarExceptionAoDesligarVeiculoQuandoCarroDesligado() throws Exception {		
		assertThrows(VeiculoEstaDesligadoException.class,() -> veiculo.desligar());
	}
	
	@Test
	void deveRetornarExceptionAoDesligarVeiculoEmMovimento() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		
		assertThrows(VeiculoEmMovimentoException.class,() -> veiculo.desligar());
	}
	
	@Test
	void deveAcelerarVeiculoQuandoLigado() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		
		assertEquals(20, veiculo.getVelocidade());
		
	}
	
	@Test
	void deveRetornarExceptionAoAcelerarVeiculoDesligado() throws Exception {
		assertThrows(VeiculoEstaDesligadoException.class,() -> veiculo.acelerar());
	}
	
	@Test
	void deveFrearVeiculoEmMovimento() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.frear();
		
		assertEquals(0, veiculo.getVelocidade());		
	}
	
	@Test
	void deveRetornarExceptionAoFrearVeiculoDesligado() throws Exception {		
		assertThrows(VeiculoEstaDesligadoException.class,() -> veiculo.frear());
	}
	
	@Test
	void deveRetornarExceptionAoFrearVeiculoParado() throws Exception {
		veiculo.ligar();
		
		assertThrows(VeiculoEstaParadoException.class,() -> veiculo.frear());
	}
	
	@Test
	void devePintarOVeiculoComACorPassadaComoParametro() throws Exception {
		veiculo.pintar("Preto");
		
		assertEquals("Preto", veiculo.getCor());		
	}
	 
	@Test
	void deveRetornarExceptionAoPassarNenhumaCorAoPintar() throws Exception {	
		
		Exception exception = assertThrows(IllegalArgumentException.class,() -> veiculo.pintar(""));
		
		assertEquals("A cor não pode ser vazia, em branco ou números.", exception.getMessage());
	}
	
	@Test
	void deveRetornarExceptionAoPassarCorEmBrancoAoPintar() throws Exception {		
		Exception exception = assertThrows(IllegalArgumentException.class,() -> veiculo.pintar("   "));
		
		assertEquals("A cor não pode ser vazia, em branco ou números.", exception.getMessage());
	}
	
	@Test
	void deveRetornarExceptionAoPassarNumerosParaCorAoPintar() throws Exception {		
		Exception exception = assertThrows(IllegalArgumentException.class,() -> veiculo.pintar("123"));
		
		assertEquals("A cor não pode ser vazia, em branco ou números.", exception.getMessage());
	}

}
