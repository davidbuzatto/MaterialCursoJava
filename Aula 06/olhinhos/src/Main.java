import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 * Modelo para desenvolvimento de exercícios criativos em Java 2D.
 * 
 * @author Prof. Dr. David Buzatto
 * @copyright Copyright (c) 2025
 */
public class Main extends EngineFrame {

    // declaração de variáveis

    // posição central entre os olhos
    double xOlhos;
    double yOlhos;

    // raios das "partes" de cada olho
    double raio;
    double raioIris;
    double raioPupila;

    // centros do olho da esquerda
    double xCentroE;
    double yCentroE;
    double xCentroIrisE;
    double yCentroIrisE;

    // centro do olho da direita
    double xCentroD;
    double yCentroD;
    double xCentroIrisD;
    double yCentroIrisD;

    // ângulos relativos entre a posição do mouse e os centros
    // de cada olho
    double anguloE;
    double anguloD;

    // coordenadas da posição do mouse
    double xMouse;
    double yMouse;

    public Main() {

        // cria a janela do jogo ou simulação
        super( 
            800,                  // 800 pixels de largura
            800,                  // 600 pixels de altura
            "Olhinhos",           // título da janela
            60,                   // 60 quadros por segundo
            true                  // ativa a suavização (antialiasing)
        );

    }

    /**
     * Processa a entrada inicial fornecida pelo usuário e cria
     * e/ou inicializa os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void create() {

        // cálculo dos raios
        raio = 100;
        raioIris = raio * 0.45;
        raioPupila = raioIris * 0.2;

        // coordenada central dos olhos
        xOlhos = getScreenWidth() / 2;
        yOlhos = getScreenHeight() / 2;

        // cálculo da posição dos olhos
        xCentroE = xOlhos - raio - 10;
        yCentroE = yOlhos;

        xCentroD = xOlhos + raio + 10;
        yCentroD = yOlhos;

    }

    /**
     * Atualiza os objetos/contextos/variáveis do jogo ou simulação.
     * O parâmetro delta contém o tempo que passou entre o quadro
     * anterior e o quadro atual.
     */
    @Override
    public void update( double delta ) {

        // obtém a posição do mouse
        xMouse = getMouseX();
        yMouse = getMouseY();

        // calcula os ângulos relativos usando o método
        // atan2
        anguloE = Math.atan2( yMouse - yCentroE, xMouse - xCentroE );
        anguloD = Math.atan2( yMouse - yCentroD, xMouse - xCentroD );
        
        // calcula a posição do centro de cada íris
        xCentroIrisE = xCentroE + ( raio / 2 ) * Math.cos( anguloE );
        yCentroIrisE = yCentroE + ( raio / 2 ) * Math.sin( anguloE );

        xCentroIrisD = xCentroD + ( raio / 2 ) * Math.cos( anguloD );
        yCentroIrisD = yCentroD + ( raio / 2 ) * Math.sin( anguloD );

    }

    /**
     * Desenha o estado dos objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void draw() {

        // limpa o fundo usando a cor branca
        clearBackground( WHITE );

        // desenha o olho da esquerda
        fillCircle( xCentroE, yCentroE, raio, WHITE );
        drawCircle( xCentroE, yCentroE, raio, BLACK );
        fillCircle( xCentroIrisE, yCentroIrisE, raioIris, BLUE );
        drawCircle( xCentroIrisE, yCentroIrisE, raioIris, BLACK );
        fillCircle( xCentroIrisE, yCentroIrisE, raioPupila, BLACK );

        // desenha o olho da direita
        fillCircle( xCentroD, yCentroD, raio, WHITE );
        drawCircle( xCentroD, yCentroD, raio, BLACK );
        fillCircle( xCentroIrisD, yCentroIrisD, raioIris, BLUE );
        drawCircle( xCentroIrisD, yCentroIrisD, raioIris, BLACK );
        fillCircle( xCentroIrisD, yCentroIrisD, raioPupila, BLACK );

    }

    public static void main( String[] args ) {
        new Main();
    }

}