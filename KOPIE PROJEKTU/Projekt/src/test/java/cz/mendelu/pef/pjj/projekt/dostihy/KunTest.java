package cz.mendelu.pef.pjj.projekt.dostihy;

import junit.framework.TestCase;

public class KunTest extends TestCase {


    /**
     * @author xrepka
     * @version etapa-1
     */

    public void testZmenPocetZetonu() {
        //setup
        var pepik = new Kun(1,1000,"hnědá",0);
        //when
        pepik.zmenPocetZetonu(1);
        //then
        assertEquals(1,pepik.getPocetZetonu());
    }


    /**
     * @author xrepka
     * @version etapa-1
     */
    public void testGetPocetZetonu() {
        //when
        Kun pepik = new Kun(1,1000,"hnědá",0);
        //then
        assertEquals(0,pepik.getPocetZetonu());


    }
}