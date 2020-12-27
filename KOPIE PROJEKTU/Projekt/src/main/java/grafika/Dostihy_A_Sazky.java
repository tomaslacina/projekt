package grafika;

import cz.mendelu.pef.pjj.projekt.dostihy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    TypPolicka typPolicka;
    int pocetHracu;
    int cisloHrace=0;

    int hodnotaHodu=0;
    int aktualniHrac=1;
    int xPozice=0;
    int yPozice=0;

    Hrac hrac;



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


        popisekLbl = new JLabel("Poèet hráèù");
        popisekLbl.setBounds(10,80,100,30);



        pocetHracuCombo = new JComboBox();
        for (int i =2;i<=7;i++){
            pocetHracuCombo.addItem(i);
        }
        pocetHracuCombo.setBounds(100,80,100,30);


        /**
         * Button pre potvrdenie poètu hráèov v setup-e.
         * @author xrepka
         * @version etapa-4
         */

        pocetHracuBtn=new JButton("Potvrï poèet");
        pocetHracuBtn.setBounds(200,80,150,30);
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
        jmenoHraceLbl.setBounds(10,80,100,30);
        jmenoHraceLbl.setVisible(false);


        jmenoTf=new JTextField();
        jmenoTf.setBounds(100,80,100,30);
        jmenoTf.setVisible(false);

        /**
         * Vytvoøení tlaèítka pro vytvoøení nového hráèe
         * @author: xlacina5
         * @version: etapa-4
         */

        vytvorHraceBtn=new JButton("Vytvoø hráèe");
        vytvorHraceBtn.setBounds(200,80,150,30);
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
         * Tlaèítko pro naètení pravidel ze souboru
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
         * Tlaèítko pro výpis hráèù
         * @author: xlacina5
         * @version: etapa-4
         */

        vypisHraceBtn = new JButton("Výpis Hráèù");
        vypisHraceBtn.setBounds(1000,50,150,30);
        vypisHraceBtn.setVisible(false);
        vypisHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.vypisVsechHracu());
            }
        });
        /**
         * Vytvorenie tlaèidla pre hod kockou.
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
                    textAreaTa.append("Hodil jsi 6tku - hážeš ještì jednou\n");
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
         * Tlaèítko pro pøepnutí na dalšího hráèe
         * @version: etapa-4
         * @author: xlacina5
         */

        dalsiHracBtn = new JButton("Další Hráè");
        dalsiHracBtn.setBounds(1000,130,150,30);
        dalsiHracBtn.setVisible(false);
        dalsiHracBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //zatim
                dalsiHracBtn.setVisible(false);
                zahrajTahBtn.setVisible(true);
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
         * Tlaèítko pro zobrazení aktuálního hráèe, který je na tahu
         * @version: etapa-4
         * @author: xlacina5
         */

        zobrazAktualnihoHraceBtn = new JButton("Aktuální hráè");
        zobrazAktualnihoHraceBtn.setBounds(1000,170,150,30);
        zobrazAktualnihoHraceBtn.setVisible(false);
        zobrazAktualnihoHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText("Informace o hráèi èíslo:"+aktualniHrac+"\n");
                textAreaTa.append(hp.vypisAktualnihoHrace(aktualniHrac)+"\n");
                textAreaHracNaTahuTa.setText("");
                textAreaHracNaTahuTa.append(hp.vypisAktualnihoHrace(aktualniHrac));
            }
        });

        /**
         * Zobrazí informace o políèku
         * @author: xlacina5
         * @version: etapa-4
         */

        zobrazInformacePolickoBtn = new JButton("Informace o políèku");
        zobrazInformacePolickoBtn.setBounds(1000,210,150,30);
        zobrazInformacePolickoBtn.setVisible(false);
        zobrazInformacePolickoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.append(hp.zobrazInformaceOPolicku(aktualniHrac)+"\n");

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


        /**
         * Nadpis, kotrý sa zobrazí po prvotnom setup-e.
         * @author xrepka
         * @version etapa-4
         */


        hracNaTahuLbl = new JLabel("Hráè na tahu:");
        hracNaTahuLbl.setBounds(10,120,150,30);
        hracNaTahuLbl.setFont(new Font("Thimes",Font.BOLD,20));
        hracNaTahuLbl.setVisible(false);

        /**
         * Vypis text area pre výpis informácií o hráèovi, ktorý je prave na ahu.
         * @author xrepka
         * @version etapa-4
         */

        textAreaHracNaTahuTa = new JTextArea();
        textAreaHracNaTahuTa.setBounds(10,180,300,200);
        textAreaHracNaTahuTa.setFont(new Font("Thimes",Font.BOLD,12));
        textAreaHracNaTahuTa.setVisible(false);

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
                    //TODO - doimplementovat, co se stane, kdyd hraci dojdou penize :O asi zobrazi ze muzes prodat majetek,...
                    //TODO - napr ze zada cislo policka majetku (kone) a tlacikem potvrdi, prictou se penize a dokonci se tah
                    //TODO - jinak by kdyby nemel zadny majetek tak by prohral a ukoncil by tak hru
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
                        //TODO - doimplementovat, co se stane, kdyd hraci dojdou penize :O asi zobrazi ze muzes prodat majetek,...
                        //TODO - napr ze zada cislo policka majetku (kone) a tlacikem potvrdi, prictou se penize a dokonci se tah
                        //TODO - jinak by kdyby nemel zadny majetek tak by prohral a ukoncil by tak hru
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

        stajBtn = new JButton("Staj");
        stajBtn.setBounds(300,700,150,30);
        stajBtn.setVisible(false);
        stajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrac = hp.vratHrace(aktualniHrac);





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
                hp.posunPoPlane(aktualniHrac,hodnotaHodu);
                xPozice=hp.getXPolicka(hp.vratHrace(aktualniHrac).getPozice());
                yPozice=hp.getYPolicka(hp.vratHrace(aktualniHrac).getPozice());
                markerLbl.setBounds(xPozice,yPozice,30,30);
                typPolicka=hp.getTypPolicka(hp.vratHrace(aktualniHrac).getPozice());
                //typPolicka=TypPolicka.NAHODA; //Pro testovani - abys nemusel klikat tak si zvolis typ policka a pak testujes
                textAreaTa.append("Hodna hodu: "+hodnotaHodu);

                switch (typPolicka){
                    case KUN -> {
                        textAreaTa.setText("Stojis na koni s názvom: \n");
                        break;
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


                    case STAJ -> {
                        textAreaTa.setText("Stojis na policku STAJ");
                        stajBtn.setVisible(true);
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


        repaint();

      
    }

    public static void main(String[] args) {
        new Dostihy_A_Sazky();

    }
}
