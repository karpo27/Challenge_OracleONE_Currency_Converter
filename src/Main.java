import java.awt.*;
import javax.swing.*;

public class Main {

    // Define App Constants:
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static final String[] CATEGORY_OPTIONS = {"Currency", "Temperature", "Option 3"};

    public static void main(String[] args) {
        // Create Main Screen:
        JFrame mainScreen = new JFrame("Alura Unit Converter");
        mainScreen.setSize(WIDTH, HEIGHT);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        // Add Category Options Panel to Main Screen:
        mainScreen.add(categoryPanel, BorderLayout.CENTER);

        // Make Main Screen Visible:
        mainScreen.setVisible(true);
    }
}

/* componente JPanel

        JPanel miJPanel = new JPanel();

        miJPanel.setSize(300, 300);

        // usamos este diseño para centrar los componentes de JPanel

        miJPanel.setLayout(new GridBagLayout());

        // componente JTextField`

        JLabel miJLabel = new JLabel();

        miJLabel.setText("Dime tu opinión acerca de Java Swing:  ");

        // componente JTextArea

        JTextArea miJTextArea = new JTextArea(5,20);

        // conecta los componentes JLabel y JTextField en JPanel`

        miJPanel.add(miJLabel);

        miJPanel.add(miJTextArea);

         */