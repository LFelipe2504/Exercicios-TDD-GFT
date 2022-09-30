package br.com.gft.model;

import java.util.List;
import java.util.Objects;

import br.com.gft.exception.ListaVaziaException;

public class Loja {
	
	private String nome;
	private String cnpj;
	private List<Livro> livros;
	private List<VideoGame> videoGames;
	
	public Loja() {		
	}

	public Loja(String nome, String cnpj, List<Livro> livros, List<VideoGame> videoGames) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.livros =  livros;
		this.videoGames = videoGames;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}
	
	public void listaLivros() {
		if(livros.isEmpty())
			throw new ListaVaziaException("A loja não tem livros no seu estoque.");
		else
			for (Livro livro : livros) {
				System.out.println("Título:" + livro.getNome() + ", preço: " + livro.getPreco() + ", quantidade em estoque: " + livro.getQtd() + ".");
			};
	}
	
	public void listaVideoGames(){
		if(videoGames.isEmpty())
			throw new ListaVaziaException("A loja não tem vídeo games no seu estoque.");
		else
			for (VideoGame game : videoGames) {
				System.out.println("Video-game: "+ game.getModelo()+", preço: "+ game.getPreco()+", quantidade em estoque: "+ game.getQtd()+".");				
			};		
	}
	
	public double calculaPatrimonio(){
		
		double valorDosGames = 0, valorDosLivros = 0, valorPatrimonio = 0;
		
		for (Livro livro : livros) {
			valorDosLivros += livro.getPreco() * livro.getQtd();			
		}
		
		for (VideoGame videoGame : videoGames) {
			valorDosGames += videoGame.getPreco() * videoGame.getQtd();
		}
		
		valorPatrimonio = valorDosLivros + valorDosGames;
		
		return valorPatrimonio;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, livros, nome, videoGames);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(livros, other.livros)
				&& Objects.equals(nome, other.nome) && Objects.equals(videoGames, other.videoGames);
	}

	@Override
	public String toString() {
		return "Loja [nome=" + nome + ", cnpj=" + cnpj + ", livros=" + livros + ", videoGames=" + videoGames + "]";
	}
	
	

}
