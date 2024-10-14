package igraloptica;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
    protected double x, y;
    protected Color color;
    protected Scena scena;

    public Figura(int x, int y, Color color, Scena scena) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.scena = scena;
        scena.dodajFiguru(this);
    }

    public void ukloni() {
        scena.ukloniFiguru(this);
    }

    public int getX() { return (int) this.x; }
    public int getY() { return (int) this.y; }

    public abstract void crtaj(Graphics g);
    protected void pomeri(double x ,double y) {
    	this.x+=x;
    	this.y+=y;
    };
    public abstract String oznakaVrste();
}


