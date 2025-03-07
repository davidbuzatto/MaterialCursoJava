/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meupaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import meupaint.geom.Forma;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class PainelDesenho extends JPanel {

    private Forma formaTemp;
    private List<Forma> formas;
    
    public PainelDesenho() {
        formas = new ArrayList<>();
    }
    
    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        g2d.setColor( Color.WHITE );
        g2d.fillRect( 0, 0, getWidth(), getHeight() );
        
        for ( Forma forma : formas ) {
            forma.desenhar( g2d );
        }
        
        if ( formaTemp != null ) {
            formaTemp.desenhar( g2d );
        }
        
        g2d.dispose();
        
    }

    public void addForma( Forma forma ) {
        formas.add( forma );
    }
    
    public void setFormaTemp( Forma formaTemp ) {
        this.formaTemp = formaTemp;
    }
    
}
