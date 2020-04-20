package exceptions.examples;

public class SaveScoreException extends Exception {
    public SaveScoreException (String message, Throwable cause){
        super(message, cause);
    }
}
