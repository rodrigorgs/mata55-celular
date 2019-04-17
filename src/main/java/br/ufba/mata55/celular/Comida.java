package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Comida extends Entidade {
	private Cor cor;
	
	public Comida(int largura, int altura) {
		super();
		int x = (int) (Math.random() * largura);
		int y = (int) (Math.random() * altura);
		centro = new Ponto(x, y);
		tamanho = (int) (5 + Math.random() * 5);
		cor = new Cor(0, 255, 0);
	}
	
	public Comida(int x, int y, int tamanho, Cor cor) {
		super();
		centro = new Ponto(x, y);
		this.tamanho = tamanho;
		this.cor = cor;
	}
	
	public void processaColisao(Entidade entidade) {
		if (entidade instanceof Celula) {
			entidade.tamanho++;
			setVivo(false);
		}
	}
	
	public void desenha(Graphics g) {
		g.setColor(new Color(cor.getR(), cor.getG(), cor.getB()));
		g.fillRect(centro.getX() - tamanho / 2, centro.getY() - tamanho / 2, tamanho, tamanho);
	}
	
	public Cor getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "Comida [x=" + centro.getX() + ", y=" + centro.getY() + ", tamanho=" + tamanho + ", cor=" + cor + "]";
	}
}
