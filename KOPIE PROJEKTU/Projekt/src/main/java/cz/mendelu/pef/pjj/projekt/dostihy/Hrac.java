package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.ArrayList;
import java.util.List;

public class Hrac {

    private List<Trener> seznamTreneru = new ArrayList<>();
    private List<Kun> seznamKoni = new ArrayList<>();
    private int stavKonta;
    private String meno;



    Hrac (String meno, int konto){
        this.meno=meno;
        this.stavKonta=konto;
        this.seznamTreneru=null;
        this.seznamKoni=null;
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

}
