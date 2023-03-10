// Java Modules:
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CurrencyConverter extends JFrame{
    final int WIDTH = 700;
    final int HEIGHT = 342;
    final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            CurrencyConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            CurrencyConverter.class.getResource("/assets/background_alura.png")));
    final ImageIcon GREEN_TICK = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/greenTick.png")));
    private final JPanelCreator IN_CURRENCY_PANEL;
    private final JPanelCreator OUT_CURRENCY_PANEL;
    private final JTextFieldCreator IN_VALUE;
    private final JTextFieldCreator OUT_VALUE;
    private final JLabelCreator INSERT_NUMBER_VALUE;
    private final JLabelCreator RESULT_VALUE;
    private final JButtonCreator BUTTON;
    final int X = WIDTH/2 - 198;
    final int Y = 41;
    final int W = 147;
    final int H = 36;
    final Rectangle PANEL_1_POS = new Rectangle(X, Y, W, H);
    final Rectangle PANEL_2_POS = new Rectangle(X, Y + H, W, H);
    final Rectangle PANEL_3_POS = new Rectangle(X - 1, Y + 2 * H, W + 1, Y - 13);
    final Rectangle PANEL_4_POS = new Rectangle(X - 1, Y + 3 * H, W + 1, Y - 13);
    final Rectangle LABEL_1_POS = new Rectangle(X - 45, Y - 2, W, Y);
    final Rectangle LABEL_2_POS = new Rectangle(X - 25, Y + H - 3, W, Y);
    final Rectangle LABEL_3_POS = new Rectangle(X - 120, Y + 2 * H - 6, W, Y);
    final Rectangle LABEL_4_POS = new Rectangle(X - 54, Y + 3 * H - 7, W, Y);
    final Rectangle BUTTON_POS = new Rectangle(X + 155, Y + 2 * H, 30, Y - 12);

    // Panel 1: Currencies:
    private final String[] CURRENCY_OPTIONS = {"-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"};

    public CurrencyConverter() {
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

        // Panel 1 - Create IN_CURRENCY_PANEL:
        IN_CURRENCY_PANEL = new JPanelCreator(PANEL_1_POS, CURRENCY_OPTIONS, true);
        // Panel 2 - Create OUT_CURRENCY_PANEL:
        OUT_CURRENCY_PANEL = new JPanelCreator(PANEL_2_POS, CURRENCY_OPTIONS, false);
        // Panel 3 - Create In Text Field:
        IN_VALUE = new JTextFieldCreator(PANEL_3_POS, false);
        // Panel 4 - Create Out Text Field:
        OUT_VALUE = new JTextFieldCreator(PANEL_4_POS, false);

        // Label 1 - Create "From" Label:
        JLabelCreator from = new JLabelCreator(LABEL_1_POS, "From", true, 14);
        // Label 2 - Create "To" Label:
        JLabelCreator to = new JLabelCreator(LABEL_2_POS, "To", false, 14);
        // Label 3 - Create "Insert a Number" Label:
        INSERT_NUMBER_VALUE = new JLabelCreator(LABEL_3_POS, "Insert a Number", false, 14);
        // Label 4 - Create "Result" Label:
        RESULT_VALUE = new JLabelCreator(LABEL_4_POS, "Result", false, 14);

        // Button - Create BUTTON:
        BUTTON = new JButtonCreator(BUTTON_POS, GREEN_TICK,false, IN_VALUE, OUT_VALUE, RESULT_VALUE);

        // Add Category Panels to Background Label:
            // Panel 1 - IN_CURRENCY_PANEL:
        bgImage.add(IN_CURRENCY_PANEL);
            // Panel 2 - OUT_CURRENCY_PANEL:
        bgImage.add(OUT_CURRENCY_PANEL);
            // Panel 3 - In Text Field:
        bgImage.add(IN_VALUE);
            // Panel 4 - Out Text Field:
        bgImage.add(OUT_VALUE);
        // Add Labels to Background Label:
        bgImage.add(from);
        bgImage.add(to);
        bgImage.add(INSERT_NUMBER_VALUE);
        bgImage.add(RESULT_VALUE);
        // Add Button to Background Label:
        bgImage.add(BUTTON);

        // Create Text Field List for setting text panel visibility:
        LinkedList<JTextFieldCreator> textList = new LinkedList<>();
        textList.add(IN_VALUE);
        textList.add(OUT_VALUE);

        // Create Label List for setting label panel visibility:
        LinkedList<JLabelCreator> labelList = new LinkedList<>();
        labelList.add(from);
        labelList.add(to);
        labelList.add(INSERT_NUMBER_VALUE);
        labelList.add(RESULT_VALUE);

        // Add ActionListener to Panel 1 - IN_CURRENCY_PANEL JComboBox:
        IN_CURRENCY_PANEL.getOptionsComboBox().addActionListener(e -> {
            String selectedOption1 = (String) IN_CURRENCY_PANEL.getOptionsComboBox().getSelectedItem();
            if ("-Select an Option-".equals(selectedOption1)) {
                OUT_CURRENCY_PANEL.setOptionsComboBox(CURRENCY_OPTIONS, "");
                setPanelVisibility(labelList, new boolean[] {true, false, false, false});
                setTextVisibility(textList, new boolean[] {false, false});
                BUTTON.setVisible(false);
            } else {
                OUT_CURRENCY_PANEL.setOptionsComboBox(CURRENCY_OPTIONS, selectedOption1);
                setPanelVisibility(labelList, new boolean[] {true, true, false, false});
                OUT_CURRENCY_PANEL.setVisible(true);
                BUTTON.setInCurrency(selectedOption1);
            }
        });

        // Add ActionListener to Panel 2 - OUT_CURRENCY_PANEL JComboBox:
        OUT_CURRENCY_PANEL.getOptionsComboBox().addActionListener(e -> {
            String selectedOption2 = (String) OUT_CURRENCY_PANEL.getOptionsComboBox().getSelectedItem();
            if ("-Select an Option-".equals(selectedOption2)) {
                setTextVisibility(textList, new boolean[] {false, false});
                INSERT_NUMBER_VALUE.setVisible(false);
                BUTTON.setVisible(false);
                RESULT_VALUE.setVisible(false);
            } else {
                IN_VALUE.setVisible(true);
                INSERT_NUMBER_VALUE.setVisible(true);
                BUTTON.setVisible(true);
                BUTTON.setOutCurrency(selectedOption2);
            }
        });

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void setPanelVisibility(LinkedList<JLabelCreator> label, boolean[] labelVisibility) {
        for (int i = 0; i < label.size(); i++){
            label.get(i).setVisible(labelVisibility[i]);
        }
    }

    public static void setTextVisibility(LinkedList<JTextFieldCreator> textField, boolean[] textVisibility) {
        for (int i = 0; i < textField.size(); i++){
            textField.get(i).setVisible(textVisibility[i]);
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}



/*
public static void setPanelVisibility(LinkedList<JPanelCreator> panel, LinkedList<JLabelCreator> label, boolean[] panelVisibility, boolean[] labelVisibility) {
        for (int i = 0; i < panel.size(); i++){
            panel.get(i).setVisible(panelVisibility[i]);
        }
        for (int j = 0; j < label.size(); j++){
            label.get(j).setVisible(labelVisibility[j]);
        }
    }
 */
