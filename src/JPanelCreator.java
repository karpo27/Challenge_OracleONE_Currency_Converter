// Java Modules:
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class JPanelCreator extends JPanel {

    public JComboBox<String> options;

    public JPanelCreator(Rectangle dimensions, LinkedList<String> options, boolean visibility){
        new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        setBounds(dimensions);
        //setFont();
        //setForeground(Color.RED);
        //setLocation();
        setVisible(visibility);
        gbc.gridy++;

        String[] optionsArray = options.toArray(new String[0]);
        this.options = new JComboBox<>(optionsArray);
        add(this.options, gbc);
    }
}
