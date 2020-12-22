package cz.mendelu.pef.pjj.projekt.dostihy;

public class Nahoda {
    int hodnotaNahody;
    String textNahody;


    public Nahoda(int hodnotaNahody, String textNahody) {
        this.hodnotaNahody = hodnotaNahody;
        this.textNahody = textNahody;
    }

    public int getHodnotaNahody() {
        return hodnotaNahody;
    }

    public String getTextNahody() {
        return textNahody;
    }
}
