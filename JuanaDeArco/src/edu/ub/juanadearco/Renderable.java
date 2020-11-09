
package edu.ub.juanadearco;

import java.awt.Graphics2D;

/**
 * Tots els objectes que es puguin dibuixar (fer el render) per pantalla han
 * d'implementar aquesta interfície.
 * 
 * @author Prog1
 */
public interface Renderable {
    
    public void render(Graphics2D g);
        
}
