package br.ufba.mata55.celular;

import processing.core.PApplet;

public class Terreno {
	private int largura;
	private int altura;
	private Celula celula;
	
	
	public Terreno(int largura, int altura) {
		super();
		this.largura = largura;
		this.altura = altura;
		
		celula = new Celula();
	}

	public void desenha(PApplet app) {
		app.fill(0, 0, 0);
		app.rect(0, 0, largura, altura);
		
		celula.desenha(app);		
	}
}
