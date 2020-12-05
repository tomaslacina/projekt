package cz.mendelu.pef.pjj.projekt.dostihy;

import junit.framework.TestCase;
import org.junit.Test;

public class HracTest extends TestCase {


    /**
     * @author xrepka
     * @version etapa-1
     */
    /*public void testTransakce() {
        //setup
        Hrac stano = new Hrac("Stano",100);
        //when
        stano.transakce(200);
        //then
        assertEquals(300, stano.getKonto());
    }*/


    /**
     * @author xrepka
     * @version etapa-1
     */
    /*public void testTransakce_duplicita() {
        //setup
        Hrac stano = new Hrac("Stano",500);
        //when
        stano.transakce(-200);
        //then
        assertEquals(300, stano.getKonto());
    }*/



    /**
     * @author xrepka
     * @version etapa-1
     */

    /*public void testPridejKone() {
        //setup
        Hrac stano = new Hrac("Stano",500);
        Kun pepik = new Kun(1,1000,"hnědá",0);
        //when
        stano.pridejKone(pepik);
        //then
        assertNotNull(stano.getKone());
    }*/



    /**
     * @author xrepka
     * @version etapa-1
     */


    /*public void testPridejKone_duplicita() {
        //setup
        Hrac stano = new Hrac("Stano", 500);
        Kun pepik = new Kun(1,1000,"hnědá",0);
        Kun tom = new Kun(1,1000,"hnědá",0);
        //when
        stano.pridejKone(pepik);
        stano.pridejKone(tom);
        //then

        assertEquals(stano.getKone().size(),2);
    }*/

    /**
     * @author xlacina5
     * @version etapa-1
     */

    //@Test
    /*public void testPridejTrenera(){
        //setup
        Hrac tomas = new Hrac("Tomas",500);
        Trener trenerVana = new Trener(5,"Trener Vana");
        //when
        tomas.pridejTrenera(trenerVana);
        //then
        assertNotNull(tomas.getTreneri());
    }*/

    /**
     * @author xlacina5
     * @version etapa-1
     */
    //@Test
    /*public void testPridejTrenera_duplicita(){
        //setup
        Hrac tomas = new Hrac("Tomas",500);
        Trener trenerVana=new Trener(5,"Trener Vana");
        Trener trenerPepa=new Trener(8,"Trener Pepa");

        //when
        tomas.pridejTrenera(trenerVana);
        tomas.pridejTrenera(trenerPepa);
        //then
        assertEquals(tomas.getTreneri().size(),2);
    }*/



}
