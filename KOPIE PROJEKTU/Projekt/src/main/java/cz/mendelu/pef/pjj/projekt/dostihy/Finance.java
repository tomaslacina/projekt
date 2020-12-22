package cz.mendelu.pef.pjj.projekt.dostihy;

public class Finance {


    int castka;
    String text;


    public Finance(int castka, String text) {
        this.castka = castka;
        this.text = text;
    }

    public int getCastkaFinance() {
        return castka;
    }

    public String getTextFinance() {
        return "Text:"+text+"\n"+castka+"\n";
    }
}
