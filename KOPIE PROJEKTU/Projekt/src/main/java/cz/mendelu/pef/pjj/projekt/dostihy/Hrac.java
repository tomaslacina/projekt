package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.*;

public class Hrac {

    private List<Trener> seznamTreneru = new ArrayList<>();
    private List<Kun> seznamKoni = new ArrayList<>();
    private List<Policko> seznamMajetkuHrace = new ArrayList<>();
    private int stavKonta;
    private String meno;
    private int id; //pridani id
    private int pozice;
    private static final int konto = 30000; //staticka promenna stav konta
    private static final int pocetPolicek=40;
    private boolean staj;
    private boolean preprava;




    /*
     * Pridani parametru id - aby to bylo identifikovatelne - kdyby byly 2 hraci se stejnym jmenem
     * Pridani parametru pozice - zruseni figurky (asi by to bylo zbytecne)
     * */
    Hrac (String meno, int id){
        this.meno=meno;
        this.stavKonta=konto;
        this.id=id;
        this.pozice=1;
        this.staj=false;
        this.preprava=false;
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


    public String vypisHraca(){
        String vypis="";
        vypis+="Meno: "+meno+"\n"+"Stav konta: "+stavKonta+"\n"+"Seznam koni: "+seznamKoni+"\n"+"Sezam treneru: "+seznamTreneru+"\n";
        return vypis;


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
     * Vrati jestli hrac vlastni staj
     * @return true/false
     */

    public boolean vlastniStaj() {
        return staj;
    }

    /**
     * Metoda pro nastaveni hodnoty staje (true/false)
     * @param staj
     */
    public void setStaj(boolean staj) {
        this.staj = staj;
    }

    public boolean vlastniPrepravu(){
        return preprava;
    }
    public void setPreprava(boolean preprava){
        this.preprava=preprava;
    }

    /**
     * Kdyz hrac vlastni jak staj tak prepravu dostane od protihracu 200 nasobek hodnoty hodu
     * Kdyz hrac vlastni bude staj nebo prepravu dostane 80 nasobek hodnoty hodu
     * Jinak dostane 0 nasobek
     * @return
     */
    public int getNasobek(){

        if (this.staj == true && this.preprava==true){
            return 200;
        }
        else if (this.staj==true || this.preprava==true){
            return 80;

        }
        else {
            return 0;
        }

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

    public void setPoziceStart(){
        this.pozice=1;
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





    public int getPoplatekZaTrenera(){
        int pocetTreneru = seznamTreneru.size();
        System.out.println(pocetTreneru*1000);
        return pocetTreneru*1000;
    }

    public String getMeno() {
        return meno;
    }

    /**
     * Prida majetek do hracova seznamu
     * @param policko
     */
    public void pridejMajetekHraci (Policko policko){
        seznamMajetkuHrace.add(policko);
        System.out.println("Pridano policko:"+policko.toString());
    }

    /**
     * Vrati jestli hrac vubec vlastni policko ktere zadal
     * @param policko
     * @return
     */

    public boolean vlastniHracMajetek(Policko policko){

        if(seznamMajetkuHrace.contains(policko)==true){
            System.out.println("Vlastnis policko");
            return true;
        }
        else {
            System.out.println("NEvlastnis policko");
            return false;
        }
    }









    /**
     * Proda a odebere majetek ze seznamu hrace, provede transakci
     *
     */
    public boolean prodejMajetekBance(Policko policko, Hrac hrac){
        int prodejniCena;

        if (seznamMajetkuHrace.contains(policko)==true){
            System.out.println("Vlastnis policko");
            prodejniCena=policko.getProdejniCena();
            hrac.transakce(prodejniCena);
            policko.setObsazenoHracem(0); //odeberu vlastnika
            seznamMajetkuHrace.remove(policko); //odeberu z hracovy kolekce policek
            return true;
        }
        else{
            return false;
        }


    }

}


