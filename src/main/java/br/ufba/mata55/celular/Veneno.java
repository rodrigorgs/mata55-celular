package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Veneno extends Entidade {
	private Cor cor;
	
	public Veneno(int x, int y, int tamanho, Cor cor) {
		super();
		centro = new Ponto(x, y);
		this.tamanho = tamanho;
		this.cor = cor;
	}
	
	public Veneno(int largura, int altura) {
		super();
		int x = (int) (Math.random() * largura);
		int y = (int) (Math.random() * altura);
		centro = new Ponto(x, y);
		tamanho = (int) (5 + Math.random() * 5);
		cor = new Cor(0, 255, 0);
	}

	@Override
	public void processaColisao(Entidade entidade) {
		if (entidade instanceof Celula) {
			entidade.tamanho -= 2;
			setVivo(false);
		}
	}
	
	public void desenha(Graphics g) {
		int x = centro.getX();
		int y = centro.getY();
		g.setColor(new Color(cor.getR(), cor.getG(), cor.getB()));
		g.fillRect(x - tamanho / 2, y - tamanho / 2, tamanho, tamanho);
		g.setColor(new Color(0, 0, 255));
		g.fillOval(x - tamanho / 2, y - tamanho / 2, tamanho, tamanho);
	}
	
	public Cor getCor() {
		return cor;
	}

}
