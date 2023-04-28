// version: 1.0
// date: 2023-04-27
// author: Stefan Ernes;
// description: This class is responsible for the testing storage of the cargo.
package administration;

import cargo.DryBulkCargo;
import cargoImpl.DryBulkCargoImpl;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    // Test via boolean, einfuegen eines Elementes in die Liste
    @org.junit.jupiter.api.Test
    void einfuegen() {
        //Arrange
        Storage lagerZuTesten = new Storage();
        DryBulkCargoImpl testCargoToAdd = new DryBulkCargoImpl();
        //Act
        boolean testEinfuegen = lagerZuTesten.einfuegen(testCargoToAdd);
        //Assert
        assertTrue(testEinfuegen);
    }

    // Test via int, lagerVoll bzw. Kapazität erreicht
    @org.junit.jupiter.api.Test
    void lagerVoll() {
        //Arrange
        Storage lagerZuTesten = new Storage();
        DryBulkCargoImpl testCargoToAdd = new DryBulkCargoImpl();
        lagerZuTesten.setKapazitaet(0);
        //Act
        int testFull = lagerZuTesten.getKapazitaet();
        //Assert

        assertTrue(lagerZuTesten.getKapazitaet() < 1);
    }

    // Test via Liste ausgabe Inhalt bzw. Element, assertEquals
    @org.junit.jupiter.api.Test
    void abrufen() {
        //Arrange
        Storage lagerZuTesten = new Storage();
        DryBulkCargoImpl testCargoToRead = new DryBulkCargoImpl();
        lagerZuTesten.einfuegen(testCargoToRead);
        //Act
        List<DryBulkCargo> testAbrufen = lagerZuTesten.abrufen(testCargoToRead);
        //Assert
        assertEquals(1, testAbrufen.size());

    }

    // Testmethode zum Entfernen eines Elements aus der Liste / Test via boolean
    @org.junit.jupiter.api.Test
    void entfernen() {
        //Arrange
        Storage lagerZuTesten = new Storage();
        DryBulkCargoImpl testCargoToDelete = new DryBulkCargoImpl();
        lagerZuTesten.einfuegen(testCargoToDelete);
        //Act
        boolean testEntfernen = lagerZuTesten.entfernen(testCargoToDelete);
        //Assert
        assertTrue(testEntfernen);
    }
    // alte Testmethode / Test via Date

    /*@org.junit.jupiter.api.Test
    void inspektion() {
        //Arrange
        Storage lagerZuTesten = new Storage();
        DryBulkCargoImpl testCargoToInspect = new DryBulkCargoImpl();
        lagerZuTesten.einfuegen(testCargoToInspect);
        //Act
        Date testInspektion = lagerZuTesten.inspektion(testCargoToInspect);
        //Assert
        assertEquals(testInspektion, testCargoToInspect.getLastInspectionDate());
        System.out.println(testCargoToInspect.getLastInspectionDate());
    }*/

    // neue Testmethode um die Inspektion zu testen / Test via boolean
    @org.junit.jupiter.api.Test
    void inspektion() {
        //Arrange
        Storage lagerZuTesten = new Storage();
        DryBulkCargoImpl testCargoToInspect = new DryBulkCargoImpl();
        lagerZuTesten.einfuegen(testCargoToInspect);
        //Act
        boolean testInspektion = lagerZuTesten.inspektion(testCargoToInspect);
        //Assert
        assertTrue(testInspektion);
    }
}