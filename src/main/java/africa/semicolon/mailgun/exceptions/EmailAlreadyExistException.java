package africa.semicolon.mailgun.exceptions;

public class EmailAlreadyExistException extends Exception {
    private final int statusCode;
    public EmailAlreadyExistException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
