package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.Objects;

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

    /**
     * @author xrepka
     * @version-3
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kun kun = (Kun) o;
        return cisloPolicka == kun.cisloPolicka &&
                kupniCena == kun.kupniCena &&
                pocetZetonu == kun.pocetZetonu &&
                barva.equals(kun.barva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cisloPolicka, kupniCena, barva, pocetZetonu);
    }

    /**
     * @author xrepka
     * @version-3
     */

    @Override
    public String toString() {
        return "Kun{" +
                "cisloPolicka=" + cisloPolicka +
                ", kupniCena=" + kupniCena +
                ", barva='" + barva + '\'' +
                ", pocetZetonu=" + pocetZetonu +
                '}';
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
        pocetZetonu += mnozstvi;
    }

    /**
     * Metoda ktora vrati pocet zetonov.
     * @return mnozstvo zetonov v rozmedzí: 0,1,2,3,4.
     * @author xrepka
     * @version etapa-1
     */
    public int getPocetZetonu(){
        return pocetZetonu;
    }



}
