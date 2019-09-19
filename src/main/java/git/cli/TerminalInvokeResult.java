package git.cli;

public class TerminalInvokeResult {

    enum Status{
        ERROR, SUCCESS
    }

    Status status;

    private String message;

    public TerminalInvokeResult(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

}
