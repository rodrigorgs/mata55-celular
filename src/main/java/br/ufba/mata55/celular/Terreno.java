package br.ufba.mata55.celular;

import java.util.ArrayList;
import java.util.Collection;

import processing.core.PApplet;

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

	public void desenha(PApplet app) {
		atualiza(app);
		
		app.fill(0, 0, 0);
		app.rect(0, 0, largura, altura);
		
		celula.desenha(app);
		
		for (Entidade item : itens) {
			item.desenha(app);
		}
	}

	private void atualiza(PApplet app) {	
		criaItensAleatorios(app);
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

	private void criaItensAleatorios(PApplet app) {
		if (Math.random() < 0.01) {
			Comida comida = new Comida(app.width, app.height);
			itens.add(comida);
			System.out.println("Nova comida: " + comida);
		}
		if (Math.random() < 0.01) {
			Veneno veneno = new Veneno(app.width, app.height);
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
