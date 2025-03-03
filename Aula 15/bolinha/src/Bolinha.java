import java.awt.Color;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

public class Bolinha {
    
    private double x;
    private double y;
    private double raio;

    private double vx;
    private double vy;
    private double atrito;
    private double elasticidade;
    private boolean arrastando;

    private Color cor;

    private double xAnterior;
    private double yAnterior;

    private double offsetX;
    private double offsetY;

    public Bolinha( 
        double x, double y, double raio, 
        double vx, double vy, double atrito, double elasticidade, 
        Color cor ) {

        this.x = x;
        this.y = y;
        this.raio = raio;
        this.vx = vx;
        this.vy = vy;
        this.atrito = atrito;
        this.elasticidade = elasticidade;
        this.arrastando = false;
        this.cor = cor;

    }

    public void update( double delta, EngineFrame e ) {

        if ( e.isMouseButtonPressed( EngineFrame.MOUSE_BUTTON_LEFT ) ) {

            int xMouse = e.getMouseX();
            int yMouse = e.getMouseY();

            offsetX = xMouse - x;
            offsetY = yMouse - y;

            double cat1 = xMouse - x;
            double cat2 = yMouse - y;
            double dist = cat1 * cat1 + cat2 * cat2;

            if ( dist <= raio * raio ) {
                arrastando = true;
            }

        } else if ( e.isMouseButtonReleased( EngineFrame.MOUSE_BUTTON_LEFT ) ) {
            arrastando = false;
        }

        if ( !arrastando ) {

            x += vx * delta;
            y += vy * delta;

            if ( x + raio > e.getScreenWidth() ) {
                x = e.getScreenWidth() - raio;
                vx = -vx * elasticidade;
            } else if ( x - raio < 0 ) {
                x = raio;
                vx = -vx * elasticidade;
            }

            if ( y + raio > e.getScreenHeight() ) {
                y = e.getScreenHeight() - raio;
                vy = -vy * elasticidade;
            } else if ( y - raio < 0 ) {
                y = raio;
                vy = -vy * elasticidade;
            }

            vx *= atrito;
            vy = vy * atrito + Main.GRAVIDADE * delta;

        } else {

            x = e.getMouseX() - offsetX;
            y = e.getMouseY() - offsetY;

            vx = ( x - xAnterior ) / delta;
            vy = ( y - yAnterior ) / delta;

        }

        xAnterior = x;
        yAnterior = y;

    }

    public void draw( EngineFrame e ) {
        e.fillCircle( x, y, raio, cor );
    }

}
