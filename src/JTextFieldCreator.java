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
        this.textField = new JTextField();
        this.textField.setHorizontalAlignment(SwingConstants.RIGHT);
        this.textField.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // Add TextField to Panel and Set Visibility:
        add(this.textField, BorderLayout.CENTER);
        setVisible(visibility);
    }

    public String getTextField() {
        return this.textField.getText();
    }

    public void setTextField(String text) {
        this.textField.setText(text);
    }

    public void requestFocus(){
        this.textField.requestFocus();
    }
}



