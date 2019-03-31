package br.ufba.mata55.celular;

import processing.core.PApplet;

public class Celula {
	private int tamanho = 10;
	private int x;
	private int y;
	
	public void desenha(PApplet app) {
		x = app.mouseX;
		y = app.mouseY;
		
		app.fill(255, 255, 255);
		app.ellipse(x, y, tamanho, tamanho);
	}

	public int getTamanho() {
		return tamanho;
	}
	
	
}
