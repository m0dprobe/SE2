package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Die Klasse modelliert eine Karte, mittels derer der Vormerk-Vorgang durchgeführt wird.
 * @author Markus, Alex, Samah, Mostafa
 */
public class Vormerkkarte 
{
	private List<Kunde> _vormerker;
	private Medium _medium;
	
	/**
	 * Initialisiert eine neue Vormerkkarte mit den angegebenen Daten. 	
	 * @param medium Das Medium, für das die Verleihkarte angelegt werden soll.
	 * @param kunde Der Kunde, für das die Vormerkkarte angelegt werden soll.
	 * 
	 * @require medium != null
	 * @require kunde != null
	 */
	public Vormerkkarte(Medium medium, Kunde kunde)
	{
		assert medium != null : "Vorbedingung verletzt: medium != null";
		assert kunde != null : "Vorbedingung verletzt: kunde != null";
		
		_medium = medium;
		
		_vormerker = new LinkedList<>();
		_vormerker.add(kunde);
	}
	
	/**
	 * Gibt die Liste aller Vormerker zurück.
	 * @return Liste aller Vormerker
	 * 
	 * @ensure result != null
	 */
	public List<Kunde> getAlleVormerker()
	{
		return _vormerker;
	}
	
	/**
	 * Gibt den 1., 2. oder 3. Vormerker zurück
	 * @param index Index, der den Vormerker wählt. Wert: 1, 2 oder 3
	 * @return Vormerker an der gewählten Stelle
	 * 
	 * @require index <= 3
	 * @require index >= 1
	 */
	public Kunde getVormerker(int index)
	{
		assert index <= 3 : "Vorbedingung verletzt: index <= 3";
		assert index >= 1 : "Vorbedingung verletzt: index >= 1";
		
		Kunde vormerker;
		
		try
		{
			vormerker = _vormerker.get(index - 1);
			return vormerker;
		}
		catch (IndexOutOfBoundsException e)
		{
			return null;
		}
	}
	
	/**
	 * Gibt das Medium zurück.
	 * @return Das Medium der Verleihkarte.
	 * 
	 * @ensure result != null
	 */
	public Medium getMedium()
	{
		return _medium;
	}
	
	/**
	 * Fügt einen neuen Vormerker zur Karte hinzu.
	 * @param kunde Der hinzuzufügende Kunde.
	 * 
	 * @require kunde != null
	 */
	public void neuerVormerker(Kunde kunde)
	{
		assert kunde != null : "Vorbedingung verletzt: kunde != null";
		
		_vormerker.add(kunde);
	}
	
	/**
	 * Entfernt einen Vormerker von der Liste.
	 * @param kunde Der zu entfernende Kunde.
	 * 
	 * @require _vormerker.contains(kunde)
	 * @require kunde != null
	 */
	public void entferneVormerker(Kunde kunde)
	{
		assert kunde != null : "Vorbedingung verletzt: kunde != null";
		assert _vormerker.contains(kunde) : "Vorbedingung verletzt: _vormerker.contains(kunde)";
		
		_vormerker.remove(kunde);
	}
}
