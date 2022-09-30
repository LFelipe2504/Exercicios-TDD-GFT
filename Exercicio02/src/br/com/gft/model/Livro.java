package br.com.gft.model;

import java.util.Objects;

public class Livro extends Produto {
	
	private String autor;
	private String tema;
	private int qtdPag;
	
	public Livro() {		
	}

	public Livro(String nome, double preco, int qtd, String autor, String tema, int qtdPag) {
		super(nome, preco, qtd);
		this.autor = autor;
		this.tema = tema;
		this.qtdPag = qtdPag;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	@Override
	public double calcularImposto() {
		if(this.tema.compareToIgnoreCase("educativo") == 0)
			return 0;
		else
		return getPreco() * 0.1 ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autor, qtdPag, tema);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(autor, other.autor) && qtdPag == other.qtdPag && Objects.equals(tema, other.tema);
	}

	@Override
	public String toString() {
		return "Livro [autor=" + autor + ", tema=" + tema + ", qtdPag=" + qtdPag + "]";
	}

		
	
	

}
