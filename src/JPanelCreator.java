// Java Modules:
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class JPanelCreator extends JPanel {

    public JComboBox<String> options;

    public JPanelCreator(Rectangle dimensions, LinkedList<String> options, boolean visibility){
        // Set Panel Properties:
        new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        setBounds(dimensions);
        setVisible(visibility);
        gbc.gridy++;

        // Define JComboBox:
        String[] optionsArray = options.toArray(new String[0]);
        this.options = new JComboBox<>(optionsArray);
        this.options.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Add ComboBox to Panel:
        add(this.options, gbc);
    }
}
