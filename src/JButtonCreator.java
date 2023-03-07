// Java Modules:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonCreator extends JPanel implements ActionListener {
    private JTextFieldCreator textField;

    public JButtonCreator(Rectangle dimensions, Icon image, boolean visibility, JTextFieldCreator textField){
        // Set Panel Properties:
        setLayout(null);
        setBounds(dimensions);

        // Set Button Properties:
        JButton button = new JButton();
        button.setBounds(0, 0, dimensions.width, dimensions.height);
        button.setEnabled(true);
        button.setIcon(image);
        button.addActionListener(this);

        this.textField = textField;
        button.addActionListener(this);

        // Add Button to Panel and Set Visibility:
        add(button);
        setVisible(visibility);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the text from the text field
        String text = textField.getTextField();

        // do something with the text...
        System.out.println("You entered: " + text);
    }
}

