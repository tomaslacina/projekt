package cz.mendelu.pef.pjj.projekt.dostihy;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.image.Kernel;
import java.io.*;
import java.util.*;
import java.util.List;

public class HerniPlan {
    private Set<Hrac> hraci = new HashSet<>();
    private Kostka kostka=new Kostka();

    private Set<Nahoda> nahody = new HashSet<>();

    private Map<Integer, Policko> mapaPolicek = new HashMap<>(); //asi to pak dat cele final
    private final int pocetPolicek = 40;

    private Set<Kun> kone = new HashSet<>();

    private Set<Finance> finance =new HashSet<>();

    private final int hodnotaTrestu=-1000;
    private final int cenaStaje=3000;
    private final int cenaPrepravy=3000;




    public HerniPlan() {
        nactiPolicka();
        nactiFinance();
        nactiNahody();


    }

    /**
     * Nacte ze souboru informace o kartach finance
     */

    public void nactiFinance(){
        int castka;
        String text;

        finance.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("finance.csv"))) {
            String radek;

            while((radek=br.readLine())!=null){
                String[] rozdeleneRadky = radek.split(";");
                castka=Integer.parseInt(rozdeleneRadky[0]);
                text=rozdeleneRadky[1];
                finance.add(new Finance(castka,text));
            }


        } catch (FileNotFoundException e) {
            System.out.println("Soubor s financemi nenalezen");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Soubor s financemi se nepodarilo nacist");
            e.printStackTrace();
        }

    }


    public void nactiNahody(){
       int posun;
       String text;

        nahody.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("nahody.csv"))) {
            String radek;

            while((radek=br.readLine())!=null){
                String[] rozdeleneRadky = radek.split(";");
                posun=Integer.parseInt(rozdeleneRadky[0]);
                text=rozdeleneRadky[1];
                nahody.add(new Nahoda(posun,text));
            }


        } catch (FileNotFoundException e) {
            System.out.println("Soubor s nahodami nenalezen");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Soubor s nahodami se nepodarilo nacist");
            e.printStackTrace();
        }

    }




    /**
     * Načíta kone zo súboru
     *
     *
     * @author xrepka
     */
    public void nactiKone() {
        int cisloPolicka;
        String meno;
        String barva;
        int kupniCena;
        int prohlidkaStaje;
        int cenaDostih1;
        int cenaDostih2;
        int cenaDostih3;
        int cenaDostih4;
        int cenaHlavniDostih;
        int cenaZaPrepravu;

        kone.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("kone.csv"))) {
            String radek;

            //dokud je co cist

            while((radek=br.readLine())!=null){

                String[] rozdeleneRadky = radek.split(";");

                cisloPolicka=Integer.parseInt(rozdeleneRadky[0]);
                meno=rozdeleneRadky[1];
                barva=rozdeleneRadky[2];
                kupniCena=Integer.parseInt(rozdeleneRadky[3]);
                prohlidkaStaje=Integer.parseInt(rozdeleneRadky[4]);
                cenaDostih1=Integer.parseInt(rozdeleneRadky[5]);
                cenaDostih2=Integer.parseInt(rozdeleneRadky[6]);
                cenaDostih3=Integer.parseInt(rozdeleneRadky[7]);
                cenaDostih4=Integer.parseInt(rozdeleneRadky[8]);
                cenaHlavniDostih=Integer.parseInt(rozdeleneRadky[9]);
                cenaZaPrepravu=Integer.parseInt(rozdeleneRadky[10]);
                Kun kun= new Kun(cisloPolicka,meno,barva,kupniCena,prohlidkaStaje,cenaDostih1,cenaDostih2,cenaDostih3,cenaDostih4,cenaHlavniDostih,cenaZaPrepravu);
                kone.add(kun);
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
     * Metoda vypise hracovi kone, ktere vlastni
     *
     * @author xlacina5
     * @version etapa-3 (implementace Set a práce s ní)
     */
    public void vypisKone() {
        Iterator<Kun> iterator = kone.iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }


    /**
     * Metoda pro nacteni vsech policke na herni plan
     * Aktualizace 21.11.2020 - nacitani dat probiha z pripraveneho csv souboru (policka.csv)
     *
     * @author xlacina5
     * @version etapa-3 (implementace Map, pridani, vypis)
     * @author xlacina5
     * @version etapa-4 (cteni ze souboru)
     *
     */
    public void nactiPolicka() {

        int cisloPolicka;
        TypPolicka typPolicka;
        String informacePolicko;
        int souradniceX;
        int souradniceY;
        int obsazenoHracem;
        int prodejniCena;

        mapaPolicek.clear(); //vymazu puvodni hodnoty, kdyby tam nahodou nejake byly

        try (BufferedReader br = new BufferedReader(new FileReader("policka.csv"))) {
            String radek;

            //dokud je co cist

            while((radek=br.readLine())!=null){
                String[] rozdeleneRadky = radek.split(";");

                cisloPolicka= Integer.parseInt(rozdeleneRadky[0]);
                typPolicka=TypPolicka.valueOf(rozdeleneRadky[1]);
                informacePolicko=rozdeleneRadky[2];
                souradniceX=Integer.parseInt(rozdeleneRadky[3]);
                souradniceY=Integer.parseInt(rozdeleneRadky[4]);
                obsazenoHracem = Integer.parseInt(rozdeleneRadky[5]);
                prodejniCena = Integer.parseInt(rozdeleneRadky[6]);

                Policko policko = new Policko(cisloPolicka,typPolicka,informacePolicko,souradniceX,souradniceY,obsazenoHracem,prodejniCena);
                mapaPolicek.put(cisloPolicka,policko);


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
     * Vrati instanci hrace z pole hracu - pro lepsi praci s Hracem
     * Omezeni zdvojeneho kodu
     * */
    public Hrac vratHrace(int idHrace){
        Hrac hrac;
        String hracReturn="";
        Iterator<Hrac> i = hraci.iterator();
        while(i.hasNext()){
            hrac=i.next();
            if((hrac.getId())==idHrace){
                return hrac;
            }
        }
        return null;

    }


    public String zobrazInformaceOPolicku(int idHrace) {
        int cisloPolicka;
        String informace="";
        Hrac hrac;
        hrac=vratHrace(idHrace);
        cisloPolicka=hrac.getPozice();
        System.out.println("Hrac je na pozici:"+cisloPolicka);

        //mapaPolicek.get(cisloPolicka).zobrazInformace();
        informace+=mapaPolicek.get(cisloPolicka).toString();
        return informace;
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
     * Vrati hodnotu trestu
     * @return
     */
    public int getHodnotaTrestu(){
        return hodnotaTrestu;
    }

    /**
     * Predelani cele metody
     * @param idHrace
     * @param hodnotaHodu
     */
    public void posunPoPlane(int idHrace, int hodnotaHodu) {
        Hrac hrac;
        hrac=vratHrace(idHrace);
        hrac.setPozice(hodnotaHodu);
    }

    /**
     * Prida objekt hráč do kolekcie hračov.
     * @param hrac objekt hrac.
     * @author xrepka
     * @version etapa-3
     */

    public void pridajHraca(Hrac hrac) {
        hraci.add(hrac);
    }

    public void vytvorAPridejHrace(String jmeno, int id){
        Hrac hrac = new Hrac(jmeno,id);
        hraci.add(hrac);
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
    public String prectiZeSouboruPravidla() {
        String radek;
        String pravidla="";
        try (BufferedReader br = new BufferedReader(new FileReader("pravidla.txt"))) {


            while((radek=br.readLine())!=null){
                System.out.println(radek);
                pravidla += radek + "\n";
            }


        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Soubor se nepodařilo přečíst");
            e.printStackTrace();
        }

        return pravidla;
    }

    /**
     * Ulozi stav policek do souboru
     * @author xlacina5;
     * @version etapa-4;
     */

    void ulozStavPolicek(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("stavPolicek.csv"))) {

            for(int i=1;i<=pocetPolicek;i++){
                bw.write(mapaPolicek.get(i).toStringCSV());
                bw.newLine();
            }
            bw.flush();
            System.out.println("Do souboru: stavPolicek.csv se podarilo zapsat data");
        } catch (IOException e) {
            System.out.println("Do souboru se nepodařilo zapsat");
            e.printStackTrace();
        }
    }



    /**
     * Zapíše do súboru vysledky.txt stav hráčov.
     * @author xrepka
     * @version etapa-4
     */

    void zapisVysledky(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("vysledky.txt"))) {

            Iterator<Hrac> i = hraci.iterator();
            while(i.hasNext()) {
                bw.write(i.next().toString());
                bw.newLine();
            }
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Do souboru se nepodařilo zapsat");
            e.printStackTrace();
        }
    }

    public String vypisVsechHracu(){
        String vypisHracu="";
        Iterator<Hrac> i = hraci.iterator();
        while(i.hasNext()) {
            vypisHracu+=i.next().vypisHraca()+"\n";
        }
        return vypisHracu;
    }


    public String vypisAktualnihoHrace(int idHrace){
        Hrac hrac;
        String hracReturn="";
        Iterator<Hrac> i = hraci.iterator();
        while(i.hasNext()){
            hrac=i.next();
            if((hrac.getId())==idHrace){
                hracReturn+=hrac.vypisHraca();
                break;
            }
        }
        return hracReturn;
    }



    public int hodKostkou(){
        return kostka.getHodnotaHodu();
    }


    public int getXPolicka(int cisloPolicka){
        int x = 0;
        for (Map.Entry<Integer,Policko> entry : mapaPolicek.entrySet()) {
            if (cisloPolicka == entry.getKey()) {
                x = entry.getValue().getPoziceX();
            }
        }
        return x;
    }


    public int getYPolicka(int cisloPolicka){
        int y = 0;

        for (Map.Entry<Integer,Policko> entry : mapaPolicek.entrySet()) {
            if (cisloPolicka == entry.getKey()) {
                y = entry.getValue().getPoziceY();
            }
        }
        return y;
    }

    public TypPolicka getTypPolicka(int cisloPolicka){
        TypPolicka typPolicka = null;
        for (Map.Entry<Integer,Policko> entry : mapaPolicek.entrySet()) {
            if (cisloPolicka == entry.getKey()) {
                typPolicka = entry.getValue().getTypPolicka();
            }
        }
        return typPolicka;
    }

    /**
     * Funkce na vraceni nahodneho cisla v projektu, v parametru se zada z kolika cisel se ma vybirat
     * @param rozsahNahodnehoCisla
     * @return vrati nahodne cislo z rozsahu - pozor muze vratit i 0!
     */

    public int nahodneCislo(int rozsahNahodnehoCisla){
        Random random = new Random();
        int nahodneCislo;
        nahodneCislo=random.nextInt(rozsahNahodnehoCisla);
        /*if(nahodneCislo==0){
            return 1;
        }
        else {
            return nahodneCislo;
        }*/

        return nahodneCislo;

    }

    public Finance getKartaFinance(){
        int pocetFinanciVKolekci = finance.size();
        int cisloFinance = nahodneCislo(pocetFinanciVKolekci);
        int pocet=0;
        Finance financeVracene;

        Iterator<Finance> i = finance.iterator();
        while(i.hasNext()){
            financeVracene=i.next();

            if((pocet==cisloFinance)){
               return financeVracene;
            }
            pocet++;
        }
        return null;


    }

    /**
     * Vylosuje nahodnou kartu nahody a vrati ji
     * @return
     */

    public Nahoda getKartaNahody(){
        int pocetNahodVKolekci = nahody.size();
        int cisloNahody = nahodneCislo(pocetNahodVKolekci);
        int pocet=0;
        Nahoda kartaNahody;


        Iterator<Nahoda> i = nahody.iterator();
        while(i.hasNext()){
            kartaNahody=i.next();

            if((pocet==cisloNahody)){
                return kartaNahody;
            }
            pocet++;
        }
        return null;
    }


    public Policko getPolicko(int cisloPolicka){
        Policko policko=null;
        policko=mapaPolicek.get(cisloPolicka);
        return policko;

    }

    public int getCenaStaje(){
        return cenaStaje;
    }
    public int getCenaPrepravy(){
        return cenaPrepravy;
    }




    public int getCenaZetonuKone(int cisloPolicka){
        Iterator <Kun> i = kone.iterator();
        while (i.hasNext()){
            if(i.next().getCisloPolicka()==cisloPolicka){
                return i.next().getCenaZaPrepravu();
            }
        }
        return 0;
    }

    public void zvysPocetZetonu(int cisloPolicka){
        Iterator <Kun> i = kone.iterator();
        while (i.hasNext()){
            if(i.next().getCisloPolicka()==cisloPolicka){
                i.next().zvysPocetZetonu();
            }
        }
    }

    public int getPoplatekZaKone(int cisloPolicka){
        Iterator <Kun> i = kone.iterator();
        while (i.hasNext()){
            if(i.next().getCisloPolicka()==cisloPolicka){
                return i.next().getPoplatekZaPronajemKone();
            }
        }
        return 0;


    }

    public int getNakupniCenaKone(int cisloPolicka){
        Iterator <Kun> i = kone.iterator();
        while (i.hasNext()){
            if(i.next().getCisloPolicka()==cisloPolicka){
                return i.next().getKupniCena();
            }
        }
        return 0;
    }


    public String getNazovKone(int cisloPolicka){
        String meno = null;
        Iterator <Kun> i = kone.iterator();
        while (i.hasNext()){
            if(i.next().getCisloPolicka()==cisloPolicka){
                meno = i.next().getMeno();
            }
        }
        return meno;
    }




}




