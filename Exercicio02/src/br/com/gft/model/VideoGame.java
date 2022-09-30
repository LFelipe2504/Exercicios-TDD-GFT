package br.com.gft.model;

import java.util.Objects;

public class VideoGame extends Produto {
	
	private String marca;
	private String modelo;
	private boolean isUsado;
	
	public VideoGame() {		
	}
	
	public VideoGame(String nome, double preco, int qtd, String marca, String modelo, boolean isUsado) {
		super(nome, preco, qtd);
		this.marca = marca;
		this.modelo = modelo;
		this.isUsado = isUsado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isUsado() {
		return isUsado;
	}

	public void setUsado(boolean isUsado) {
		this.isUsado = isUsado;
	}	

	@Override
	public double calcularImposto() {
		if(this.isUsado == true)
			return getPreco() * 0.25;
		else
			return getPreco() * 0.45;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(isUsado, marca, modelo);
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
		VideoGame other = (VideoGame) obj;
		return isUsado == other.isUsado && Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString() {
		return "VideoGame [marca=" + marca + ", modelo=" + modelo + ", isUsado=" + isUsado + "]";
	}	
	
	

}
