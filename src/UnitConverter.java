// Java Modules:
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 512;
    static final int HEIGHT = 264;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png")));
    final Rectangle PANEL_1_POS = new Rectangle(WIDTH/2 - 80, 10, 133, 33);
    final Rectangle PANEL_2_POS = new Rectangle(WIDTH/2 - 80, 41, 133, 33);
    final Rectangle PANEL_3_POS = new Rectangle(WIDTH/2 - 80, 74, 133, 33);
    final Rectangle PANEL_4_POS = new Rectangle(WIDTH/2 - 80, 107, 133, 33);
    final Rectangle LABEL_1_POS = new Rectangle(WIDTH/2 - 148, 10, 133, 33);
    final Rectangle LABEL_2_POS = new Rectangle(WIDTH/2 - 118, 41, 133, 33);
    final Rectangle LABEL_3_POS = new Rectangle(WIDTH/2 - 104, 74, 133, 33);

    // Panel 1 - Categories:
    final LinkedList<String> CATEGORY_OPTIONS = new LinkedList<>(Arrays.asList("-Select an Option-", "Currency", "Length", "Temperature"));

    // Panel 2: Currency, Length, Temperature:
    final LinkedList<String> CURRENCY_OPTIONS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> LENGTH_OPTIONS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> TEMPERATURE_OPTIONS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"));

    // Panel 3 - Currencies:
    final LinkedList<String> ARGENTINE = new LinkedList<>(Arrays.asList("-Select an Option-", "Dollar", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> DOLLAR = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> EURO = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Pounds", "Yen", "Won"));
    final LinkedList<String> POUNDS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Yen", "Won"));
    final LinkedList<String> YEN = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Won"));
    final LinkedList<String> WON = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen"));


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

        // Panel 1 - Create Category Panel:
        JPanelCreator categoryPanel = new JPanelCreator(PANEL_1_POS, CATEGORY_OPTIONS, true);
        
        // Panel 2 - Create Currency, Length and Temperature Panels:
        JPanelCreator currencyPanel = new JPanelCreator(PANEL_2_POS, CURRENCY_OPTIONS, false);
        JPanelCreator lengthPanel = new JPanelCreator(PANEL_2_POS, LENGTH_OPTIONS, false);
        JPanelCreator temperaturePanel = new JPanelCreator(PANEL_2_POS, TEMPERATURE_OPTIONS, false);

        // Panel 3 - Create Currency, Length and Temperature Panels:
        JPanelCreator currencyPanel2 = new JPanelCreator(PANEL_3_POS, CURRENCY_OPTIONS, false);
        JPanelCreator lengthPanel2 = new JPanelCreator(PANEL_3_POS, LENGTH_OPTIONS, false);
        JPanelCreator temperaturePanel2 = new JPanelCreator(PANEL_3_POS, TEMPERATURE_OPTIONS, false);

        // Panel 3 - Create Currencies Panels:
        JPanelCreator argentinePanel = new JPanelCreator(PANEL_3_POS, ARGENTINE, false);
        JPanelCreator dollarPanel = new JPanelCreator(PANEL_3_POS, DOLLAR, false);
        JPanelCreator euroPanel = new JPanelCreator(PANEL_3_POS, EURO, false);
        JPanelCreator poundsPanel = new JPanelCreator(PANEL_3_POS, POUNDS, false);
        JPanelCreator yenPanel = new JPanelCreator(PANEL_3_POS, YEN, false);
        JPanelCreator wonPanel = new JPanelCreator(PANEL_3_POS, WON, false);

        // Panel 4 - Create In Text Field:
        JTextFieldCreator inValue = new JTextFieldCreator(PANEL_4_POS, true);

        // Label 1 - Create "Select Unit" Label:
        JLabelCreator selectUnit = new JLabelCreator(LABEL_1_POS, "Select Unit", true);

        // Label 2 - Create "From" Label:
        JLabelCreator from = new JLabelCreator(LABEL_2_POS, "From", false);

        // Label 3 - Create "To" Label:
        JLabelCreator to = new JLabelCreator(LABEL_3_POS, "To", false);

        // Add Category Panels to Background Label:
            // Panel 1 - Category Panel:
        bgImage.add(categoryPanel);
            // Panel 2 - Currency, Length and Temperature Panels:
        bgImage.add(currencyPanel);
        bgImage.add(temperaturePanel);
        bgImage.add(lengthPanel);
            // Panel 3 - Currency, Length and Temperature Panels:
        bgImage.add(currencyPanel2);
        bgImage.add(temperaturePanel2);
        bgImage.add(lengthPanel2);
            // Panel 3 - Currencies Panels:
        bgImage.add(argentinePanel);
        bgImage.add(dollarPanel);
        bgImage.add(euroPanel);
        bgImage.add(poundsPanel);
        bgImage.add(yenPanel);
        bgImage.add(wonPanel);
            // Panel 4 - In Text Field:
        bgImage.add(inValue);

        // Add Labels to Background Label:
        bgImage.add(selectUnit);
        bgImage.add(from);
        bgImage.add(to);

        //Add ActionListener to Category Options JComboBox:
            // Add Currency, Length, Temperature to Panel List:
        LinkedList<JPanelCreator> categoryList = new LinkedList<>();
        categoryList.add(currencyPanel);
        categoryList.add(lengthPanel);
        categoryList.add(temperaturePanel);

            // Add Labels "From", "To, to Label List:
        LinkedList<JLabelCreator> labelList = new LinkedList<>();
        labelList.add(from);
        labelList.add(to);

        categoryPanel.options.addActionListener(e -> {
                    String selectedOption = (String) categoryPanel.options.getSelectedItem();
                    // Show/Hide relevant Panel/Label based on selected option:
            switch (Objects.requireNonNull(selectedOption)) {
                case "-Select an Option-" -> setPanelVisibility(categoryList, labelList, new boolean[] {false, false, false}, new boolean[] {false, false});
                case "Currency" -> setPanelVisibility(categoryList, labelList, new boolean[] {true, false, false}, new boolean[] {true, false});
                case "Length" -> setPanelVisibility(categoryList, labelList, new boolean[] {false, true, false}, new boolean[] {true, false});
                case "Temperature" -> setPanelVisibility(categoryList, labelList, new boolean[] {false, false, true}, new boolean[] {true, false});
            }
                });

        //Add ActionListener to Currency Options JComboBox:
            // Add Currencies Panels to Lists:
        LinkedList<JPanelCreator> currencyList = new LinkedList<>();
        currencyList.add(currencyPanel2);
        currencyList.add(argentinePanel);
        currencyList.add(dollarPanel);
        currencyList.add(euroPanel);
        currencyList.add(poundsPanel);
        currencyList.add(yenPanel);
        currencyList.add(wonPanel);

        currencyPanel.options.addActionListener(e -> {
            String selectedOption = (String) currencyPanel.options.getSelectedItem();

            // Show/Hide relevant Panel/Label based on selected option:
            switch (Objects.requireNonNull(selectedOption)) {
                case "-Select an Option-" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, false}, new boolean[] {true, false});
                case "Argentine Peso" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, true, false, false, false, false, false}, new boolean[] {true, true});
                case "Dollar" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, true, false, false, false, false}, new boolean[] {true, true});
                case "Euro" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, true, false, false, false}, new boolean[] {true, true});
                case "Pounds" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, true, false, false}, new boolean[] {true, true});
                case "Yen" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, true, false}, new boolean[] {true, true});
                case "Won" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, true}, new boolean[] {true, true});
            }
        });

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void setPanelVisibility(LinkedList<JPanelCreator> panel, LinkedList<JLabelCreator> label, boolean[] panelVisibility, boolean[] labelVisibility) {
        for (int i = 0; i < panel.size(); i++){
            panel.get(i).setVisible(panelVisibility[i]);
        }
        for (int j = 0; j < label.size(); j++){
            label.get(j).setVisible(labelVisibility[j]);
        }
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}


/*
LinkedList<JPanelCreator> argentineList = new LinkedList<>();
        argentineList.add(argentinePanel);
        argentineList.add(dollarPanel);
        argentineList.add(euroPanel);
        argentineList.add(poundsPanel);
        argentineList.add(yenPanel);
        argentineList.add(wonPanel);

        LinkedList<JPanelCreator> dollarList = new LinkedList<>();
        dollarList.add(argentinePanel);
        dollarList.add(dollarPanel);
        dollarList.add(euroPanel);
        dollarList.add(poundsPanel);
        dollarList.add(yenPanel);
        dollarList.add(wonPanel);

        LinkedList<JPanelCreator> euroList = new LinkedList<>();
        euroList.add(argentinePanel);
        euroList.add(dollarPanel);
        euroList.add(euroPanel);
        euroList.add(poundsPanel);
        euroList.add(yenPanel);
        euroList.add(wonPanel);

        LinkedList<JPanelCreator> poundList = new LinkedList<>();
        poundList.add(argentinePanel);
        poundList.add(dollarPanel);
        poundList.add(euroPanel);
        poundList.add(poundsPanel);
        poundList.add(yenPanel);
        poundList.add(wonPanel);

        LinkedList<JPanelCreator> yenList = new LinkedList<>();
        yenList.add(argentinePanel);
        yenList.add(dollarPanel);
        yenList.add(euroPanel);
        yenList.add(poundsPanel);
        yenList.add(yenPanel);
        yenList.add(wonPanel);

        LinkedList<JPanelCreator> wonList = new LinkedList<>();
        wonList.add(argentinePanel);
        wonList.add(dollarPanel);
        wonList.add(euroPanel);
        wonList.add(poundsPanel);
        wonList.add(yenPanel);
        wonList.add(wonPanel);
 */