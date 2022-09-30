package com.gft.model;

import br.com.gft.exception.QuantidadeDeCombustivelAcimaDaCapacidadeException;
import br.com.gft.exception.QuantidadeDeCombustivelInvalidaException;
import br.com.gft.exception.VeiculoEmMovimentoException;
import br.com.gft.exception.VeiculoEstaDesligadoException;
import br.com.gft.exception.VeiculoEstaLigadoException;
import br.com.gft.exception.VeiculoEstaParadoException;

public class Veiculo {

	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private float km;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;
	private double preco;

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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public boolean getIsLigado() {
		return isLigado;
	}

	public void setIsLigado(boolean isLigado) {
		this.isLigado = isLigado;
	}

	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}

	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void acelerar() {
		if (this.isLigado == true)
			this.velocidade += 20;
		else
			throw new VeiculoEstaDesligadoException("O veículo precisa estar ligado para acelerar.");
	}

	private String calculaQuantidadeParaEncherOTanque() {
		Integer qtdParaTanqueCheio = 60 - this.litrosCombustivel;
		return qtdParaTanqueCheio.toString();
	}

	public void abastecer(int combustivel) {

		if (combustivel <= 0)
			throw new QuantidadeDeCombustivelInvalidaException("Quantidade inválida de combustível!");
		else if (combustivel + this.litrosCombustivel > 0 && combustivel + this.litrosCombustivel <= 60)
			this.litrosCombustivel += combustivel;
		else
			throw new QuantidadeDeCombustivelAcimaDaCapacidadeException(
					"Capacidade do tanque excedida,por favor coloque a" + " quantidade de combustível menor ou igual a "
							+ calculaQuantidadeParaEncherOTanque() + " litros.");
	}

	public void frear() {
		if (getIsLigado() == false)
			throw new VeiculoEstaDesligadoException("O veículo está desligado.");
		else if (this.velocidade < 20)
			throw new VeiculoEstaParadoException("O veículo está parado.");
		else
			this.velocidade -= 20;
	}

	public void pintar(String cor) {
		if (cor.isBlank() | cor.matches("[0-9]*"))
			throw new IllegalArgumentException("A cor não pode ser vazia, em branco ou números.");
		this.cor = cor;
	}

	public void ligar() {
		if (this.isLigado == false)
			this.isLigado = true;
		else
			throw new VeiculoEstaLigadoException("O veículo já está ligado!");
	}

	public void desligar() {
		if (this.isLigado == true)

			if (this.velocidade == 0)
				this.isLigado = false;
			else
				throw new VeiculoEmMovimentoException("O veículo não pode ser desligado em movimento.");
		else
			throw new VeiculoEstaDesligadoException("O veículo já está desligado.");
	}

}
