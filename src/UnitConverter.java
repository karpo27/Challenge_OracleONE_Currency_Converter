// Java Modules:
import java.awt.*;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 512;
    static final int HEIGHT = 264;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png")));

    static final Rectangle PANEL_1_POS = new Rectangle(WIDTH/2 - 80, 10, 133, 31);
    static final Rectangle PANEL_2_POS = new Rectangle(WIDTH/2 - 80, 41, 133, 33);
    static final Rectangle PANEL_3_POS = new Rectangle(WIDTH/2 - 80, 39, 133, 29);
    static final Rectangle LABEL_2_POS = new Rectangle(WIDTH/2 - 118, 41, 133, 33);
    static final String[] CATEGORY_OPTIONS = {"-Select an Option-", "Currency", "Length", "Temperature"};
    static final String[] CURRENCY_OPTIONS = {"-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"};
    static final String[] LENGTH_OPTIONS = {"-Select an Option-", "Peso Argentino", "Dolar", "Euro"};
    static final String[] TEMPERATURE_OPTIONS = {"-Select an Option-", "Peso Argentino", "Dolar", "Euro"};

    public UnitConverter() {
        // Create Main Screen:
        setTitle("Alura Unit Converter");
        setIconImage(ICON);

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Label and Load Background Image:
        JLabel bgImage = new JLabel(BG_IMAGE);
        add(bgImage);
        //bgImage.setLayout(new FlowLayout());

        // Panel 1 - Create Category Panel:
        JPanelCreator categoryPanel = new JPanelCreator(PANEL_1_POS, CATEGORY_OPTIONS, true);
        
        // Panel 2 - Create Currency, Length and Temperature Panels:
        JPanelCreator currencyPanel = new JPanelCreator(PANEL_2_POS, CURRENCY_OPTIONS, false);
        JPanelCreator lengthPanel = new JPanelCreator(PANEL_2_POS, LENGTH_OPTIONS, false);
        JPanelCreator temperaturePanel = new JPanelCreator(PANEL_2_POS, TEMPERATURE_OPTIONS, false);

        // Create "From" label and add to the left of panel 2:
        JLabelCreator fromLabel = new JLabelCreator(LABEL_2_POS, "From", true);

        JLabel fromLabel2 = new JLabel("From");
        fromLabel2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fromLabel2.setForeground(Color.BLACK);

        // Add Category Panels to Background Label:
        bgImage.add((fromLabel2));
        bgImage.add(fromLabel);

        // Add Category Panels to Background Label:
        bgImage.add(currencyPanel);
        bgImage.add(temperaturePanel);
        bgImage.add(lengthPanel);

        //Add ActionListener to Category Options JComboBox:
        categoryPanel.options.addActionListener(e -> {
                    String selectedOption = (String) categoryPanel.options.getSelectedItem();

                    // Show/Hide relevant category panel based on selected option:
            switch (selectedOption) {
                case "Currency" -> {
                    currencyPanel.setVisible(true);
                    lengthPanel.setVisible(false);
                    temperaturePanel.setVisible(false);
                }
                case "Length" -> {
                    currencyPanel.setVisible(false);
                    lengthPanel.setVisible(true);
                    temperaturePanel.setVisible(false);
                }
                case "Temperature" -> {
                    currencyPanel.setVisible(false);
                    lengthPanel.setVisible(false);
                    temperaturePanel.setVisible(true);
                }
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
