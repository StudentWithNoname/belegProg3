// version: 1.0
// date: 2023-04-27
// author: Stefan Ernes;
// description: This class is only for personal use. Just for fun and testing.
import administration.Storage;
import cargoImpl.DryBulkCargoImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {


    private static List<DryBulkCargoImpl> dryBulkCargoList = new ArrayList<>();
    // muss static sein, da sonst nicht in der main Methode darauf zugegriffen werden kann.

    public static void main(String[] args) {
        Storage testLager = new Storage();
        // erstellt ein neues Lager
        DryBulkCargoImpl testCargo = new DryBulkCargoImpl();
        // erstellt ein neues DryBulkCargo
        System.out.println(dryBulkCargoList.size());
        // gibt die Größe der Liste aus
    }
}
