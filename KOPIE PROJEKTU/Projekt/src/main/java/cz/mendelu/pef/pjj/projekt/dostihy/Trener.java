package cz.mendelu.pef.pjj.projekt.dostihy;

public class Trener {

    private int cisloPolicka;
    private String text;
    private boolean obsadenost;


    Trener(int cisloPolicka, String text){
        this.cisloPolicka=cisloPolicka;
        this.text=text;
    }

    public int getCisloPolicka() {
        return cisloPolicka;
    }

    public boolean isObsadenost() {
        return obsadenost;
    }

    @Override
    public String toString() {
        return "Trener{" +
                "cisloPolicka=" + cisloPolicka +
                ", text='" + text + '\'' +
                '}';
    }
}
