package view.menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class MenuWindow {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuWindow window = new MenuWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MenuWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Main Menu - DonkeyKong");
        frame.setSize(500, 550);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30};
        gridBagLayout.rowHeights = new int[] {0, 30, 30, 30, 30, 30, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        frame.getContentPane().setLayout(gridBagLayout);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\budin\\Desktop\\project\\oop17-kong\\res\\images\\logo.png"));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 2;
        gbc_lblNewLabel.gridy = 1;
        frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        JButton btnNewButton = new JButton("Play");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 3;
        frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
        
        JButton btnNewButton_1 = new JButton("High Scores");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 2;
        gbc_btnNewButton_1.gridy = 4;
        frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Info");
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_2.gridx = 2;
        gbc_btnNewButton_2.gridy = 5;
        frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Exit");
        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_3.gridx = 2;
        gbc_btnNewButton_3.gridy = 6;
        frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
    }

}
