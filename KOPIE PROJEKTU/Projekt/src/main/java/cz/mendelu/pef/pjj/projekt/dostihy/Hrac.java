package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hrac {

    private List<Trener> seznamTreneru = new ArrayList<>();
    private List<Kun> seznamKoni = new ArrayList<>();
    private int stavKonta;
    private String meno;



    Hrac (String meno, int konto){
        this.meno=meno;
        this.stavKonta=konto;

    }

    /**
     * predpokladejme ze kazdy hrac bude mit unikatni herni username nebo nick
     * @version - etapa-3
     * @author - xlacina5
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hrac hrac = (Hrac) o;
        return meno.equals(hrac.meno);
    }

    /**
     * @version - etapa-3
     * @author - xlacina5
     */

    @Override
    public int hashCode() {
        return Objects.hash(meno);
    }

    /**
     * @version - etapa-3
     * @author - xlacina5
     */

    @Override
    public String toString() {
        return "Hrac{" +
                "seznamTreneru=" + seznamTreneru +
                ", seznamKoni=" + seznamKoni +
                ", stavKonta=" + stavKonta +
                ", meno='" + meno + '\'' +
                '}';
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

    public List<Trener> getTreneri(){
        //return Collections.unmodifiableCollection(seznamTreneru);
        return seznamTreneru; //upravit na to unmodifiableCollection - viz cviko
        //throw new UnsupportedOperationException("Not implemented yet.");
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

    public static void main(String[] args) {
        Hrac hrac = new Hrac("Ivan",1000);
        Hrac hrac1 = new Hrac("Ivan",1000);

        Trener trener = new Trener(1,"prvni trener");
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
        System.out.println(hrac.equals(hrac1));
    }

}
