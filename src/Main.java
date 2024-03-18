/*
 * Alexander Carlisi
 * AP CSA
 * Project : Slot Machine
 */

/* PSEUDO CODE
 * 
 * 
 * Main Method
 * Create GUI
 * Create Panel
 * Create Slot Labels
 * Create Slot Machine
 * Create Spin Button
 * Add Components
 * Set Visible
 * 
 * Spin Button Action
 * Pull Lever
 * Set Slot Images
 * Check Winnings
 * Update Money Label
 * 
 */


import javax.swing.*;
import java.awt.*;

// Main Class
public class Main {
    // Static Constants
    private static final String folderPath = "src/Images/";
    private static final String fileType = ".jpg";

    private static double money = 100; // Player's Money
    private static final double cost = 35; // Cost to Pull Lever
    
    // Main Method
    public static void main(String[] args) throws Exception {
        // Create GUI
        JFrame gui = new JFrame();
        gui.setTitle("Slot Machine");
        gui.setSize(500, 500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create Panel
        JPanel panel = new JPanel();
        JPanel slotPanel = new JPanel();
        slotPanel.setLayout(new BoxLayout(slotPanel, BoxLayout.X_AXIS));
        
        // Create Slot Labels
        JLabel[] slotLabels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            slotPanel.add(Box.createHorizontalGlue());
            slotLabels[i] = new JLabel();
            slotPanel.add(slotLabels[i]);
        }

        // Money Label
        JLabel moneyLabel = new JLabel("Money: $" + money);
        panel.add(moneyLabel);
        
        // Create Slot Machine
        SlotMachine slotMachine = new SlotMachine();
        
        // Create Spin Button
        JButton spinButton = new JButton("Spin");
        // Spin Button Action
        spinButton.addActionListener(e -> {
            // Pull Lever
            int[] results = slotMachine.pullLever();
            // Set Slot Images
            for (int i = 0; i < 3; i++) {
                // Scale Image to desired size
                ImageIcon icon = new ImageIcon(folderPath + results[i] + fileType);
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                
                // Modify Button
                slotLabels[i].setIcon(scaledIcon);
            }

            // Check Winnings
            SlotMachine.Prize prize = slotMachine.checkWinnings();
            if (prize == SlotMachine.Prize.A) {
                money += 100;
                JOptionPane.showMessageDialog(null, "You won Prize A! +$100");
            } else if (prize == SlotMachine.Prize.B) {
                money += 50;
                JOptionPane.showMessageDialog(null, "You won Prize B! +$50");
            } else {
                money -= cost;
                JOptionPane.showMessageDialog(null, "You lost! -$"+cost);
            }

            if (money < cost) {
                JOptionPane.showMessageDialog(null, "You lost all your money! Game Over!\n99.9% of gamblers quit before they hit it big. Don't be a statistic!");
                System.exit(0);
            }

            moneyLabel.setText("Money: $" + money);
        });
        
        // Add Components
        panel.add(slotPanel);
        panel.add(spinButton);
        gui.add(panel);
        
        // Set Visible
        slotPanel.setVisible(true);
        panel.setVisible(true);
        gui.setVisible(true);
    }
}
