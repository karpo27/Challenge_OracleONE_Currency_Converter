// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JButtonCreator extends JPanel {
    final JButton button;

    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility) {
        // Set Panel Properties:
        setLayout(null);
        setBounds(dimensions);

        // Set Button Properties:
        button = new JButton();
        button.setBounds(0, 0, dimensions.width, dimensions.height);
        button.setIcon(image);
        button.setFocusPainted(false);

        // Add Button to Panel and Set Visibility:
        add(button);
        setVisible(visibility);
    }
}
