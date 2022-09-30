package br.com.gft.main;

import java.util.ArrayList;
import java.util.List;

import br.com.gft.exception.ListaVaziaException;
import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;

public class Main {
	
	public static void main(String[] args) {
		
		Livro l1 = new Livro("Harry Potter", 40, 50, "J. K. Rowling", "fantasia", 300);
		Livro l2 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);
		
		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		VideoGame xbox = new VideoGame("XBOX", 1500, 500, "Microsoft", "One", false);
		
		List<Livro> livros = new ArrayList<>();
		livros.add(l1);
		livros.add(l2);
		livros.add(l3);
		
		List<VideoGame> games = new ArrayList<>();
		games.add(ps4);
		games.add(ps4Usado);
		games.add(xbox);
		
		Loja americanas = new Loja("Americanas", "12345678", livros, games);
		
		System.out.println("R$ "+l2.calcularImposto()+" de imposto sobre o livro "+l2.getNome()+".");
		System.out.println("R$ "+l3.calcularImposto()+" de imposto sobre o livro "+l3.getNome()+", porque é um livro educativo.");
		
		System.out.println("Imposto sobre o PS4 Slim usado R$ "+ps4Usado.calcularImposto()+"."); ;
		System.out.println("Imposto sobre o PS4 Slim R$ "+ ps4.calcularImposto()+".");
		
		System.out.println("-------------------------------------");		
		System.out.println("A Loja Americanas possui estes livros para venda:");
		try {
			americanas.listaLivros();
		} catch (ListaVaziaException e) {
			System.out.println( e.getMessage());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("A Loja Americanas possui estes video-games para venda:");
		try {
			americanas.listaVideoGames();
		} catch (ListaVaziaException e) {
			System.out.println( e.getMessage());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("O patrimônio da Loja Americanas é de R$ "+ americanas.calculaPatrimonio());
		
		
		
		
	}
	

}
