import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pef.pjj.projekt.dostihy.DostihyWorld;
import greenfoot.Greenfoot;

public class Runner extends GreenfootRunner {

    static{
        bootstrap(Runner.class,
                Configuration.forWorld(DostihyWorld.class));
    }


    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}
