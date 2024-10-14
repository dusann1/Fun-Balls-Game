package igraloptica;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class Scena extends Canvas {
    private ArrayList<Figura> figure;

    public Scena() {
    	setPreferredSize(new Dimension(500,500));
        figure = new ArrayList<>();
    }

    public void dodajFiguru(Figura figura) {
        figure.add(figura);
        repaint();
    }

    public void ukloniFiguru(Figura figura) {
        figure.remove(figura);
        repaint();
    }

    public ArrayList<Figura> getFigure() {
        return figure;
    }

    @Override
    public void paint(Graphics g) {
        for (Figura figura : figure) {
            figura.crtaj(g);
        }
    }

    public void pokreni() {
        for (Figura figura : figure) {
            if (figura instanceof AktivnaFigura) {
                ((AktivnaFigura) figura).pokreni();
            }
        }
    }

    public void zaustavi() {
        for (Figura figura : figure) {
            if (figura instanceof AktivnaFigura) {
                ((AktivnaFigura) figura).zaustavi();
            }
        }
    }
}
