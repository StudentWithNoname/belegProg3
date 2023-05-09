// version: 1.0
// date: 2023-04-27
// author: Stefan Ernes;
// description: This class is responsible for the storage of the cargo.
package administration;

import cargo.DryBulkCargo;
import cargoImpl.DryBulkCargoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Storage {
    private List<DryBulkCargo> dryBulkCargoList = new ArrayList<>();
    private List<Customer> customerList;
    private int kapazitaet = 1000;
    private int used;
    private boolean full;

    public int getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    // Konstruktor für die Klasse Storage, wird erst später benötigt
    //TODO: 27.04.2023  Konstruktor muss noch implementiert werden---> wegen Kapazitaet und used!

    /*public Storage(List<DryBulkCargo> dryBulkCargoList, List<Customer> customerList, int kapazitaet, int used, boolean full) {
        this.dryBulkCargoList = dryBulkCargoList;
        this.customerList = customerList;
        this.kapazitaet = kapazitaet;
        this.used = used;
        this.full = full;
    }

    public Storage() {

    }*/

    // Methode zum Einfügen eines Elements in die Liste
    public boolean einfuegen(DryBulkCargo cargoToAdd) {

        if (dryBulkCargoList.size() == kapazitaet || full || used == kapazitaet - 1) {
            full = true;
            throw new UnsupportedOperationException("Kein Platz mehr im Lager!");
        } else {
            full = false;
        }
        kapazitaet--;
        return dryBulkCargoList.add(cargoToAdd);
    }
    // TODO: 27.04.2023  Kapazitaet muss noch implementiert werden

    // Methode zum abrufen der Liste bzw. eines Elementes aus der Liste
    public List<DryBulkCargo> abrufen(DryBulkCargo cargoToRead) {
        if (dryBulkCargoList.size() == 0) {
            System.out.println("Liste enthält keine Elemente");
           // throw new UnsupportedOperationException("Liste enthält keine Elemente");
        }
        List<DryBulkCargo> dryBulkCargoListKopie = new ArrayList<>(dryBulkCargoList);
        return dryBulkCargoList;
    }


    //  Methode zum Entfernen eines Elements aus der Liste
    public boolean entfernen(DryBulkCargo cargoToDelete) {
        if (dryBulkCargoList.size() == 0) {
            System.out.println("Liste enthält keine Elemente");
            //throw new UnsupportedOperationException("Not implemented yet");
        }
        if (kapazitaet == 1000) {
            System.out.println("Lager ist leer");
            //throw new UnsupportedOperationException("Not implemented yet");
        }
        else {
            kapazitaet++;
        }
        //kapazitaet++;
        return dryBulkCargoList.remove(cargoToDelete);
    }
    // alte Methode zum setzen des letzten Inspektionsdatums via Date evtl nochmal verwenden bzw. anpassen

    /*public Date inspektion(DryBulkCargoImpl cargoToInspect) {
        if (dryBulkCargoList.size() == 0) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
        cargoToInspect.setLastInspectionDate(new Date());
        //Date lastInspectionDate = cargoToInspect.getLastInspectionDate();
        //return lastInspectionDate;
        return cargoToInspect.getLastInspectionDate();
    }*/


    // Methode zur Inspektion eines Elements aus der Liste bzw. setzen des letzten Inspektionsdatums
    public boolean inspektion(DryBulkCargoImpl cargoToInspect) {
        if (dryBulkCargoList.size() == 0) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
        if (cargoToInspect.getLastInspectionDate() != null) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
        // TODO: 27.04.2023  Crasht sonst! ---> fixen
      /*  if (cargoToInspect.getLastInspectionDate().after(new Date())) {
            throw new UnsupportedOperationException("Not implemented yet");
        }*/

        if (this.dryBulkCargoList.contains(cargoToInspect)) {
            cargoToInspect.setLastInspectionDate(new Date());
            return true;
        }
        return false;
    }

}
