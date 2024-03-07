import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    private static final String folderPath = "src/Images/";
    private static final String fileType = ".jpg";
    private static final int imageSize = 100; // Adjust the size as needed

    public static void main(String[] args) throws Exception {
        JFrame gui = new JFrame();
        gui.setTitle("SLOT MACHINE");
        gui.setSize(500, 500);
        gui.setBackground(new Color(10, 10, 150));

        SlotMachine machine = new SlotMachine();

        JPanel mainPanel = new JPanel();
        OverlayLayout overlayLayout = new OverlayLayout(mainPanel);
        mainPanel.setLayout(overlayLayout);

        // Add the SlotMachine image to the panel
        mainPanel.add(new JLabel(new ImageIcon(folderPath + "SlotMachine" + fileType)));

        // Spin Slot Machine on Mouse Click.
        gui.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] results = machine.pullLever();

                // Clear existing labels
                mainPanel.removeAll();

                // Add labels with resized images based on the results array
                for (int result : results) {
                    String imageName = result + fileType;
                    ImageIcon icon = new ImageIcon(folderPath + imageName);
                    Image image = icon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
                    mainPanel.add(new JLabel(new ImageIcon(image)));
                }

                // Add the SlotMachine image back to the panel
                mainPanel.add(new JLabel(new ImageIcon(folderPath + "SlotMachine" + fileType)));

                // Repaint the panel to reflect the changes
                mainPanel.revalidate();
                mainPanel.repaint();

                // Check and print winnings
                String message = machine.checkWinnings();
                System.out.println(message);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        gui.add(mainPanel);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
