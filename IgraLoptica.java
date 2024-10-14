package igraloptica;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IgraLoptica extends Frame {
    private Scena scena;
    private Igrac igrac;

    public IgraLoptica() {
        setTitle("Igra Loptica");
        setLocation(600,350);;
        scena = new Scena();
        add(scena);
        igrac = new Igrac( 70, 15, scena);
        pack();
        addCigle();
        addListeners();
        scena.pokreni();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	scena.zaustavi();
                dispose();
            }
        });

        setVisible(true);
    }
    public void addCigle() {
    	new Cigla(51, 11, 10, 100, 20, scena);
        new Cigla(153, 11, 10, 100, 20, scena);
        new Cigla(256, 11, 10, 100, 20, scena);
        new Cigla(359, 11, 10, 100, 20, scena);
        new Cigla(51, 33, 10, 100, 20, scena);
        new Cigla(153, 33, 10, 100, 20, scena);
        new Cigla(256, 33, 10, 100, 20, scena);
            	
    }
    public void addListeners() {
    	scena.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    igrac.pomeri(-10,0);
                    
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    igrac.pomeri(10,0);
                }
            }
        });

        scena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                igrac.ispaliLopticu();
            }
        });
    	
    }

    public static void main(String[] args) {
        new IgraLoptica();
    }
}
