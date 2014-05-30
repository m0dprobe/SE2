package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

import java.awt.*;
import javax.swing.*;

/**
 * Created by alex on 30/05/14.
 */
public class BezahlWerkzeugUI
{
    private JDialog _dialog;
    private JButton _okButton;
    private JButton _cancelButton;
    private JLabel _zuZahlenLabel;
    private JLabel _zuZahlenEuro;
    private JLabel _zuZahlenKomma;
    private JLabel _zuZahlenCent;
    private JLabel _zuZahlenWaehrung;
    private JLabel _gegebenLabel;
    private JTextField _gegebenEuro;
    private JLabel _gegebenKomma;
    private JTextField _gegebenCent;
    private JLabel _gegebenWaehrung;
    private JLabel _restLabel;
    private JLabel _restEuro;
    private JLabel _restKomma;
    private JLabel _restCent;
    private JLabel _restWaehrung;

    private Geldbetrag _preis;

    public BezahlWerkzeugUI(Geldbetrag preis)
    {
        _preis = preis;
        erzeugeUI(_preis);
    }

    private void erzeugeUI(Geldbetrag preis)
    {
        _dialog = new JDialog(new JDialog(), "Barzahlung", true);
        Container contentPane = _dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // TODO Layout verbessern

        _zuZahlenLabel = new JLabel("ZU ZAHLEN:");
        _zuZahlenEuro = new JLabel(Integer.toString(preis.getEuroAnteil()));
        _zuZahlenKomma = new JLabel(",");
        _zuZahlenCent = new JLabel(Integer.toString(preis.getCentAnteil()));
        _zuZahlenWaehrung = new JLabel("EUR");

        _gegebenLabel = new JLabel("GEGEBEN:");
        _gegebenEuro = new JTextField();
        _gegebenKomma = new JLabel(",");
        _gegebenCent = new JTextField("00", 2);
        _gegebenWaehrung = new JLabel("EUR");

        _restLabel = new JLabel("RÜCKGABE:");
        _restEuro = new JLabel(Integer.toString(preis.getEuroAnteil()));
        _restKomma = new JLabel(",");
        _restCent = new JLabel(Integer.toString(preis.getCentAnteil()));
        _restWaehrung = new JLabel("EUR");

        _okButton = new JButton("OK");
        _cancelButton = new JButton("Abbrechen");

        // Panel oben

        JPanel topPanel = new JPanel();
        contentPane.add(topPanel, BorderLayout.NORTH);

        //GroupLayout layout = new GroupLayout(topPanel);

        /*layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(_zuZahlenLabel)
                                .addComponent(_gegebenLabel)
                                .addComponent(_restLabel)
                        )
                        .addGroup(layout.createParallelGroup()
                                .addComponent(_zuZahlenEuro)
                                .addComponent(_gegebenEuro)
                                .addComponent(_restEuro)
                        )
                        .addGroup(layout.createParallelGroup()
                                .addComponent(_zuZahlenKomma)
                                .addComponent(_gegebenKomma)
                                .addComponent(_restKomma)
                        )
                        .addGroup(layout.createParallelGroup()
                                .addComponent(_zuZahlenCent)
                                .addComponent(_gegebenCent)
                                .addComponent(_restCent)
                        )
                        .addGroup(layout.createParallelGroup()
                                .addComponent(_zuZahlenWaehrung)
                                .addComponent(_gegebenWaehrung)
                                .addComponent(_restWaehrung)
                        )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                        .addComponent(_zuZahlenLabel)
                                        .addComponent(_zuZahlenEuro)
                                        .addComponent(_zuZahlenKomma)
                                        .addComponent(_zuZahlenCent)
                                        .addComponent(_zuZahlenWaehrung)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(_gegebenLabel)
                                .addComponent(_gegebenEuro)
                                .addComponent(_gegebenKomma)
                                .addComponent(_gegebenCent)
                                .addComponent(_gegebenWaehrung)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(_restLabel)
                                .addComponent(_restEuro)
                                .addComponent(_restKomma)
                                .addComponent(_restCent)
                                .addComponent(_restWaehrung)
                        )
        );*/

        GridLayout layout = new GridLayout(3, 5);
        
        layout.addLayoutComponent(null, _zuZahlenLabel);
        layout.addLayoutComponent(null, _zuZahlenEuro);
        layout.addLayoutComponent(null, _zuZahlenKomma);
        layout.addLayoutComponent(null, _zuZahlenCent);
        layout.addLayoutComponent(null, _zuZahlenWaehrung);
        
        layout.addLayoutComponent(null, _gegebenLabel);
        layout.addLayoutComponent(null, _gegebenEuro);
        layout.addLayoutComponent(null, _gegebenKomma);
        layout.addLayoutComponent(null, _gegebenCent);
        layout.addLayoutComponent(null, _gegebenWaehrung);

        layout.addLayoutComponent(null, _restLabel);
        layout.addLayoutComponent(null, _restEuro);
        layout.addLayoutComponent(null, _restKomma);
        layout.addLayoutComponent(null, _restCent);
        layout.addLayoutComponent(null, _restWaehrung);

        topPanel.setLayout(layout);
        
        topPanel.add(_zuZahlenLabel);
        topPanel.add(_zuZahlenEuro);
        topPanel.add(_zuZahlenKomma);
        topPanel.add(_zuZahlenCent);
        topPanel.add(_zuZahlenWaehrung);

        topPanel.add(_gegebenLabel);
        topPanel.add(_gegebenEuro);
        topPanel.add(_gegebenKomma);
        topPanel.add(_gegebenCent);
        topPanel.add(_gegebenWaehrung);

        topPanel.add(_restLabel);
        topPanel.add(_restEuro);
        topPanel.add(_restKomma);
        topPanel.add(_restCent);
        topPanel.add(_restWaehrung);

        // unteres Panel

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 2));

        _okButton.setEnabled(false);

        lowerPanel.add(_okButton);
        lowerPanel.add(_cancelButton);

        contentPane.add(lowerPanel, BorderLayout.SOUTH);
    }

    public void schliessen()
    {
        _dialog.dispose();
    }

    public void zeigeDialog()
    {
        _dialog.setVisible(true);
    }

    public JButton getOKButton()
    {
        return _okButton;
    }

    public JButton getCancelButton()
    {
        return _cancelButton;
    }

    public JTextField getEingabeEuro()
    {
        return _gegebenEuro;
    }

    public JTextField getEingabeCent()
    {
        return _gegebenCent;
    }

    public JLabel getRestEuro()
    {
        return _restEuro;
    }

    public JLabel getRestCent()
    {
        return _restCent;
    }

    public void zeigeFehler(String meldung, String titel)
    {
        JOptionPane.showMessageDialog(_dialog, meldung, titel, JOptionPane.ERROR_MESSAGE);
    }
}
