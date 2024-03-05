import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Wheel {
    private final Random random = new Random();
    private final ArrayList<Integer> slot;

    public Wheel() {
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
            for (int j = 0; j < 4; j++) 
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
        int spins = random.nextInt(11) + 10;

        for (int i = 0; i < spins; i++) {
            Collections.shuffle(slot);
        }

        return slot.get(0);
    }
}
