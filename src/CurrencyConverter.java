// Java Modules:
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CurrencyConverter extends JFrame{
    final int WIDTH = 700;
    final int HEIGHT = 342;
    final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            CurrencyConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            CurrencyConverter.class.getResource("/assets/background_alura.png")));
    final ImageIcon GREEN_TICK = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/greenTick.png")));
    final ImageIcon CLEAN = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/clean.png")));
    final ImageIcon COPY = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/copy.png")));
    final ImageIcon QUESTION_MARK = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/question_mark.png")));
    private final JPanelCreator IN_CURRENCY_PANEL;
    private final JPanelCreator OUT_CURRENCY_PANEL;
    final JTextFieldCreator IN_VALUE_PANEL;
    final JTextFieldCreator OUT_VALUE_PANEL;
    final JLabelCreator FROM_LABEL;
    final JLabelCreator TO_LABEL;
    final JLabelCreator INSERT_NUMBER_LABEL;
    final JLabelCreator RESULT_LABEL;
    final JButtonCreator CONVERT_BUTTON;
    final JButtonCreator CLEAN_BUTTON;
    final JButtonCreator COPY_BUTTON;
    final JButtonCreator QUESTION_MARK_BUTTON;
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
    final Rectangle BUTTON_1_POS = new Rectangle(X + 155, Y + 2 * H, 30, Y - 12);
    final Rectangle BUTTON_2_POS = new Rectangle(X + 195, Y + 2 * H, 30, Y - 12);
    final Rectangle BUTTON_3_POS = new Rectangle(X + 155, Y + 3 * H, 30, Y - 12);
    final Rectangle BUTTON_4_POS = new Rectangle(X + 450, Y - 34, 24, Y - 17);
    private final String[] CURRENCY_OPTIONS = {"-Select an Option-", "Argentina Peso", "Brazil Real", "Chile Peso",
            "Uruguay Peso", "Paraguay Guarani", "Bolivia Boliviano", "Peru Sol", "Colombia Peso", "US Dollar",
            "Venezuela Bolivar", "Mexico Peso", "Euro", "Pounds", "Japan Yen", "Korea Won"};
    private final HashMap<String, String> CURRENCY_SYMBOLS = new HashMap<>() {{
        put("Argentina Peso", "ARS");
        put("Brazil Real", "BRL");
        put("Chile Peso", "CLP");
        put("Uruguay Peso", "UYU");
        put("Paraguay Guarani", "PYG");
        put("Bolivia Boliviano", "BOB");
        put("Peru Sol", "PEN");
        put("Colombia Peso", "COP");
        put("Venezuela Bolivar", "VES");
        put("Mexico Peso", "MXN");
        put("US Dollar", "USD");
        put("Euro", "EUR");
        put("Pounds", "GBP");
        put("Japan Yen", "JPY");
        put("Korea Won", "KRW");
    }};
    private String inCurrency;
    private String outCurrency;

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
        Arrays.sort(CURRENCY_OPTIONS);
        IN_CURRENCY_PANEL = new JPanelCreator(PANEL_1_POS, CURRENCY_OPTIONS, true);
        // Panel 2 - Create OUT_CURRENCY_PANEL:
        OUT_CURRENCY_PANEL = new JPanelCreator(PANEL_2_POS, CURRENCY_OPTIONS, false);
        // Panel 3 - Create In Text Field:
        IN_VALUE_PANEL = new JTextFieldCreator(PANEL_3_POS, false);
        // Panel 4 - Create Out Text Field:
        OUT_VALUE_PANEL = new JTextFieldCreator(PANEL_4_POS, false);

        // Label 1 - Create "From" Label:
        FROM_LABEL = new JLabelCreator(LABEL_1_POS, "From", true, 14);
        // Label 2 - Create "To" Label:
        TO_LABEL = new JLabelCreator(LABEL_2_POS, "To", false, 14);
        // Label 3 - Create "Insert a Number" Label:
        INSERT_NUMBER_LABEL = new JLabelCreator(LABEL_3_POS, "Insert a Number", false, 14);
        // Label 4 - Create "Result" Label:
        RESULT_LABEL = new JLabelCreator(LABEL_4_POS, "Result", false, 14);

        // Button 1 - Create "Convert" Button:
        CONVERT_BUTTON = new JButtonCreator(BUTTON_1_POS, GREEN_TICK,false);
        // Button 2 - Create "Clean" Button:
        CLEAN_BUTTON = new JButtonCreator(BUTTON_2_POS, CLEAN,false);
        // Button 3 - Create "Copy" Button:
        COPY_BUTTON = new JButtonCreator(BUTTON_3_POS, COPY,false);
        // Button 4 - Create "Question Mark" Button:
        QUESTION_MARK_BUTTON = new JButtonCreator(BUTTON_4_POS, QUESTION_MARK,true);

        // Add Category Panels to Background Label:
            // Panel 1 - IN_CURRENCY_PANEL:
        bgImage.add(IN_CURRENCY_PANEL);
            // Panel 2 - OUT_CURRENCY_PANEL:
        bgImage.add(OUT_CURRENCY_PANEL);
            // Panel 3 - In Text Field:
        bgImage.add(IN_VALUE_PANEL);
            // Panel 4 - Out Text Field:
        bgImage.add(OUT_VALUE_PANEL);
        // Add Labels to Background Label:
        bgImage.add(FROM_LABEL);
        bgImage.add(TO_LABEL);
        bgImage.add(INSERT_NUMBER_LABEL);
        bgImage.add(RESULT_LABEL);
        // Add ButtonS to Background Label:
        bgImage.add(CONVERT_BUTTON);
        bgImage.add(CLEAN_BUTTON);
        bgImage.add(COPY_BUTTON);
        bgImage.add(QUESTION_MARK_BUTTON);

        // Create Text Field List for setting text panel visibility:
        LinkedList<JTextFieldCreator> textList = new LinkedList<>();
        textList.add(IN_VALUE_PANEL);
        textList.add(OUT_VALUE_PANEL);

        // Create Label List for setting label panel visibility:
        LinkedList<JLabelCreator> labelList = new LinkedList<>();
        labelList.add(FROM_LABEL);
        labelList.add(TO_LABEL);
        labelList.add(INSERT_NUMBER_LABEL);
        labelList.add(RESULT_LABEL);

        // Create Button List for setting button panel visibility:
        LinkedList<JButtonCreator> buttonList = new LinkedList<>();
        buttonList.add(CONVERT_BUTTON);
        buttonList.add(CLEAN_BUTTON);
        buttonList.add(COPY_BUTTON);

        // Panel 1 - IN_CURRENCY_PANEL JComboBox Actions:
        IN_CURRENCY_PANEL.getOptionsComboBox().addActionListener(e -> {
            String selectedOption = (String) IN_CURRENCY_PANEL.getOptionsComboBox().getSelectedItem();
            if ("-Select an Option-".equals(selectedOption)) {
                OUT_CURRENCY_PANEL.setOptionsComboBox(CURRENCY_OPTIONS, "");
                setVisibility(labelList, new boolean[] {true, false, false, false});
                setVisibility(textList, new boolean[] {false, false});
                setVisibility(buttonList, new boolean[] {false, false, false});
                IN_VALUE_PANEL.setTextField("");
            } else {
                OUT_CURRENCY_PANEL.setOptionsComboBox(CURRENCY_OPTIONS, selectedOption);
                setVisibility(labelList, new boolean[] {true, true, false, false});
                OUT_CURRENCY_PANEL.setVisible(true);
                inCurrency = CURRENCY_SYMBOLS.get(selectedOption);
            }
        });

        // Panel 2 - OUT_CURRENCY_PANEL JComboBox Actions:
        OUT_CURRENCY_PANEL.getOptionsComboBox().addActionListener(e -> {
            String selectedOption = (String) OUT_CURRENCY_PANEL.getOptionsComboBox().getSelectedItem();
            if ("-Select an Option-".equals(selectedOption)) {
                setVisibility(labelList, new boolean[] {true, true, false, false});
                setVisibility(textList, new boolean[] {false, false});
                setVisibility(buttonList, new boolean[] {false, false, false});
                IN_VALUE_PANEL.setTextField("");
            } else {
                setVisibility(labelList, new boolean[] {true, true, true, false});
                setVisibility(textList, new boolean[] {true, false});
                setVisibility(buttonList, new boolean[] {true, true, false});
                IN_VALUE_PANEL.requestFocus();
                outCurrency = CURRENCY_SYMBOLS.get(selectedOption);
            }
        });

        // Convert Button Actions:
        CONVERT_BUTTON.button.addActionListener(e-> {
            // Get the text from the TextField:
            String text = IN_VALUE_PANEL.getTextField();

            // Check if text contains "-" or "+":
            if (text.indexOf('-') == -1 && text.indexOf('+') == -1) {
                // Attempt to parse the text as a number:
                try {
                    double number = Double.parseDouble(text);

                    // Set URL request for API Currencies:
                    String urlString = "https://api.exchangerate.host/convert?from=" + inCurrency + "&to=" + outCurrency;
                    URL url = new URL(urlString);
                    HttpURLConnection request = (HttpURLConnection) url.openConnection();
                    request.connect();

                    // Read the JSON response from the input stream
                    InputStreamReader isr = new InputStreamReader(request.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    String jsonString = sb.toString();

                    // Create a Gson object:
                    Gson gson = new Gson();

                    // Parse the JSON string into a JsonObject:
                    JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

                    // Access the "result" field using the get() method and round the result:
                    double result = jsonObject.get("result").getAsDouble() * number;
                    double roundedResult = Math.round(result * 100.0) / 100.0;
                    String stringResult = outCurrency + " " + roundedResult;

                    // Disconnect the request:
                    request.disconnect();

                    // Show successful conversion:
                    OUT_VALUE_PANEL.setTextField(stringResult);
                    OUT_VALUE_PANEL.setVisible(true);
                    RESULT_LABEL.setVisible(true);
                    COPY_BUTTON.setVisible(true);

                } catch (NumberFormatException | IOException ex) {
                    // Show error message
                    JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Show error message
                JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Clean Button Actions:
        CLEAN_BUTTON.button.addActionListener(e-> {
            IN_VALUE_PANEL.setTextField("");
            OUT_VALUE_PANEL.setVisible(false);
            RESULT_LABEL.setVisible(false);
            IN_VALUE_PANEL.requestFocus();
            COPY_BUTTON.setVisible(false);
        });

        // Copy Button Actions:
        COPY_BUTTON.button.addActionListener(e-> {
            StringSelection textToCopy = new StringSelection(OUT_VALUE_PANEL.getTextField());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(textToCopy, null);
        });

        // Question Mark Button Actions:
        QUESTION_MARK_BUTTON.button.addActionListener(e-> {
            String message = "Currency Converter is a Java application developed by me, Julian Giudice (github.com/karpo27) for the Java Challenge Oracle ONE. \n"
                    + "The application allows users to convert between different currencies using the latest exchange rates obtained from a free API. \n"
                    + "It has a user-friendly graphical interface developed using Swing, where users can select the input and output currency, enter \n"
                    + "the value to convert, and obtain the converted value. Additionally, the application supports a wide range of currencies, making \n"
                    + "it useful for people who need to convert currencies frequently.";
            // Show message
            JOptionPane.showMessageDialog(this, message, "About", JOptionPane.INFORMATION_MESSAGE);
        });

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void setVisibility(LinkedList<? extends Component> label, boolean[] labelVisibility) {
        for (int i = 0; i < label.size(); i++){
            label.get(i).setVisible(labelVisibility[i]);
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
