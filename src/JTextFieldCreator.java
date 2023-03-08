// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JTextFieldCreator extends JPanel {
    private final JTextField textField;

    public JTextFieldCreator(Rectangle dimensions, boolean visibility){
        // Set Panel Properties:
        setBounds(dimensions);
        setLayout(new BorderLayout());

        // Set TextField Properties:
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // Add TextField to Panel and Set Visibility:
        add(textField, BorderLayout.CENTER);
        setVisible(visibility);
    }

    public String getTextField() {
        return textField.getText();
    }

    public void setTextField(String text) {
        textField.setText(text);
    }
}



