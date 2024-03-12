import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    private static final String folderPath = "src/Images/";
    private static final String fileType = ".jpg";

    private static double money = 100; // Player's Money
    private static final double cost = 10; // Cost to Pull Lever
    
    public static void main(String[] args) throws Exception {
        JFrame gui = new JFrame();
        gui.setTitle("Slot Machine");
        gui.setSize(500, 500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JPanel slotPanel = new JPanel();
        slotPanel.setLayout(new BoxLayout(slotPanel, BoxLayout.X_AXIS));
        
        JLabel[] slotLabels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            slotPanel.add(Box.createHorizontalGlue());
            slotLabels[i] = new JLabel();
            slotPanel.add(slotLabels[i]);
        }

        JLabel moneyLabel = new JLabel("Money: $" + money);
        panel.add(moneyLabel);
        
        SlotMachine slotMachine = new SlotMachine();
        
        JButton spinButton = new JButton("Spin");
        spinButton.addActionListener(e -> {
            int[] results = slotMachine.pullLever();
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
                JOptionPane.showMessageDialog(null, "You lost! -$10");
            }

            moneyLabel.setText("Money: $" + money);
        });
        
        panel.add(slotPanel);
        panel.add(spinButton);
        gui.add(panel);
        
        slotPanel.setVisible(true);
        panel.setVisible(true);
        gui.setVisible(true);
    }
}
