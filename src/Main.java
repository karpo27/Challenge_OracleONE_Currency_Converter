// Java Modules:
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    // Define App Constants:
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    private static final String[] CATEGORY_OPTIONS = {"Currency", "Temperature", "Option 3"};

    public static void main(String[] args) {
        // Create Main Screen:
        JFrame mainScreen = new JFrame("Alura Unit Converter");
        mainScreen.setSize(WIDTH, HEIGHT);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load Background Image:
        URL imageURL = Main.class.getResource("/assets/background_alura.png");

        Image image = null;
        try {
            image = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create Background Label:
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));
        backgroundLabel.setLayout(new BorderLayout());

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
        backgroundLabel.add(categoryPanel, BorderLayout.CENTER);

        // Add Background Label to Main Screen:
        mainScreen.setContentPane(backgroundLabel);

        // Make Main Screen Visible:
        mainScreen.setVisible(true);
    }
}
