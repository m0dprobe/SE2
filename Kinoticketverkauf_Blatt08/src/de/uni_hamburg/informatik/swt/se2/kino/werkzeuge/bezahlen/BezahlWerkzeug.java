package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Die Klasse modelliert ein Werkzeug, das den Bezahlvorgang an der Kinokasse unterstützt.
 * @author Samah, Markus, Mostafa, Alex
 */

public class BezahlWerkzeug extends ObservableSubwerkzeug
{
    private BezahlWerkzeugUI _ui;
    private int _preis;

    /**
     * Initialisiert ein Exemplar des BezahlWerkzeugs mit dem angegebenen Preis.
     * @param preis Der Preis der zu verkaufenden Plätze in Cent.
     */
    public BezahlWerkzeug(int preis)
    {
        _preis = preis;
        _ui = new BezahlWerkzeugUI(_preis);
    }

    /**
     * Initialisiert die UI-Aktionen und zeigt den Dialog. 
     */
    public void initialisieren()
    {
        registriereUIAktionen();
        _ui.zeigeDialog();
    }

    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {
        _ui.getCancelButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                _ui.schliessen();
            }
        });

        _ui.getEingabeCent().getDocument().addDocumentListener(
                new DocumentListener()
                {
                    @Override public void insertUpdate(DocumentEvent e)
                    {
                        aufEingabeReagieren();
                    }
                    @Override public void removeUpdate(DocumentEvent e)
                    {
                        aufEingabeReagieren();
                    }
                    @Override public void changedUpdate(DocumentEvent e)
                    {
                        aufEingabeReagieren();
                    }
                });

        _ui.getOKButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                informiereUeberAenderung();
                _ui.schliessen();
            }
        });
    }

    /**
     * Reagiert auf Eingaben.
     */
    private void aufEingabeReagieren()
    {
        String input = _ui.getEingabeCent().getText();
        if(input.matches("[0-9]*") && !input.equals(""))
        {
            int input_int = Integer.parseInt(input);
            int restpreis = input_int - _preis;
            if(input_int >= _preis)
            {
                _ui.getRestCent().setForeground(Color.black);
                _ui.getRestCent().setText(Integer.toString(restpreis));

                _ui.getOKButton().setEnabled(true);
            }
            else
            {
            	_ui.getRestCent().setForeground(Color.red);
                _ui.getRestCent().setText(Integer.toString(restpreis));

                _ui.getOKButton().setEnabled(false);
            }
        }
        else if (input.equals(""))
        {
        	_ui.getRestCent().setForeground(Color.red);
        	_ui.getRestCent().setText("-" + Integer.toString(_preis));
        }
        else
        {
            _ui.zeigeFehler("Bitte nur Zahlen eingeben.", "Eingabefehler");
            _ui.getOKButton().setEnabled(false);
        }

    }
}
