package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.Random;

public class Kostka {
    Random rn = new Random();

    Kostka(){
    }

    /**
     * Vrati hodnotu hodu.
     * @return hodnota hodu: 1,2,3,4,5,6
     * @author xrepka
     * @version etapa-1
     */
    int getHodnotaHodu(){
        int hodnotaHodu;
        hodnotaHodu=rn.nextInt(6);
        if(hodnotaHodu==0){
            hodnotaHodu=1;
        }

        return hodnotaHodu;
    }



}
