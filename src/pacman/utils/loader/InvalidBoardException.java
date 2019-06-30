package pacman.utils.loader;

public class InvalidBoardException extends Exception {
    public InvalidBoardException() {
        super();
    }

    public InvalidBoardException(String message) {
        super(message);
    }

    public InvalidBoardException(Throwable throwable) {
        super(throwable);
    }

    public InvalidBoardException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
