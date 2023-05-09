package viewControl;

import administration.Storage;
import cargoImpl.DryBulkCargoImpl;
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
                System.out.println("Bitte geben Sie einen Befehl ein!");
                System.out.println("Moegliche Befehle sind: \n- c fuer create\n- d fuer delete" +
                        "\n- r fuer read\n- u fuer update\n- e fuer exit");
                Command c = new Command(s.next());
                switch (c.operator) {
                    case CREATE:
                        this.model.einfuegen(DryBulkCargoImpl.class.newInstance());
                        break;
                    case DELETE:
                        this.model.entfernen(DryBulkCargoImpl.class.newInstance());
                        break;
                    case READ:
                        this.model.abrufen(DryBulkCargoImpl.class.newInstance());
                        break;
                    // Todo Update aendern auf Interface
                    case UPDATE:
                        this.model.inspektion(DryBulkCargoImpl.class.newInstance());
                        break;
                    case EXIT:
                        System.out.println("Programm wird beendet");
                        return;
                    case ERROR:
                        System.out.println("error");
                        break;
                }
                System.out.println(this.model.getKapazitaet());
            } while (true);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /*public void execute() {
        try (Scanner s = new Scanner(System.in)) {
            do {
                System.out.println("enter command:");
                Command c = new Command(s.next());
               // switch (c.operator) {
                switch (c.operator) {
                    case CREATE:
                        //this.model.einfuegen((DryBulkCargo) model);
                        this.model.einfuegen((DryBulkCargo) c);
                        break;
                    case DELETE:
                        this.model.entfernen((DryBulkCargo) c);
                        break;
                    case READ:
                        this.model.abrufen((DryBulkCargo) c);
                        break;
                        // Todo Update ändern auf Interface
                    *//*case UPDATE:
                        this.model.inspektion((DryBulkCargoImpl.) c);
                        break;*//*
                    case ERROR:
                        System.out.println("error");
                        break;
                }
                System.out.println(this.model.getKapazitaet());
            } while (true);
        }
    }*/
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
