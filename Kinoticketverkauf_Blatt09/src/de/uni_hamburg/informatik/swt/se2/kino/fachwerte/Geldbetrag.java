package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

// TODO Kommentare schreiben

/**
 * @author 3timmerm
 *
 */
public final class Geldbetrag implements Comparable<Geldbetrag>
{
    private final int _cent;    
    
    public Geldbetrag(int value)
    {
        _cent = value;
    }
    
    public Geldbetrag(String s)
    {
        assert validate(s) : "Vorbedingung verletzt: validate(s)";

        if (s.matches("[0-9]{1,7},[0-9]{2}"))
        {
            _cent = Integer.parseInt(s.replace(",", ""));
        }
        else if (s.matches("[0-9]{1,7}"))
        {
            _cent = Integer.parseInt(s)*100;
        }
        else 
        {
            _cent = 0;
        }
        
    }
    
    @Override
    public String toString()
    {
        int euro = _cent / 100;
        int cent = Math.abs(_cent % 100);
        
        String centF;
        
        if (cent < 10)
        {
            centF = "0" + cent;
        }
        else
        {
            centF = Integer.toString(cent);
        }
        
        return euro + "," + centF;
    }
    
    public int getEuro()
    {
        return _cent / 100;
    }
    
    public int getCent()
    {
        return _cent % 100;
    }
        
    public static Geldbetrag add(Geldbetrag a, Geldbetrag b)
    {
        return new Geldbetrag(a._cent + b._cent);
    }
    
    public static Geldbetrag subtract(Geldbetrag a, Geldbetrag b)
    {
        return new Geldbetrag(a._cent - b._cent);
    }
    
    public static Geldbetrag multiply(Geldbetrag g, int factor)
    {
        return new Geldbetrag(g._cent * factor);
    }
    
    private static boolean validate(String s)
    {
        return s.matches("[0-9]{1,7},[0-9]{2}") || s.matches("[0-9]{1,7}");
    }
    
    public int getCentValue()
    {
        return _cent;
    }
    
    @Override
    public int compareTo(Geldbetrag o)
    {
        return _cent - o._cent;
    }
    
    @Override
    public boolean equals(Object o)
    {
        return (o instanceof Geldbetrag) && equals((Geldbetrag)o);
    }
    
    public boolean equals(Geldbetrag o)
    {
        return (_cent == o._cent);
    }
    
    @Override
    public int hashCode()
    {
        return _cent;
    }
}
