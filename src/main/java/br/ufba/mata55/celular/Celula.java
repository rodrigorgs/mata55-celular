package br.ufba.mata55.celular;

import processing.core.PApplet;

public class Celula extends Entidade {
	
	public void desenha(PApplet app) {
		centro.setX(app.mouseX);
		centro.setY(app.mouseY);
		
		app.fill(255, 255, 255);
		app.ellipse(centro.getX(), centro.getY(), tamanho, tamanho);
	}

	public int getTamanho() {
		return tamanho;
	}
}
