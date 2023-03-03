// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JPanelCreator extends JPanel {

    public JComboBox<String> options;

    public JPanelCreator(Rectangle dimensions, String[] options){
        new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        setBounds(dimensions);
        //setFont();
        //setForeground(Color.RED);
        //setLocation();
        gbc.gridy++;

        this.options = new JComboBox<String>(options);
        add(this.options, gbc);
    }
}
