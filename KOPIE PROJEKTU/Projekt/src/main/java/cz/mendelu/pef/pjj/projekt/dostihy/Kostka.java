package cz.mendelu.pef.pjj.projekt.dostihy;

public class Kostka {
    Kostka(){}

    /**
     * Vrati hodnotu hodu.
     * @return hodnota hodu: 1,2,3,4,5,6
     * @author xrepka
     * @version etapa-1
     */
    int getHodnotaHodu(){
        return (int) Math.floor(Math.random() * Math.floor(6));
    }



}
