package cz.mendelu.pef.pjj.projekt.dostihy;

public class HerniPlan {

    public HerniPlan (){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Posunie figurku po plane.
     * @param poziceFigurky miesto, kde sa figurka nachadza: 0,1,2,...40
     * @param hodnotaHodu hodnota hodu kostky: 0,1,2,3,4,5,6
     * @author xrepka
     * @version etapa-1
     */
    public void posunPoPlane(int poziceFigurky, int hodnotaHodu){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Na základě políčka, na které hráč vstoupil se vyvolá příslušná akce - zobrazí se hráči co je možno v tomto tahu udělat
     * (např. koupit koně, prodat koně, koupit trenéra atd.) a hráč poté hráč rozhodne co se dané kolo stane.
     * @param cisloPolicka - označení políčka, na které hráč vstoupil
     * @author xlacina5
     * @version etapa-1
     */


    public void akce (int cisloPolicka){
        throw new UnsupportedOperationException("Not implemented yet.");
    }


    /**
     * Metoda zjistí od hráče co chce prodat (podle čísla políčka) a za jakou cenu. Následně provede transakci
     * @param cisloPolicka - v rozsahu 1-40
     * @param cena nesmí být záporná
     * @author xlacina5
     * @version etapa-1
     */
    public void prodejMajetek(int cisloPolicka, int cena){
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
