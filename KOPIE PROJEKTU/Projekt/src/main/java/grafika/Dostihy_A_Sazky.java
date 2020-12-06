package grafika;

import cz.mendelu.pef.pjj.projekt.dostihy.HerniPlan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dostihy_A_Sazky extends JFrame {
    JTextArea textAreaTa;
    JScrollPane scrollPane;
    JButton pocetHracuBtn;
    JComboBox pocetHracuCombo;
    JLabel popisekLbl;
    JLabel jmenoHraceLbl;
    JLabel herniPlanLbl;
    JTextField jmenoTf;
    JButton vytvorHraceBtn;

    JButton nactiPravidlaBtn;
    JButton vypisHraceBtn;
    JButton kostkaBtn;
    JButton dalsiHracBtn;
    JButton zobrazAktualnihoHraceBtn;
    JButton zobrazInformacePolickoBtn;


    int pocetHracu;
    int cisloHrace=0;
    int hodnotaHodu=0;
    int aktualniHrac=1;

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
        textAreaTa.setBounds(100,300,750,300); //nastaveni velikosti - musi byt asi stejne jak scrollPane

        scrollPane = new JScrollPane(); //aby se to dalo posunovat nahoru a dolu (doleva, doprava)
        scrollPane.setBounds(100,300,750,300);
        scrollPane.getViewport().setBackground(Color.WHITE); //pozadi
        scrollPane.getViewport().add(textAreaTa); //pridani textArea do scrollPane


        popisekLbl = new JLabel("Po�et hr���");
        popisekLbl.setBounds(10,10,100,30);

        pocetHracuCombo = new JComboBox();
        for (int i =2;i<=7;i++){
            pocetHracuCombo.addItem(i);
        }
        pocetHracuCombo.setBounds(100,10,100,30);



        pocetHracuBtn=new JButton("Potvr� po�et");
        pocetHracuBtn.setBounds(200,10,150,30);
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

        jmenoHraceLbl= new JLabel("Jm�no hr��e:");
        jmenoHraceLbl.setBounds(250,10,100,30);
        jmenoHraceLbl.setVisible(false);

        jmenoTf=new JTextField();
        jmenoTf.setBounds(350,10,100,30);
        jmenoTf.setVisible(false);

        vytvorHraceBtn=new JButton("Vytvo� hr��e");
        vytvorHraceBtn.setBounds(450,10,150,30);
        vytvorHraceBtn.setVisible(false);
        vytvorHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //overeniVstupu
                if(jmenoTf.getText().length()>=3){
                    cisloHrace++;
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

                    nactiPravidlaBtn.setVisible(true);
                    vypisHraceBtn.setVisible(true);
                    kostkaBtn.setVisible(true);
                    zobrazAktualnihoHraceBtn.setVisible(true);
                    zobrazInformacePolickoBtn.setVisible(true);
                }
            }
        });

        nactiPravidlaBtn = new JButton("Pravidla Hry");
        nactiPravidlaBtn.setBounds(600,10,150,30);
        nactiPravidlaBtn.setVisible(false);
        nactiPravidlaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.prectiZeSouboruPravidla());
            }
        });

        vypisHraceBtn = new JButton("V�pis Hr���");
        vypisHraceBtn.setBounds(600,50,150,30);
        vypisHraceBtn.setVisible(false);
        vypisHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText(hp.vypisVsechHracu());
            }
        });

        kostkaBtn = new JButton("Kostka");
        kostkaBtn.setBounds(600,90,150,30);
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


        dalsiHracBtn = new JButton("Dal�� Hr��");
        dalsiHracBtn.setBounds(600,130,150,30);
        dalsiHracBtn.setVisible(false);
        dalsiHracBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //zatim
                kostkaBtn.setVisible(true);
                dalsiHracBtn.setVisible(false);
                aktualniHrac++; //kdyz prekrocim, tak vynuluj - nastav na 1
                if(aktualniHrac>pocetHracu){
                    aktualniHrac=1;
                }
            }
        });

        zobrazAktualnihoHraceBtn = new JButton("Aktu�ln� hr��");
        zobrazAktualnihoHraceBtn.setBounds(600,170,150,30);
        zobrazAktualnihoHraceBtn.setVisible(false);
        zobrazAktualnihoHraceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.setText("Informace o hr��i ��slo:"+aktualniHrac+"\n");
                textAreaTa.append(hp.vypisAktualnihoHrace(aktualniHrac)+"\n");
            }
        });

        zobrazInformacePolickoBtn = new JButton("Informace o pol��ku");
        zobrazInformacePolickoBtn.setBounds(600,210,150,30);
        zobrazInformacePolickoBtn.setVisible(false);
        zobrazInformacePolickoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTa.append(hp.zobrazInformaceOPolicku(aktualniHrac)+"\n");

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

        repaint();

    }

    public static void main(String[] args) {
        new Dostihy_A_Sazky();
    }
}
