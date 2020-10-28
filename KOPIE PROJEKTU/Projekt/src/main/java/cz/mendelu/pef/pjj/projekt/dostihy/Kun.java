package cz.mendelu.pef.pjj.projekt.dostihy;

public class Kun {


    private int cisloPolicka;
    private int kupniCena;
    private String barva;
    private int pocetZetonu;

    /**
     * Parametrický konstruktor
     * @param cisloPolicka
     * @param kupniCena
     * @param barva
     * @param pocetZetonu
     * @author xlacina5
     */

    public Kun(int cisloPolicka, int kupniCena, String barva, int pocetZetonu) {
        this.cisloPolicka = cisloPolicka;
        this.kupniCena = kupniCena;
        this.barva = barva;
        this.pocetZetonu = pocetZetonu;
    }

    /*public Kun(){
        throw new UnsupportedOperationException("Not implemented yet.");
    }*/

    /**
     * Metoda ktora zmeni pocet zetonov, teda zvacsi vybavu kona.
     * @param mnozstvi mnozstvo zetonov
     * @author xrepka
     * @version etapa-1
     */


    public void zmenPocetZetonu(int mnozstvi){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Metoda ktora vrati pocet zetonov.
     * @return mnozstvo zetonov v rozmedzí: 0,1,2,3,4.
     * @author xrepka
     * @version etapa-1
     */
    public int getPocetZetonu(){
        throw new UnsupportedOperationException("Not implemented yet.");
    }



}
