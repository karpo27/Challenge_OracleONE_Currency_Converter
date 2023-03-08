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
        setFont(new Font("SansSerif", Font.PLAIN, 12));
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add TextField to Panel and Set Visibility:
        add(textField, BorderLayout.CENTER);
        setVisible(visibility);
    }

    public String getTextField() {
        return textField.getText();
    }
}



