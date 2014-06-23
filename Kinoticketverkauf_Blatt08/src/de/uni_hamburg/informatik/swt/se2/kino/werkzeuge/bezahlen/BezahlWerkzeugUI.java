package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;



import javax.swing.*;
import java.awt.*;

/**
 * UI-Klasse des BezahlWerkzeugs
 * @author Samah, Markus, Mostafa, Alex
 */
public class BezahlWerkzeugUI
{
    private JDialog _dialog;
    private JButton _okButton;
    private JButton _cancelButton;
    private JLabel _zuZahlenLabel;
    private JLabel _zuZahlenCent;
    private JLabel _zuZahlenWaehrung;
    private JLabel _gegebenLabel;
    private JTextField _gegebenCent;
    private JLabel _gegebenWaehrung;
    private JLabel _restLabel;
    private JLabel _restCent;
    private JLabel _restWaehrung;
    private int _preis;

    /**
     * Initialisiert ein Exemplar der UI des BezahlWerkzeugs mit dem gegebenen Preis.
     * @param preis Der anzuzeigende Preis in Cent.
     * 
     * @require preis >= 0
     */
    public BezahlWerkzeugUI(int preis)
    {
        assert preis >= 0 : "Vorbedingung verletzt: preis >= 0";
    	
    	_preis = preis;
        erzeugeUI(_preis);
    }

    /**
     * Erzeugt die UI mit dem gegebenen Preis.
     * @param preis Der zu zahlende Preis in Cent.
     * 
     * @require preis >= 0
     */
    private void erzeugeUI(int preis)
    {
        assert preis >= 0 : "Vorbedingung verletzt: preis >= 0";
    	
    	_dialog = new JDialog(new JDialog(), "Barzahlung", true);
        _dialog.setSize(300,160);
        _dialog.setResizable(false);
        _dialog.pack();
        _dialog.setLocationRelativeTo(null);
        Container contentPane = _dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // DONE Layout verbessern

        _zuZahlenLabel = new JLabel("ZU ZAHLEN:");
        _zuZahlenCent = new JLabel(Integer.toString(preis));
        _zuZahlenWaehrung = new JLabel("Cent");

        _gegebenLabel = new JLabel("GEGEBEN:");
        _gegebenCent = new JTextField(6);
        _gegebenCent.setHorizontalAlignment(JTextField.CENTER);
        _gegebenWaehrung = new JLabel("Cent");

        _restLabel = new JLabel("RÜCKGABE:");
        _restCent = new JLabel("-" + Integer.toString(preis));
        _restCent.setForeground(Color.RED);
        _restWaehrung = new JLabel("Cent");

        _okButton = new JButton("OK");
        _cancelButton = new JButton("Abbrechen");
        
        // Panel oben

        JPanel topPanel = new JPanel();
        contentPane.add(topPanel, BorderLayout.NORTH);

        GridLayout layout = new GridLayout(3, 2);
        
        JPanel _zuZahlenPanel = new JPanel();
        JPanel _gegebenPanel = new JPanel();
        JPanel _restPanel = new JPanel();
        
        _zuZahlenPanel.setLayout(new FlowLayout());
        _gegebenPanel.setLayout(new FlowLayout());
        _restPanel.setLayout(new FlowLayout());
        
        _zuZahlenPanel.add(_zuZahlenCent);
        _zuZahlenPanel.add(_zuZahlenWaehrung);

        _gegebenPanel.add(_gegebenCent);
        _gegebenPanel.add(_gegebenWaehrung);

        _restPanel.add(_restCent);
        _restPanel.add(_restWaehrung);
        
        layout.addLayoutComponent(null, _zuZahlenLabel);
        layout.addLayoutComponent(null, _zuZahlenPanel);
        
        
        layout.addLayoutComponent(null, _gegebenLabel);
        layout.addLayoutComponent(null, _gegebenPanel);

        layout.addLayoutComponent(null, _restLabel);
        layout.addLayoutComponent(null, _restPanel);

        topPanel.setLayout(layout);
        
        topPanel.add(_zuZahlenLabel);
        topPanel.add(_zuZahlenPanel);

        topPanel.add(_gegebenLabel);
        topPanel.add(_gegebenPanel);

        topPanel.add(_restLabel);
        topPanel.add(_restPanel);

        // unteres Panel

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 2));

        _okButton.setEnabled(false);

        lowerPanel.add(_okButton);
        lowerPanel.add(_cancelButton);

        contentPane.add(lowerPanel, BorderLayout.SOUTH);
    }

    /**
     * Schließt den Dialog.
     */
    public void schliessen()
    {
        _dialog.dispose();
    }

    /**
     * Zeigt den Dialog.
     */
    public void zeigeDialog()
    {
        _dialog.setVisible(true);
    }

    /**
     * Gibt den OK-Button zurück.
     * @return der OK-Button
     * 
     * @ensure result != null
     */
    public JButton getOKButton()
    {
        return _okButton;
    }

    public JButton getCancelButton()
    {
        return _cancelButton;
    }

    public JTextField getEingabeCent()
    {
        return _gegebenCent;
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
