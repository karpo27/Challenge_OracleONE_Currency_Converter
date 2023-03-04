// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JLabelCreator extends JLabel{
    public JLabelCreator(Rectangle dimensions, String text, boolean visibility) {
        new JLabel();
        setText(text);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        setBounds(dimensions);
        setVisible(visibility);
    }
}
