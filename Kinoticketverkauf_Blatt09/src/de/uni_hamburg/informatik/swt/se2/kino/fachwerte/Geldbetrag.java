package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

/**
 * Modelliert den Fachwert eines Geldbetrags im Kinosystem.
 * @author Samah, Markus, Mostafa, Alex
 */
public final class Geldbetrag implements Comparable<Geldbetrag>
{
    private final int _cent;    
    
    /**
     * Initialisiert ein neues Exemplar eines Geldbetrags.
     * @param value Der Betrag in Cent.
     * 
     * @require value != null
     */
    public Geldbetrag(int value)
    {
        _cent = value;
    }
    
    /**
     * Initialisiert ein neues Exemplar des Geldbetrags mittels eines Strings.
     * @param inputString Der zu parsende String.
     * 
     * @require validate(inputString)
     */
    public Geldbetrag(String inputString)
    {
        assert validate(inputString) : "Vorbedingung verletzt: validate(s)";

        if (inputString.matches("[0-9]{1,7},[0-9]{2}"))
        {
            _cent = Integer.parseInt(inputString.replace(",", ""));
        }
        else if (inputString.matches("[0-9]{1,7}"))
        {
            _cent = Integer.parseInt(inputString)*100;
        }
        else 
        {
            _cent = 0;
        }
        
    }
    
    /**
     * Gibt eine String-Repräsentation der Form "E*,CC" zurück.
     * 
     * @ensure result != ""
     */
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
    
    /**
     * Gibt den Euro-Anteil des Geldbetrags zurück.
     * @return Der Euro-Anteil des Geldbetrags.
     */
    public int getEuro()
    {
        return _cent / 100;
    }
    
    /**
     * Gibt den Cent-Anteil des Geldbetrags zurück.
     * @return Der Cent-Anteil des Geldbetrags.
     */
    public int getCent()
    {
        return _cent % 100;
    }
    
    /**
     * Addiert zwei Geldbeträge und gibt einen neuen Geldbetrag mit dem Ergebnis zurück.
     * @param summand1 Der erste Summand.
     * @param summand2 Der zweite Summand.
     * @return Das Ergebnis der Addition.
     */
    public static Geldbetrag add(Geldbetrag summand1, Geldbetrag summand2)
    {
        return new Geldbetrag(summand1._cent + summand2._cent);
    }
    
    /**
     * Subtrahiert zwei Geldbeträge und gibt einen neuen Geldbetrag mit dem Ergebnis zurück.
     * @param minuend Der Minuend der Subtraktion.
     * @param subtrahend Der Subtrahend der Subtraktion.
     * @return Das Ergebnis der Subtraktion.
     */
    public static Geldbetrag subtract(Geldbetrag minuend, Geldbetrag subtrahend)
    {
        return new Geldbetrag(minuend._cent - subtrahend._cent);
    }
    
    /**
     * Multipliziert einen Geldbetrag mit einem Faktor und gibt das Ergebnis als Geldbetrag zurück.
     *      Zu beachten: bei einem Dezimalbruch als Faktor wird das Ergebnis auf Integer 
     *      <strong>abgeschnitten</strong>, nicht gerundet.
     * @param geldbetrag Der zu multiplizierende Geldbetrag.
     * @param factor Der Faktor als int oder Double.
     * @return Das Produkt der Multiplikation.
     */
    public static Geldbetrag multiply(Geldbetrag geldbetrag, Double factor)
    {
        return new Geldbetrag((int)(geldbetrag._cent * factor));
    }
    
    public static Geldbetrag multiply(Geldbetrag geldbetrag, int factor)
    {
        return new Geldbetrag(geldbetrag._cent * factor);
    }
    
    /**
     * Validiert, ob ein String im passenden Format vorliegt: 1-7 Ziffern vor und 2 Ziffern nach dem Komma 
     *      oder nur der Vorkommaanteil.
     * @param parseString Der zu validierende String.
     * @return <code>true</code>, wenn ein valider String vorliegt, sonst <code>false</code>
     */
    public static boolean validate(String parseString)
    {
        return parseString.matches("[0-9]{1,7},[0-9]{2}") || parseString.matches("[0-9]{1,7}");
    }
    
    /**
     * Gibt den Wert des Geldbetrags komplett in Cent zurück.
     * @return Der Cent-Wert des Geldbetrags.
     */
    public int getCentValue()
    {
        return _cent;
    }
    
    @Override
    public int compareTo(Geldbetrag other)
    {
        return _cent - other._cent;
    }
    
    @Override
    public boolean equals(Object other)
    {
        return (other instanceof Geldbetrag) && equals((Geldbetrag)other);
    }
    
    public boolean equals(Geldbetrag other)
    {
        return (_cent == other._cent);
    }
    
    @Override
    public int hashCode()
    {
        return _cent;
    }
}
