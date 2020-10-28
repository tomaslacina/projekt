package cz.mendelu.pef.pjj.projekt.dostihy;

public class Figurka {

    private int pozice;
    private final int pocetPolicek=40;

    /**
     * Konstruktor figurky
     * @param pozice - defaultně bude nastaveno 0; pro testování je zatím konstruktor parametrický
     * @author xlacina5
     * @version etapa-3 - 27.10.2020
     */
    Figurka(int pozice){
        this.pozice=pozice;
    }

    /**
     * Vrati poziciu figurky na plane.
     * @return pozicia figurky moze byt : 0,1,2,...40
     * @author xrepka
     * @version etapa-1
     */
    int getPoziceFigurky(){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Nastavi novou pozici figurce.
     * @param posun - převezme hod z kostky (1-6) , nebo z akční karty (libovolné číslo)
     * @author xlacina5
     * @version etapa-1
     */
    void setPoziceFigurky(int posun){

        int aktualniPozice=this.pozice;
        int novaPozice=aktualniPozice+posun;
        int rozdil;

        this.pozice+=posun;

        if(novaPozice>pocetPolicek){
            rozdil=novaPozice-pocetPolicek;
            this.pozice=rozdil;
        }
        else{
            this.pozice=novaPozice;
        }
        System.out.println("Pozice figurky je:"+this.pozice);
    }

    public static void main(String[] args) {

        System.out.println("mozem jebat");
        System.out.println("Tak snad to teď neposerem :D");
        System.out.println("Pojebany rybicka");
        System.out.println("skuska 1.comitu");
        System.out.println("skuska 2.comitu");
        System.out.println("zkurvený COVID");

    }
}
