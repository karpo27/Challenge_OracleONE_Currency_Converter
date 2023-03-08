// Java Modules:
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class JButtonCreator extends JPanel implements ActionListener {
    private final JTextFieldCreator textField;
    private final HashMap<String, String> currencySymbols = new HashMap<>(){{
        put("Argentine Peso", "ARS");
        put("Dollar", "USD");
        put("Euro", "EUR");
        put("Pounds", "GBP");
        put("Yen", "JPY");
        put("Won", "KRW");
    }};
    private String currency1;
    private String currency2;

    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility, JTextFieldCreator textField) {
        // Set Panel Properties:
        setLayout(null);
        setBounds(dimensions);

        // Set Button Properties:
        JButton button = new JButton();
        button.setBounds(0, 0, dimensions.width, dimensions.height);
        button.setEnabled(true);
        button.setIcon(image);
        button.addActionListener(this);
        this.textField = textField;

        // Add Button to Panel and Set Visibility:
        add(button);
        setVisible(visibility);
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currencySymbols.get(currency1);
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currencySymbols.get(currency2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the text from the TextField:
        String text = textField.getTextField();

        // Attempt to parse the text as a number:
        try {
            double number = Double.parseDouble(text);

            // Set URL request for API Currencies:
            String url_str = "https://api.exchangerate.host/convert?from=" + currency1 + "&to=" + currency2;
            URL url = new URL(url_str);
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

            // Access the "result" field using the get() method:
            double result = jsonObject.get("result").getAsDouble() * number;
            System.out.println(result);

            // Disconnect the request:
            request.disconnect();

            // Show successful conversion message:
            JOptionPane.showMessageDialog(this, "You entered: " + result, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | IOException ex) {
            // Show error message
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Please enter a valid number");
        }
    }
}


