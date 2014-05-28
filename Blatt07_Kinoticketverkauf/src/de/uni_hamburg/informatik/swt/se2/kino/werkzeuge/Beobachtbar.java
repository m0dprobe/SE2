package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.util.ArrayList;
import java.util.List;

/**
 * Basisklasse für Subwerkzeuge, die ihr Kontextwerkzeug bei Änderungen
 * benachrichtigen möchten.
 * 
 * @author Samah, Mostafa, Markus, Alex
 */
public abstract class Beobachtbar
{
    private List<Beobachter> _beobachter;
    
    /**
     * Initialisiert eine Instanz von Beobachtbar mit einer leeren ArrayList
     * der Beobachter.
     */
    public Beobachtbar()
    {
        _beobachter = new ArrayList<>();
    }
    
    /**
     * Registriert einen neuen Beobachter.
     * @param b Ein Beobachter, der registriert werden soll.
     * 
     * @require b != null
     */
    public void registriereBeobachter(Beobachter b)
    {
        assert b != null : "Vorbedingung verletzt: b != null";
        
        _beobachter.add(b);
    }
    
    /**
     * Informiert jeden Beobachter über die Änderung(en).
     */
    public void informiereUeberAenderungen()
    {
        for(Beobachter b : _beobachter)
        {
            b.reagiereAufAenderungen(this);
        }
    }
}
