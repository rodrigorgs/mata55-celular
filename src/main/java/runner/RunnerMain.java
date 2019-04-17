package runner;

import processing.core.PApplet;

public class RunnerMain extends PApplet {
	public static final int LARGURA = 500;
	public static final int ALTURA = 500;
	
	public void settings() {
		size(LARGURA, ALTURA);
	}
	
	@Override
	public void setup() {
		noStroke();
		
	}
	
	@Override
	public void draw() {
	}
	
	public static void main(String[] args) {
		PApplet.main("runner.RunnerMain");
	}
}
