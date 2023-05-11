package viewControl;

import administration.Customer;
import administration.CustomerImpl;
import administration.CustomerManagement;
import administration.Storage;
import cargo.DryBulkCargo;
import cargoImpl.DryBulkCargoImpl;
import util.Command;

import java.math.BigDecimal;
import java.util.Scanner;

public class Console {
    private Storage model;
    private CustomerManagement model2;

    public Console(Storage model, CustomerManagement model2) {
        this.model = model;
        this.model2 = model2;
    }

    public void execute() throws InstantiationException, IllegalAccessException {
        try (Scanner s = new Scanner(System.in)) {
            do {
                System.out.println("Bitte geben Sie einen Befehl ein!");
                System.out.println("Moegliche Befehle sind: \n- c fuer create\n- d fuer delete" +
                        "\n- r fuer read\n- u fuer update\n- e fuer exit");
                Command c = new Command(s.next());
                switch (c.operator) {
                    case CREATE:
                        //this.model.einfuegen(DryBulkCargo
                       CustomerImpl owner = new CustomerImpl("testkunde");
                        model2.addCustomer("testkunde");
                        model.einfuegen(owner, new BigDecimal("232323.232323"),null,4);
                        break;
                    case DELETE:
                        CustomerImpl owner2 = new CustomerImpl("testkunde");
                        model2.addCustomer("testkunde");
                        model.einfuegen(owner2, new BigDecimal("232323.232323"),null,4);
                        model.entfernen("testkunde");
                        break;
                    case READ:
                        CustomerImpl ownerRead = new CustomerImpl("testkunde");
                        model2.addCustomer("testkunde");
                        model.einfuegen(ownerRead, new BigDecimal("232323.232323"),null,4);

                        this.model.abrufen("testkunde");
                        break;
                    // Todo Update aendern auf Interface
                    case UPDATE:
                        CustomerImpl ownerUpdate = new CustomerImpl("testkunde");
                        model2.addCustomer("testkunde");
                        model.einfuegen(ownerUpdate, new BigDecimal("232323.232323"),null,4);
                        model.inspektion("testkunde", new BigDecimal("232323.232323"),null,4);
                        System.out.println("update");

                        break;
                    case EXIT:
                        System.out.println("Programm wird beendet");
                        return;
                    case ERROR:
                        System.out.println("error");
                        break;
                }
                System.out.println("aktuelle Kapazitaet " + this.model.getKapazitaet());
            } while (true);
        }
    }

}
