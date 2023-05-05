package viewControl;

import administration.Storage;
import cargo.DryBulkCargo;
import cargoImpl.DryBulkCargoImpl;
//import contract.cargo.DrybulCargo;
import util.Command;

import java.util.Scanner;

public class Console {
    private Storage model;

    public Console(Storage model) {
        this.model = model;
    }

    public void execute() {
        try (Scanner s = new Scanner(System.in)) {
            do {
                System.out.println("enter command:");
                Command c = new Command(s.next());
                switch (c.operator) {
                    case CREATE:
                        this.model.einfuegen((DryBulkCargo) c);
                        break;
                    case DELETE:
                        this.model.entfernen((DryBulkCargo) c);
                        break;
                    case READ:
                        this.model.abrufen((DryBulkCargo) c);
                        break;
                        // Todo Update ändern auf Interface
                    /*case UPDATE:
                        this.model.inspektion((DryBulkCargoImpl.) c);
                        break;*/
                    case ERROR:
                        System.out.println("error");
                        break;
                }
                System.out.println(this.model.getKapazitaet());
            } while (true);
        }
    }
    /*private DryBulkCargoImpl model;

    public Console(DryBulkCargoImpl model) {
        this.model = model;
    }

    public void execute() {
        try (Scanner s = new Scanner(System.in)) {
            do {
                System.out.println("enter command:");
                Command c = new Command(s.next());
                switch (c.operator) {
                    case CREATE:
                        this.model.einfuegen(c.number);
                        break;
                    case DELETE:
                        this.model.subtract(c.number);
                        break;
                    case READ:
                        this.model.subtract(c.number);
                        break;
                    case UPDATE:
                        System.out.println("error");
                        break;
                }
                System.out.println(this.model.getNumber());
            } while (true);
        }
    }*/
}
