// Java Modules:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonCreator extends JPanel implements ActionListener {
    private final JTextFieldCreator textField;

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

        // Add Button to Panel and Set Visibility:
        add(button);
        setVisible(visibility);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the text from the TextField:
        String text = textField.getTextField();

        // Attempt to parse the text as a number:
        try {
            double number = Double.parseDouble(text);
            System.out.println("You entered: " + number);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Please enter a valid number");
        }

    }
}

