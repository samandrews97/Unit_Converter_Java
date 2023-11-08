import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature extends JFrame {
    private JButton btnTempToMain;
    private JPanel panelTemperature;
    private JTextField textFieldOriginal;
    private JTextField textFieldConverted;
    private JButton btnConvert;
    private JComboBox comboBoxOriginal;
    private JComboBox comboBoxConverted;
    private JLabel labelToConvert;
    private JLabel labelConverted;


    public Temperature() {

        // Set temperature frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelTemperature);
        setTitle("Temperature");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Open main menu when button clicked
        btnTempToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.main(null); // Create a new Main menu frame

                dispose(); // Close the temperature frame.
            }
        });

        // List of temperature units for the combo boxes
        String[] tempStrings = {"Celsius", "Fahrenheit", "Kelvin"};

        // Original temperature combobox
        for (String temp : tempStrings) {

            comboBoxOriginal.addItem(temp);

        }
        comboBoxOriginal.setSelectedIndex(0);

        // Converted combobox

        for (String temp : tempStrings) {

            comboBoxConverted.addItem(temp);

        }
        comboBoxConverted.setSelectedIndex(0);

    }
}
