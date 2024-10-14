package igraloptica;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
    private int width, height;

    public Igrac(int width, int height, Scena scena) {
        super(scena.getPreferredSize().width/2, scena.getPreferredSize().height-20, Color.BLUE, scena);
        this.width = width;
        this.height = height;
    }

    @Override
    public void crtaj(Graphics g) {
        g.setColor(color);
        g.fillRect((int)x - width / 2, (int)y - height / 2, width, height);
    }

    public void ispaliLopticu() {
        int radius = height / 2;
        Loptica loptica = new Loptica((int)this.x, (int)this.y - this.height, 10, radius, scena);
        loptica.pokreni();
    }
    @Override
    public void pomeri(double x, double y) {
        if (this.x - width / 2 + x >= 0 && this.x + width / 2 + x <= scena.getWidth()) {
            this.x += x;
            scena.repaint();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String oznakaVrste() {
        return "I";
    }
}
