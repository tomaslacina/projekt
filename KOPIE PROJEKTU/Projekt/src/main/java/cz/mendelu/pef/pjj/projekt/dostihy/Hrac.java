package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hrac {

    private List<Trener> seznamTreneru = new ArrayList<>();
    private List<Kun> seznamKoni = new ArrayList<>();
    private int stavKonta;
    private String meno;
    private int id; //pridani id
    private int pozice;
    private static final int konto = 30000; //staticka promenna stav konta
    private static final int pocetPolicek=40;




    /*
     * Pridani parametru id - aby to bylo identifikovatelne - kdyby byly 2 hraci se stejnym jmenem
     * Pridani parametru pozice - zruseni figurky (asi by to bylo zbytecne)
     * */
    Hrac (String meno, int id){
        this.meno=meno;
        this.stavKonta=konto;
        this.id=id;
        this.pozice=1;
    }

    /**
     * @version - etapa-3
     * @author - xlacina5
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hrac hrac = (Hrac) o;
        return stavKonta == hrac.stavKonta &&
                Objects.equals(seznamTreneru, hrac.seznamTreneru) &&
                Objects.equals(seznamKoni, hrac.seznamKoni) &&
                meno.equals(hrac.meno);
    }

    /**
     * @version - etapa-3
     * @author - xlacina5
     */
    @Override
    public int hashCode() {
        return Objects.hash(seznamTreneru, seznamKoni, stavKonta, meno);
    }

    /**
     * @version - etapa-3
     * @author - xlacina5
     */

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hrac{");
        sb.append("seznamTreneru=").append(seznamTreneru);
        sb.append(", seznamKoni=").append(seznamKoni);
        sb.append(", stavKonta=").append(stavKonta);
        sb.append(", meno='").append(meno).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Metoda pripočíta alebo odpocíta určitú sumu z hračovho konta.
     * @param suma hodnota o koľko sa zmeni hračové konto, rozsah: -x; x (-300, 500,...).
     * @author xrepka
     * @version etapa-1
     */

    public void transakce(int suma){
        stavKonta += suma;

    }


    /**
     * Metoda pre vratenie hodnoty konta.
     * @return hodnota konta.
     * @author xrepka
     * @version etapa-1
     */

    public int getKonto(){
        return stavKonta;
    }

    /**
     * Metoda, ktora pri zakupeni prida kona do vlastnenych konov.
     * @param kun kon ktory sa prida do vlastnenych konov.
     * @author xrepka
     * @version etapa-1
     */

    public void pridejKone(Kun kun){
        seznamKoni.add(kun);
    }


    /**
     * Metoda pre vratenie pola vlastnenych konov.
     * @return pole vlasnenych konov.
     * @author xrepka
     * @version etapa-1
     */
    public List<Kun> getKone(){
        return seznamKoni;
    }

    public void pridejTrenera(Trener trener){
        seznamTreneru.add(trener);
        //throw new UnsupportedOperationException("Not impleneted yet.");
    }

    /**
     * Metoda na vrácení pole trenerů, které hráč vlastní
     * @return pole hráčových trenérů
     * @author xlacina5
     * @version etapa-1
     */

    //TODO Upravit na unmodifiableCollection
    public List<Trener> getTreneri(){
        //return Collections.unmodifiableCollection(seznamTreneru);
        return seznamTreneru; //upravit na to unmodifiableCollection - viz cviko
    }

    /**
     * Vraci id hrace;
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Vraci pozici hrace
     * @return pozice
     */
    public int getPozice() {
        return pozice;
    }

    public void setPozice(int hodnotaHodu) {

        int aktualniPozice=this.pozice;
        int novaPozice=aktualniPozice+hodnotaHodu;
        int rozdil;


        this.pozice+=hodnotaHodu;

        if(novaPozice>pocetPolicek){
            rozdil=novaPozice-pocetPolicek;
            this.pozice=rozdil;
        }
        else{
            this.pozice=novaPozice;
        }

    }

    /**
     * Metoda vypise vsechny trenery
     * @author xlacina5
     * @version etapa-3
     */



    public void vypisTrenery(){
        int pocetTreneru=seznamTreneru.size();
        System.out.println(pocetTreneru);

        if(pocetTreneru>0){
            System.out.println("Vlastnis:"+pocetTreneru+" treneru");
            for (int i=0;i<pocetTreneru;i++){
                System.out.println(seznamTreneru.get(i).toString());
            }
        }
        else{
            System.out.println("Nevlastnis zadne trenery");
        }

    }


    // Main pouze pro testovani :)

    public static void main(String[] args) {
        /*Hrac hrac = new Hrac("Ivan",1000);
        Hrac hrac1 = new Hrac("Ivan",1000);
        HerniPlan herniPlan = new HerniPlan();*/


        //testovani policek
        /*herniPlan.nactiPolicka();
        for(int i=0;i<herniPlan.getPocetPolicek();i++){
            herniPlan.zobrazInformaceOPolicku(i);
        }*/


        //testovani Koni
        /*Kun kunA = new Kun(1,1000,"hneda",0);
        Kun kunB = new Kun(2,10000,"cerna",0);
        Kun kunC = new Kun(3,100000,"bila",0);

        herniPlan.vypisKone();
        herniPlan.pridejKone(kunA);
        herniPlan.pridejKone(kunB);
        herniPlan.pridejKone(kunC);

        herniPlan.vypisKone();*/


        //testovani treneru

        /*Trener trener = new Trener(1,"prvni trener");
        Trener trener1 = new Trener(2,"prvni1 trener");
        Trener trener2 = new Trener(3,"prvni2 trener");
        hrac.vypisTrenery();
        hrac.pridejTrenera(trener);
        hrac.pridejTrenera(trener1);
        hrac.pridejTrenera(trener2);
        hrac.vypisTrenery();



        System.out.println(hrac.toString());
        System.out.println(hrac.hashCode());
        System.out.println(hrac1.hashCode());
        System.out.println(hrac.equals(hrac1));*/
    }

}
