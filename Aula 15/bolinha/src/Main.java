import java.awt.Color;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.MathUtils;

/**
 * Projeto da bolinha.
 * 
 * @author Prof. Dr. David Buzatto
 * @copyright Copyright (c) 2025
 */
public class Main extends EngineFrame {

    public static final double GRAVIDADE = 2000;
    private Bolinha[] bolinhas;
    private int quantidade;

    public Main() {
        super( 600, 400, "Bolinha", 60, true );
    }

    @Override
    public void create() {

        bolinhas = new Bolinha[100];
        quantidade = 1;

        bolinhas[0] = new Bolinha( 
            getScreenWidth() / 2,
            getScreenHeight() / 2,
            30,
            200,
            200,
            0.99,
            0.9,
            BLUE 
        );

    }

    @Override
    public void update( double delta ) {
        
        if ( isMouseButtonPressed( MOUSE_BUTTON_RIGHT ) ) {
            if ( quantidade < bolinhas.length ) {
                bolinhas[quantidade++] = new Bolinha( 
                    getMouseX(),
                    getMouseY(),
                    MathUtils.getRandomValue( 10, 40 ),
                    MathUtils.getRandomValue( -200, 200 ),
                    MathUtils.getRandomValue( -200, 200 ),
                    0.99,
                    0.9,
                    new Color( 
                        MathUtils.getRandomValue( 0, 255 ), 
                        MathUtils.getRandomValue( 0, 255 ), 
                        MathUtils.getRandomValue( 0, 255 )
                    )
                );
            }
        }

        for ( int i = 0; i < quantidade; i++ ) {
            bolinhas[i].update( delta, this );
        }

    }

    @Override
    public void draw() {
        for ( int i = 0; i < quantidade; i++ ) {
            bolinhas[i].draw( this );
        }
    }

    public static void main( String[] args ) {
        new Main();
    }

}