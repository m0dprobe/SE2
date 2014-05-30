package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 30/05/14.
 */
public class BezahlWerkzeug extends ObservableSubwerkzeug
{
    private BezahlWerkzeugUI _ui;
    private Geldbetrag _preis;

    public BezahlWerkzeug(Geldbetrag preis)
    {
        _preis = preis;
        _ui = new BezahlWerkzeugUI(_preis);
    }

    public void init()
    {
        registriereUIAktionen();
        _ui.zeigeDialog();
    }

    private void registriereUIAktionen()
    {
        _ui.getCancelButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                _ui.schliessen();
            }
        });

        _ui.getEingabeCent().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                aufEingabeReagieren();
            }
        });

        _ui.getEingabeEuro().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
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

    private void aufEingabeReagieren()
    {
        String input = _ui.getEingabeEuro().getText() + _ui.getEingabeCent().getText();
        if(input.matches("[0-9]+"))
        {
            int input_int = Integer.parseInt(input);
            if(input_int >= (_preis.getEuroAnteil()*100 + _preis.getCentAnteil()))
            {
                int restpreis = input_int - (_preis.getEuroAnteil()*100 + _preis.getCentAnteil());
                Geldbetrag rueckgeld = new Geldbetrag(restpreis);
                _ui.getRestEuro().setText(Integer.toString(rueckgeld.getEuroAnteil()));
                _ui.getRestCent().setText(rueckgeld.getFormatiertenCentAnteil());

                _ui.getOKButton().setEnabled(true);
                _ui.getOKButton().requestFocus();
            }
            else
            {
                _ui.zeigeFehler("Bitte geben Sie einen ausreichenden Betrag ein.",
                        "Wir haben alle zu wenig Geld, aber…");
                _ui.getOKButton().setEnabled(false);
            }
        }

    }
}
