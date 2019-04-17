package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Celula extends Entidade {
	
	public void desenha(Graphics g) {
		// TODO
		centro.setX(Controle.mouseX);
		centro.setY(Controle.mouseY);
		
		g.setColor(Color.WHITE);
		g.fillOval(centro.getX() - tamanho / 2, centro.getY() - tamanho / 2, tamanho, tamanho);
	}

	public int getTamanho() {
		return tamanho;
	}
}
