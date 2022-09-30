package br.com.gft.model;

public class Gerente extends Funcionario{

	public Gerente(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}
	
	@Override
	public double bonificacao() {
		return getSalario() + 10000.00; 
	}
	
	

}
