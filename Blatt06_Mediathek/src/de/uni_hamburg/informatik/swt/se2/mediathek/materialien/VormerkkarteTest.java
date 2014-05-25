package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.DVD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
	private Medium _medium1;
	private Medium _medium2;
	private Kunde _vormerkkunde1;
	private Kunde _vormerkkunde2;
	
	private Vormerkkarte _karte1;
	private Vormerkkarte _karte2;
	
	public VormerkkarteTest()
	{
		_vormerkkunde1 = new Kunde(new Kundennummer(424242), "Douglas", "Adams");
		_vormerkkunde2 = new Kunde(new Kundennummer(232323), "Eris,", "Goddess of Discord");
		_medium1 = new DVD("The Hitchhiker's Guide to the Galaxy", "Buch ist besser", "Dr. Foo Bar", 120);
		_medium2 = new CD("Weisses Rauschen", "Sehr entspannend", "Theodor Prinz der Tapfere", 30000);
		
		_karte1 = new Vormerkkarte(_medium1, _vormerkkunde1);
		_karte2 = new Vormerkkarte(_medium2, _vormerkkunde2);
	}
	
	@Test
	public void testTesteKonstruktor()
	{
		assertEquals(_vormerkkunde1, _karte1.getVormerker(1));
		assertEquals(_vormerkkunde2, _karte2.getVormerker(1));
		
		List<Kunde> _vormerkliste1 = new LinkedList<>();
		List<Kunde> _vormerkliste2 = new LinkedList<>();
		
		_vormerkliste1.add(_vormerkkunde1);
		_vormerkliste2.add(_vormerkkunde2);
		
		assertEquals(_vormerkliste1, _karte1.getAlleVormerker());
		assertEquals(_vormerkliste2, _karte2.getAlleVormerker());
		
		assertEquals(_medium1, _karte1.getMedium());
		assertEquals(_medium2, _karte2.getMedium());
	}
	
	
}
