package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{
    @Test
    public final void testGeldbetragGetters()
    {
        Geldbetrag betrag = new Geldbetrag(100);
        assertEquals(1, betrag.getEuroAnteil());
        assertEquals(0, betrag.getCentAnteil());
        assertEquals("1,00", betrag.getFormatiertenString());

        betrag = new Geldbetrag(0);
        assertEquals(0, betrag.getEuroAnteil());
        assertEquals(0, betrag.getCentAnteil());
        assertEquals("0,00", betrag.getFormatiertenString());

        betrag = new Geldbetrag(99);
        assertEquals(0, betrag.getEuroAnteil());
        assertEquals(99, betrag.getCentAnteil());
        assertEquals("0,99", betrag.getFormatiertenString());

        betrag = new Geldbetrag(101);
        assertEquals(1, betrag.getEuroAnteil());
        assertEquals(1, betrag.getCentAnteil());
        assertEquals("1,01", betrag.getFormatiertenString());
    }

    @Test
    public final void testEqualsHashcode()
    {
        Geldbetrag betrag1 = new Geldbetrag(100);
        Geldbetrag betrag2 = new Geldbetrag(100);
        assertTrue(betrag1.equals(betrag2));
        assertTrue(betrag1.hashCode() == betrag2.hashCode());

        Geldbetrag betrag3 = new Geldbetrag(101);
        assertFalse(betrag1.equals(betrag3));
        assertFalse(betrag1.hashCode() == betrag3.hashCode());

        Geldbetrag betrag4 = new Geldbetrag(1000);
        assertFalse(betrag1.equals(betrag4));
        assertFalse(betrag1.hashCode() == betrag4.hashCode());
    }
    
    @Test
    public final void testeAddieren()
    {
        Geldbetrag betrag1 = new Geldbetrag(10,42);
        Geldbetrag betrag2 = new Geldbetrag(5,23);
        
        assertEquals(15, Geldbetrag.addiere(betrag1, betrag2).getEuroAnteil());
        assertEquals(65, Geldbetrag.addiere(betrag1, betrag2).getCentAnteil());
        assertEquals("15,65", Geldbetrag.addiere(betrag1, betrag2).getFormatiertenString());
        
    }
    
    @Test
    public final void testeAddieren()
    {
        Geldbetrag betrag1 = new Geldbetrag(10,42);
        Geldbetrag betrag2 = new Geldbetrag(5,23);
        
        assertEquals(5, Geldbetrag.subtrahiere(betrag1, betrag2).getEuroAnteil());
        assertEquals(19, Geldbetrag.subtrahiere(betrag1, betrag2).getCentAnteil());
        assertEquals("5,19", Geldbetrag.subtrahiere(betrag1, betrag2).getFormatiertenString());
        
    }
    
    @Test
    public final void testMultiplikation()
    {
        Geldbetrag betrag1 = new Geldbetrag(10,42);
        int faktor = 2;
        
        assertEquals(20, Geldbetrag.multipliziere(betrag1, faktor).getEuroAnteil());
        assertEquals(84, Geldbetrag.multipliziere(betrag1, faktor).getCentAnteil());
        assertEquals("20,84", Geldbetrag.multipliziere(betrag1, faktor).getFormatiertenString());
        
    }
    
    @Test
    public final void testParser()
    {
        String betrag = "23,42";
        
        assertEquals(23, Geldbetrag.parseString(betrag).getEuroAnteil());
        assertEquals(42, Geldbetrag.parseString(betrag).getCentAnteil());
        assertEquals("23,42", Geldbetrag.parseString(betrag).getFormatiertenString());
    }
}
