// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JPanelCreator extends JPanel {

    public JComboBox<String> options;

    public JPanelCreator(Rectangle dimensions, String[] options, boolean visibility){
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

        this.options = new JComboBox<String>(options);
        add(this.options, gbc);
    }
}
