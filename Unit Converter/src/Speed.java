import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Speed extends JFrame {
    private JPanel panelSpeed;
    private JTextField textFieldOriginal;
    private JButton btnConvert;
    private JTextField textFieldConverted;
    private JComboBox comboBoxOriginal;
    private JComboBox comboBoxConverted;
    private JLabel labelConverted;
    private JLabel labelToConvert;
    private JButton btnSpeedToMain;

    public Speed() {

        // Set speed frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelSpeed);
        setTitle("Speed");

        btnSpeedToMain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Menu.main(null);    // Create a new Main menu frame

                dispose();  // Close the time frame

            }
        });

        // List of time units for the combo boxes
        String[] speedStrings = {"Kilometers per hour", "Miles per hour", "Metres per second", "Knots"};

        // Populate original combo box and set initial value
        for (String speed : speedStrings) {

            comboBoxOriginal.addItem(speed);

        }
        comboBoxOriginal.setSelectedIndex(0);

        // Populate converted combo box and set initial value
        for (String speed : speedStrings) {

            comboBoxConverted.addItem(speed);

        }
        comboBoxConverted.setSelectedIndex(0);

        // Make the user unable to edit the converted text box
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

                // Switch block for backend of time calculator
                switch (originalUnit) {
                    // When original combo box is kilometers per hour
                    case 0:
                        switch (convertedUnit) {
                            // When conversion combo box is kilometers per hour
                            case 0:
                                String kphToKph = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(kphToKph);
                                break;
                            // When conversion box is miles per hour
                            case 1:
                                String kphToMph = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.6213712))));
                                textFieldConverted.setText(kphToMph);
                                break;
                            // When conversion box is meters per second
                            case 2:
                                String kphToMs = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.2777778))));
                                textFieldConverted.setText(kphToMs);
                                break;
                            // When conversion box is knots
                            case 3:
                                String kphToKnots = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.5399565))));
                                textFieldConverted.setText(kphToKnots);
                                break;
                        }
                        break;
                    // When original combo box is miles per hour
                    case 1:
                        switch (convertedUnit) {
                            // When conversion combo box is kilometers per hour
                            case 0:
                                String mphToKph = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1.609344))));
                                textFieldConverted.setText(mphToKph);
                                break;
                            // When conversion combo box is miles per hour
                            case 1:
                                String mphToMph = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(mphToMph);
                                break;
                            // When conversion box is meters per second
                            case 2:
                                String mphToMs = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.44704))));
                                textFieldConverted.setText(mphToMs);
                                break;
                            // When conversion box is knots
                            case 3:
                                String mphToKnots = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.8689758))));
                                textFieldConverted.setText(mphToKnots);
                                break;

                        }
                        break;
                // When original combo box is meters per second
                    case 2:
                        switch (convertedUnit) {
                            // When converted combo box is kilometers per hour
                            case 0:
                                String msToKph = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 3.6))));
                                textFieldConverted.setText(msToKph);
                                break;
                            // When converted box is miles per hour
                            case 1:
                                String msToMph = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2.236936))));
                                textFieldConverted.setText(msToMph);
                                break;
                            // When converted box is meters per second
                            case 2:
                                String msToMs = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(msToMs);
                                break;
                            // When converted box is knots
                            case 3:
                                String msToKnots = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1.943844))));
                                textFieldConverted.setText(msToKnots);
                                break;

                        }
                        break;
                    // When original combo box is knots
                    case 3:
                        switch (convertedUnit) {
                            // When converted combo box is kilometers per hour
                            case 0:
                                String knotsToKph = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1.852001))));
                                textFieldConverted.setText(knotsToKph);
                                break;
                            // When converted combo box is miles per hour
                            case 1:
                                String knotsToMph = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1.15078))));
                                textFieldConverted.setText(knotsToMph);
                                break;
                            // When converted combo box is meters per second
                            case 2:
                                String knotsToMs = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0]) * 0.5144447)));
                                textFieldConverted.setText(knotsToMs);
                                break;
                            // When converted combo box is knots
                            case 3:
                                String knotsToKnots = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(knotsToKnots);
                                break;
                        }
                        break;
                }
            }
        });
    }
}
