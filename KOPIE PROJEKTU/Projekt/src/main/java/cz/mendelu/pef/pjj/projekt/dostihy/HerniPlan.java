package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.*;

public class HerniPlan {
    private Set<Hrac> hraci = new HashSet<>();
    private Kostka kostka;

    private Set<Nahoda> nahody = new HashSet<>();

    private Map<Integer, Policko> mapaPolicek = new HashMap<>(); //asi to pak dat cele final
    private final int pocetPolicek=40;

    private Set<Kun> koni = new HashSet<>();


    public HerniPlan(Kostka kostka) {
        this.kostka = kostka;
    }


    public HerniPlan() {

    }

    public void pridejKone(Kun kun){
        koni.add(kun);
    }
    public void vypisKone(){
       Iterator<Kun> iterator = koni.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next().toString());
       }
    }


   public void nactiPolicka(){
       String informacePolicko="Testovaci Policko";

       for (int i=0;i<pocetPolicek;i++){
           Policko policko = new Policko(TypPolicka.getRandomPolicko(),i,informacePolicko);
           mapaPolicek.put(i,policko);
       }
    }

    public void zobrazInformaceOPolicku(int cisloPolicka){
       mapaPolicek.get(cisloPolicka).zobrazInformace();
    }

    /**
     * Metoda vrati celkovy pocet policek na hernim planu
     * @return pocetPolicek
     * @author xlacina5
     *
     */

    public int getPocetPolicek(){
        return pocetPolicek;
    }



    /**
     * Posunie figurku po plane.
     *
     * @param figurka figurka hráča
     * @author xrepka
     * @version etapa-1
     */
    public void posunPoPlane(Figurka figurka) {
        figurka.setPoziceFigurky(kostka.getHodnotaHodu());

    }

    /**
     * Prida objekt hráč do kolekcie hračov.
     *
     * @param hrac objekt hrac.
     * @author xrepka
     * @version etapa-3
     */

    public void pridajHraca(Hrac hrac) {
        hraci.add(hrac);
    }


    /**
     * Na základě políčka, na které hráč vstoupil se vyvolá příslušná akce - zobrazí se hráči co je možno v tomto tahu udělat
     * (např. koupit koně, prodat koně, koupit trenéra atd.) a hráč poté hráč rozhodne co se dané kolo stane.
     *
     * @param cisloPolicka - označení políčka, na které hráč vstoupil
     * @author xlacina5
     * @version etapa-1
     */


    public void akce(int cisloPolicka) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }


    /**
     * Metoda zjistí od hráče co chce prodat (podle čísla políčka) a za jakou cenu. Následně provede transakci
     *
     * @param cisloPolicka - v rozsahu 1-40
     * @param cena         nesmí být záporná
     * @author xlacina5
     * @version etapa-1
     */
    public void prodejMajetek(int cisloPolicka, int cena) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }


    /**
     * @author xrepka
     * @version etapa-3
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HerniPlan herniPlan = (HerniPlan) o;
        return hraci.equals(herniPlan.hraci) &&
                kostka.equals(herniPlan.kostka) &&
                nahody.equals(herniPlan.nahody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hraci, kostka, nahody);
    }
}