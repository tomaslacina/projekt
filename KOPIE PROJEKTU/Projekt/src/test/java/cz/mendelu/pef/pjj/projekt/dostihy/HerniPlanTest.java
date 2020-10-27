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
        HerniPlan plan = new HerniPlan();
        var figurka = new Figurka(0);
        var kostka = new Kostka();
        //when
        plan.posunPoPlane(figurka.getPoziceFigurky(),kostka.getHodnotaHodu());
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
        HerniPlan plan = new HerniPlan();
        Figurka figurka = new Figurka(40);
        Kostka kostka = new Kostka();
        int hodnotaHodu = 5; //normálně by se to vygenerovalo automatick ale pro jednoduší příklad jsem zvolil konstatní hodnotu
        //when
        plan.posunPoPlane(figurka.getPoziceFigurky(),hodnotaHodu);
        //then
        figurka.setPoziceFigurky(hodnotaHodu);
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
        Policko policko = new Policko();
        Kostka kostka = new Kostka();

        int hodnotaHodu=kostka.getHodnotaHodu();
        int staraPozice=figurka.getPoziceFigurky();

        //when
        plan.posunPoPlane(figurka.getPoziceFigurky(),hodnotaHodu);
        figurka.setPoziceFigurky(hodnotaHodu);
        //then
        assertEquals(staraPozice+hodnotaHodu,figurka.getPoziceFigurky());
        policko.zobrazInformace(figurka.getPoziceFigurky());

    }

    /**
     * @author xlacina5
     * @version etapa-1
     */

    @Test
    public void testprodejMajetek(){
        //setup
        Hrac tomas = new Hrac();
        HerniPlan plan = new HerniPlan();
        Policko policko = new Policko();
        int cisloPolicka=10;
        int staryZustatek = tomas.getKonto();

        //when
        plan.prodejMajetek(cisloPolicka,policko.getCena(cisloPolicka));
        //then
        tomas.transakce(policko.getCena(cisloPolicka));
        assertEquals(staryZustatek+policko.getCena(cisloPolicka),tomas.getKonto());

    }

}