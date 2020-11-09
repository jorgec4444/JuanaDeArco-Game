package edu.ub.juanadearco;

import edu.ub.juanadearco.actors.Clau;
import edu.ub.juanadearco.actors.Heroina;
import edu.ub.juanadearco.actors.Menjar;
import edu.ub.juanadearco.actors.Serp;
import edu.ub.juanadearco.actors.Vida;

/**
 * Demo.
 * 
 * @author Prog1
 */

public class Practica{

    private Joc joc;
    private Castell castell;
    private Heroina heroina;

    private static final int MAX_MENJAR_PER_HABITACIO = 2;
    
    private Practica() {
        castell = new Castell(3, 3);
        castell.addHabitacio(0, 0, crearHabitacio0Planta0());
        castell.addHabitacio(0, 1, crearHabitacio1Planta0());
        castell.addHabitacio(0, 2, crearHabitacio2Planta0());  
        castell.addHabitacio(1, 0, crearHabitacio0Planta1());
        castell.addHabitacio(1, 1, crearHabitacio1Planta1());
        castell.addHabitacio(1, 2, crearHabitacio2Planta1());
        castell.addHabitacio(2, 0, crearHabitacio0Planta2());
        castell.addHabitacio(2, 1, crearHabitacio1Planta2());
        castell.addHabitacio(2, 2, crearHabitacio2Planta2());
        
        heroina = new Heroina();
        Habitacio h = castell.getHabitacio(0, 0);
        int[] p = h.getPosicioCela(10, 10);
        heroina.setPosicioInicial(p[0], p[1]);
        
        crearClau();
        
        joc = new Joc(castell, heroina);                            
        distribuirMenjar();
        
        GuiJoc gui = new GuiJoc(joc);
        
        
    }
    
        
    private Habitacio crearHabitacio0Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_0.txt");
        
        Porta porta = h.getPorta(14, 24);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 1));
        
        crearSerp(h, 10, 18);
        crearSerp(h, 13, 10);
        
        return h;
    }
    
    private Habitacio crearHabitacio1Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_1.txt");

        Porta porta = h.getPorta(14, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 23));
       
        porta = h.getPorta(16, 21);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 21));
        
        crearSerp(h, 3, 6);
        crearSerp(h, 8, 7);
        
        return h;
    }

    private Habitacio crearHabitacio2Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_2.txt");
        Porta porta = h.getPorta(0, 21);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(15, 21));
        
        porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 12));
        
        crearSerp(h, 5, 21);
        crearSerp(h, 9, 17);
        crearSerp(h, 2, 8);
        
        return h;
    }
    
    private Habitacio crearHabitacio0Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_0.txt");
        Porta porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 12));
        
        porta = h.getPorta(0, 2);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 2));
        
        crearVida(h, 3, 23);
        crearSerp(h, 10, 16);
        crearSerp(h, 9, 10);
        
        return h;  
    }
    
    private Habitacio crearHabitacio1Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_1.txt");
        Porta porta = h.getPorta(16, 2);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 2));
        
        porta = h.getPorta(4, 24);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(4, 1));
        
        crearSerp(h, 15, 19);
        crearSerp(h, 7, 13);
        return h;
    }
    
    private Habitacio crearHabitacio2Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_2.txt");
        Porta porta = h.getPorta(4, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(4, 23));
        
        porta = h.getPorta(2, 24);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 1));
        
        crearSerp(h, 9, 5);
        crearSerp(h, 4, 12);
        crearSerp(h, 8, 17);
        
        return h;
    }
    
    private Habitacio crearHabitacio0Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_0.txt");
        Porta porta = h.getPorta(2, 0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 23));
        
        porta = h.getPorta(2, 24);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 1));
        
        crearVida(h, 15, 6);
        crearSerp(h, 9, 17);
        
        return h;
    }
    
    private Habitacio crearHabitacio1Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_1.txt");
        Porta porta = h.getPorta(2, 0);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 23));
        
        porta = h.getPorta(13, 0);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(13, 23));
        
        crearSerp(h, 2, 4);
        crearSerp(h, 6, 17);
        crearSerp(h, 6, 13);
        crearSerp(h, 9, 3);
        
        return h;
    }
    
    private Habitacio crearHabitacio2Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_2.txt");
        Porta porta = h.getPorta(13, 24);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(13, 1));
        
        crearSerp(h, 6, 21);
        crearSerp(h, 14, 16);
        crearSerp(h, 9, 3);
        
        return h;
    }
    
    
    private void distribuirMenjar() {
        String[] menjars = {  "Pizza", "Pollastre", "Síndria" } ;
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            { 25, 540, 14, 30, 22 },
            { 50, 439, 14, 27, 23 },
            { 50, 97, 100, 30, 20 }
        };
        
        for (int i = 0; i < castell.getNumPlantes(); i++) {
            
            for (int j = 0; j < castell.getNumHabitacions(i); j++) {
                Habitacio h = castell.getHabitacio(i, j);
                int numMenjars = (int)(Math.random() * (MAX_MENJAR_PER_HABITACIO + 1));
                
                for (int k = 0; k < numMenjars; k++) {
                    int[] cela = obtenirCelaLliure(h);
                    int imenjar = (int)(Math.random() * menjars.length);
                    Menjar m = new Menjar(menjars[imenjar], 
                            dades[imenjar][0], dades[imenjar][1], dades[imenjar][2], 
                            dades[imenjar][3], dades[imenjar][4]);
                    
                    int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                    m.setPosicioInicial(posicio[0], posicio[1]);
                    h.addActor(m);                     
                }
            }
            
        }
    }

    private void crearVida(Habitacio h, int x, int y){
        
        int [] dades = {174, 12, 26 ,24};
        
        Vida v = new Vida("Vida", dades[0], dades[1], dades[2], dades[3]);
        
        int [] posicio = h.getPosicioCela(x, y);
        
        v.setPosicioInicial(posicio[0], posicio[1]);
        
        h.addActor(v);
    }
    
    private void crearSerp(Habitacio h, int x, int y){
        
        int [] serp = {700, 42, 40, 42};
        
        Serp s = new Serp("Serp", serp[0], serp[1], serp[2], serp[3]);
        
        int [] posicio = h.getPosicioCela(x, y);
        s.setPosicioInicial(posicio[0], posicio[1]);
        
        h.addActor(s);
    }
    
    private void crearClau(){
        
        int [] clau = {675, 50, 20, 30};
        
        Clau ferro = new Clau("Ferro", clau[0], clau[1], clau[2], clau[3]);
        Clau bronze = new Clau("Bronze", clau[0], clau[1], clau[2], clau[3]);
        Clau llauto = new Clau("Llauto", clau[0], clau[1], clau[2], clau[3]);
        Clau plata = new Clau("Plata", clau[0], clau[1], clau[2], clau[3]);
        Clau or = new Clau("Or", clau[0], clau[1], clau[2], clau[3]);
        
        Clau [] llista_claus = new Clau[5];
        
        llista_claus[0] = ferro;
        llista_claus[1] = bronze;
        llista_claus[2] = llauto;
        llista_claus[3] = plata;
        llista_claus[4] = or;
        
        for (Clau c : llista_claus) {
            int x = (int) (Math.random() * castell.getNumPlantes());
            int y = (int) (Math.random() * castell.getNumHabitacions(x));
            Habitacio h = castell.getHabitacio(x, y);
            int[] cela = obtenirCelaLliure(h);
            int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                    
                    
            c.setPosicioInicial(posicio[0], posicio[1]);
            h.addActor(c);                     
                
            }
        }
                
    

   
    private int[] obtenirCelaLliure(Habitacio h) {
        int fila = 0;
        int col = 0;
        int cela[] = null;
        boolean trobada = false;
        boolean terra = false;
        
        while (!trobada) {            
            terra = false;
            while (!terra) {
                fila = (int)(Math.random() * Constants.NUM_CELES_VERTICALS);
                col = (int)(Math.random() * Constants.NUM_CELES_HORIZONTALS);
                terra = h.getValor(fila, col) == Constants.SIMBOL_TERRA;
            }
            
            // comprovar que cap actor està dins la cela
            Actor[] actors = h.getActorsAsArray();
            int i = 0;
            boolean lliure = true;
            while (i < actors.length && lliure) {
                cela = h.getCela(actors[i].getPosicioInicial()[0], 
                        actors[i].getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];            
                i++;
            }         
            trobada = lliure;
        }
        return new int[] { fila, col };
    }
    
    
    public static void main (String [] args){
        new Practica ();
    }   
}