import java.util.Random;

public class SlotMachine {
    // Static Constants
    private static final int NUMBER_OF_SLOTS = 3;

    /** Slot Machine Wheels */
    private final Wheel[] wheels;

    /**
     * Initializes the SlotMachine Class.
     */
    public SlotMachine() {
        wheels = new Wheel[NUMBER_OF_SLOTS];
    }
}
