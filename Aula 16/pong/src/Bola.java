import java.awt.Color;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 * Classe que representa a bola do jogo;
 */
public class Bola {
    
    private double x;
    private double y;
    private double raio;

    private double vx;
    private double vy;

    private boolean pontuou1;
    private boolean pontuou2;

    private Color cor;

    public Bola( double x, double y, double raio, Color cor ) {
        this.x = x;
        this.y = y;
        this.raio = raio;
        this.cor = cor;
        this.vx = 200;
        this.vy = 200;
    }

    public void update( double delta, EngineFrame e ) {

        x += vx * delta;
        y += vy * delta;

        if ( x - raio < 0 ) {
            resetar( e );
            pontuou2 = true;
        } else if ( x + raio > e.getScreenWidth() ) {
            resetar( e );
            pontuou1 = true;
        }

        if ( y - raio < 0 ) {
            y = raio;
            vy = -vy;
        } else if ( y + raio > e.getScreenHeight() ) {
            y = e.getScreenHeight() - raio;
            vy = -vy;
        }

    }

    public void draw( EngineFrame e ) {
        e.fillCircle( x, y, raio, cor );
    }

    public double obterX() {
        return x;
    }

    public double obterY() {
        return y;
    }

    public double obterRaio() {
        return raio;
    }

    public void configurarX( double x ) {
        this.x = x;
    }

    public void configurarVelocidades( double vx, double vy ) {
        this.vx = vx;
        this.vy = vy;
    }

    public void inverterVx() {
        vx = -vx;
    }

    public void resetar( EngineFrame e ) {
        vx = 0;
        vy = 0;
        x = e.getScreenWidth() / 2;
        y = e.getScreenHeight() / 2;
        pontuou1 = false;
        pontuou2 = false;
    }

    public boolean jogador1Pontou() {
        return pontuou1;
    }

    public boolean jogador2Pontou() {
        return pontuou2;
    }

}
