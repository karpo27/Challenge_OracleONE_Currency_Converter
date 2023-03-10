// Java Modules:
import javax.swing.*;
import java.awt.*;

public class JPanelCreator extends JPanel {
    private final JComboBox<String> optionsComboBox;

    public JPanelCreator(Rectangle dimensions, String[] options, boolean visibility){
        // Set Panel Properties:
        new JPanel(new GridBagLayout());
        setBounds(dimensions);
        setVisible(visibility);

        // Define JComboBox:
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>(options);
        this.optionsComboBox = new JComboBox<>(comboModel);
        this.optionsComboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Add ComboBox to Panel:
        add(this.optionsComboBox);
    }

    public JComboBox<String> getOptionsComboBox() {
        return this.optionsComboBox;
    }

    public void setOptionsComboBox(String[] options, String selectedOption) {
        this.optionsComboBox.removeAllItems();

        for (String option : options){
            this.optionsComboBox.addItem(option);
        }

        if (selectedOption != null && !selectedOption.isEmpty()) {
            this.optionsComboBox.removeItem(selectedOption);
        } else {
            setVisible(false);
        }
    }
}
