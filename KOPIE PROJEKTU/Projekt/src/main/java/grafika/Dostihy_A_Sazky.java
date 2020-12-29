package grafika;

import cz.mendelu.pef.pjj.projekt.dostihy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

public class Dostihy_A_Sazky extends JFrame {
    JTextArea textAreaTa;
    JTextArea textAreaHracNaTahuTa;
    JScrollPane scrollPane;
    JButton pocetHracuBtn;
    JComboBox pocetHracuCombo;
    JLabel popisekLbl;
    JLabel jmenoHraceLbl;
    JLabel herniPlanLbl;
    JLabel hracNaTahuLbl;
    JLabel markerLbl;
    JTextField jmenoTf;
    JButton vytvorHraceBtn;


    JButton nactiPravidlaBtn;
    JButton vypisHraceBtn;
    JButton kostkaBtn;
    JButton dalsiHracBtn;
    JButton zobrazAktualnihoHraceBtn;
    JButton zobrazInformacePolickoBtn;
    JButton zahrajTahBtn;
    JButton zaplatTrestBtn;
    JButton financeBtn;
    JButton nahodaBtn;
    JButton stajBtn;
    JButton koupitStajBtn;
    JButton zaplatProhlidkuStajeBtn;
    JButton prepravaBtn;
    JButton koupitPrepravuBtn;
    JButton zaplatPouzitiPrepravyBtn;
    JButton trenerBtn;
    JButton kupitTreneraBtn;
    JButton kunBtn;
    JButton kupZetonBtn;
    JButton kupKone;

    JLabel cisloPolickaLbl;
    JTextField cisloPolickaTf;
    JButton prodejMajetekBtn;


    TypPolicka typPolicka;
    int pocetHracu;
    int cisloHrace=0;

    int hodnotaHodu=0;
    int aktualniHrac=1;
    int xPozice=0;
    int yPozice=0;
    boolean rozhodnutie;
    Hrac hrac;
    Policko policko;



    public Dostihy_A_Sazky(){
        HerniPlan hp = new HerniPlan();
        super.setTitle("Dostihy a sazky");
        //nastaveni okna
        setLayout(null);
        setSize(1250,800); //velikost aplikace
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zmackunim krizku se to zavre a ukonci
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);


        //prvky aplikace

        textAreaTa = new JTextArea();
        textAreaTa.setBounds(10,10,500,60); //nastaveni velikosti - musi byt asi stejne jak scrollPane

        scrollPane = new JScrollPane(); //aby se to dalo posunovat nahoru a dolu (doleva, doprava)
        scrollPane.setBounds(10,10,500,60);
        scrollPane.getViewport().setBackground(Color.WHITE); //pozadi
        scrollPane.getViewport().add(textAreaTa); //pridani textArea do scrollPane


        popisekLbl = new JLabel("Po�et hr���");
        popisekLbl.setBounds(10,80,100,30);



        pocetHracuCombo = new JComboBox();
        for (int i =2;i<=7;i++){
            pocetHracuCombo.addItem(i);
        }
        pocetHracuCombo.setBounds(100,80,100,30);


        /**
         * Button pre potvrdenie po�tu hr��ov v setup-e.
         * @author xrepka
         * @version etapa-4
         */

        pocetHracuBtn=new JButton("Potvr� po�et");
        pocetHracuBtn.setBounds(200,80,150,30);
        pocetHracuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pocetHracu= Integer.parseInt(String.valueOf(pocetHracuCombo.getSelectedItem()));
                textAreaTa.setText("Zadan� po�et hr��� je: "+pocetHracu+"\n");
                textAreaTa.append("Nyn� zadej do pol��ka jm�no hr��e - alespo� 3 znaky:\n");
                pocetHracuCombo.setVisible(false);
                pocetHracuBtn.setVisible(false);
                popisekLbl.setVisible(false);

                jmenoHraceLbl.setVisible(true);
                jmenoTf.setVisible(true);
                vytvorHraceBtn.setVisible(true);
            }
        });
        /**
         * Nadis v setup-e.
         * @author xrepka
         * @version etapa-4
         */

        jmenoHraceLbl= new JLabel("Jm�no hr��e:");
        jmenoHraceLbl.setBounds(10,80,100,30);
        jmenoHraceLbl.setVisible(false);


        jmenoTf=new JTextField();
        jmenoTf.setBounds(100,80,100,30);
        jmenoTf.setVisible(false);

        /**
         * Vytvo�en� tla��tka pro vytvo�en� nov�ho hr��e
         * @author: xlacina5
         * @version: etapa-4
         */

        vytvorHraceBtn=new JButton("Vytvo� hr��e");
        vytvorHraceBtn.setBounds(200,80,150,30);
        vytvorHraceBtn.setVisible(false);
        vytvorHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //overeniVstupu
                if(jmenoTf.getText().length()>=3){
                    cisloHrace++;
                    System.out.println(cisloHrace);
                    textAreaTa.setText("Jmeno hr��e ��slo:"+cisloHrace+" je:"+jmenoTf.getText()+"\n");
                    hp.vytvorAPridejHrace(jmenoTf.getText(),cisloHrace);
                    textAreaTa.append("Hr�� byl �sp�n� vytvo�en");
                    jmenoTf.setText("");
                }
                else{
                    textAreaTa.setText("NEPLATN� VSTUP!!! JM�NO HR��E MUS� OBSAHOVAT ALESPO� 3 ZNAKY!");
                    jmenoTf.setText("");

                }

                if(cisloHrace==pocetHracu){
                    textAreaTa.setText("Vytvo�ili jsme hru pro po�et hr���:"+cisloHrace+"\n");
                    jmenoTf.setVisible(false);
                    jmenoHraceLbl.setVisible(false);
                    vytvorHraceBtn.setVisible(false);


                    textAreaHracNaTahuTa.setVisible(true);
                    nactiPravidlaBtn.setVisible(true);
                    vypisHraceBtn.setVisible(true);
                    kostkaBtn.setVisible(true);
                    zobrazAktualnihoHraceBtn.setVisible(true);
                    zobrazInformacePolickoBtn.setVisible(true);
                    herniPlanLbl.setVisible(true);
                    hracNaTahuLbl.setVisible(true);
                    markerLbl.setVisible(true);
                    zahrajTahBtn.setVisible(true);

                    textAreaHracNaTahuTa.setText(hp.vypisAktualnihoHrace(aktualniHrac));
                }
            }
        });

        /**
         * Tla��tko pro na�ten� pravidel ze souboru
         *@author: xlacina5
         *@version: etapa-4
         */
        nactiPravidlaBtn = new JButton("Pravidla Hry");
        nactiPravidlaBtn.setBounds(1000,10,150,30);
        nactiPravidlaBtn.setVisible(false);
        nactiPravidlaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.prectiZeSouboruPravidla());
            }
        });

        /**
         * Tla��tko pro v�pis hr���
         * @author: xlacina5
         * @version: etapa-4
         */

        vypisHraceBtn = new JButton("V�pis Hr���");
        vypisHraceBtn.setBounds(1000,50,150,30);
        vypisHraceBtn.setVisible(false);
        vypisHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.vypisVsechHracu());
            }
        });

        /**
         * Vytvorenie tla�idla pre hod kockou.
         * @author xrepka
         * @version etapa-4
         */

        kostkaBtn = new JButton("Kostka");
        kostkaBtn.setBounds(1000,90,150,30);
        kostkaBtn.setVisible(false);
        kostkaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                hodnotaHodu+=hp.hodKostkou();
                textAreaTa.setText("Hodil jsi kostkou:");
                textAreaTa.append("Hodnota hodu:"+hodnotaHodu+"\n");
                kostkaBtn.setVisible(false);
                if(hodnotaHodu==6){
                    textAreaTa.append("Hodil jsi 6tku - h�e� je�t� jednou\n");
                    kostkaBtn.setVisible(true);
                    dalsiHracBtn.setVisible(false);
                }
                else{

                    //zobraz akce - tlacitka;
                    textAreaTa.append("V tomto tahu si hodil:"+hodnotaHodu+"\n");
                    hp.posunPoPlane(aktualniHrac,hodnotaHodu); //posun po planu
                    hodnotaHodu=0;//vynuluju hodnotu hodu
                    kostkaBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }


            }
        });

        /**
         * Tla��tko pro p�epnut� na dal��ho hr��e
         * @version: etapa-4
         * @author: xlacina5
         */

        dalsiHracBtn = new JButton("Dal�� Hr��");
        dalsiHracBtn.setBounds(1000,130,150,30);
        dalsiHracBtn.setVisible(false);
        dalsiHracBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //zatim
                dalsiHracBtn.setVisible(false);
                zahrajTahBtn.setVisible(true);
                kupitTreneraBtn.setVisible(false);
                kupZetonBtn.setVisible(false);
                kupKone.setVisible(false);

                aktualniHrac++; //kdyz prekrocim, tak vynuluj - nastav na 1


                if(aktualniHrac>pocetHracu){
                    aktualniHrac=1;
                }
                xPozice=hp.getXPolicka(hp.vratHrace(aktualniHrac).getPozice());
                yPozice=hp.getYPolicka(hp.vratHrace(aktualniHrac).getPozice());
                markerLbl.setBounds(xPozice,yPozice,30,30);
                //System.out.println(aktualniHrac);
                System.out.println(xPozice+" "+yPozice);




            }
        });

        /**
         * Tla��tko pro zobrazen� aktu�ln�ho hr��e, kter� je na tahu
         * @version: etapa-4
         * @author: xlacina5
         */

        zobrazAktualnihoHraceBtn = new JButton("Aktu�ln� hr��");
        zobrazAktualnihoHraceBtn.setBounds(1000,170,150,30);
        zobrazAktualnihoHraceBtn.setVisible(false);
        zobrazAktualnihoHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText("Informace o hr��i ��slo:"+aktualniHrac+"\n");
                textAreaTa.append(hp.vypisAktualnihoHrace(aktualniHrac)+"\n");
                textAreaHracNaTahuTa.setText("");
                textAreaHracNaTahuTa.append(hp.vypisAktualnihoHrace(aktualniHrac));
            }
        });

        /**
         * Zobraz� informace o pol��ku
         * @author: xlacina5
         * @version: etapa-4
         */

        zobrazInformacePolickoBtn = new JButton("Informace o pol��ku");
        zobrazInformacePolickoBtn.setBounds(1000,210,150,30);
        zobrazInformacePolickoBtn.setVisible(false);
        zobrazInformacePolickoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.append(hp.zobrazInformaceOPolicku(aktualniHrac)+"\n");

            }
        });

        /**
         * Na��tanie obr�zku pl�nu do hry.
         * @author xrepka
         * @version etapa-4
         */

        herniPlanLbl=new JLabel();
        herniPlanLbl.setIcon(new ImageIcon("dostihysazky.png"));
        herniPlanLbl.setBounds(450,100,500,500);
        herniPlanLbl.validate();
        herniPlanLbl.setVisible(false);


        /**
         * Nadpis, kotr� sa zobraz� po prvotnom setup-e.
         * @author xrepka
         * @version etapa-4
         */


        hracNaTahuLbl = new JLabel("Hr�� na tahu:");
        hracNaTahuLbl.setBounds(10,120,150,30);
        hracNaTahuLbl.setFont(new Font("Thimes",Font.BOLD,20));
        hracNaTahuLbl.setVisible(false);

        /**
         * Vypis text area pre v�pis inform�ci� o hr��ovi, ktor� je prave na �ahu.
         * @author xrepka
         * @version etapa-4
         */

        textAreaHracNaTahuTa = new JTextArea();
        textAreaHracNaTahuTa.setBounds(10,180,300,200);
        textAreaHracNaTahuTa.setFont(new Font("Thimes",Font.BOLD,12));
        textAreaHracNaTahuTa.setVisible(false);

        /**
         * Marker pre zobrazenie poz�cie aktu�lneho hr��a
         * @author xrepka
         * @version etapa-4
         */

        markerLbl = new JLabel();
        markerLbl.setIcon(new ImageIcon("x.png"));
        markerLbl.setBounds(415,500,30,30);
        markerLbl.validate();
        markerLbl.setVisible(false);


        /**
         * Odecte hracovi, ktery stoji na policku trest castku 1.000 Kc
         */
        zaplatTrestBtn = new JButton("Zaplatit trest");
        zaplatTrestBtn.setBounds(300,700,150,30);
        zaplatTrestBtn.setVisible(false);
        zaplatTrestBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac=hp.vratHrace(aktualniHrac); //instance hrace, ktery je na tahu
                textAreaTa.append("Stav konta pred transakci:"+hrac.getKonto());
                textAreaTa.append("Hodnota trestu je:"+hp.getHodnotaTrestu());
                if(hrac.getKonto()>hp.getHodnotaTrestu()){
                    textAreaTa.append("Trest byl zaplacen, tvuj tah je u konce");
                    hrac.transakce(hp.getHodnotaTrestu());
                    textAreaTa.append("Stav konta po trestu je:"+hrac.getKonto());
                    dalsiHracBtn.setVisible(true);
                    zaplatTrestBtn.setVisible(false);
                }
                else{
                    textAreaTa.append("Nemas dostatek penez na uctu...");

                    cisloPolickaLbl.setVisible(true);
                    cisloPolickaTf.setVisible(true);
                    prodejMajetekBtn.setVisible(true);

                    dalsiHracBtn.setVisible(true);
                }

            }
        });


        /**
         * Tlacitko pro policku (kartu) finance
         * Z herniho planu si necham vratit nahodnou kartu financi
         * Kdyz bude castka kladna - hraci se pripisou na ucet penize
         * Kdyz bude castka zaporna - pokud bude mit hrac dost financi, odectou se z uctu a hraje dalsi hrac
         * Jinak bude hrac nucen prodat svuj majetek ... musime doimplemenotvat......
         */

        financeBtn = new JButton("Finance");
        financeBtn.setBounds(300,700,150,30);
        financeBtn.setVisible(false);
        financeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac=hp.vratHrace(aktualniHrac); //instance hrace, ktery je na tahu
                Finance finance = hp.getKartaFinance();
                int castka = finance.getCastkaFinance();

                textAreaTa.setText("Vygenerovala se ti tato karta financi:\n");
                textAreaTa.append(finance.getTextFinance());

                if(castka>0){
                    textAreaTa.append("Gratulujeme, na tvuj herni ucet se pripise:"+castka+"\n");
                    hrac.transakce(castka);
                    financeBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.append("Bohuzel, na karte financi je zaporne cislo "+castka+"\n");
                    textAreaTa.append("Budes muset zaplatit \n");
                    if(hrac.getKonto()>castka){
                        hrac.transakce(castka);
                        textAreaTa.append("Transakce probehla v poradku!\n");
                        financeBtn.setVisible(false);
                        dalsiHracBtn.setVisible(true);
                    }
                    else{
                        textAreaTa.append("Nemas dostatek penez na uctu...\n");

                        cisloPolickaLbl.setVisible(true);
                        cisloPolickaTf.setVisible(true);
                        prodejMajetekBtn.setVisible(true);

                        dalsiHracBtn.setVisible(true);
                    }
                }
            }
        });


        nahodaBtn=new JButton("Nahoda");
        nahodaBtn.setBounds(300,700,150,30);
        nahodaBtn.setVisible(false);
        nahodaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);
                Nahoda nahoda = hp.getKartaNahody();
                textAreaTa.append(nahoda.getTextNahody()+"\n");
                textAreaTa.append("Stara pozice:"+hrac.getPozice()+"\n");
                if((hrac.getPozice()+nahoda.getHodnotaNahody())<0){
                    textAreaTa.append("Nahoda te posunula na startovaci policko");
                    hrac.setPoziceStart();
                }
                else{
                    hp.posunPoPlane(aktualniHrac,nahoda.getHodnotaNahody());
                }

                textAreaTa.append("Nova pozice:"+hrac.getPozice()+"\n");
                nahodaBtn.setVisible(false);
                dalsiHracBtn.setVisible(true);

            }
        });

        koupitStajBtn = new JButton("Koupit staj");
        koupitStajBtn.setBounds(500,700,150,30);
        koupitStajBtn.setVisible(false);
        koupitStajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);
                policko=hp.getPolicko(hrac.getPozice());

                if(hrac.getKonto()>=hp.getCenaStaje()){
                    textAreaTa.append("Gratulujeme koupil jsi staj!\n");
                    textAreaTa.append("Stav pred transakci:"+hrac.getKonto()+"\n");
                    hrac.transakce((-1)*hp.getCenaStaje());
                    textAreaTa.append("Stav po transakci:"+hrac.getKonto()+"\n");
                    policko.setObsazenoHracem(hrac.getId()); //nastavim vlastnictvi policka hraci na tahu
                    hrac.setStaj(true);
                    hrac.pridejMajetekHraci(hp.getPolicko(hrac.getPozice()));
                    koupitStajBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.append("Na konte nemas dostatek financi\n");
                    textAreaTa.append("Bud prodas majetek nebo klikni na tlacitko dalsi hrac.\n");
                    dalsiHracBtn.setVisible(true);

                    cisloPolickaLbl.setVisible(true);
                    cisloPolickaTf.setVisible(true);
                    prodejMajetekBtn.setVisible(true);
                }

            }
        });

        zaplatProhlidkuStajeBtn = new JButton("Zaplat p�epravu");
        zaplatProhlidkuStajeBtn.setBounds(500,700,150,30);
        zaplatProhlidkuStajeBtn.setVisible(false);
        zaplatProhlidkuStajeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac=hp.vratHrace(aktualniHrac);
                policko=hp.getPolicko(hrac.getPozice()); //vrati pozici policka staje
                int idVlastnika = policko.getObsazenoHracem();
                Hrac vlastnikStaje = hp.vratHrace(idVlastnika);
                int cenaProhlidky = hodnotaHodu*vlastnikStaje.getNasobek();
                textAreaTa.append("Cena prohlidky staje je:"+cenaProhlidky+"\n");

                if(hrac.getId()==idVlastnika){
                    textAreaTa.append("Jsi vlastnikem policka, neplatis nic ani nic nedostanes\n");
                    dalsiHracBtn.setVisible(true);
                    zaplatProhlidkuStajeBtn.setVisible(false);
                }
                else if(hrac.getKonto()>=cenaProhlidky){
                    hrac.transakce((-1)*cenaProhlidky);
                    vlastnikStaje.transakce(cenaProhlidky);
                    textAreaTa.append("Hrac:"+hrac.vypisHraca()+" zaplatil za prohildku staje hraci:\n"+vlastnikStaje.vypisHraca()+"\n");
                    zaplatProhlidkuStajeBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.append("Na konte nemas dostatek financi k zaplaceni prohlidky:\n");

                    cisloPolickaLbl.setVisible(true);
                    cisloPolickaTf.setVisible(true);
                    prodejMajetekBtn.setVisible(true);
                }
            }
        });


        stajBtn = new JButton("Staj");
        stajBtn.setBounds(300,700,150,30);
        stajBtn.setVisible(false);
        stajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);
                policko=hp.getPolicko(hrac.getPozice());

                if(policko.getObsazenoHracem()==0){
                    textAreaTa.setText("Policko staj neni obsazeno zadnym hracem\n");
                    textAreaTa.append("Muzes si policko koupit kliknutim na tlacitko koupit staj \n");
                    textAreaTa.append("Pokud nechces kupovat staj, klikni na tlacitko dalsi hrac\n");
                    koupitStajBtn.setVisible(true);
                    stajBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.setText("Policko staj jiz vlastni jiny hrac:"+hrac.toString()+"\n");
                    textAreaTa.append("Budes muset zaplatit za prepravu \n");
                    zaplatProhlidkuStajeBtn.setVisible(true);
                    stajBtn.setVisible(false);
                }


            }
        });

        zaplatPouzitiPrepravyBtn = new JButton("Pou��t p�epravu");
        zaplatPouzitiPrepravyBtn.setBounds(500,700,150,30);
        zaplatPouzitiPrepravyBtn.setVisible(false);
        zaplatPouzitiPrepravyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac=hp.vratHrace(aktualniHrac);
                policko=hp.getPolicko(hrac.getPozice()); //vrati pozici policka prepravy
                int idVlastnika = policko.getObsazenoHracem();
                Hrac vlastnikPrepravy = hp.vratHrace(idVlastnika);
                int cenaPrepravy = hodnotaHodu*vlastnikPrepravy.getNasobek();
                textAreaTa.append("Cena prepravy staje je:"+cenaPrepravy+"\n");

                if(hrac.getId()==idVlastnika){
                    textAreaTa.append("Jsi vlastnikem policka, neplatis nic ani nic nedostanes\n");
                    dalsiHracBtn.setVisible(true);
                    zaplatPouzitiPrepravyBtn.setVisible(false);
                }
                else if(hrac.getKonto()>=cenaPrepravy){
                    hrac.transakce((-1)*cenaPrepravy);
                    vlastnikPrepravy.transakce(cenaPrepravy);
                    textAreaTa.append("Hrac:"+hrac.vypisHraca()+" zaplatil za pouziti prepravy hraci:\n"+vlastnikPrepravy.vypisHraca()+"\n");
                    zaplatPouzitiPrepravyBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.append("Na konte nemas dostatek financi k zaplaceni prepravy:\n");

                    cisloPolickaLbl.setVisible(true);
                    cisloPolickaTf.setVisible(true);
                    prodejMajetekBtn.setVisible(true);
                }

            }
        });

        koupitPrepravuBtn = new JButton("Koupit p�epravu");
        koupitPrepravuBtn.setBounds(500,700,150,30);
        koupitPrepravuBtn.setVisible(false);
        koupitPrepravuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);
                policko=hp.getPolicko(hrac.getPozice());

                if(hrac.getKonto()>=hp.getCenaPrepravy()){
                    textAreaTa.append("Gratulujeme koupil jsi prepravu!\n");
                    textAreaTa.append("Stav pred transakci:"+hrac.getKonto()+"\n");
                    hrac.transakce((-1)*hp.getCenaStaje());
                    textAreaTa.append("Stav po transakci:"+hrac.getKonto()+"\n");
                    policko.setObsazenoHracem(hrac.getId()); //nastavim vlastnictvi policka hraci na tahu
                    hrac.setPreprava(true);
                    koupitPrepravuBtn.setVisible(false);
                    hrac.pridejMajetekHraci(hp.getPolicko(hrac.getPozice()));
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.append("Na konte nemas dostatek financi\n");
                    textAreaTa.append("Bud prodas majetek nebo klikni na tlacitko dalsi hrac.\n");
                    dalsiHracBtn.setVisible(true);

                    cisloPolickaLbl.setVisible(true);
                    cisloPolickaTf.setVisible(true);
                    prodejMajetekBtn.setVisible(true);
                }

            }
        });


        prepravaBtn = new JButton("P�eprava");
        prepravaBtn.setBounds(300,700,150,30);
        prepravaBtn.setVisible(false);
        prepravaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);
                policko=hp.getPolicko(hrac.getPozice());

                if(policko.getObsazenoHracem()==0){
                    textAreaTa.setText("Policko preprava neni obsazeno zadnym hracem\n");
                    textAreaTa.append("Muzes si policko koupit kliknutim na tlacitko koupit prepravu \n");
                    textAreaTa.append("Pokud nechces kupovat prepravu, klikni na tlacitko dalsi hrac\n");
                    koupitPrepravuBtn.setVisible(true);
                    prepravaBtn.setVisible(false);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.setText("Policko preprava jiz vlastni jiny hrac:"+hrac.vypisHraca()+"\n");
                    textAreaTa.append("Budes muset zaplatit za prepravu, pokud nejsi jeho vlastnikem \n");
                    zaplatPouzitiPrepravyBtn.setVisible(true);
                    prepravaBtn.setVisible(false);
                }
            }
        });



        kupitTreneraBtn = new JButton("Kupit trenera");
        kupitTreneraBtn.setBounds(500,700,150,30);
        kupitTreneraBtn.setVisible(false);
        kupitTreneraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);
                hrac.transakce(-4000);
                policko.setObsazenoHracem(hrac.getId());
                textAreaTa.append("Blaho�el�me! Kupil si si tr�nera za 4000. \n");
                textAreaTa.append("Zostatok na tvojom konte je "+hrac.getKonto()+ "\n");
                kupitTreneraBtn.setVisible(false);
                hrac.pridejMajetekHraci(hp.getPolicko(hrac.getPozice()));
                Trener trener = new Trener(hrac.getPozice(),"");
                hrac.pridejTrenera(trener);
            }
        });



        trenerBtn=new JButton("Trener");
        trenerBtn.setBounds(300,700,150,30);
        trenerBtn.setVisible(false);
        trenerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trenerBtn.setVisible(false);
                hrac = hp.vratHrace(aktualniHrac);
                policko = hp.getPolicko(hrac.getPozice());
                if (policko.getObsazenoHracem() == 0) {
                    //hrac si trenera moze kupit
                    dalsiHracBtn.setVisible(true);
                    kupitTreneraBtn.setVisible(true);
                    textAreaTa.append("\nM� mo�nos� si k�pi� tren�ra na tomto pol��ku. \n");
                    textAreaTa.append("Ak chce� kupit trenera, klikni na kupit trenera. \n");
                    textAreaTa.append("Ak trenera kupit nechce�, klikni na dal�� hr��. \n");

                } else {
                    textAreaTa.append("Tr�nera vlastn� in� hr��, mus� mu zaplati�. \n");
                    int idVlastnika = policko.getObsazenoHracem();
                    Hrac vlastnikTrenera = hp.vratHrace(idVlastnika);
                    int cenaZaPronajati = vlastnikTrenera.getPoplatekZaTrenera();
                    if (hrac.getKonto() >= cenaZaPronajati) {
                        hrac.transakce((-1) * cenaZaPronajati);
                        vlastnikTrenera.transakce(cenaZaPronajati);
                        textAreaTa.append("Zaplatil si hracovi " + vlastnikTrenera.getMeno() + " sumu " + vlastnikTrenera.getPoplatekZaTrenera() + "\n");
                        textAreaTa.append("Zostatok na tvojom konte je " + hp.vratHrace(aktualniHrac).getKonto() + "\n");
                        dalsiHracBtn.setVisible(true);
                    } else {
                        textAreaTa.append("Nem� dostato�n� zostatok na tvojom konte. \n");
                        textAreaTa.append("Bud prodas majetek nebo klikni na tlacitko dalsi hrac.\n");
                        dalsiHracBtn.setVisible(true);
                        //prodej majetek
                        cisloPolickaLbl.setVisible(true);
                        cisloPolickaTf.setVisible(true);
                        prodejMajetekBtn.setVisible(true);
                    }

                }
            }


        });

        /**
         * Prodej majetku
         */


        cisloPolickaLbl = new JLabel("��slo pol��ka:");
        cisloPolickaLbl.setBounds(450,600,100,30);
        cisloPolickaLbl.setVisible(true);

        cisloPolickaTf = new JTextField();
        cisloPolickaTf.setBounds(550,600,150,30);
        cisloPolickaTf.setVisible(true);

        prodejMajetekBtn = new JButton("Prodej majetek");
        prodejMajetekBtn.setBounds(700,600,150,30);
        prodejMajetekBtn.setVisible(true);
        prodejMajetekBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hrac hrac = hp.vratHrace(aktualniHrac);
                int cisloPolicka = Integer.parseInt(cisloPolickaTf.getText());
                Policko policko = hp.getPolicko(cisloPolicka);

                if(hrac.vlastniHracMajetek(policko)==true){
                    cisloPolickaLbl.setVisible(false);
                    cisloPolickaTf.setVisible(false);
                    //TODO overeni jestli opravdu chce prodat - kdyz zbude cas
                    if(hrac.prodejMajetekBance(policko,hrac)==true){
                        textAreaTa.append("Uspesne si prodal majetek bance:\n");
                        textAreaTa.append("Tvuj novy stav konta je:"+hrac.getKonto()+"\n");
                    }
                    else{
                        textAreaTa.append("NECO SE NEPOVEDLO \n");
                    }


                }
                else{
                    textAreaTa.append("Bohu�el toto poli�ko nevlastni�\n");
                    textAreaTa.append("Zadej znovu nebo ukonci svuj tah\n");
                }


            }
        });


        kupKone = new JButton("Kup kone");
        kupKone.setBounds(500,700,150,30);
        kupKone.setVisible(false);
        kupKone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kupZetonBtn.setVisible(false);
                hrac = hp.vratHrace(aktualniHrac);
                policko = hp.getPolicko(hrac.getPozice());
                if(hrac.getKonto()>=hp.getNakupniCenaKone(hrac.getPozice())){
                    hp.vratHrace(aktualniHrac).transakce(hp.getNakupniCenaKone(hp.vratHrace(aktualniHrac).getPozice()));
                    textAreaTa.append("\nBlaho�el�me! K�pil si ko�a\n");
                    hp.vratHrace(aktualniHrac).pridejMajetekHraci(policko);
                    //TODO transakcia sice prebehne ale:
                    //TODO je potrebn� prida� kone do hr��ovho zoznamu kon� (souvis� to asi s t�m TODO ktor� je nap�san� ni��ie ku else r. 874)
                }
                else{
                    textAreaTa.append("\nBohu�ial, nem� dostatok pe�az� na n�kup ko�a.\n");
                }
            }

        });


        kupZetonBtn =new JButton("Kupit zeton");
        kupZetonBtn.setBounds(500,700,150,30);
        kupZetonBtn.setVisible(false);
        kupZetonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kupKone.setVisible(false);
                hrac = hp.vratHrace(aktualniHrac);
                policko = hp.getPolicko(hrac.getPozice());
                //TODO tu sa sna��m dosta� cenu �etonu (cena vylep�enia ktor� ma ka�dy k�� in�) zo s�boru a urobi� tranakciu, no toto je asi najmenej podstatn�
                if(hrac.getKonto()>=hp.getCenaZetonuKone(hrac.getPozice())){
                    hp.vratHrace(aktualniHrac).transakce((-1)*hp.getCenaZetonuKone(hp.vratHrace(aktualniHrac).getPozice()));
                    hp.zvysPocetZetonu( hp.vratHrace(aktualniHrac).getPozice());
                    textAreaTa.append("\nBlaho�el�me! K�pil si si �et�n na tohto ko�a.\n");
                }
            }

        });



        kunBtn=new JButton("Kun");
        kunBtn.setBounds(300,700,150,30);
        kunBtn.setVisible(false);
        kunBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kunBtn.setVisible(false);
                hrac = hp.vratHrace(aktualniHrac);
                policko = hp.getPolicko(hrac.getPozice());
                //TODO porie�it pre�o sa nezobrazuje nazov kone
                textAreaTa.append(hp.getNazovKone(hrac.getPozice())+"\n");
                if (policko.getObsazenoHracem() == 0) {
                    //vlastni niekto tohto kona? - nevlastn�
                    textAreaTa.append("Ko�a nikto nevlastn�.\n");
                    textAreaTa.append("Ak chce� si k�pi� tohto ko�a stla� Kup kone.\n");
                    textAreaTa.append("Ak nie stla� dal�� hr��.\n");
                    kupKone.setVisible(true);
                    dalsiHracBtn.setVisible(true);


                    }

                else{

                    //niekto toto poli�ko vlastn�
                    if(hrac.getId()==policko.getObsazenoHracem()){
                        //vlastn� ho aktualni hr��
                        dalsiHracBtn.setVisible(true);
                        kupZetonBtn.setVisible(true);

                        textAreaTa.append("\nChce� dok�pi� �et�n na zv��enie n�jmu ko�a? Stoj�: "+hp.
                                getCenaZetonuKone(policko.getCisloPolicka())+"\n");
                        textAreaTa.append("Ak chce� kupit tak klikni na kupit �et�n, ak nechce� klikni na dal�� hr��");


                    } else {
                        //TODO (priklad) prv� hr�� kup� ko�a, druh� stupi na jeho poli�ko, no neuka�e sa �e ten 2. hr�� stoj� na koni toho prv�ho
                        //TODO teda sa nevyvol� ani tento else
                        //vlastni ho nejaky in� hra�
                        int idVlastnika = policko.getObsazenoHracem();
                        Hrac vlastnikKone = hp.vratHrace(idVlastnika);
                        int cenaZaPronajati = hp.getPoplatekZaKone(idVlastnika);

                        if (hrac.getKonto() >= cenaZaPronajati) {
                            //hrac ma dostatok penazi na zaplatenie
                            hrac.transakce((-1) * cenaZaPronajati);
                            vlastnikKone.transakce(cenaZaPronajati);
                            textAreaTa.append("Zaplatil si hracovi " + vlastnikKone.getMeno() + " sumu " + cenaZaPronajati + "\n");
                            textAreaTa.append("Zostatok na tvojom konte je " + hp.vratHrace(aktualniHrac).getKonto() + "\n");
                            dalsiHracBtn.setVisible(true);

                        }else{
                            //hrac nema dostatok penazi
                            textAreaTa.append("Nem� dostato�n� zostatok na tvojom konte. \n");
                            textAreaTa.append("Bud prodas majetek nebo klikni na tlacitko dalsi hrac.\n");
                            dalsiHracBtn.setVisible(true);
                            //prodej majetek
                            cisloPolickaLbl.setVisible(true);
                            cisloPolickaTf.setVisible(true);
                            prodejMajetekBtn.setVisible(true);

                            }

                        }

                }

            }
        });







        zahrajTahBtn=new JButton("Zahraj tah");
        zahrajTahBtn.setBounds(50,700,150,30);
        zahrajTahBtn.setVisible(false);
        zahrajTahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dalsiHracBtn.setVisible(true);
                zahrajTahBtn.setVisible(false);
                System.out.println("Aktualni hrac zahrajBtn:"+aktualniHrac);
                hodnotaHodu=hp.hodKostkou();
                hodnotaHodu=1 ;//.... pouze pro testovani
                hp.posunPoPlane(aktualniHrac,hodnotaHodu);
                xPozice=hp.getXPolicka(hp.vratHrace(aktualniHrac).getPozice());
                yPozice=hp.getYPolicka(hp.vratHrace(aktualniHrac).getPozice());
                markerLbl.setBounds(xPozice,yPozice,30,30);
                typPolicka=hp.getTypPolicka(hp.vratHrace(aktualniHrac).getPozice());
                //typPolicka=TypPolicka.PREPRAVA; //Pro testovani - abys nemusel klikat tak si zvolis typ policka a pak testujes
                textAreaTa.append("Hodna hodu: "+hodnotaHodu);




                switch (typPolicka){
                    case KUN -> {
                        textAreaTa.setText("Stojis na koni s n�zvom: ");
                        kunBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                    }

                    /**
                     * Otestovano
                     */

                    case TREST -> {
                        textAreaTa.setText("Stojis na policku trest:\n");
                        textAreaTa.append(hp.zobrazInformaceOPolicku(aktualniHrac)+"\n");
                        zaplatTrestBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);

                    }

                    /**
                     * Otestovano
                     */

                    case FINANCE -> {
                        textAreaTa.setText("Stojis na policku FINANCE: \n");
                        financeBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                    }

                    /**
                     * Otestovano
                     */

                    case NAHODA -> {
                        textAreaTa.setText("Stojis na policku NAHODA: \n");
                        nahodaBtn.setVisible(true);

                    }


                    /**
                     * Otestovano
                     */
                    case STAJ -> {
                        textAreaTa.setText("Stojis na policku STAJ\n");
                        stajBtn.setVisible(true);
                    }

                    /**
                     * Asi otestovano
                     */
                    case PREPRAVA -> {
                        textAreaTa.setText("Stojis na policku PREPRAVA\n");
                        prepravaBtn.setVisible(true);
                    }

                    /**
                     * Otestovan�
                     */
                    case TRENER -> {
                        textAreaTa.setText("Stojis na policku TRENER\n");
                        trenerBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                    }

                    case PARKOVISTE -> {
                        textAreaTa.setText("Stojis na policku PARKOVISTE\n");
                        textAreaTa.append("Na tomto policku neni zadna akce, pokracuj kliknutim na tlacitko dalsi hrac\n");
                        dalsiHracBtn.setVisible(true);
                    }







                    default -> textAreaTa.append("Not implemented yet!");


                }


                System.out.println(aktualniHrac);

                xPozice=hp.getXPolicka(hp.vratHrace(aktualniHrac).getPozice());
                yPozice=hp.getYPolicka(hp.vratHrace(aktualniHrac).getPozice());
                markerLbl.setBounds(xPozice,yPozice,30,30);

                System.out.println(xPozice+" "+yPozice);


            }
        });



        //pridani prvku do aplikace
        add(scrollPane);
        add(pocetHracuBtn);
        add(pocetHracuCombo);
        add(popisekLbl);
        add(jmenoHraceLbl);
        add(jmenoTf);
        add(vytvorHraceBtn);
        add(nactiPravidlaBtn);
        add(vypisHraceBtn);
        add(kostkaBtn);
        add(dalsiHracBtn);
        add(zobrazAktualnihoHraceBtn);
        add(zobrazInformacePolickoBtn);
        add(herniPlanLbl);
        add(hracNaTahuLbl);
        add(textAreaHracNaTahuTa);
        add(markerLbl);
        add(zahrajTahBtn);
        add(zaplatTrestBtn);
        add(financeBtn);
        add(nahodaBtn);
        add(stajBtn);
        add(koupitStajBtn);
        add(zaplatProhlidkuStajeBtn);
        add(prepravaBtn);
        add(zaplatPouzitiPrepravyBtn);
        add(koupitPrepravuBtn);
        add(trenerBtn);
        add(kupitTreneraBtn);
        add(prodejMajetekBtn);
        add(cisloPolickaLbl);
        add(cisloPolickaTf);
        add(kunBtn);
        add(kupZetonBtn);
        add(kupKone);



        repaint();

      
    }

    public static void main(String[] args) {
        new Dostihy_A_Sazky();

    }
}
