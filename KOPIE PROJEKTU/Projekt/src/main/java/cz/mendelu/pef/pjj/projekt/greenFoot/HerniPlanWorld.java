package cz.mendelu.pef.pjj.projekt.greenFoot;

import cz.mendelu.pef.pjj.projekt.dostihy.HerniPlan;
import cz.mendelu.pef.pjj.projekt.dostihy.Kostka;
import greenfoot.World;

public class HerniPlanWorld extends World {
    private HerniPlan herniPlan=new HerniPlan();

    public HerniPlanWorld(){
        super(900,600,1);


        addObject(new KostkaActor(herniPlan),200,200);

    }
}
