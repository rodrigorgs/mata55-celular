package br.ufba.mata55.celular;

import processing.core.PApplet;

public class Main extends PApplet {
	public static final int LARGURA = 500;
	public static final int ALTURA = 500;
	private Terreno terreno;
	
	public void settings() {
		size(LARGURA, ALTURA);
	}
	
	@Override
	public void setup() {
		noStroke();
		
		terreno = new Terreno(LARGURA, ALTURA);
	}
	
	@Override
	public void draw() {
		terreno.desenha(this);
	}
	
	public static void main(String[] args) {
		PApplet.main("br.ufba.mata55.celular.Main");
	}
}
