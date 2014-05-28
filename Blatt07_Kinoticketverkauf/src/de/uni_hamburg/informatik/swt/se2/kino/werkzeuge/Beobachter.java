package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

/**
 * Implementiert das Beobachterinterface des Beobachtermusters für das
 * Kinoticketsystem. 
 * @author Samah, Markus, Mostafa, Alex
 */
public interface Beobachter
{
    /**
     * Reagiert auf Änderungen in den beobachteten Subwerkzeugen.
     * 
     * @param b ein beobachtbares Subwerkzeug
     * @require b ist ein gültiges Subwerkzeug
     */
    void reagiereAufAenderungen(Beobachtbar b);
}
