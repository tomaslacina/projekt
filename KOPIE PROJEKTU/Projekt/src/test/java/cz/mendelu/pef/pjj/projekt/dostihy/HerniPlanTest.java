package cz.mendelu.pef.pjj.projekt.dostihy;

import junit.framework.TestCase;
import org.junit.Test;

public class HerniPlanTest extends TestCase {


    /**
     * @author xrepka
     * @version etapa-1
     */
    public void testPosunPoPlane() {
        //setup
        Kostka kostka = new Kostka();
        HerniPlan plan = new HerniPlan(kostka);
        var figurka = new Figurka(0);
        //when
        plan.posunPoPlane(figurka);
        //then
        assertNotNull(figurka.getPoziceFigurky());

    }

    /**
     * Komentář:
     * Pro jednoduchost jsem nastavil figurku na poslední políčko hracího plánu a hodnotu hodu na hodnotu 5
     * Po posunu by se měla figurka nacházet na pozici 5 (jelikož přejde startem)
     * @author xlacina5
     * @version etapa-1

     */

    @Test
    public void testPosunPoPlane_prekroceniStartu(){
        //setup
        Kostka kostka = new Kostka();
        HerniPlan plan = new HerniPlan(kostka);
        Figurka figurka = new Figurka(40);

        //when
        plan.posunPoPlane(figurka);
        //then
        assertEquals(5,figurka.getPoziceFigurky());

    }

    /**
     * @author xlacina5
     * @version etapa-1
     */

    @Test
    public void testakce(){

        //setup
        HerniPlan plan = new HerniPlan();
        Figurka figurka = new Figurka(15);
        Policko policko = new Policko(1,TypPolicka.NAHODA,"info",10,10,false);
        Kostka kostka = new Kostka();

        int hodnotaHodu=kostka.getHodnotaHodu();
        int staraPozice=figurka.getPoziceFigurky();

        //when
        plan.posunPoPlane(figurka);
        figurka.setPoziceFigurky(hodnotaHodu);
        //then
        assertEquals(staraPozice+hodnotaHodu,figurka.getPoziceFigurky());
        policko.zobrazInformace();

    }

    /**
     * @author xlacina5
     * @version etapa-1
     */

    @Test
    public void testprodejMajetek(){
        //setup
        Hrac tomas = new Hrac("Tomas",500);
        HerniPlan plan = new HerniPlan();
        Policko policko = new Policko(1,TypPolicka.NAHODA,"info",10,10,false);
        int cisloPolicka=10;
        int staryZustatek = tomas.getKonto();

        //when
        //plan.prodejMajetek(cisloPolicka,policko.getCena());
        //then
        //tomas.transakce(policko.getCena());
       // assertEquals(staryZustatek+policko.getCena(),tomas.getKonto());

    }

}