package br.com.gft.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.gft.model.Pessoa;

public class PessoaService {

	public String devolveONomeDaPessoaMaisVelhaDaLista(List<Pessoa> listaDePessoas) {

		if (listaDePessoas.isEmpty())
			throw new NoSuchElementException("A Lista está vazia.");
		else {
			List<Integer> idades = new ArrayList<>();

			for (Pessoa pessoa : listaDePessoas) {
				idades.add(pessoa.getIdade());
			}

			int maiorIdade = Collections.max(idades);
			String pessoaComMaiorIdade = null;

			for (Pessoa pessoa : listaDePessoas) {
				if (pessoa.getIdade() == maiorIdade)
					pessoaComMaiorIdade = pessoa.getNome();
			}

			return pessoaComMaiorIdade;
		}
	}

	public void removePessoasMenoresDeIdadeDaLista(List<Pessoa> listaDePessoas) {
		if (listaDePessoas.isEmpty())
			throw new NoSuchElementException("A Lista está vazia.");
		else
			listaDePessoas.removeIf(pessoa -> pessoa.getIdade() < 18);

	}

	public boolean consultaSeUmaPessoaEstaNalista(List<Pessoa> listaDePessoas, Pessoa pessoa) {
		if (listaDePessoas.isEmpty())
			throw new NoSuchElementException("A Lista está vazia.");
		else
			return listaDePessoas.contains(pessoa);
	}

}
