package com.gft.main; 

import java.util.Scanner;

import com.gft.model.Veiculo;

import br.com.gft.exception.QuantidadeDeCombustivelAcimaDaCapacidadeException;
import br.com.gft.exception.QuantidadeDeCombustivelInvalidaException;
import br.com.gft.exception.VeiculoEstaDesligadoException;
import br.com.gft.exception.VeiculoEstaLigadoException;
import br.com.gft.exception.VeiculoEstaParadoException;

public class Main {

	public static void main(String[] args) {
		Veiculo veiculo = new Veiculo();
		
		System.out.println("\n------------------------------ Teste método abastecer.\n");
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de combustível que deseja abastecer:");
		int combustivel = sc.nextInt();
		
		try {
			veiculo.abastecer(combustivel);
		} catch (QuantidadeDeCombustivelAcimaDaCapacidadeException | QuantidadeDeCombustivelInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("A quantidade de litros de combustível no veículo é de: "+veiculo.getLitrosCombustivel());		
		
		

		System.out.println("\n------------------------------ Teste métodos ligar e desligar.\n");
		
		
		
		
		System.out.println("O veiculo está ligado?\n"+ veiculo.getIsLigado());
		
		try {
			veiculo.ligar();

			veiculo.desligar();
		} catch (VeiculoEstaLigadoException | VeiculoEstaDesligadoException e) {
			System.out.println(e.getMessage());
		}		
		
		System.out.println("\nO veiculo está ligado?\n"+ veiculo.getIsLigado());
		
		
		
		System.out.println("\n------------------------------ Teste métodos acelerar e frear.\n");
		
		
		
		try {
			veiculo.ligar();
			veiculo.acelerar();
			System.out.println("A velocidade do veículo é de: "+veiculo.getVelocidade()+"\n");
			
			veiculo.frear();
			System.out.println("A velocidade do veículo é de: "+veiculo.getVelocidade());
		} catch (VeiculoEstaParadoException | VeiculoEstaDesligadoException | VeiculoEstaLigadoException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("\n------------------------------ Teste método pintar.\n");
		System.out.println("Digite uma cor para pintar o veículo:");
		String cor = sc.next();
		sc.close();	
		
		try {
			veiculo.pintar(cor);
			System.out.println("A cor do veículo é: "+ veiculo.getCor());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}		
		
		

	}

}
