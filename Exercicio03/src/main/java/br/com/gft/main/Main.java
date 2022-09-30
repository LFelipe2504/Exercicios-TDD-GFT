package br.com.gft.main;

import br.com.gft.model.Guerreiro;
import br.com.gft.model.Mago;
import br.com.gft.model.Personagem;

public class Main {
	
	public static void main(String[] args) {
		
		Mago m1 = new Mago();
		m1.setNome("Alakazam");
		Guerreiro g1 = new Guerreiro();
		g1.setNome("Kratos");
		
		try {
			m1.aprenderMagia("Ice metal");
			g1.aprenderHabilidade("Dash");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}		
		
		m1.lvlUp();
		m1.lvlUp();
		System.out.println("Mago "+m1);
		System.out.println("O valor do attack do mago "+m1.getNome()+ " é de "+ m1.attack()+".");
		
		System.out.println("---------------------------");
		g1.lvlUp();
		g1.lvlUp();
		System.out.println("Guerreiro " +g1);
		System.out.println("O valor do attack do guerreiro "+g1.getNome()+ " é de "+ g1.attack()+".");
		
		System.out.println("---------------------------");
		
		System.out.println("A quantidade de personagens criados é de: " + Personagem.getPersonagensCriados()+".");
		
		
		
		
		
		
		
	}
}
