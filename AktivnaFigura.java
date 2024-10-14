package igraloptica;

import java.awt.Color;

public abstract class AktivnaFigura extends Figura implements Runnable {
    private Thread thread;
    private boolean works;
    protected int vremeCekanja;

    public AktivnaFigura(int x, int y, Color color, int milisekunde, Scena scena) {
        super(x, y, color, scena);
        this.vremeCekanja = milisekunde;
        this.works = false;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                azurirajPoziciju();
                scena.repaint();
                Thread.sleep(vremeCekanja);
            }
        } catch (InterruptedException e) {
                    }
    }

    protected abstract void azurirajPoziciju();

    public void pokreni() {
    	if(!thread.isAlive()) {
        thread.start();
    	}
    }
    

    public void zaustavi() {
        if (thread != null) {
            works = false;
            thread.interrupt();
            thread = null;
        }
    }

	protected int dohvatiPeriod() {
		return this.vremeCekanja;
	}
}
