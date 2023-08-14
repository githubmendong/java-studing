package prob5;

public class MyStackException extends Throwable {
    private static final long serialVersionUID = 1L;

    public MyStackException() {
        super();
    }

    public MyStackException(String message) {
        super(message);
    }
}
