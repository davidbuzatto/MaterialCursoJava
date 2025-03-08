import java.awt.Color;

import br.com.davidbuzatto.jsge.collision.CollisionUtils;
import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.math.Vector2;

/**
 * Classe que representa os jogadores.
 */
public class Jogador {
    
    private static final double VELOCIDADE_MOVIMENTO = 200;

    private double x;
    private double y;
    private double largura;
    private double altura;
    private double vy;
    private int pontos;

    private Color cor;

    public Jogador( double x, double y, double largura, double altura, Color cor ) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.cor = cor;
    }

    public void update( double delta, int teclaCima, int teclaBaixo, EngineFrame e ) {

        if ( e.isKeyDown( teclaCima ) ) {
            vy = -VELOCIDADE_MOVIMENTO;
        } else if ( e.isKeyDown( teclaBaixo ) ) {
            vy = VELOCIDADE_MOVIMENTO;
        } else {
            vy = 0;
        }

        y += vy * delta;

        if ( y < 0 ) {
            y = 0;
        } else if ( y + altura > e.getScreenHeight() ) {
            y = e.getScreenHeight() - altura;
        }

    }

    public void draw( EngineFrame e ) {
        e.fillRectangle( x, y, largura, altura, cor );
    }

    public boolean checarColisao( Bola bola ) {
        return CollisionUtils.checkCollisionCircleRectangle(
            new Vector2( bola.obterX(), bola.obterY() ),
            bola.obterRaio(),
            new Rectangle( x, y, largura, altura ) 
        );
    }

    public double obterX() {
        return x;
    }

    public double obterLargura() {
        return largura;
    }

    public void pontuar() {
        pontos++;
    }

    public int obterPontos() {
        return pontos;
    }

}
