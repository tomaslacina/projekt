import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pef.pjj.projekt.greenFoot.HerniPlanWorld;

public class Runner extends GreenfootRunner {

    static{
        bootstrap(Runner.class,
                Configuration.forWorld(HerniPlanWorld.class).projectName("Dostihy a sazky").hideControls(false));
    }


    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}
