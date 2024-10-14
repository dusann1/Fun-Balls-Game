package igraloptica;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {
    private int width, height;
    private boolean pogodjena;

    public Cigla(int x, int y, int milisek, int width, int height, Scena scena) {
        super(x, y, Color.RED, milisek, scena);
        this.width = width;
        this.height = height;
        this.pogodjena = false;
    }

    @Override
    public void crtaj(Graphics g) {
        g.setColor(pogodjena ? Color.GRAY : color);
        g.fillRect((int)x - width / 2, (int)y - height / 2, width, height);
    }

    @Override
    protected void azurirajPoziciju() {
        if (pogodjena) {
            this.pomeri(0, 5);
            if (y - height / 2 > scena.getHeight()) {
                this.ukloni();
                zaustavi();
            }
        }
    }
    public void pogodi() {
        pogodjena = true;
        scena.repaint();
        
    }

    public boolean isPogodjena() {
        return pogodjena;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String oznakaVrste() {
        return "C";
    }

}
