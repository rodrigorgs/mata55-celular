package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

public class Terreno {
	private int largura;
	private int altura;
	private Celula celula;
	private Collection<Entidade> itens = new ArrayList<>();
	
	public Terreno(int largura, int altura) {
		super();
		this.largura = largura;
		this.altura = altura;
		
		celula = new Celula();
	}

	public void desenha(Graphics g) {
		atualiza(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, largura, altura);
		
		celula.desenha(g);
		
		for (Entidade item : itens) {
			item.desenha(g);
		}
	}

	private void atualiza(Graphics g) {	
		criaItensAleatorios();
		processaColisao();
		removeMortos();
	}

	private void processaColisao() {
		for (Entidade item : itens) {
			if (celula.colidiuCom(item)) {
				item.processaColisao(celula);
			}
		}
	}

	private void criaItensAleatorios() {
		double limiar = 0.03;
		if (Math.random() < limiar) {
			Comida comida = new Comida(largura, altura);
			itens.add(comida);
			System.out.println("Nova comida: " + comida);
		}
		if (Math.random() < limiar) {
			Veneno veneno = new Veneno(largura, altura);
			itens.add(veneno);
			System.out.println("Novo veneno: " + veneno);
			
		}
	}

	private void removeMortos() {
		ArrayList<Entidade> paraRemover = new ArrayList<>();
		for (Entidade item : itens) {
			if (!item.isVivo() ) {
				paraRemover.add(item);
			}
		}
		itens.removeAll(paraRemover);
	}
}
