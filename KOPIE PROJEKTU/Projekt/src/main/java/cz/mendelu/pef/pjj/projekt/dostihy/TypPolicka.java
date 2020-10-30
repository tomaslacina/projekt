package cz.mendelu.pef.pjj.projekt.dostihy;

import java.util.Random;

public enum TypPolicka {
    KUN,
    STAJ,
    TREST,
    NAHODA,
    FINANCE,
    START,
    PARKOVISTE,
    DISTANC,
    TRENER;

    /**
     * Metoda generuje nahodny typ policka - slouzi pouze pro testovaci ucely a pro naplneni pole policek,
     * zbytek bude pozdeji nacitan automaticky ze souboru
     * @return TypPolicka
     * @author xlacina5
     */
    public static TypPolicka getRandomPolicko() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
