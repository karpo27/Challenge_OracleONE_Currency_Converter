// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JButtonCreator extends JPanel{
    //Image greenTick = new ImageIcon(Toolkit.getDefaultToolkit().getImage(JButtonCreator.class.getResource("/assets/logo16.png"))).getImage();

    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility){
        setLayout(null);
        setBounds(dimensions);
        //setOpaque(false);
        JButton button = new JButton();
        button.setBounds(0, 0, dimensions.width, dimensions.height); // set the size and position of the button
        button.setIcon(image);
        add(button);
        setVisible(visibility);
    }

}

