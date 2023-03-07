// Java Modules:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonCreator extends JPanel implements ActionListener {
    JButton button = new JButton();

    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility){
        // Set Panel Properties:
        setLayout(null);
        setBounds(dimensions);

        // Set Button Properties:
        button.setBounds(0, 0, dimensions.width, dimensions.height);
        button.setEnabled(false);
        button.setIcon(image);
        button.addActionListener(this);

        // Add Button to Panel and Set Visibility:
        add(button);
        setVisible(visibility);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

