// Java Modules:
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 700;
    static final int HEIGHT = 342;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png")));
    final ImageIcon GREEN_TICK = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/greenTick.png")));
    private final JPanelCreator currencyPanel;
    private final JTextFieldCreator inValue;
    private final JTextFieldCreator outValue;
    private final JLabelCreator insertValue;
    private final JLabelCreator resultValue;
    private final JButtonCreator button;
    final int x = WIDTH/2 - 198;
    final int y = 41;
    final int w = 147;
    final int h = 36;
    final Rectangle PANEL_1_POS = new Rectangle(x, y, w, h);
    final Rectangle PANEL_2_POS = new Rectangle(x, y + h, w, h);
    final Rectangle PANEL_3_POS = new Rectangle(x - 1, y + 2 * h, w + 1, y - 13);
    final Rectangle PANEL_4_POS = new Rectangle(x - 1, y + 3 * h, w + 1, y - 13);
    final Rectangle LABEL_1_POS = new Rectangle(x - 45, y - 2, w, y);
    final Rectangle LABEL_2_POS = new Rectangle(x - 25, y + h - 3, w, y);
    final Rectangle LABEL_3_POS = new Rectangle(x - 120, y + 2 * h - 6, w, y);
    final Rectangle LABEL_4_POS = new Rectangle(x - 50, y + 3 * h - 20, w, y);
    final Rectangle BUTTON_POS = new Rectangle(x + 155, y + 2 * h, 30, y - 12);

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
        currencyPanel = new JPanelCreator(PANEL_1_POS, CURRENCY_OPTIONS, true);
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
        outValue = new JTextFieldCreator(PANEL_4_POS, false);

        // Label 1 - Create "From" Label:
        JLabelCreator from = new JLabelCreator(LABEL_1_POS, "From", true, 14);
        // Label 2 - Create "To" Label:
        JLabelCreator to = new JLabelCreator(LABEL_2_POS, "To", false, 14);
        // Label 3 - Create "To" Label:
        insertValue = new JLabelCreator(LABEL_3_POS, "Insert a Number", false, 14);
        // Label 4 - Create "Result" Label:
        resultValue = new JLabelCreator(LABEL_4_POS, "Result", false, 14);

        // Button - Create "Button":
        button = new JButtonCreator(BUTTON_POS, GREEN_TICK,false, inValue, outValue);

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
                    button.setVisible(false);
                }
                case "Argentine Peso" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, true, false, false, false, false, false}, new boolean[] {true, true, false, false});
                    button.setInCurrency(selectedOption);
                }
                case "Dollar" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, false, true, false, false, false, false}, new boolean[] {true, true, false, false});
                    button.setInCurrency(selectedOption);
                }
                case "Euro" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, true, false, false, false}, new boolean[] {true, true, false, false});
                    button.setInCurrency(selectedOption);
                }
                case "Pounds" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, true, false, false}, new boolean[] {true, true, false, false});
                    button.setInCurrency(selectedOption);
                }
                case "Yen" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, true, false}, new boolean[] {true, true, false, false});
                    button.setInCurrency(selectedOption);
                }
                case "Won" -> {
                    setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, true}, new boolean[] {true, true, false, false});
                    button.setInCurrency(selectedOption);
                }
            }
        });

        //Add ActionListener to In Value Text Field:
        for (JPanelCreator panel : currencyList) {
            JComboBox<String> options = panel.options;
            options.addActionListener(e -> {
                String selectedOption = (String) options.getSelectedItem();
                if ("-Select an Option-".equals(selectedOption)) {
                    inValue.setVisible(false);
                    insertValue.setVisible(false);
                    button.setVisible(false);
                    outValue.setVisible(false);
                    resultValue.setVisible(false);
                } else {
                    inValue.setVisible(true);
                    insertValue.setVisible(true);
                    button.setVisible(true);
                    button.setOutCurrency(selectedOption);
                }
            });
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
