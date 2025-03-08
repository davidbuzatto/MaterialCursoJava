import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.MathUtils;

/**
 * Projeto do jogo Pong.
 * 
 * @author Prof. Dr. David Buzatto
 * @copyright Copyright (c) 2025
 */
public class Main extends EngineFrame {

    private EstadoJogo estado;

    private Jogador jogador1;
    private Jogador jogador2;
    private Bola bola;

    public Main() {
        super( 600, 400, "Pong", 60, true );
    }

    @Override
    public void create() {
        jogador1 = new Jogador( 40, getScreenHeight() / 2 - 60, 20, 120, WHITE );
        jogador2 = new Jogador( getScreenWidth() - 60, getScreenHeight() / 2 - 60, 20, 120, WHITE );
        bola = new Bola( getScreenWidth() / 2, getScreenHeight() / 2, 15, WHITE );
        estado = EstadoJogo.PARADO;
        setDefaultFontSize( 40 );
    }

    @Override
    public void update( double delta ) {

        if ( isKeyPressed( KEY_ENTER ) ) {
            estado = EstadoJogo.JOGANDO;
        }

        if ( estado != EstadoJogo.PARADO ) {

            jogador1.update( delta, KEY_W, KEY_S, this );
            jogador2.update( delta, KEY_UP, KEY_DOWN, this );
            bola.update( delta, this );

            resolverColisao();

            if ( bola.jogador1Pontou() ) {
                jogador1.pontuar();
                bola.resetar( this );
                estado = EstadoJogo.PARADO;
                bola.configurarVelocidades( 
                    200,
                    MathUtils.getRandomValue( 0, 1 ) == 0 ? 200 : -200
                );
            } else if ( bola.jogador2Pontou() ) {
                jogador2.pontuar();
                bola.resetar( this );
                estado = EstadoJogo.PARADO;
                bola.configurarVelocidades( 
                    -200,
                    MathUtils.getRandomValue( 0, 1 ) == 0 ? 200 : -200
                );
            }

        }

    }

    @Override
    public void draw() {

        clearBackground( BLACK );
        jogador1.draw( this );
        jogador2.draw( this );
        bola.draw( this );

        String placar = String.format( "%d | %d", jogador1.obterPontos(), jogador2.obterPontos() );
        int larguraPlacar = measureText( placar );
        drawText( placar, getScreenWidth() / 2 - larguraPlacar / 2, 20, WHITE );

    }

    private void resolverColisao() {
        
        if ( jogador1.checarColisao( bola ) ) {
            bola.configurarX( jogador1.obterX() + jogador1.obterLargura() + bola.obterRaio() );
            bola.inverterVx();
        } else if ( jogador2.checarColisao( bola ) ) {
            bola.configurarX( jogador2.obterX() - bola.obterRaio() );
            bola.inverterVx();
        }

    }

    public static void main( String[] args ) {
        new Main();
    }

}