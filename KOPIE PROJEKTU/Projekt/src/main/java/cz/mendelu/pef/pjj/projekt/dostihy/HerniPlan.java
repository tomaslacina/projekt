package cz.mendelu.pef.pjj.projekt.dostihy;

import java.io.*;
import java.util.*;

public class HerniPlan {
    private Set<Hrac> hraci = new HashSet<>();
    private Kostka kostka;

    private Set<Nahoda> nahody = new HashSet<>();

    private Map<Integer, Policko> mapaPolicek = new HashMap<>(); //asi to pak dat cele final
    private final int pocetPolicek = 40;

    private Set<Kun> koni = new HashSet<>();


    public HerniPlan(Kostka kostka) {
        this.kostka = kostka;
    }


    public HerniPlan() {

    }

    /**
     * Přidá hráčovi koně
     *
     * @param kun
     * @author xlacina5
     */
    public void pridejKone(Kun kun) {
        koni.add(kun);
    }

    /**
     * Metoda vypise hracovi kone, ktere vlastni
     *
     * @author xlacina5
     * @version etapa-3 (implementace Set a práce s ní)
     */
    public void vypisKone() {
        Iterator<Kun> iterator = koni.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }


    /**
     * Metoda pro nacteni vsech policke na herni plan
     * Prozatim pracuje s testovacimi daty, pozdeji naimplementujeme nacitani dat ze souboru
     *
     * @author xlacina5
     * @version etapa-3 (implementace Map, pridani, vypis)
     */
    public void nactiPolicka() {

        int cisloPolicka;
        TypPolicka typPolicka;
        String informacePolicko;
        int souradniceX;
        int souradniceY;

        mapaPolicek.clear(); //vymazu puvodni hodnoty, kdyby tam nahodou nejake byly

        try (BufferedReader br = new BufferedReader(new FileReader("policka.csv"))) {
            String radek;

            //dokud je co cist
            //Problem s parsovanim, zkusim vyresit...
            //TODO vyresit problem s parsovanim stringu na int
            while((radek=br.readLine())!=null){
                String[] rozdeleneRadky = radek.split(";");
                //cisloPolicka=Integer.parseInt(prvni);
                //cisloPolicka= Integer.parseInt(rozdeleneRadky[0]);
                typPolicka=TypPolicka.valueOf(rozdeleneRadky[1]);
                informacePolicko=rozdeleneRadky[2];

            }

        } catch (FileNotFoundException e) {
            System.out.println("Soubor s policky nenalezen");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Soubor se nepodařilo přečíst");
            e.printStackTrace();
        }

    }

    /**
     * Na zaklade klice - cislo policka, vypise jeho inforamce
     *
     * @param cisloPolicka - cislo policka, o kterem chci vypsat informace
     * @author xlacina5
     */

    public void zobrazInformaceOPolicku(int cisloPolicka) {
        mapaPolicek.get(cisloPolicka).zobrazInformace();
    }

    /**
     * Metoda vrati celkovy pocet policek na hernim planu
     *
     * @return pocetPolicek
     * @author xlacina5
     */

    public int getPocetPolicek() {
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


    /**
     * Metoda slouží pro přečtení pravidel z připraveného souboru
     * Soubor musí být uložen nejspíš hned na první stránce v tom adresáři a ne v těch resources :/
     * @version etapa4
     * @author:
     */
    void prectiZeSouboruPravidla() {
        try (BufferedReader br = new BufferedReader(new FileReader("pravidla.txt"))) {
            String radek;

            while((radek=br.readLine())!=null){
                System.out.println(radek);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Soubor se nepodařilo přečíst");
            e.printStackTrace();
        }


    }

    /**
     * Metoda slouží pro zápis do souboru
     * Je to jen demo verze jak se zapisuje :)
     *
     */
    void zapisDoSouboru(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("zapisDoSouboru.txt"))) {
            System.out.println("Uspesny zapis");
            bw.write("První řádek");
            bw.newLine();
            bw.write("Tento text je na druhém řádku");
            bw.newLine();
            bw.write("A do třetice.");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Do souboru se nepodařilo zapsat");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HerniPlan hp = new HerniPlan();
        hp.prectiZeSouboruPravidla();
       // hp.zapisDoSouboru();
        hp.nactiPolicka();
        
    }

}




