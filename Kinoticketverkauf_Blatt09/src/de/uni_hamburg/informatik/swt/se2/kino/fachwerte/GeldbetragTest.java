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
        assertEquals(1, betrag.getEuro());
        assertEquals(0, betrag.getCent());
        assertEquals("1,00", betrag.getFormattedString());

        betrag = new Geldbetrag(0);
        assertEquals(0, betrag.getEuro());
        assertEquals(0, betrag.getCent());
        assertEquals("0,00", betrag.getFormattedString());

        betrag = new Geldbetrag(99);
        assertEquals(0, betrag.getEuro());
        assertEquals(99, betrag.getCent());
        assertEquals("0,99", betrag.getFormattedString());

        betrag = new Geldbetrag(101);
        assertEquals(1, betrag.getEuro());
        assertEquals(1, betrag.getCent());
        assertEquals("1,01", betrag.getFormattedString());
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
        Geldbetrag betrag1 = new Geldbetrag(1042);
        Geldbetrag betrag2 = new Geldbetrag(523);
        
        assertEquals(15, Geldbetrag.add(betrag1, betrag2).getEuro());
        assertEquals(65, Geldbetrag.add(betrag1, betrag2).getCent());
        assertEquals("15,65", Geldbetrag.add(betrag1, betrag2).getFormattedString());
        
    }
    
    @Test
    public final void testeSubtrahieren()
    {
        Geldbetrag betrag1 = new Geldbetrag(1042);
        Geldbetrag betrag2 = new Geldbetrag(523);
        
        assertEquals(5, Geldbetrag.subtract(betrag1, betrag2).getEuro());
        assertEquals(19, Geldbetrag.subtract(betrag1, betrag2).getCent());
        assertEquals("5,19", Geldbetrag.subtract(betrag1, betrag2).getFormattedString());
        
    }
    
    @Test
    public final void testMultiplikation()
    {
        Geldbetrag betrag1 = new Geldbetrag(1042);
        int faktor = 2;
        
        assertEquals(20, Geldbetrag.multiply(betrag1, faktor).getEuro());
        assertEquals(84, Geldbetrag.multiply(betrag1, faktor).getCent());
        assertEquals("20,84", Geldbetrag.multiply(betrag1, faktor).getFormattedString());
        
    }
    
    @Test
    public final void testParser()
    {
        String betrag = "23,42";
        
        assertEquals(23, new Geldbetrag(betrag).getEuro());
        assertEquals(42, new Geldbetrag(betrag).getCent());
        assertEquals("23,42", new Geldbetrag(betrag).getFormattedString());
    }
}
