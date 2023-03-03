// Java Modules:
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 512;
    static final int HEIGHT = 250;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png")));
    static final String[] CATEGORY_OPTIONS = {"-Select an Option-", "Currency", "Length", "Temperature"};
    static final String[] PANEL_1 = {"-Select an Option-", "Currency", "Length", "Temperature"};
    static final String[] CURRENCY_OPTIONS = {"-Select an Option-", "Peso Argentino", "Dolar", "Euro"};
    static final String[] LENGTH_OPTIONS = {"-Select an Option-", "Peso Argentino", "Dolar", "Euro"};
    static final String[] TEMPERATURE_OPTIONS = {"-Select an Option-", "Peso Argentino", "Dolar", "Euro"};

    public UnitConverter() {
        // Create Main Screen:
        setTitle("Alura Unit Converter");
        setIconImage(ICON);

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Label and Load Background Image:
        JLabel bgImage = new JLabel(BG_IMAGE);
        add(bgImage);
        //bgImage.setLayout(new FlowLayout());

        // Create Category Panel:
        JPanel categoryPanel = new JPanel(new GridBagLayout());
        categoryPanel.setBounds(WIDTH/2 - 80, 10, 133, 29);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy++;
        JComboBox<String> categoryOptions = new JComboBox<String>(CATEGORY_OPTIONS);
        categoryPanel.add(categoryOptions, gbc);

        // Create Currency Panel:
        JPanelCreator currencyPanel = new JPanelCreator(WIDTH/2 - 80, 39, 133, 29, CURRENCY_OPTIONS);

        // Create Length Panel:
        JPanelCreator lengthPanel = new JPanelCreator(WIDTH/2 - 80, 39, 133, 29, LENGTH_OPTIONS);

        // Create Temperature Panel:
        JPanelCreator temperaturePanel = new JPanelCreator(WIDTH/2 - 80, 39, 133, 29, TEMPERATURE_OPTIONS);

        // Add Category Panels to Background Label:
        bgImage.add(currencyPanel);
        bgImage.add(temperaturePanel);
        bgImage.add(lengthPanel);

        // Show Currency Panel by default:
        currencyPanel.setVisible(true);
        temperaturePanel.setVisible(false);
        lengthPanel.setVisible(false);

        // Add ActionListener to Category Options JComboBox:
        categoryOptions.addActionListener(e -> {
                    String selectedOption = (String) categoryOptions.getSelectedItem();

                    // Show/Hide relevant category panel based on selected option:
                    if (selectedOption.equals("Currency")) {
                        currencyPanel.setVisible(true);
                        temperaturePanel.setVisible(false);
                        lengthPanel.setVisible(false);
                    } else if (selectedOption.equals("Temperature")) {
                        currencyPanel.setVisible(false);
                        temperaturePanel.setVisible(true);
                        lengthPanel.setVisible(false);
                    } else if (selectedOption.equals("Length")) {
                        currencyPanel.setVisible(false);
                        temperaturePanel.setVisible(false);
                        lengthPanel.setVisible(true);
                    }
                });

        // Add Background Label to Main Screen:
        setContentPane(bgImage);

        // Add Category Panel to Main Screen
        add(categoryPanel, BorderLayout.CENTER);

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void main(String[] args) {

        new UnitConverter();
    }
}
