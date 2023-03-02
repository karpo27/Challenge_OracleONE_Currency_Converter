// Java Modules:
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 512;
    static final int HEIGHT = 250;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final Image BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png"))).getImage();
    static final String[] CATEGORY_OPTIONS = {"Currency", "Temperature", "Option 3"};

    public UnitConverter() {
        // Create Main Screen:
        setTitle("Alura Unit Converter");
        setIconImage(ICON);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Create Label and Load Background Image:
        JLabel background = new JLabel(
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(
                        getClass().getResource("/assets/background_alura.png"))));
        add(background);
        background.setLayout(new FlowLayout());

        // Create Category Panel:
        JPanel categoryPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        categoryPanel.add(new JLabel("Select an option: "), gbc);

        gbc.gridy++;
        JComboBox<String> categoryOptions = new JComboBox<String>(CATEGORY_OPTIONS);
        categoryPanel.add(categoryOptions, gbc);

        // Add Category Options Panel to Background Label:
        background.add(categoryPanel, BorderLayout.CENTER);

        // Add Background Label to Main Screen:
        setContentPane(background);

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}
