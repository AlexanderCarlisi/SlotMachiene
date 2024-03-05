/**
 * Alexander Carlisi
 * APCSA
 * Slot Machine Project
 * 
 * Time Logs {
 *  9:03 - 9:15 > 12m
 *  10:09 - 10:44 > 33m > 45m
 *  11:00 - 11:27 > 27m > 72m
 *  12:22 - 12:30 > 18m > 90m
 *  1:06 - 1:40 > 34m > 124m
 * }
 * 
 * Pseudo code :
 * main {
 *  
 * 
 * }
 * 
 * 
 * 
 */


import javax.swing.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame gui = new JFrame();
        gui.setTitle("SLOT MACHINE");
        gui.setSize(500, 500);
        gui.setBackground(new Color(10, 10, 150));

        SlotMachine machine = new SlotMachine();

        // Spin Slot Machine on Mouse Click.
        gui.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] results = machine.pullLever();

                
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        });

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
