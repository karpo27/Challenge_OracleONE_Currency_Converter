// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JLabelCreator extends JLabel{
    public JLabelCreator(Rectangle dimensions, String text, boolean visibility, int textSize) {
        // Set Label Properties:
        new JLabel();
        setText(text);
        setFont(new Font("SansSerif", Font.BOLD, textSize));
        setForeground(Color.BLACK);
        setBounds(dimensions);
        setVisible(visibility);
    }
}
