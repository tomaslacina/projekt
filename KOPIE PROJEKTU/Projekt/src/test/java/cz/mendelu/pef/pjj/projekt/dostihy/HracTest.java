package cz.mendelu.pef.pjj.projekt.dostihy;

import junit.framework.TestCase;
import org.junit.Test;

public class HracTest extends TestCase {


    /**
     * @author xrepka
     * @version etapa-1
     */
    public void testTransakce() {
        //setup
        Hrac stano = new Hrac(100);
        //when
        stano.transakce(200);
        //then
        assertEquals(300, stano.getKonto());
    }


    /**
     * @author xrepka
     * @version etapa-1
     */
    public void testTransakce_duplicita() {
        //setup
        Hrac stano = new Hrac(500);
        //when
        stano.transakce(-200);
        //then
        assertEquals(300, stano.getKonto());
    }



    /**
     * @author xrepka
     * @version etapa-1
     */

    public void testPridejKone() {
        //setup
        Hrac stano = new Hrac();
        Kun pepik = new Kun();
        //when
        stano.pridejKone(pepik);
        //then
        assertNotNull(stano.getKone());
    }



    /**
     * @author xrepka
     * @version etapa-1
     */


    public void testPridejKone_duplicita() {
        //setup
        Hrac stano = new Hrac();
        Kun pepik = new Kun();
        Kun tom = new Kun();
        //when
        stano.pridejKone(pepik);
        stano.pridejKone(tom);
        //then

        assertEquals(stano.getKone().length,2);
    }

    /**
     * @author xlacina5
     * @version etapa-1
     */

    @Test
    public void testPridejTrenera(){
        //setup
        Hrac tomas = new Hrac();
        Trener trenerVana = new Trener();
        //when
        tomas.pridejTrenera(trenerVana);
        //then
        assertNotNull(tomas.getTreneri());
    }

    /**
     * @author xlacina5
     * @version etapa-1
     */
    @Test
    public void testPridejTrenera_duplicita(){
        //setup
        Hrac tomas = new Hrac();
        Trener trenerVana=new Trener();
        Trener trenerPepa=new Trener();

        //when
        tomas.pridejTrenera(trenerVana);
        tomas.pridejTrenera(trenerPepa);
        //then
        assertEquals(tomas.getTreneri().length,2);
    }



}
