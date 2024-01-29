import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Weight extends JFrame {
    private JPanel panelWeight;
    private JButton btnConvert;
    private JComboBox comboBoxOriginal;
    private JComboBox comboBoxConverted;
    private JTextField textFieldOriginal;
    private JTextField textFieldConverted;
    private JLabel labelOriginal;
    private JLabel labelConverted;
    private JButton btnWeightToMain;

    public Weight() {

        // Set weight frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelWeight);
        setTitle("Weight");

        btnWeightToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Menu.main(null);    // Create a new Main menu frame

                dispose();

            }
        });

        // List of weight units for the combo boxes
        String[] weightStrings = {"Gram", "Kilogram", "Milligram", "Metric ton", "Ton", "Ounce", "Pound", "Stone"};

        // Populate original combo box and set initial value
        for (String weight : weightStrings) {

            comboBoxOriginal.addItem(weight);

        }
        comboBoxOriginal.setSelectedIndex(0);

        // Populate converted combo box and set initial value
        for (String weight: weightStrings) {

            comboBoxConverted.addItem(weight);

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

                // Switch block for backend of weight calculator
                switch (originalUnit) {
                    // When original combo box is gram
                    case 0:
                        switch (convertedUnit) {
                            // When conversion combo box is gram
                            case 0:
                                String gramToGram = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(gramToGram);
                                break;
                            // When conversion combo box is kilogram
                            case 1:
                                String gramToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(gramToKg);
                                break;
                            // When conversion combo box is milligram
                            case 2:
                                String gramToMg = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0] * 1000)));
                                textFieldConverted.setText(gramToMg);
                                break;
                            // When conversion combo box is metric ton
                            case 3:
                                String gramToMt = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.000001))));
                                textFieldConverted.setText(gramToMt);
                                break;
                            // When conversion combo box is ton
                            case 4:
                                String gramToTon = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.0000011023))));
                                textFieldConverted.setText(gramToTon);
                                break;
                            // When conversion combo box is ounce
                            case 5:
                                String gramToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.03527396))));
                                textFieldConverted.setText(gramToOunce);
                                break;
                            // When conversion combo box is pound
                            case 6:
                                String gramToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.002204623))));
                                textFieldConverted.setText(gramToPound);
                                break;
                            // When conversion combo box is stone
                            case 7:
                                String gramToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.000157473))));
                                textFieldConverted.setText(gramToStone);
                                break;


                        }
                        break;

                    // When original combo box is kilograms
                    case 1:
                        switch (convertedUnit) {
                            // When conversion combo box is grams
                            case 0:
                                String kgToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000))));
                                textFieldConverted.setText(kgToGram);
                                break;
                            // When conversion combo box is kilograms
                            case 1:
                                String kgToKg = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(kgToKg);
                                break;
                            // When conversion combo box is milligrams
                            case 2:
                                String kgToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000000))));
                                textFieldConverted.setText(kgToMg);
                                break;
                            // When conversion combo box is metric ton
                            case 3:
                                String kgToMt = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(kgToMt);
                                break;
                            // When conversion combo box is ton
                            case 4:
                                String kgToTon = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.001102311))));
                                textFieldConverted.setText(kgToTon);
                                break;
                            // When conversion combo box is ounce
                            case 5:
                                String kgToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 35.27396))));
                                textFieldConverted.setText(kgToOunce);
                                break;
                            // When conversion combo box is pound
                            case 6:
                                String kgToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2.204623))));
                                textFieldConverted.setText(kgToPound);
                                break;
                            // When conversion combo box is stone
                            case 7:
                                String kgToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.157473))));
                                textFieldConverted.setText(kgToStone);
                                break;

                        }
                        break;
                    // When original combo box is milligram
                    case 2:
                        switch (convertedUnit) {
                            // When conversion combo box is gram
                            case 0:
                                String mgToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(mgToGram);
                                break;
                            // When conversion combo box is kilogram
                            case 1:
                                String mgToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.000001))));
                                textFieldConverted.setText(mgToKg);
                                break;
                            // When conversion combo box is milligram
                            case 2:
                                String mgToMg = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(mgToMg);
                                break;
                            // When conversion combo box is metric ton
                            case 3:
                                String mgToMt = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.000000001))));
                                textFieldConverted.setText(mgToMt);
                                break;
                            // When conversion combo box is ton
                            case 4:
                                String mgToTon = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.00000000102311))));
                                textFieldConverted.setText(mgToTon);
                                break;
                            // When conversion combo box is ounce
                            case 5:
                                String mgToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.000035274))));
                                textFieldConverted.setText(mgToOunce);
                                break;
                            // When conversion combo box is pound
                            case 6:
                                String mgToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.0000022046))));
                                textFieldConverted.setText(mgToPound);
                                break;
                            // When conversion combo box is stone
                            case 7:
                                String mgToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.0000001577))));
                                textFieldConverted.setText(mgToStone);
                                break;

                        }
                        break;

                    // When original combo box is metric ton
                    case 3:
                        switch (convertedUnit) {
                            // When conversion combo box is gram
                            case 0:
                                String mtToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000000))));
                                textFieldConverted.setText(mtToGram);
                                break;
                            // When conversion combo box is kilogram
                            case 1:
                                String mtToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000))));
                                textFieldConverted.setText(mtToKg);
                                break;
                            // When conversion combo box is milligram
                            case 2:
                                String mtToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000000000))));
                                textFieldConverted.setText(mtToMg);
                                break;
                            // When conversion combo box is metric ton
                            case 3:
                                String mtToMt = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(mtToMt);
                                break;
                            // When conversion box is ton
                            case 4:
                                String mtToTon = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1.102311))));
                                textFieldConverted.setText(mtToTon);
                                break;
                            // When conversion box is ounce
                            case 5:
                                String mtToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 35273.96))));
                                textFieldConverted.setText(mtToOunce);
                                break;
                            // When conversion box is pound
                            case 6:
                                String mtToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2204.623))));
                                textFieldConverted.setText(mtToPound);
                                break;
                            // When conversion box is stone
                            case 7:
                                String mtToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 157.473))));
                                textFieldConverted.setText(mtToStone);
                                break;

                        }
                        break;
                }
            }
        });
    }
}
