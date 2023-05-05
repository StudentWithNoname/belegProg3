package util;

public class Command {
    public enum Operator{
        CREATE,
        DELETE,
        READ,
        UPDATE,

        ERROR,
    }
    public final Operator operator;

    public Command(String eingabe) {
        String op = eingabe.substring(0, 1);
        switch (op) {
            case "c":
                this.operator = Operator.CREATE;
                break;
            case "d":
                this.operator = Operator.DELETE;
                break;
            case "r":
                this.operator = Operator.READ;
                break;
            case "u":
                this.operator = Operator.UPDATE;
                break;
            default:
                this.operator = Operator.ERROR;
                break;
        }
    }


}
