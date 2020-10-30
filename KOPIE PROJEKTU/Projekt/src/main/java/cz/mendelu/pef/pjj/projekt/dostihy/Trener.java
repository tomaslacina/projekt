package cz.mendelu.pef.pjj.projekt.dostihy;

public class Trener {
    private int cisloPolicka;
    private String text;


    Trener(int cisloPolicka, String text){
        this.cisloPolicka=cisloPolicka;
        this.text=text;
    }

    @Override
    public String toString() {
        return "Trener{" +
                "cisloPolicka=" + cisloPolicka +
                ", text='" + text + '\'' +
                '}';
    }
}
