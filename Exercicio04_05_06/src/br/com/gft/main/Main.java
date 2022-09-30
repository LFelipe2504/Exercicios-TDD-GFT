package br.com.gft.main;

import java.util.ArrayList;
import java.util.List;

import br.com.gft.model.Pessoa;
import br.com.gft.service.PessoaService;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("----------------- Exercício 4 ------------------\n");
		
		
		List<Pessoa> listaDePessoas = new ArrayList<>();
		
		Pessoa joao = new Pessoa("João", 15);
		Pessoa leandro = new Pessoa("Leandro", 21);
		Pessoa paulo = new Pessoa("Paulo", 17);
		Pessoa jessica = new Pessoa("Jessica", 18);

		listaDePessoas.add(joao);
		listaDePessoas.add(leandro);
		listaDePessoas.add(paulo);
		listaDePessoas.add(jessica);
		
		PessoaService pessoaService = new PessoaService();			
		String pessoaMaisVelha = pessoaService.devolveONomeDaPessoaMaisVelhaDaLista(listaDePessoas);
		
		System.out.println("O nome da pessoa mais velha da lista é " + pessoaMaisVelha+".");
		
		
		System.out.println("\n----------------- Exercício 5 ------------------\n");
		
		
		System.out.println("Quantidade de Pessoas na lista antes da exclusão dos menores de 18 anos: "+ listaDePessoas.size()+".");
		
		pessoaService.removePessoasMenoresDeIdadeDaLista(listaDePessoas);	
		
		System.out.println("Quantidade de Pessoas na lista após a exclusão dos menores de 18 anos: "+ listaDePessoas.size()+".");
		
		
		
		System.out.println("\n----------------- Exercício 6 ------------------\n");
		
		System.out.println("A lista contém o objeto 'Jessica' ?\n"+ pessoaService.consultaSeUmaPessoaEstaNalista(listaDePessoas, jessica));
		System.out.println("\nA idade de Jessica é de:");
			System.out.println(jessica.getIdade()+" anos.");
	}

}
