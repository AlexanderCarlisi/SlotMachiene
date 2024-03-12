import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    private static final String folderPath = "src/Images/";
    private static final String fileType = ".jpg";
    
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
        });
        
        panel.add(slotPanel);
        panel.add(spinButton);
        gui.add(panel);
        
        slotPanel.setVisible(true);
        panel.setVisible(true);
        gui.setVisible(true);
    }
}
