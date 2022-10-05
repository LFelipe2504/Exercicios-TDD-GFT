package br.com.gft.service;

import java.util.Random;

public class GeradorNumeroRandonico {
	
	public static int gerarNumeroRandonico(){
		Random random = new Random();
		return  random.nextInt(301);		
	}

}
