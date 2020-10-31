package cz.mendelu.pef.pjj.projekt.dostihy;


import java.util.Map;
import java.util.Objects;

public class Policko {


    private TypPolicka typPolicka;
    private int cisloPolicka;
    private String informacePolicko;

    public Policko(TypPolicka typPolicka, int cisloPolicka, String informacePolicko) {
        this.typPolicka = typPolicka;
        this.cisloPolicka = cisloPolicka;
        this.informacePolicko = informacePolicko;
    }

    /**
     * Zobrazí informace o daném políčku. Tyto informace budou čerpány ze souboru a podle čísla políčka se zobrazí tyto informace
     * hráči
     * @author xlacina5
     * @version etapa-1
     */

    public void zobrazInformace(){
        System.out.println("Typ policka:"+this.typPolicka);
        System.out.println("Cislo policka:"+this.cisloPolicka);
        System.out.println("Informace o policku:"+this.informacePolicko);
    }

    public TypPolicka getTypPolicka() {
        return typPolicka;
    }

    public int getCisloPolicka() {
        return cisloPolicka;
    }

    public String getInformacePolicko() {
        return informacePolicko;
    }

    public int getCena(){
        throw new UnsupportedOperationException("Not implemented yet");
    }


    /**
     *
     * @param o - objekt policka
     * @return true/false
     * @author xlacina5
     * @version etapa3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policko policko = (Policko) o;
        return cisloPolicka == policko.cisloPolicka &&
                typPolicka == policko.typPolicka &&
                informacePolicko.equals(policko.informacePolicko);
    }

    /**
     *
     * @return int
     * @author xlacina5
     * @version etapa3
     */
    @Override
    public int hashCode() {
        return Objects.hash(typPolicka, cisloPolicka, informacePolicko);
    }



    //testovani

   /* public static void main(String[] args) {

        Policko policko = new Policko(TypPolicka.NAHODA,1,"a");
        Policko policko2 = new Policko(TypPolicka.NAHODA,1,"a");
        Policko policko3 = new Policko(TypPolicka.TRENER,1,"a");

        System.out.println(policko.hashCode());
        System.out.println(policko2.hashCode());
        System.out.println(policko3.hashCode());
        System.out.println(policko.equals(policko2));
        System.out.println(policko.equals(policko3));
    }*/

}


