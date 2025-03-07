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
public abstract class Forma {
    
    protected int xIni;
    protected int yIni;
    protected int xFim;
    protected int yFim;
    protected Color corContorno;
    protected Color corPreenchimento;

    public Forma( int xIni, int yIni, int xFim, int yFim, Color corContorno, Color corPreenchimento ) {
        this.xIni = xIni;
        this.yIni = yIni;
        this.xFim = xFim;
        this.yFim = yFim;
        this.corContorno = corContorno;
        this.corPreenchimento = corPreenchimento;
    }

    public abstract void desenhar( Graphics2D g2d );
    
    public void setXIni( int xIni ) {
        this.xIni = xIni;
    }

    public void setYIni( int yIni ) {
        this.yIni = yIni;
    }

    public void setXFim( int xFim ) {
        this.xFim = xFim;
    }

    public void setYFim( int yFim ) {
        this.yFim = yFim;
    }

    public void setCorContorno( Color corContorno ) {
        this.corContorno = corContorno;
    }

    public void setCorPreenchimento( Color corPreenchimento ) {
        this.corPreenchimento = corPreenchimento;
    }
    
}
