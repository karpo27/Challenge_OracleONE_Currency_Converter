// Java Modules:
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 512;
    static final int HEIGHT = 264;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png")));

    static final Rectangle PANEL_1_POS = new Rectangle(WIDTH/2 - 80, 10, 133, 33);
    static final Rectangle PANEL_2_POS = new Rectangle(WIDTH/2 - 80, 41, 133, 33);
    static final Rectangle PANEL_3_POS = new Rectangle(WIDTH/2 - 80, 74, 133, 33);
    static final Rectangle LABEL_1_POS = new Rectangle(WIDTH/2 - 148, 10, 133, 33);
    static final Rectangle LABEL_2_POS = new Rectangle(WIDTH/2 - 118, 41, 133, 33);
    static final Rectangle LABEL_3_POS = new Rectangle(WIDTH/2 - 104, 74, 133, 33);
    static final String[] CATEGORY_OPTIONS = {"-Select an Option-", "Currency", "Length", "Temperature"};
    static final String[] CURRENCY_OPTIONS = {"-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"};
    static final String[] LENGTH_OPTIONS = {"-Select an Option-", "", "", ""};
    static final String[] TEMPERATURE_OPTIONS = {"-Select an Option-", "", "", ""};

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

        // Panel 3 - Create Currency, Length and Temperature Panels:
        JPanelCreator currencyPanel2 = new JPanelCreator(PANEL_3_POS, CURRENCY_OPTIONS, false);
        JPanelCreator lengthPanel2 = new JPanelCreator(PANEL_3_POS, LENGTH_OPTIONS, false);
        JPanelCreator temperaturePanel2 = new JPanelCreator(PANEL_3_POS, TEMPERATURE_OPTIONS, false);

        // Label 2 - Create "From" Label:
        JLabelCreator selectUnit = new JLabelCreator(LABEL_1_POS, "Select Unit", true);

        // Label 2 - Create "From" Label:
        JLabelCreator from = new JLabelCreator(LABEL_2_POS, "From", false);

        // Label 3 - Create "To" Label:
        JLabelCreator to = new JLabelCreator(LABEL_3_POS, "To", false);

        // Add Category Panels to Background Label:
        bgImage.add(categoryPanel);
        bgImage.add(currencyPanel);
        bgImage.add(temperaturePanel);
        bgImage.add(lengthPanel);
        bgImage.add(currencyPanel2);
        bgImage.add(temperaturePanel2);
        bgImage.add(lengthPanel2);

        // Add Labels to Background Label:
        bgImage.add(selectUnit);
        bgImage.add(from);
        bgImage.add(to);

        //Add ActionListener to Category Options JComboBox:
        LinkedList<JPanelCreator> categoryList = new LinkedList<>();
        categoryList.add(currencyPanel);
        categoryList.add(lengthPanel);
        categoryList.add(temperaturePanel);

        LinkedList<JLabelCreator> labelList = new LinkedList<>();
        labelList.add(from);
        labelList.add(to);

        categoryPanel.options.addActionListener(e -> {
                    String selectedOption = (String) categoryPanel.options.getSelectedItem();

                    // Show/Hide relevant panel based on selected option:
            switch (Objects.requireNonNull(selectedOption)) {
                case "-Select an Option-" -> {
                    panelVisibility(categoryList, labelList, new boolean[] {false, false, false}, new boolean[] {false, false});
                }
                case "Currency" -> {
                    panelVisibility(categoryList, labelList, new boolean[] {true, false, false}, new boolean[] {true, false});
                }
                case "Length" -> {
                    panelVisibility(categoryList, labelList, new boolean[] {false, true, false}, new boolean[] {true, false});
                }
                case "Temperature" -> {
                    panelVisibility(categoryList, labelList, new boolean[] {false, false, true}, new boolean[] {true, false});
                }
            }
                });

        //Add ActionListener to Currency Options JComboBox:
        LinkedList<JPanelCreator> currencyList = new LinkedList<>();
        currencyList.add(currencyPanel2);

        currencyPanel.options.addActionListener(e -> {
            String selectedOption = (String) currencyPanel.options.getSelectedItem();

            // Show/Hide relevant panel based on selected option:
            switch (Objects.requireNonNull(selectedOption)) {
                case "-Select an Option-" -> {

                    panelVisibility(currencyList, labelList, new boolean[] {false, false, false}, new boolean[] {true, false});
                }
                case "Argentine Peso", "Dollar", "Euro" -> {
                    String[] tempOptions = CURRENCY_OPTIONS;
                    List<String> tempOptionsList = new ArrayList<>(Arrays.asList(tempOptions));
                    tempOptionsList.remove(selectedOption);
                    tempOptions = tempOptionsList.toArray(new String[0]);
                    System.out.println(tempOptions);

                    JPanelCreator tempPanel = new JPanelCreator(PANEL_3_POS, tempOptions, false);
                    bgImage.add(tempPanel);
                    LinkedList<JPanelCreator> tempList = new LinkedList<>();
                    tempList.add(tempPanel);
                    panelVisibility(currencyList, labelList, new boolean[] {true, false, false}, new boolean[] {true, true});
                }
            }
        });

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void panelVisibility(LinkedList<JPanelCreator> panel, LinkedList<JLabelCreator> label, boolean[] panelVisibility, boolean[] labelVisibility) {
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
