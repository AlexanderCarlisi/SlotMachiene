import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Wheel Class
 * 
 * This class represents a Wheel in a Slot Machine.
 * It contains a Slot ArrayList and methods to spin the wheel.
 * 
 * The Slot ArrayList contains 5 elements, each element is a number from 0-4.
 * The Wheel can be spun a random amount of times, and the element at 0 is returned.
 * 
 * The Wheel can also return the element at 0 without spinning.
 * 
 * The Wheel is used in the SlotMachine class.
 * 
 * @see SlotMachine
 */
public class Wheel {
    /** Random Number Generator. */
    private final Random random = new Random();

    /** Slot ArrayList */
    private final ArrayList<Integer> slot;

    /**
     * Initialize Wheel, populates Slot.
     */
    public Wheel() {
        // Initialize Slot
        slot = new ArrayList<>();
        populate();
    }

    /**
     * Populates the Slot ArrayList
     */
    private void populate() {
        // Add 5 elements 2 times
        for (int i = 0; i < 2; i++) {
            // 5 elements
            for (int j = 0; j < 5; j++) 
                slot.add(j);
        }
    }

    /**
     * Spins the Arraylist Slot a Random amount of times.
     * spins 10-20 times
     *  
     * @return element at 0
     */
    public int spin() {
        // Randomly Spin
        int spins = random.nextInt(20) + 1;

        // Shuffle Slot
        for (int i = 0; i < spins; i++) {
            Collections.shuffle(slot);
        }

        // Return Element at 0
        return slot.get(0);
    }

    /**
     * Get the element at 0 of slot.
     * @return
     */
    public int getSlotValue() {
        // Return Element at 0
        return slot.get(0);
    }
}
