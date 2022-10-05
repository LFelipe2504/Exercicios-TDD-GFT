package br.com.gft.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gft.service.GeradorNumeroRandonico;

public class Guerreiro extends Personagem {	

	private List<String> habilidades = new ArrayList<>();
	
	public Guerreiro() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public List<String> getHabilidade() {
		return habilidades;
	}

	public void setHabilidade(List<String> habilidade) {
		this.habilidades = habilidade;
	}
	
	@Override
	public void lvlUp() {
		setLevel(getLevel()+1) ;
		setForca(getForca()+3);
		setInteligencia(getInteligencia()+2);
		setMana(getMana()+2);
		setVida(getVida()+3);	
	}
	
	public int attack() {
		int ValorDoAttack = (getForca() * getLevel()) + GeradorNumeroRandonico.gerarNumeroRandonico();		
		return ValorDoAttack;	
		
	}
	
	public void aprenderHabilidade(String novaHabilidade) {
		if(novaHabilidade.isBlank())
			throw new IllegalArgumentException("O nome da habilidade não pode ser nulo ou em branco.");
		else 
			habilidades.add(novaHabilidade);
	}
	

}
