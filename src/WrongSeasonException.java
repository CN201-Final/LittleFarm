/** The selected seeds cannot be planted in the current season. */
public class WrongSeasonException extends FarmException {
    private static final long serialVersionUID = 1L;

    public WrongSeasonException(String message) {
        super(message);
    }
}
