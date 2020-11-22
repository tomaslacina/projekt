package cz.mendelu.pef.pjj.projekt.greenFoot;

import cz.mendelu.pef.pjj.projekt.dostihy.Figurka;
import cz.mendelu.pef.pjj.projekt.dostihy.HerniPlan;
import cz.mendelu.pef.pjj.projekt.dostihy.Kostka;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class KostkaActor extends Actor {
    private final HerniPlan herniPlan;


    public KostkaActor(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
        this.update();
    }

    private void update() {
        setImage("obrazky/kostka.png");
    }


}
