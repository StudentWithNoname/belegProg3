// version: 1.0
// date: 2023-04-27
// author: Stefan Ernes;
// description: This class is responsible for the storage of the cargo.
package administration;

import cargo.DryBulkCargo;
import cargo.Hazard;
import cargoImpl.DryBulkCargoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Storage {
    private List<DryBulkCargo> dryBulkCargoList = new ArrayList<>();
    private List<Customer> customerList;
    private static int kapazitaet = 1000;
    private int used;
    private boolean full;

    public static int getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    // Konstruktor für die Klasse Storage, wird erst später benötigt
    //TODO: 27.04.2023  Konstruktor muss noch implementiert werden---> wegen Kapazitaet und used!

    public Storage() {
        this.customerList = new ArrayList<>();
        this.dryBulkCargoList = new ArrayList<>();
        this.kapazitaet = 1000;
        this.used = 0;
    }

    // Methode zum Einfügen eines Elements in die Liste
    public boolean einfuegen(Customer owner, BigDecimal value, Collection<Hazard> hazards, int grainSize) {

        if (dryBulkCargoList.size() == kapazitaet || full || used == kapazitaet - 1) {
            full = true;
            throw new UnsupportedOperationException("Kein Platz mehr im Lager!");
        } else {
            full = false;
        }
        //cargoToAdd.getStorageLocation();
        kapazitaet--;


        //return dryBulkCargoList.add(new DryBulkCargoImpl(owner, value, hazards, grainSize));
        return true;
    }
    // TODO: 27.04.2023  Kapazitaet muss noch implementiert werden

    // Methode zum abrufen der Liste bzw. eines Elementes aus der Liste
    public List<DryBulkCargo> abrufen(String cargoToRead) {
        if (dryBulkCargoList.size() == 0) {
            System.out.println("Liste enthält keine Elemente");
            // throw new UnsupportedOperationException("Liste enthält keine Elemente");
        }
        List<DryBulkCargo> dryBulkCargoListKopie = new ArrayList<>(dryBulkCargoList);
        return dryBulkCargoListKopie;
    }


    //  Methode zum Entfernen eines Elements aus der Liste
    public boolean entfernen(String cargoToDelete) {
        if (dryBulkCargoList.size() == 0) {
            System.out.println("Liste enthält keine Elemente");
            //throw new UnsupportedOperationException("Not implemented yet");
        }
        if (kapazitaet == 1000) {
            System.out.println("Lager ist leer");
            //throw new UnsupportedOperationException("Not implemented yet");
        } else {
            kapazitaet++;
        }
        kapazitaet++;
        dryBulkCargoList.remove(cargoToDelete);
        return true;
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
    public boolean inspektion(String testkunde, BigDecimal bigDecimal, DryBulkCargoImpl cargoToInspect, int i) {
        /*if (dryBulkCargoList.size() == 0) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
        if (cargoToInspect.getLastInspectionDate() != null) {
            throw new UnsupportedOperationException("Not implemented yet");
        }*/
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

    public boolean inspektionCargo(DryBulkCargoImpl storageLocation) {
        for (DryBulkCargo cargo : dryBulkCargoList) {
            //if (cargo.getStorageLocation() == storageLocation) {
                if (cargo instanceof DryBulkCargoImpl dryBulkCargo) {
                    dryBulkCargo.setLastInspectionDate(new Date());
                }
                return true;
            }
        return false;
        }

    }


