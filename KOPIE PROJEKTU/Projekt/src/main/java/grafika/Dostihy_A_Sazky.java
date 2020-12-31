package grafika;

import cz.mendelu.pef.pjj.projekt.dostihy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

public class Dostihy_A_Sazky extends JFrame {
    JTextArea textAreaTa;
    //JTextArea textAreaHracNaTahuTa;
    JScrollPane scrollPane;
    JButton pocetHracuBtn;
    JComboBox pocetHracuCombo;
    JLabel popisekLbl;
    JLabel jmenoHraceLbl;
    JLabel herniPlanLbl;
    JLabel polickoObrazekLbl;
    //JLabel hracNaTahuLbl;
    JLabel markerLbl;
    JTextField jmenoTf;
    JButton vytvorHraceBtn;


    JButton nactiPravidlaBtn;
    JButton vypisHraceBtn;
    //JButton kostkaBtn;
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
    Kun kun;



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
        textAreaTa.setBounds(10,10,700,110); //nastaveni velikosti - musi byt asi stejne jak scrollPane

        scrollPane = new JScrollPane(); //aby se to dalo posunovat nahoru a dolu (doleva, doprava)
        scrollPane.setBounds(10,10,700,110);
        scrollPane.getViewport().setBackground(Color.WHITE); //pozadi
        scrollPane.getViewport().add(textAreaTa); //pridani textArea do scrollPane


        popisekLbl = new JLabel("Poèet hráèù");
        popisekLbl.setBounds(10,120,130,30);



        pocetHracuCombo = new JComboBox();
        for (int i =2;i<=7;i++){
            pocetHracuCombo.addItem(i);
        }
        pocetHracuCombo.setBounds(100,130,100,30);


        /**
         * Button pre potvrdenie poètu hráèov v setup-e.
         * @author xrepka
         * @version etapa-4
         */

        pocetHracuBtn=new JButton("Potvrï poèet");
        pocetHracuBtn.setBounds(200,130,150,30);
        pocetHracuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pocetHracu= Integer.parseInt(String.valueOf(pocetHracuCombo.getSelectedItem()));
                textAreaTa.setText("Zadaný poèet hráèù je: "+pocetHracu+"\n");
                textAreaTa.append("Nyní zadej do políèka jméno hráèe - alespoò 3 znaky:\n");
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

        jmenoHraceLbl= new JLabel("Jméno hráèe:");
        jmenoHraceLbl.setBounds(10,130,100,30);
        jmenoHraceLbl.setVisible(false);


        jmenoTf=new JTextField();
        jmenoTf.setBounds(100,130,100,30);
        jmenoTf.setVisible(false);

        /**
         * Vytvoøení tlaèítka pro vytvoøení nového hráèe
         * @author: xlacina5
         * @version: etapa-4
         */

        vytvorHraceBtn=new JButton("Vytvoø hráèe");
        vytvorHraceBtn.setBounds(200,130,150,30);
        vytvorHraceBtn.setVisible(false);
        vytvorHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //overeniVstupu
                if(jmenoTf.getText().length()>=3){
                    cisloHrace++;
                    System.out.println(cisloHrace);
                    textAreaTa.setText("Jmeno hráèe èíslo:"+cisloHrace+" je:"+jmenoTf.getText()+"\n");
                    hp.vytvorAPridejHrace(jmenoTf.getText(),cisloHrace);
                    textAreaTa.append("Hráè byl úspìšnì vytvoøen");
                    jmenoTf.setText("");
                }
                else{
                    textAreaTa.setText("NEPLATNÝ VSTUP!!! JMÉNO HRÁÈE MUSÍ OBSAHOVAT ALESPOÒ 3 ZNAKY!");
                    jmenoTf.setText("");

                }

                if(cisloHrace==pocetHracu){
                    textAreaTa.setText("Vytvoøili jsme hru pro poèet hráèù:"+cisloHrace+"\n");
                    jmenoTf.setVisible(false);
                    jmenoHraceLbl.setVisible(false);
                    vytvorHraceBtn.setVisible(false);
                    cisloPolickaLbl.setVisible(false);
                    cisloPolickaTf.setVisible(false);
                    prodejMajetekBtn.setVisible(false);


                   // textAreaHracNaTahuTa.setVisible(true);
                    nactiPravidlaBtn.setVisible(true);
                    vypisHraceBtn.setVisible(true);
                    //kostkaBtn.setVisible(true);
                    zobrazAktualnihoHraceBtn.setVisible(true);
                    zobrazInformacePolickoBtn.setVisible(true);
                    herniPlanLbl.setVisible(true);
                    //hracNaTahuLbl.setVisible(true);
                    markerLbl.setVisible(true);
                    zahrajTahBtn.setVisible(true);
                    /*textAreaHracNaTahuTa.setText("");
                    textAreaHracNaTahuTa.append(hp.vypisVsechHracu());*/
                }
            }
        });

        /**
         * Tlaèítko pro naètení pravidel ze souboru
         *@author: xlacina5
         *@version: etapa-4
         */
        nactiPravidlaBtn = new JButton("Pravidla Hry");
        nactiPravidlaBtn.setBounds(1000,50,150,70);
        nactiPravidlaBtn.setBackground(Color.ORANGE);
        nactiPravidlaBtn.setVisible(false);
        nactiPravidlaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.prectiZeSouboruPravidla());
            }
        });

        /**
         * Tlaèítko pro výpis hráèù
         * @author: xlacina5
         * @version: etapa-4
         */

        vypisHraceBtn = new JButton("Výpis Hráèù");
        vypisHraceBtn.setBounds(1000,250,150,70);
        vypisHraceBtn.setBackground(SystemColor.LIGHT_GRAY);
        vypisHraceBtn.setVisible(false);
        vypisHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.vypisVsechHracu());
            }
        });


        /**
         * Tlaèítko pro pøepnutí na dalšího hráèe
         * @version: etapa-4
         * @author: xlacina5
         */

        dalsiHracBtn = new JButton("Další Hráè");
        dalsiHracBtn.setBounds(1000,600,150,100);
        dalsiHracBtn.setBackground(Color.GREEN);
        dalsiHracBtn.setVisible(false);
        dalsiHracBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dalsiHracBtn.setVisible(false);
                zahrajTahBtn.setVisible(true);
                kupitTreneraBtn.setVisible(false);
                kupZetonBtn.setVisible(false);
                kupKone.setVisible(false);
                kunBtn.setVisible(false);
                prodejMajetekBtn.setVisible(false);
                cisloPolickaLbl.setVisible(false);
                cisloPolickaTf.setVisible(false);
                polickoObrazekLbl.setVisible(false);


                aktualniHrac++; //kdyz prekrocim, tak vynuluj - nastav na 1
                //textAreaHracNaTahuTa.setText("");
               // textAreaHracNaTahuTa.append(hp.vypisVsechHracu());


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
         * Tlaèítko pro zobrazení aktuálního hráèe, který je na tahu
         * @version: etapa-4
         * @author: xlacina5
         */

        zobrazAktualnihoHraceBtn = new JButton("Aktuální hráè");
        zobrazAktualnihoHraceBtn.setBounds(1000,170,150,70);
        zobrazAktualnihoHraceBtn.setBackground(Color.LIGHT_GRAY);
        zobrazAktualnihoHraceBtn.setVisible(false);
        zobrazAktualnihoHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText("Informace o hráèi èíslo:"+aktualniHrac+"\n");
                textAreaTa.append(hp.vypisAktualnihoHrace(aktualniHrac)+"\n");
                }

        });

        /**
         * Zobrazí informace o políèku
         * @author: xlacina5
         * @version: etapa-4
         */

        zobrazInformacePolickoBtn = new JButton("Informace o políèku");
        zobrazInformacePolickoBtn.setBounds(1000,370,150,70);
        zobrazInformacePolickoBtn.setVisible(false);
        zobrazInformacePolickoBtn.setBackground(SystemColor.LIGHT_GRAY);
        zobrazInformacePolickoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.zobrazInformaceOPolicku(aktualniHrac)+"\n");

            }
        });

        /**
         * Naèítanie obrázku plánu do hry.
         * @author xrepka
         * @version etapa-4
         */

        herniPlanLbl=new JLabel();
        herniPlanLbl.setIcon(new ImageIcon("dostihysazky.png"));
        herniPlanLbl.setBounds(450,100,500,500);
        herniPlanLbl.validate();
        herniPlanLbl.setVisible(false);


        polickoObrazekLbl=new JLabel();
        polickoObrazekLbl.setBounds(50,200,250,300);



        /**
         * Nadpis, kotrý sa zobrazí po prvotnom setup-e.
         * @author xrepka
         * @version etapa-4
         */


        /*hracNaTahuLbl = new JLabel("Kontá hráèov");
        hracNaTahuLbl.setBounds(10,130,150,30);
        hracNaTahuLbl.setFont(new Font("Thimes",Font.BOLD,20));
        hracNaTahuLbl.setVisible(false);*/

        /**
         * Vypis text area pre výpis informácií o hráèovi, ktorý je prave na ahu.
         * @author xrepka
         * @version etapa-4
         */

        /*textAreaHracNaTahuTa = new JTextArea();
        textAreaHracNaTahuTa.setBounds(10,180,300,520);
        textAreaHracNaTahuTa.setFont(new Font("Thimes",Font.BOLD,12));
        textAreaHracNaTahuTa.setVisible(false);*/

        /**
         * Marker pre zobrazenie pozície aktuálneho hráèa
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
                textAreaTa.append("Stav konta pred transakci:"+hrac.getKonto()+"\n");
                textAreaTa.append("Hodnota trestu je:"+hp.getHodnotaTrestu()+"\n");
                if(hrac.getKonto()>hp.getHodnotaTrestu()){
                    textAreaTa.append("Trest byl zaplacen, tvuj tah je u konce\n");
                    hrac.transakce(hp.getHodnotaTrestu());
                    textAreaTa.append("Stav konta po trestu je:"+hrac.getKonto()+"\n");
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
                    textAreaTa.append("Nahoda te posunula na startovaci policko\n");
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

        zaplatProhlidkuStajeBtn = new JButton("Zaplat pøepravu");
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
                    textAreaTa.append("Jsi vlastnikem policka, neplatis nic, ani nic nedostanes\n");
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

        zaplatPouzitiPrepravyBtn = new JButton("Použít pøepravu");
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

        koupitPrepravuBtn = new JButton("Koupit pøepravu");
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


        prepravaBtn = new JButton("Pøeprava");
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

                if(hrac.getKonto()>=4000){
                    hrac.transakce(-4000);
                    policko.setObsazenoHracem(hrac.getId());
                    textAreaTa.append("Blahoželáme! Kupil si si trénera za 4000. \n");
                    textAreaTa.append("Zostatok na tvojom konte je "+hrac.getKonto()+ "\n");
                    kupitTreneraBtn.setVisible(false);
                    hrac.pridejMajetekHraci(hp.getPolicko(hrac.getPozice()));
                    Trener trener = new Trener(hrac.getPozice(),"Trener");
                    hrac.pridejTrenera(trener);
                    dalsiHracBtn.setVisible(true);
                }
                else{
                    textAreaTa.append("Na hernim uctu neni dostatek penez");
                    textAreaTa.append("Pokracuj kliknutim na dalsiho hrace");
                    dalsiHracBtn.setVisible(true);
                }


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
                    textAreaTa.append("\nMáš možnos si kúpi trenéra na tomto políèku. \n");
                    textAreaTa.append("Ak chceš kupit trenera, klikni na kupit trenera. \n");
                    textAreaTa.append("Ak trenera kupit nechceš, klikni na další hráè. \n");

                } else {
                    textAreaTa.append("Trénera vlastní iný hráè, musíš mu zaplati. \n");
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
                        textAreaTa.append("Nemáš dostatoèný zostatok na tvojom konte. \n");
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


        cisloPolickaLbl = new JLabel("Èíslo políèka:");
        cisloPolickaLbl.setBounds(450,600,100,30);
        cisloPolickaLbl.setVisible(false);

        cisloPolickaTf = new JTextField();
        cisloPolickaTf.setBounds(550,600,150,30);
        cisloPolickaTf.setVisible(false);

        prodejMajetekBtn = new JButton("Prodej majetek");
        prodejMajetekBtn.setBounds(700,600,150,30);
        prodejMajetekBtn.setVisible(false);
        prodejMajetekBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hrac hrac = hp.vratHrace(aktualniHrac);
                int cisloPolicka = Integer.parseInt(cisloPolickaTf.getText());
                Policko policko = hp.getPolicko(cisloPolicka);

                if(hrac.vlastniHracMajetek(policko)==true){
                    cisloPolickaLbl.setVisible(false);
                    cisloPolickaTf.setVisible(false);

                    if(hrac.prodejMajetekBance(policko,hrac,hp)==true){
                        textAreaTa.append("Uspesne si prodal majetek bance:\n");
                        textAreaTa.append("Tvuj novy stav konta je:"+hrac.getKonto()+"\n");
                    }
                    else{
                        textAreaTa.append("NECO SE NEPOVEDLO \n");
                    }


                }
                else{
                    textAreaTa.append("Bohužel toto polièko nevlastniš\n");
                    textAreaTa.append("Zadej znovu nebo ukonci svuj tah\n");
                    cisloPolickaTf.setText("");
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
                kun = hp.vratObjektKun(hrac.getPozice());

                if(hrac.getKonto()>=kun.getNakupniCena()){
                    hrac.transakce((-1)*(kun.getNakupniCena()));
                    textAreaTa.append("\nBlahoželáme! Kúpil si koòa\n");
                    hrac.pridejMajetekHraci(policko);
                    policko.setObsazenoHracem(aktualniHrac); //priradim vlastnictvi hraci ktery je na tahu a uspesne zaplatil za kone
                    hrac.pridejKone(kun); //prida do hracovych koni kone
                    kupKone.setVisible(false);
                    textAreaTa.append("Zostatok na tvojm úète je "+hrac.getKonto()+"\n");
                }
                else{
                    textAreaTa.append("\nBohužial, nemáš dostatok peòazí na nákup koòa.\n");
                    kupKone.setVisible(false);
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
                kun =hp.vratObjektKun(hrac.getPozice());

                //pokud ma penize a zaroven jeste kun nema 5 zetonu tak muze koupit
                if((hrac.getKonto()>=kun.getCenaZetonu())&&(kun.getPocetZetonu()<5)){
                    hrac.transakce((-1)*(kun.getCenaZetonu()));
                    kun.zvysPocetZetonu();
                    textAreaTa.append("\nBlahoželáme! Kúpil si si žetón na tohto koòa.\n");
                    textAreaTa.append("Zostatok na tvojm úète je "+hrac.getKonto()+"\n");


                }
                //jinak proste vypise hlasku
                else
                    {

                    if(hrac.getKonto()<kun.getCenaZetonu()){
                        textAreaTa.append("\n Nemas dostatek financi na provedeni teto transakce\n");
                    }
                    else {
                        textAreaTa.append("\n Dosahl si maximalniho poctu zetonu\n");
                    }

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
                kun = hp.vratObjektKun(hrac.getPozice());
                textAreaTa.append("Jmeno kone: "+kun.getMeno()+"\n");
                if (policko.getObsazenoHracem() == 0) {
                    //vlastni niekto tohto kona? - nevlastní
                    textAreaTa.append("Koòa nikto nevlastní, stojí "+kun.getNakupniCena()+"\n");
                    textAreaTa.append("Ak chceš si kúpi tohto koòa stlaè Kup kone.\n");
                    textAreaTa.append("Ak nie stlaè další hráè.\n");
                    kupKone.setVisible(true);
                    dalsiHracBtn.setVisible(true);
                    }

                else{

                    //niekto toto polièko vlastní
                    if(hrac.getId()==policko.getObsazenoHracem()){
                        //vlastní ho aktualni hráè

                        textAreaTa.append("\nChceš dokúpi žetón na zvýšenie nájmu koòa? Stojí: "+kun.getCenaZetonu()+"\n");
                        textAreaTa.append("Ak chceš kupit tak klikni na kupit žetón, ak nechceš klikni na další hráè\n");
                        dalsiHracBtn.setVisible(true);
                        kupZetonBtn.setVisible(true);

                    } else {

                        //vlastni ho nejaky iný hraè
                        int idVlastnika = policko.getObsazenoHracem();
                        Hrac vlastnikKone = hp.vratHrace(idVlastnika);
                        int cenaZaPronajati = kun.getPoplatekZaPronajemKone();

                        if (hrac.getKonto() >= cenaZaPronajati) {
                            //hrac ma dostatok penazi na zaplatenie
                            hrac.transakce((-1) * cenaZaPronajati);
                            vlastnikKone.transakce(cenaZaPronajati);
                            textAreaTa.append("Zaplatil si hracovi " + vlastnikKone.getMeno() + " sumu " + cenaZaPronajati + "\n");
                            textAreaTa.append("Zostatok na tvojom konte je " + hrac.getKonto() + "\n");
                            dalsiHracBtn.setVisible(true);

                        }else{
                            //hrac nema dostatok penazi
                            textAreaTa.append("Nemáš dostatoèný zostatok na tvojom konte. \n");
                            textAreaTa.append("Prodej majetek \n");
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
        zahrajTahBtn.setBounds(50,650,150,70);
        zahrajTahBtn.setBackground(Color.GREEN);
        zahrajTahBtn.setVisible(false);
        zahrajTahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int max=0;
                String vyherca="";
                dalsiHracBtn.setVisible(true);
                zahrajTahBtn.setVisible(false);
                hodnotaHodu=hp.hodKostkou();
                hp.posunPoPlane(aktualniHrac,hodnotaHodu);
                xPozice=hp.getXPolicka(hp.vratHrace(aktualniHrac).getPozice());
                yPozice=hp.getYPolicka(hp.vratHrace(aktualniHrac).getPozice());
                markerLbl.setBounds(xPozice,yPozice,30,30);
                typPolicka=hp.getTypPolicka(hp.vratHrace(aktualniHrac).getPozice());
                textAreaTa.append("Hodnota hodu: "+hodnotaHodu);
                //textAreaHracNaTahuTa.setText("");

                //textAreaHracNaTahuTa.append(hp.vypisVsechHracu());
                textAreaTa.setText("Hrac na tahu: "+hp.vratHrace(aktualniHrac).getMeno()+" Hodnota hodu: "+hodnotaHodu+"\n");


                switch (typPolicka){
                    case KUN -> {

                        textAreaTa.append("Stojis na policku KUN: \n");
                        kunBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("kartaKone.png"));
                        polickoObrazekLbl.validate();

                    }

                    /**
                     * Otestovano
                     */

                    case TREST -> {
                        textAreaTa.append("Stojis na policku trest:\n");
                        textAreaTa.append(hp.zobrazInformaceOPolicku(aktualniHrac)+"\n");
                        zaplatTrestBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("trest.png"));
                        polickoObrazekLbl.validate();

                    }

                    /**
                     * Otestovano
                     */

                    case FINANCE -> {
                        textAreaTa.append("Stojis na policku FINANCE: \n");
                        financeBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("finance.png"));
                        polickoObrazekLbl.validate();
                    }

                    /**
                     * Otestovano
                     */

                    case NAHODA -> {
                        textAreaTa.append("Stojis na policku NAHODA: \n");
                        nahodaBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("nahoda.png"));
                        polickoObrazekLbl.validate();

                    }


                    /**
                     * Otestovano
                     */
                    case STAJ -> {
                        textAreaTa.append("Stojis na policku STAJ\n");
                        stajBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("staj.png"));
                        polickoObrazekLbl.validate();
                    }

                    /**
                     * Asi otestovano
                     */
                    case PREPRAVA -> {
                        textAreaTa.append("Stojis na policku PREPRAVA\n");
                        prepravaBtn.setVisible(true);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("preprava.png"));
                        polickoObrazekLbl.validate();
                    }

                    /**
                     * Otestované
                     */
                    case TRENER -> {
                        textAreaTa.append("Stojis na policku TRENER\n");
                        trenerBtn.setVisible(true);
                        dalsiHracBtn.setVisible(false);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("trener.png"));
                        polickoObrazekLbl.validate();
                    }

                    case PARKOVISTE -> {
                        textAreaTa.append("Stojis na policku PARKOVISTE\n");
                        textAreaTa.append("Na tomto policku neni zadna akce, pokracuj kliknutim na tlacitko dalsi hrac\n");
                        dalsiHracBtn.setVisible(true);
                        polickoObrazekLbl.setVisible(true);
                        polickoObrazekLbl.setIcon(new ImageIcon("parkoviste.png"));
                        polickoObrazekLbl.validate();
                    }



                    default -> textAreaTa.append("Not implemented yet!");


                }


                System.out.println(aktualniHrac);

                xPozice=hp.getXPolicka(hp.vratHrace(aktualniHrac).getPozice());
                yPozice=hp.getYPolicka(hp.vratHrace(aktualniHrac).getPozice());
                markerLbl.setBounds(xPozice,yPozice,30,30);

                System.out.println(xPozice+" "+yPozice);


                //TODO pokus o ukonèenie hry, vyhadzuje tam nejake chyby

                //hracovi dat atribut je ve hre a testovat vzdy pri dalsim hraci jinak pripocist jedna a testovat znovu...
                //nez zustane posledni hrac


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
        //add(kostkakBtn);
        add(dalsiHracBtn);
        add(zobrazAktualnihoHraceBtn);
        add(zobrazInformacePolickoBtn);
        add(herniPlanLbl);
        //add(hracNaTahuLbl);
        //add(textAreaHracNaTahuTa);
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
        add(polickoObrazekLbl);



        repaint();

      
    }

    public static void main(String[] args) {
        new Dostihy_A_Sazky();

    }
}
