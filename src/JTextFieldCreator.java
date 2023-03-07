// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JTextFieldCreator extends JPanel {
    public JTextFieldCreator(Rectangle dimensions, boolean visibility){
        setBounds(dimensions);
        setLayout(new BorderLayout());
        setFont(new Font("SansSerif", Font.PLAIN, 12));
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField, BorderLayout.CENTER);
        setVisible(visibility);
    }
}



