package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

class Painel extends JPanel implements KeyListener, MouseInputListener {
	private static final long serialVersionUID = 1L;

	public static final int LARGURA = 500;
	public static final int ALTURA = 500;

	private Terreno terreno;

	public Painel() {
		terreno = new Terreno(LARGURA, ALTURA);

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	int x = 0;

	public void atualiza() {
		x++;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);
		g.fillRect(x, 10, 20, 12);

		terreno.desenha(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();

		if (keyChar == 27) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Controle.mouseX = e.getX();
		Controle.mouseY = e.getY();
	}
}

public class Main extends JFrame {
	private Painel painel;

	public Main() {
		painel = new Painel();
		painel.setPreferredSize(new Dimension(Painel.LARGURA, Painel.ALTURA));
		add(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(painel);
	}

	private void executa() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Timer timer = new Timer(1000 / 30, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						painel.atualiza();
						painel.repaint();
					}
				});
				timer.start();
			}
		});
	}

	public static void main(String[] args) {
		new Main().executa();
	}
}
