import javax.swing.*;
import java.awt.*;

public class JPanelCreator extends JPanel {

    public JPanelCreator(int x, int y, int width, int height, String[] options){
        new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        setBounds(x, y, width, height);

        gbc.gridy++;
        JComboBox<String> categoryOptions = new JComboBox<String>(options);
        add(categoryOptions, gbc);
    }
}
