// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JButtonCreator extends JPanel{
    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility){
        setLayout(null);
        setBounds(dimensions);
        JButton button = new JButton();
        button.setBounds(0, 0, dimensions.width, dimensions.height); // set the size and position of the button
        button.setEnabled(false);
        button.setIcon(image);
        add(button);
        setVisible(visibility);
    }
}

