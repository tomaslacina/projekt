package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.Objects;

public class Kun {

    private int cisloPolicka;
    private String meno;
    private String barva;
    private int kupniCena;
    private int prohlidkaStaje;
    private int cenaDostih1;
    private int cenaDostih2;
    private int cenaDostih3;
    private int cenaDostih4;
    private int cenaHlavniDostih;
    private int cenaZaPrepravu;
    private int pocetZetonu;


    /**
     *
     * @param cisloPolicka
     * @param meno
     * @param barva
     * @param kupniCena
     * @param prohlidkaStaje
     * @param cenaDostih1
     * @param cenaDostih2
     * @param cenaDostih3
     * @param cenaDostih4
     * @param cenaHlavniDostih
     * @param cenaZaPrepravu
     * @author xrepka
     * @version etapa-4
     */

    public Kun(int cisloPolicka, String meno, String barva, int kupniCena, int prohlidkaStaje, int cenaDostih1, int cenaDostih2, int cenaDostih3, int cenaDostih4, int cenaHlavniDostih, int cenaZaPrepravu) {
        this.cisloPolicka = cisloPolicka;
        this.meno = meno;
        this.barva = barva;
        this.kupniCena = kupniCena;
        this.prohlidkaStaje = prohlidkaStaje;
        this.cenaDostih1 = cenaDostih1;
        this.cenaDostih2 = cenaDostih2;
        this.cenaDostih3 = cenaDostih3;
        this.cenaDostih4 = cenaDostih4;
        this.cenaHlavniDostih = cenaHlavniDostih;
        this.cenaZaPrepravu = cenaZaPrepravu;
        this.pocetZetonu = 0;
    }

    /**
     * @author xrepka
     * @version etapa-4
     *
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kun kun = (Kun) o;
        return cisloPolicka == kun.cisloPolicka &&
                kupniCena == kun.kupniCena &&
                prohlidkaStaje == kun.prohlidkaStaje &&
                cenaDostih1 == kun.cenaDostih1 &&
                cenaDostih2 == kun.cenaDostih2 &&
                cenaDostih3 == kun.cenaDostih3 &&
                cenaDostih4 == kun.cenaDostih4 &&
                cenaHlavniDostih == kun.cenaHlavniDostih &&
                cenaZaPrepravu == kun.cenaZaPrepravu &&
                pocetZetonu == kun.pocetZetonu &&
                Objects.equals(meno, kun.meno) &&
                Objects.equals(barva, kun.barva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cisloPolicka, meno, barva, kupniCena, prohlidkaStaje, cenaDostih1, cenaDostih2, cenaDostih3, cenaDostih4, cenaHlavniDostih, cenaZaPrepravu, pocetZetonu);
    }

    /**
     * @author xrepka
     * @version etapa-4
     */

    @Override
    public String toString() {
        return "Kun{" +
                "cisloPolicka=" + cisloPolicka +
                ", meno='" + meno + '\'' +
                ", barva='" + barva + '\'' +
                ", kupniCena=" + kupniCena +
                ", prohlidkaStaje=" + prohlidkaStaje +
                ", cenaDostih1=" + cenaDostih1 +
                ", cenaDostih2=" + cenaDostih2 +
                ", cenaDostih3=" + cenaDostih3 +
                ", cenaDostih4=" + cenaDostih4 +
                ", cenaHlavniDostih=" + cenaHlavniDostih +
                ", cenaZaPrepravu=" + cenaZaPrepravu +
                ", pocetZetonu=" + pocetZetonu +
                '}';
    }

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
