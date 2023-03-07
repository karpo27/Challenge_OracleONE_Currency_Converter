// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JButtonCreator extends JPanel{
    public JButtonCreator(Rectangle dimensions, boolean visibility){
        JButton button = new JButton();
        setBounds(dimensions);
        add(button, BorderLayout.CENTER);
        setVisible(true);
    }

}

