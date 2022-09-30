package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gft.service.PessoaService;

public class PessoaServiceTest {

	private PessoaService pessoaService;
	
	private List<Pessoa> listaDePessoas;

	@BeforeEach
	void setup() {
		pessoaService = new PessoaService();
		
		listaDePessoas = new ArrayList<>();
		
		Pessoa joao = new Pessoa("João", 15);
		Pessoa leandro = new Pessoa("Leandro", 21);
		Pessoa paulo = new Pessoa("Paulo", 17);
		Pessoa jessica = new Pessoa("Jessica", 18);
		
		listaDePessoas.add(joao);
		listaDePessoas.add(leandro);
		listaDePessoas.add(paulo);
		listaDePessoas.add(jessica);
	}

	@Test
	void deveDevolverNomeDaPessoaMaisVelhaDaLista() throws Exception {
		assertEquals("Leandro", pessoaService.devolveONomeDaPessoaMaisVelhaDaLista(listaDePessoas));		
	}

	@Test
	void deveRetornarExceptionAoDevolverNomeDaPessoaMaisVelhaEmUmaListaVazia() {		
		listaDePessoas.clear();
		
		assertThrows(NoSuchElementException.class,() -> pessoaService.devolveONomeDaPessoaMaisVelhaDaLista(listaDePessoas));
	}
	
	@Test
	void deveRemoverPessoasMenoresDeIdadeDaLista() throws Exception {
		pessoaService.removePessoasMenoresDeIdadeDaLista(listaDePessoas);
		
		assertEquals(2, listaDePessoas.size());
	}
	
	@Test
	void deveRetornarExceptionAoRemovePessoasMenoresDeIdadeEmUmaListaVazia() {		
		listaDePessoas.clear();
		
		assertThrows(NoSuchElementException.class,() -> pessoaService.removePessoasMenoresDeIdadeDaLista(listaDePessoas));
	}
	
	@Test
	void deveRetornarTrueAoConsultarUmaPessoaQueEstaNalista() throws Exception {
		Pessoa julia = new Pessoa("julia", 23);
		listaDePessoas.add(julia);
		
		assertTrue(pessoaService.consultaSeUmaPessoaEstaNalista(listaDePessoas, julia));		
	}
	
	@Test
	void deveRetornarFalseAoConsultarUmaPessoaQueNaoEstaNalista() throws Exception {
		Pessoa julia = new Pessoa("julia", 23);
		
		assertFalse(pessoaService.consultaSeUmaPessoaEstaNalista(listaDePessoas, julia));		
	}
	
	@Test
	void deveRetornarExceptionAoConsultarSeUmaPessoaEstaNalistaVazia() {	
		Pessoa julia = new Pessoa("julia", 23);
		listaDePessoas.clear();
		
		assertThrows(NoSuchElementException.class,() -> pessoaService.consultaSeUmaPessoaEstaNalista(listaDePessoas, julia));
	}
	
	

}
