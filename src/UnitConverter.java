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
    final ImageIcon greenTick = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/greenTick.png")));
    private JTextFieldCreator inValue;
    private JButtonCreator button;

    final Rectangle PANEL_1_POS = new Rectangle(WIDTH/2 - 80, 41, 133, 33);
    final Rectangle PANEL_2_POS = new Rectangle(WIDTH/2 - 80, 74, 133, 33);
    final Rectangle PANEL_3_POS = new Rectangle(WIDTH/2 - 81, 107, 134, 27);
    final Rectangle PANEL_4_POS = new Rectangle(WIDTH/2 - 81, 134, 134, 27);
    final Rectangle LABEL_1_POS = new Rectangle(WIDTH/2 - 118, 41, 133, 33);
    final Rectangle LABEL_2_POS = new Rectangle(WIDTH/2 - 104, 74, 133, 33);
    final Rectangle LABEL_3_POS = new Rectangle(WIDTH/2 - 180, 103, 133, 33);
    final Rectangle LABEL_4_POS = new Rectangle(WIDTH/2 - 124, 136, 133, 33);
    final Rectangle BUTTON_POS = new Rectangle(WIDTH/2 + 58, 108, 30, 26);

    // Panel 1: Currency, Length, Temperature:
    final LinkedList<String> CURRENCY_OPTIONS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"));

    // Panel 2 - Currencies:
    final LinkedList<String> ARGENTINE = new LinkedList<>(Arrays.asList("-Select an Option-", "Dollar", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> DOLLAR = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> EURO = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Pounds", "Yen", "Won"));
    final LinkedList<String> POUNDS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Yen", "Won"));
    final LinkedList<String> YEN = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Won"));
    final LinkedList<String> WON = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen"));

    public UnitConverter() {
        // Create Main Screen:
        setTitle("Alura Currency Converter");
        setIconImage(ICON);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Label and Load Background Image:
        JLabel bgImage = new JLabel(BG_IMAGE);
        add(bgImage);

        // Panel 1 - Create Currency Panel:
        JPanelCreator currencyPanel = new JPanelCreator(PANEL_1_POS, CURRENCY_OPTIONS, true);
        // Panel 2 - Create Currencies Panel:
        JPanelCreator currencyPanel2 = new JPanelCreator(PANEL_2_POS, CURRENCY_OPTIONS, false);
        JPanelCreator argentinePanel = new JPanelCreator(PANEL_2_POS, ARGENTINE, false);
        JPanelCreator dollarPanel = new JPanelCreator(PANEL_2_POS, DOLLAR, false);
        JPanelCreator euroPanel = new JPanelCreator(PANEL_2_POS, EURO, false);
        JPanelCreator poundsPanel = new JPanelCreator(PANEL_2_POS, POUNDS, false);
        JPanelCreator yenPanel = new JPanelCreator(PANEL_2_POS, YEN, false);
        JPanelCreator wonPanel = new JPanelCreator(PANEL_2_POS, WON, false);
        // Panel 3 - Create In Text Field:
        inValue = new JTextFieldCreator(PANEL_3_POS, false);
        // Panel 4 - Create In Text Field:
        JTextFieldCreator outValue = new JTextFieldCreator(PANEL_4_POS, false);

        // Label 1 - Create "From" Label:
        JLabelCreator from = new JLabelCreator(LABEL_1_POS, "From", true, 12);
        // Label 2 - Create "To" Label:
        JLabelCreator to = new JLabelCreator(LABEL_2_POS, "To", false, 12);
        // Label 3 - Create "To" Label:
        JLabelCreator insertValue = new JLabelCreator(LABEL_3_POS, "Insert a Number", false, 12);
        // Label 4 - Create "Result" Label:
        JLabelCreator resultValue = new JLabelCreator(LABEL_4_POS, "Result", false, 12);

        // Button - Create "Button":
        button = new JButtonCreator(BUTTON_POS, greenTick,false, inValue);

        // Add Category Panels to Background Label:
            // Panel 1 - Currency Panel:
        bgImage.add(currencyPanel);
            // Panel 2 - Currencies Panel:
        bgImage.add(currencyPanel2);
        bgImage.add(argentinePanel);
        bgImage.add(dollarPanel);
        bgImage.add(euroPanel);
        bgImage.add(poundsPanel);
        bgImage.add(yenPanel);
        bgImage.add(wonPanel);
            // Panel 3 - In Text Field:
        bgImage.add(inValue);
            // Panel 4 - Out Text Field:
        bgImage.add(outValue);
        // Add Labels to Background Label:
        bgImage.add(from);
        bgImage.add(to);
        bgImage.add(insertValue);
        bgImage.add(resultValue);
        // Add Button to Background Label:
        bgImage.add(button);

        //Add ActionListener to Currency Options JComboBox:
            // Add Currencies Panels to List:
        LinkedList<JPanelCreator> currencyList = new LinkedList<>();
        currencyList.add(currencyPanel2);
        currencyList.add(argentinePanel);
        currencyList.add(dollarPanel);
        currencyList.add(euroPanel);
        currencyList.add(poundsPanel);
        currencyList.add(yenPanel);
        currencyList.add(wonPanel);
            // Add Labels "From", "To, to Label List:
        LinkedList<JLabelCreator> labelList = new LinkedList<>();
        labelList.add(from);
        labelList.add(to);
        labelList.add(insertValue);
        labelList.add(resultValue);

        currencyPanel.options.addActionListener(e -> {
            String selectedOption = (String) currencyPanel.options.getSelectedItem();
            // Show/Hide relevant Panel/Label based on selected option:
            switch (Objects.requireNonNull(selectedOption)) {
                case "-Select an Option-" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, false}, new boolean[] {true, false, false, false});
                    inValue.setVisible(false);
                }
                case "Argentine Peso" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, true, false, false, false, false, false}, new boolean[] {true, true, false, false});
                case "Dollar" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, true, false, false, false, false}, new boolean[] {true, true, false, false});
                case "Euro" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, true, false, false, false}, new boolean[] {true, true, false, false});
                case "Pounds" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, true, false, false}, new boolean[] {true, true, false, false});
                case "Yen" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, true, false}, new boolean[] {true, true, false, false});
                case "Won" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, true}, new boolean[] {true, true, false, false});
            }
        });

        //Add ActionListener to In Value Text Field:
            // Add In Value to List:
        LinkedList<JTextFieldCreator> inValueList = new LinkedList<>();
        inValueList.add(inValue);

        for (JPanelCreator panel : currencyList) {
            JComboBox<String> options = panel.options;
            options.addActionListener(e -> {
                String selectedOption = (String) options.getSelectedItem();
                if ("-Select an Option-".equals(selectedOption)) {
                    inValue.setVisible(false);
                    insertValue.setVisible(false);
                    button.setVisible(false);
                } else {
                    inValue.setVisible(true);
                    insertValue.setVisible(true);
                    button.setVisible(true);
                }
            });
        }

        if(inValue.getTextField().equals("")){
            System.out.println("correcto");
        }

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
