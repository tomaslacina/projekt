import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pef.pjj.projekt.greenFoot.DostihyWorld;

public class Runner extends GreenfootRunner {

    static{
        bootstrap(Runner.class,
                Configuration.forWorld(DostihyWorld.class).projectName("Dostihy").hideControls(false));
    }


    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}
