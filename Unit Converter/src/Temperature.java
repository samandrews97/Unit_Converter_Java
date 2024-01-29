import javax.swing.*;
import java.awt.*;
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

        // Populate original combo box and set initial value
        for (String temp : tempStrings) {

            comboBoxOriginal.addItem(temp);

        }
        comboBoxOriginal.setSelectedIndex(0);

        // Populate converted combo box and set initial value
        for (String temp : tempStrings) {

            comboBoxConverted.addItem(temp);

        }
        comboBoxConverted.setSelectedIndex(0);

        // Make the user unable to edit converted text box
        textFieldConverted.setEditable(false);

        // User input from text box
        final float[] originalValue = {0};

        // When convert button clicked
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get index of original combo box
                int originalUnit = comboBoxOriginal.getSelectedIndex();

                // Get index of converted combo box
                int convertedUnit = comboBoxConverted.getSelectedIndex();

                // Get user input from text box
                String originalValueString = textFieldOriginal.getText();

                // Convert user input to a float
                try {

                    originalValue[0] = Float.parseFloat(originalValueString);

                } catch (NumberFormatException exception) {

                    // Print an error dialog box if the input is not a number
                    JOptionPane.showMessageDialog(null, "Enter a Number", "ERROR!", JOptionPane.ERROR_MESSAGE);

                }

                // Switch block for backend of temperature calculator
                switch (originalUnit) {
                    // When original combo box is celsius
                    case 0 :
                        switch (convertedUnit) {
                            // When conversion combo box is celsius
                            case 0:
                                String celsiusToCelsius = Integer.toString(Math.round(originalValue[0]));
                                textFieldConverted.setText(celsiusToCelsius);
                                break;
                            // When converted combo box is fahrenheit
                            case 1:
                                int celsiusToFahrenheit = Math.round(originalValue[0] * ((float) 9 / 5)) + 32;
                                String celsiusToFahrenheitString = Integer.toString(celsiusToFahrenheit);
                                textFieldConverted.setText(celsiusToFahrenheitString);
                                break;
                            // When converted combo box is kelvin
                            case 2:
                                int celsiusToKelvin = Math.round(originalValue[0] + ((float) 273.15));
                                String celsiusToKelvinString = Integer.toString(celsiusToKelvin);
                                textFieldConverted.setText(celsiusToKelvinString);
                                break;
                        }
                        break;
                    // When original combo box is fahrenheit
                    case 1:
                        switch (convertedUnit) {
                            // When conversion combo box is celsius
                            case 0:
                                int fahrenheitToCelsius = Math.round((originalValue[0] - 32) * ((float) 5 / 9));
                                String fahrenheitToCelsiusString = Integer.toString(fahrenheitToCelsius);
                                textFieldConverted.setText(fahrenheitToCelsiusString);
                                break;
                            // When conversion combo box is fahrenheit
                            case 1:
                                String fahrenheitToFahrenheit = Integer.toString(Math.round(originalValue[0]));
                                textFieldConverted.setText(fahrenheitToFahrenheit);
                                break;
                            // When conversion combo box is kelvin
                            case 2:
                                int fahrenheitToKelvin = Math.round((originalValue[0] - 32) * ((float) 5 / 9) + ((float) 273.15));
                                String fahrenheitToKelvinString = Integer.toString(fahrenheitToKelvin);
                                textFieldConverted.setText(fahrenheitToKelvinString);
                                break;
                        }
                        break;
                    // When original combo box is kelvin
                    case 2:
                        switch (convertedUnit) {
                            // When conversion combo box is celsius
                            case 0:
                                int kelvinToCelsius = Math.round(originalValue[0] - ((float) 273.15));
                                String kelvinToCelsiusString = Integer.toString(kelvinToCelsius);
                                textFieldConverted.setText(kelvinToCelsiusString);
                                break;
                            // When conversion combo box is fahrenheit
                            case 1:
                                int kelvinToFahrenheit = Math.round((originalValue[0] - ((float) 273.15)) * ((float) 9 / 5) + 32);
                                String kelvinToFahrenheitString = Integer.toString(kelvinToFahrenheit);
                                textFieldConverted.setText(kelvinToFahrenheitString);
                                break;
                            // When conversion combo box is kelvin
                            case 2:
                                String kelvinToKelvin = Integer.toString(Math.round(originalValue[0]));
                                textFieldConverted.setText(kelvinToKelvin);
                                break;
                        }
                        break;

                }

            }

      });

    }

}
