package br.com.gft.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mago extends Personagem {	

	private List<String> magia = new ArrayList<>();	

	public Mago() {
		super();
	}
	
	public List<String> getMagia() {
		return magia;
	}

	public void setMagia(List<String> magia) {
		this.magia = magia;
	}	
	
	@Override
	public void lvlUp() {
		setLevel(getLevel()+1) ;
		setForca(getForca()+2);
		setInteligencia(getInteligencia()+3);
		setMana(getMana()+3);
		setVida(getVida()+2);	
	}

	public int attack() {
		Random random = new Random();
		int numAleatorio = random.nextInt(301);		
		int ValorDoAttack = (getInteligencia() * getLevel()) + numAleatorio;
		
		return ValorDoAttack;		
	}

	
	public void aprenderMagia(String novaMagia) {
		if(novaMagia.isBlank())
			throw new IllegalArgumentException("O nome da magia não pode ser nulo ou em branco.");
		else 
			magia.add(novaMagia);		
	}

}
