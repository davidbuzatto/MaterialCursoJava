/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meupaint.geom;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Linha extends Forma {

    public Linha( int xIni, int yIni, int xFim, int yFim, Color corContorno ) {
        super( xIni, yIni, xFim, yFim, corContorno, null );
    }

    @Override
    public void desenhar( Graphics2D g2d ) {
        g2d = (Graphics2D) g2d.create();
        g2d.setColor( corContorno );
        g2d.drawLine( xIni, yIni, xFim, yFim );
        g2d.dispose();
    }
    
}
