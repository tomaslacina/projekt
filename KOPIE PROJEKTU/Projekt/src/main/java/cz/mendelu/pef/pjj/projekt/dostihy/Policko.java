package cz.mendelu.pef.pjj.projekt.dostihy;


public class Policko {


    private TypPolicka typPolicka;
    private int cisloPolicka;
    private String informacePolicko;


    //TODO
    /*public Policko(TypPolicka typPolicka, int cisloPolicka, String informacePolicko) {
        this.typPolicka = typPolicka;
        this.cisloPolicka = cisloPolicka;
        this.informacePolicko = informacePolicko;
    }

    public Policko nactiPolicko(int cisloPolicka){
        Policko policko = new Policko(TypPolicka.getRandomPolicko(),cisloPolicka,"testovaciVerze");
        return policko;
    }*/



    /**
     * Zobrazí informace o daném políčku. Tyto informace budou čerpány ze souboru a podle čísla políčka se zobrazí tyto informace
     * hráči
     * @param cisloPolicka - mohou být hodnoty od 1-40
     * @author xlacina5
     * @version etapa-1
     */

    public void zobrazInformace(int cisloPolicka){



        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getCena(int cisloPolicka){
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
