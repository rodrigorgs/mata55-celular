package br.ufba.mata55.celular;

import java.awt.Graphics;

public abstract class Entidade {
	protected Ponto centro = new Ponto(0, 0);
	protected int tamanho = 10;
	boolean vivo = true;
	
	public Entidade() {
	}
	
	public Entidade(Ponto ponto, int tamanho) {
		super();
		this.centro = ponto;
		this.tamanho = tamanho;
	}
	
	public boolean colidiuCom(Entidade outra) {
		if (outra == null || outra.centro == null) {
			return false;
		}
		int dx = centro.getX() - outra.centro.getX();
		int dy = centro.getY() - outra.centro.getY();
		int tam = (tamanho + outra.tamanho) / 2;
		
		return dx * dx + dy * dy <= tam * tam;
 	}
	
	public abstract void desenha(Graphics g);
	public void processaColisao(Entidade entidade) {
		
	}

	public Ponto getPonto() {
		return centro;
	}

	public void setPonto(Ponto ponto) {
		this.centro = ponto;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
}
