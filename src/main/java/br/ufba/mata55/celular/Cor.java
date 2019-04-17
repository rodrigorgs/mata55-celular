package br.ufba.mata55.celular;

public class Cor {
	private int r;
	private int g;
	private int b;
	
	public Cor(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Cor [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
	
}
