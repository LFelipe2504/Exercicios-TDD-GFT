package br.com.gft.main;

import br.com.gft.model.Gerente;
import br.com.gft.model.Supervisor;
import br.com.gft.model.Vendedor;

public class Main {

	public static void main(String[] args) {
		
		Gerente gerente = new Gerente("Daniel", 33, 3000.00);
		Supervisor supervisor = new Supervisor("Fernanda", 29, 2300.00);
		Vendedor vendedor = new Vendedor("Alves", 25, 1800.00);
		
		System.out.println("Funcionário gerente: "+gerente);
		System.out.println("Bonificação: "+gerente.bonificacao());
		
		System.out.println("-----------");
		System.out.println("Funcionário supervisor: "+supervisor);
		System.out.println("Bonificação: "+supervisor.bonificacao());
		
		System.out.println("-----------");
		System.out.println("Funcionário vendedor: "+vendedor);
		System.out.println("Bonificação: "+vendedor.bonificacao());
	}

}

