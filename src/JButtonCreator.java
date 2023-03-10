// Java Modules:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JButtonCreator extends JPanel implements ActionListener {
    private final JTextFieldCreator inValue;
    private final JTextFieldCreator outValue;
    private final JLabelCreator result;
    private final HashMap<String, String> CURRENCY_SYMBOLS = new HashMap<>(){{
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

    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility, JTextFieldCreator inValue, JTextFieldCreator outValue, JLabelCreator result) {
        // Set Panel Properties:
        setLayout(null);
        setBounds(dimensions);

        // Set Button Properties:
        JButton button = new JButton();
        button.setBounds(0, 0, dimensions.width, dimensions.height);
        button.setIcon(image);
        button.addActionListener(this);
        button.setFocusPainted(false);

        // Additional variables to control with Button:
        this.inValue = inValue;
        this.outValue = outValue;
        this.result = result;

        // Add Button to Panel and Set Visibility:
        add(button);
        setVisible(visibility);
    }

    public void setInCurrency(String inCurrency) {
        this.inCurrency = CURRENCY_SYMBOLS.get(inCurrency);
    }

    public void setOutCurrency(String outCurrency) {
        this.outCurrency = CURRENCY_SYMBOLS.get(outCurrency);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the text from the TextField:
        String text = this.inValue.getTextField();

        // Attempt to parse the text as a number:
        try {
            double number = Double.parseDouble(text);

            // Set URL request for API Currencies:
            String urlString = "https://api.exchangerate.host/convert?from=" + this.inCurrency + "&to=" + this.outCurrency;
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
            String stringResult = this.outCurrency + " " + roundedResult;

            // Disconnect the request:
            request.disconnect();

            // Show successful conversion message:
            this.outValue.setTextField(stringResult);
            this.outValue.setVisible(true);
            this.result.setVisible(true);

        } catch (NumberFormatException | IOException ex) {
            // Show error message
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


