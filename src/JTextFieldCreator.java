// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JTextFieldCreator extends JPanel {
    private JTextField textField;

    public JTextFieldCreator(Rectangle dimensions, boolean visibility){
        setBounds(dimensions);
        setLayout(new BorderLayout());
        setFont(new Font("SansSerif", Font.PLAIN, 12));
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField, BorderLayout.CENTER);
        setVisible(visibility);
    }
    public String getTextField() {
        return textField.getText();
    }
}



