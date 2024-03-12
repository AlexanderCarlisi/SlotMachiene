public class SlotMachine {

    public static enum Prize {
        None, A, B
    }

    // Static Constants
    private static final int NUMBER_OF_SLOTS = 3;

    /** Slot Machine Wheels */
    private final Wheel[] wheels;

    /**
     * Initializes the SlotMachine Class.
     */
    public SlotMachine() {
        wheels = new Wheel[NUMBER_OF_SLOTS];
        for (int i = 0; i < NUMBER_OF_SLOTS; i++)
            wheels[i] = new Wheel();
    }

    /**
     * Starts the Slot Machine Roullete.
     * @return results of each Wheel's spin.
     */
    public int[] pullLever() {
        return new int[] {wheels[0].spin(), wheels[1].spin(), wheels[2].spin()};
    }

    /**
     * Checks for congruent Slot Values, and sees if the User has one something.
     * 
     * 2 congruent slots = Prize B
     * 3 congruent slots = Prize A
     * @return Prize
     */
    public Prize checkWinnings() {
        int[] slotValues = new int[3];
        for (int i = 0; i < 3; i++) {
            slotValues[i] = wheels[i].getSlotValue();
        }
        
        if (slotValues[0] == slotValues[1] && slotValues[1] == slotValues[2]) return Prize.A;
        else if (slotValues[0] == slotValues[1]) return Prize.B;
        else if (slotValues[1] == slotValues[2]) return Prize.B;
        else if (slotValues[0] == slotValues[2]) return Prize.B;

        return Prize.None;
    }
}
