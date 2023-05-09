package util;

public class Command {
    public enum Operator {
        CREATE,
        DELETE,
        READ,
        UPDATE,
        EXIT,

        ERROR,
    }

    public final Operator operator;
    public Command(String eingabe) {
        String op = eingabe;

        switch (op) {
            case "c":
                this.operator = Operator.CREATE;
                break;
            case "create":
                this.operator = Operator.CREATE;
                break;
            case "d":
                this.operator = Operator.DELETE;
                break;
            case "delete":
                this.operator = Operator.DELETE;
                break;
            case "r":
                this.operator = Operator.READ;
                break;
            case "read":
                this.operator = Operator.READ;
                break;
            case "u":
                this.operator = Operator.UPDATE;
                break;
            case "update":
                this.operator = Operator.UPDATE;
                break;
            case "e":
                this.operator = Operator.EXIT;
                break;
            case "exit":
                this.operator = Operator.EXIT;
                break;

            default:
                this.operator = Operator.ERROR;
                break;
        }
    }


}
