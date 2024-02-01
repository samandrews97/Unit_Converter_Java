import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistanceHeight extends JFrame {
    private JPanel panelDistanceHeight;
    private JTextField textFieldConverted;
    private JTextField textFieldOriginal;
    private JComboBox comboBoxOriginal;
    private JComboBox comboBoxConverted;
    private JLabel labelConverted;
    private JLabel labelOriginal;
    private JButton btnConvert;
    private JButton btnDistanceHeightToMain;

    public DistanceHeight() {

        // Set distance/height frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelDistanceHeight);
        setTitle("Distance/Height");

        btnDistanceHeightToMain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Menu.main(null);    // Create a new Main menu frame

                dispose();

            }
        });

        // List of distance/height units for the combo boxes
        String[] distanceHeightStrings = {"Centimetre", "Metre", "Kilometre", "Inch", "Feet", "Yard", "Mile"};

        // Populate original combo box and set initial value
        for (String distanceHeight : distanceHeightStrings) {

            comboBoxOriginal.addItem(distanceHeight);

        }
        comboBoxOriginal.setSelectedIndex(0);

        // Populate converted combo box and set initial value
        for (String distanceHeight : distanceHeightStrings) {

            comboBoxConverted.addItem(distanceHeight);

        }
        comboBoxConverted.setSelectedIndex(0);

        // Make the user unable to edit the converted text box
        textFieldConverted.setEditable(false);

        // User inout from text box
        final float[] originalValue = {0};

        // When converted button clicked
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

                // Switch block for backend of distance/height calculator
                switch (originalUnit) {
                    // When original combo box is centimetre
                    case 0:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String cmToCm = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(cmToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String cmToM = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.01))));
                                textFieldConverted.setText(cmToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String cmToKm = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.00001))));
                                textFieldConverted.setText(cmToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String cmToInch = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.3937008))));
                                textFieldConverted.setText(cmToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String cmToFeet = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.0328084))));
                                textFieldConverted.setText(cmToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String cmToYard = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.01093613))));
                                textFieldConverted.setText(cmToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String cmToMile = Float.toString(Float.parseFloat(String.format("%.8f", (originalValue[0] * 0.0000062137))));
                                textFieldConverted.setText(cmToMile);
                                break;

                        }
                        break;
                    // When original combo box is metre
                    case 1:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String mToCm = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 100))));
                                textFieldConverted.setText(mToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String mToM = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(mToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String mToKm = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(mToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String mToInch = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 39.37008))));
                                textFieldConverted.setText(mToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String mToFeet = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 3.28084))));
                                textFieldConverted.setText(mToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String mToYard = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 1.093613))));
                                textFieldConverted.setText(mToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String mToMile = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.0006213712))));
                                textFieldConverted.setText(mToMile);
                                break;

                        }
                        break;
                    // When original combo box is kilometre
                    case 2:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String kmToCm = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 100000))));
                                textFieldConverted.setText(kmToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String kmToM = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000))));
                                textFieldConverted.setText(kmToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String kmToKm = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(kmToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String kmToInch = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 39370.08))));
                                textFieldConverted.setText(kmToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String kmToFeet = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 3280.84))));
                                textFieldConverted.setText(kmToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String kmToYard = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 1093.613))));
                                textFieldConverted.setText(kmToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String kmToMile = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.6213712))));
                                textFieldConverted.setText(kmToMile);
                                break;

                        }
                        break;
                    // When original text box is inch
                    case 3:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String inchToCm = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2.54))));
                                textFieldConverted.setText(inchToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String inchToM = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.0254))));
                                textFieldConverted.setText(inchToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String inchToKm = Float.toString(Float.parseFloat(String.format("%.7f", (originalValue[0] * 0.0000254))));
                                textFieldConverted.setText(inchToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String inchToInch = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(inchToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String inchToFeet = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.08333333))));
                                textFieldConverted.setText(inchToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String inchToYard = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.02777778))));
                                textFieldConverted.setText(inchToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String inchToMile = Float.toString(Float.parseFloat(String.format("%.7f", (originalValue[0] * 0.0000157828))));
                                textFieldConverted.setText(inchToMile);
                                break;

                        }
                        break;
                    // When original combo box is feet
                    case 4:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String feetToCm = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 30.48))));
                                textFieldConverted.setText(feetToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String feetToM = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.3048))));
                                textFieldConverted.setText(feetToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String feetToKm = Float.toString(Float.parseFloat(String.format("%.7f", (originalValue[0] * 0.0003048))));
                                textFieldConverted.setText(feetToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String feetToInch = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 12))));
                                textFieldConverted.setText(feetToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String feetToFeet = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(feetToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String feetToYard = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.3333333))));
                                textFieldConverted.setText(feetToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String feetToMile = Float.toString(Float.parseFloat(String.format("%.5f", (originalValue[0] * 0.0001893939))));
                                textFieldConverted.setText(feetToMile);
                                break;
                        }
                        break;
                    // When original combo box is yard
                    case 5:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String yardToCm = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 91.44))));
                                textFieldConverted.setText(yardToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String yardToM = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.9144))));
                                textFieldConverted.setText(yardToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String yardToKm = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.0009144))));
                                textFieldConverted.setText(yardToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String yardToInch = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 36))));
                                textFieldConverted.setText(yardToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String yardToFeet = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 3))));
                                textFieldConverted.setText(yardToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String yardToYard = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(yardToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String yardToMile = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.0005681818))));
                                textFieldConverted.setText(yardToMile);
                                break;

                        }
                        break;
                    // When original combo box is mile
                    case 6:
                        switch (convertedUnit) {
                            // When conversion combo box is centimetre
                            case 0:
                                String mileToCm = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 160934.4))));
                                textFieldConverted.setText(mileToCm);
                                break;
                            // When conversion combo box is metre
                            case 1:
                                String mileToM = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 1609.344))));
                                textFieldConverted.setText(mileToM);
                                break;
                            // When conversion combo box is kilometre
                            case 2:
                                String mToKm = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 1.609344))));
                                textFieldConverted.setText(mToKm);
                                break;
                            // When conversion combo box is inch
                            case 3:
                                String mToInch = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 63360))));
                                textFieldConverted.setText(mToInch);
                                break;
                            // When conversion combo box is feet
                            case 4:
                                String mToFeet = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 5280))));
                                textFieldConverted.setText(mToFeet);
                                break;
                            // When conversion combo box is yard
                            case 5:
                                String mToYard = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1760))));
                                textFieldConverted.setText(mToYard);
                                break;
                            // When conversion combo box is mile
                            case 6:
                                String mileToMile = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                        }
                        break;
                }
            }
        });
    }
}
