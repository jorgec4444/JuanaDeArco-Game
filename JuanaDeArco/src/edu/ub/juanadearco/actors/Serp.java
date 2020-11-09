package edu.ub.juanadearco.actors;

import edu.ub.juanadearco.Actor;
import edu.ub.juanadearco.Colisio;
import edu.ub.juanadearco.Constants;
import edu.ub.juanadearco.Context;
import edu.ub.juanadearco.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


public class Serp extends AbstractActor {

    private float calories;
    private Image image;
    private int amplada;
    private int alcada;
    private String nom;

    
    /**
     * Crea un nou objecte del tipus Menjar amb una subimage del fitxer
     * <code>objectes.png</code>, el nom i calories proporcionades. Les calories
     * aporten un guany proporcional en la vida del jugador.
     * 
     * @param nom Nom
     * @param calories guany de vida 
     * @param imgPosX posició x de la subimage
     * @param imgPosY posició y de la subimage
     * @param imgAmplada amplada de la subimage
     * @param imgAlcada alçada de la subimage
     */
    public Serp (String nom, int imgPosX, int imgPosY, int imgAmplada, int imgAlcada) {
        this.nom = nom;
        this.image = Util.carregarImatge("objectes.png", 
                imgPosX, imgPosY, imgAmplada, imgAlcada);
        this.amplada = imgAmplada;
        this.alcada = imgAlcada;
        setEstat(Constants.ESTAT_ACTIU);
    }

    public void actualitzar(Context context) {
        // no fem res, es estàtic
    }

    public Rectangle getLimits() {
        return new Rectangle(getX(), getY(), amplada, alcada);
    }

    public void tractarColisio(Colisio colisio) {
        Actor actor = colisio.getActor();
        if (actor instanceof Heroina) {
                actor.setVida(actor.getVida() - 50.0f);
	        setEstat(Constants.ESTAT_INACTIU);
        }
    }

    public void render(Graphics2D g) {
        g.drawImage(image, getX(), getY(), observer);
        g.setColor(Color.GREEN);
        Font f = new Font("Dialog", Font.BOLD, 10);
        g.setFont(f);
        g.drawString(nom, getX(), getY() - 3);
    }
           
}
