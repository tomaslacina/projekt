package cz.mendelu.pef.pjj.projekt.dostihy;


import java.util.Map;
import java.util.Objects;

public class Policko {




    private TypPolicka typPolicka;
    private int cisloPolicka;
    private String informacePolicko;
    private int poziceX;
    private int poziceY;

    public Policko(TypPolicka typPolicka, int cisloPolicka, String informacePolicko) {
        this.typPolicka = typPolicka;
        this.cisloPolicka = cisloPolicka;
        this.informacePolicko = informacePolicko;
    }

   
    /**
     * Konstruktor pro cteni ze souboru - pokus :)
     * @param cisloPolicka
     * @param typPolicka
     * @param informacePolicko
     * @param poziceX
     * @param poziceY
     * @atuhor xlacina5
     */
    public Policko(int cisloPolicka, TypPolicka typPolicka,String informacePolicko, int poziceX, int poziceY){
        this.cisloPolicka=cisloPolicka;
        this.typPolicka=typPolicka;
        this.informacePolicko=informacePolicko;
        this.poziceX=poziceX;
        this.poziceY=poziceY;
    }

    /**
     * Zobrazí informace o daném políčku. Tyto informace budou čerpány ze souboru a podle čísla políčka se zobrazí tyto informace
     * hráči
     * @author xlacina5
     * @version etapa-1, etapa-3 implementace (propojeno s vypisem policka v hernim planu a Map - policka)
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

    /*public int getCena(){
        throw new UnsupportedOperationException("Not implemented yet");
    }*/


    /**
     * toString - policko - vypis informaci o policku
     * @return
     * @author xlacina5
     * @version - etapa3
     */
    @Override
    public String toString() {
        return "Policko{" +
                "typPolicka=" + typPolicka +
                ", cisloPolicka=" + cisloPolicka +
                ", informacePolicko='" + informacePolicko + '\'' +
                '}';
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


