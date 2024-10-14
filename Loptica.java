package igraloptica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Loptica extends AktivnaFigura {
    private int radius;
    private double brzinaX, brzinaY;
    private int periodBrojac;

    public Loptica(int x, int y, int milisek, int radius, Scena scena) {
        super(x, y, Color.GREEN, milisek, scena);
        this.radius = radius;
        //Random rand = new Random();
        this.brzinaX = -1 + Math.random() * 2; 
        this.brzinaY = -Math.random();    
        this.periodBrojac = 0;
    }

    @Override
    public void crtaj(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius, (int)y - radius, 2 * radius, 2 * radius);
    }

    @Override
    protected void azurirajPoziciju() {
        

        if (x - radius < 0 || x + radius > scena.getWidth()) {
            brzinaX = -brzinaX;
        }
        if (y - radius < 0) {
            brzinaY = -brzinaY;
        }

        for (Figura f:scena.getFigure()) {
			if(f instanceof Loptica) {
				continue;
			}else if (f instanceof Igrac) {
				Igrac igrac=(Igrac) f;
				if(Math.abs(this.x+this.radius-igrac.getX()+igrac.getWidth()/2)<=Math.abs(this.brzinaX) && this.brzinaX>0 &&
						this.y>=igrac.getY()-igrac.getHeight()/2 &&
						this.y<=igrac.getY()+igrac.getHeight()/2) {
							
							this.brzinaX=-brzinaX;
				}else if(Math.abs(this.x-this.radius-igrac.getX()-igrac.getWidth()/2)<=Math.abs(this.brzinaX) && this.brzinaX<0 &&
						this.y>=igrac.getY()-igrac.getHeight()/2 &&
						this.y<=igrac.getY()+igrac.getHeight()/2) {
							this.brzinaX=-brzinaX;
				}else if(Math.abs(this.y+this.radius-igrac.getY()+igrac.getHeight()/2)<=Math.abs(this.brzinaY) && this.brzinaY>0 &&
						this.x>=igrac.getX()-igrac.getWidth()/2 &&
						this.x<=igrac.getX()+igrac.getWidth()/2) {
							this.brzinaY=-brzinaY;
				}
				
			}else if (f instanceof Cigla) {
				Cigla cigla = (Cigla) f;
				if(Math.abs(this.y-this.radius-cigla.getY()-cigla.getHeight()/2)<=Math.abs(this.brzinaY) && this.brzinaY<0 &&
						this.x>=cigla.getX()-cigla.getWidth()/2 &&
						this.x<=cigla.getX()+cigla.getWidth()/2) {
							cigla.pogodi();
							this.brzinaY=-brzinaY;
				}else if(Math.abs(this.x+this.radius-cigla.getX()+cigla.getWidth()/2)<=Math.abs(this.brzinaX) && this.brzinaX>0 &&
						this.y>=cigla.getY()-cigla.getHeight()/2 &&
						this.y<=cigla.getY()+cigla.getHeight()/2) {
							cigla.pogodi();
							this.brzinaX=-brzinaX;
				}else if(Math.abs(this.x-this.radius-cigla.getX()-cigla.getWidth()/2)<=Math.abs(this.brzinaX) && this.brzinaX<0 &&
						this.y>=cigla.getY()-cigla.getHeight()/2 &&
						this.y<=cigla.getY()+cigla.getHeight()/2) {
							cigla.pogodi();
							this.brzinaX=-brzinaX;
				}else if(Math.abs(this.y+this.radius-cigla.getY()+cigla.getHeight()/2)<=Math.abs(this.brzinaY) && this.brzinaY>0 &&
						this.x>=cigla.getX()-cigla.getWidth()/2 &&
						this.x<=cigla.getX()+cigla.getWidth()/2) {
							cigla.pogodi();
							this.brzinaY=-brzinaY;
				}
			}
		}
        
        
        if (periodBrojac % 100 == 0) {
            brzinaX *= 1.1;
            brzinaY *= 1.1;
        }
        periodBrojac++;
        this.pomeri(brzinaX, brzinaY);
    }

    @Override
    protected int dohvatiPeriod() {
        return this.vremeCekanja;
    }

    @Override
    public String oznakaVrste() {
        return "L";
    }
}

