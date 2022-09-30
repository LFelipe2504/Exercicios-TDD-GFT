package br.com.gft.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gft.exception.ListaVaziaException;

public class LojaTest {

	private Loja loja;
	private List<Livro> livros;
	private List<VideoGame> games;

	@BeforeEach
	void setup() throws Exception {
		Livro l1 = new Livro("Harry Potter", 40, 50, "J. K. Rowling", "fantasia", 300);
		Livro l2 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);

		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Normal", true);
		VideoGame xbox = new VideoGame("XBOX", 1500, 500, "Microsoft", "One", false);

		livros = new ArrayList<>();
		livros.add(l1);
		livros.add(l2);
		livros.add(l3);

		games = new ArrayList<>();
		games.add(ps4);
		games.add(ps4Usado);
		games.add(xbox);

		loja = new Loja("Americanas", "12345678", livros, games);
	}

	@Test
	void deveRetornarTodosOsLivrosDaLoja() throws Exception {		
		
		List<String> listaParaComparacao = new ArrayList<>();
		listaParaComparacao.add("Harry Potter");
		listaParaComparacao.add("Senhor dos Anéis");
		listaParaComparacao.add("Java POO");

		List<String> nomeLivrosDaListaDeLivros = new ArrayList<>();
		nomeLivrosDaListaDeLivros.add(livros.get(0).getNome());
		nomeLivrosDaListaDeLivros.add(livros.get(1).getNome());
		nomeLivrosDaListaDeLivros.add(livros.get(2).getNome());
		
		assertLinesMatch(listaParaComparacao, nomeLivrosDaListaDeLivros);
	}
	
	@Test
	void deveRetornarMensagemQuandoListaDeLivrosVazia() throws Exception {
		livros.clear();
		
		Exception exception = assertThrows(ListaVaziaException.class,() -> loja.listaLivros());
		
		assertEquals("A loja não tem livros no seu estoque.", exception.getMessage());		
	}
	
	@Test
	void deveRetornarTodosOsVideoGamesDaLoja() throws Exception {		
		
		List<String> listaParaComparacao = new ArrayList<>();
		listaParaComparacao.add("PS4Slim");
		listaParaComparacao.add("PS4Normal");
		listaParaComparacao.add("XBOXOne");

		List<String> nomesVideoGamesDalistaGames = new ArrayList<>();
		nomesVideoGamesDalistaGames.add(games.get(0).getNome()+games.get(0).getModelo());
		nomesVideoGamesDalistaGames.add(games.get(1).getNome()+games.get(1).getModelo());
		nomesVideoGamesDalistaGames.add(games.get(2).getNome()+games.get(2).getModelo());
		
		assertLinesMatch(listaParaComparacao, nomesVideoGamesDalistaGames);
	}
	
	@Test
	void deveRetornarMensagemQuandoListaDeVideoGamesVazia() throws Exception {
		games.clear();
		
		Exception exception = assertThrows(ListaVaziaException.class,() -> loja.listaVideoGames());
		
		assertEquals("A loja não tem vídeo games no seu estoque.", exception.getMessage());		
	}
	
	@Test
	void deveSomarPrecoDeTodosOsProdutosDaLoja() throws Exception {
		assertEquals(941800.00, loja.calculaPatrimonio());		
	}

}
