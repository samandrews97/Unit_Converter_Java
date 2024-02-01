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
                            // When converted combo box is gram
                            case 0:
                                String gramToGram = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(gramToGram);
                                break;
                            // When converted combo box is kilogram
                            case 1:
                                String gramToKg = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(gramToKg);
                                break;
                            // When converted combo box is milligram
                            case 2:
                                String gramToMg = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0] * 1000)));
                                textFieldConverted.setText(gramToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String gramToMt = Float.toString(Float.parseFloat(String.format("%.7f", (originalValue[0] * 0.000001))));
                                textFieldConverted.setText(gramToMt);
                                break;
                            // When converted combo box is ton
                            case 4:
                                String gramToTon = Float.toString(Float.parseFloat(String.format("%.8f", (originalValue[0] * 0.0000011023))));
                                textFieldConverted.setText(gramToTon);
                                break;
                            // When converted combo box is ounce
                            case 5:
                                String gramToOunce = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.03527396))));
                                textFieldConverted.setText(gramToOunce);
                                break;
                            // When converted combo box is pound
                            case 6:
                                String gramToPound = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.002204623))));
                                textFieldConverted.setText(gramToPound);
                                break;
                            // When converted combo box is stone
                            case 7:
                                String gramToStone = Float.toString(Float.parseFloat(String.format("%.5f", (originalValue[0] * 0.000157473))));
                                textFieldConverted.setText(gramToStone);
                                break;


                        }
                        break;

                    // When original combo box is kilograms
                    case 1:
                        switch (convertedUnit) {
                            // When converted combo box is grams
                            case 0:
                                String kgToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000))));
                                textFieldConverted.setText(kgToGram);
                                break;
                            // When converted combo box is kilograms
                            case 1:
                                String kgToKg = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(kgToKg);
                                break;
                            // When converted combo box is milligrams
                            case 2:
                                String kgToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000000))));
                                textFieldConverted.setText(kgToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String kgToMt = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(kgToMt);
                                break;
                            // When converted combo box is ton
                            case 4:
                                String kgToTon = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.001102311))));
                                textFieldConverted.setText(kgToTon);
                                break;
                            // When converted combo box is ounce
                            case 5:
                                String kgToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 35.27396))));
                                textFieldConverted.setText(kgToOunce);
                                break;
                            // When converted combo box is pound
                            case 6:
                                String kgToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2.204623))));
                                textFieldConverted.setText(kgToPound);
                                break;
                            // When converted combo box is stone
                            case 7:
                                String kgToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.157473))));
                                textFieldConverted.setText(kgToStone);
                                break;

                        }
                        break;
                    // When original combo box is milligram
                    case 2:
                        switch (convertedUnit) {
                            // When converted combo box is gram
                            case 0:
                                String mgToGram = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.001))));
                                textFieldConverted.setText(mgToGram);
                                break;
                            // When converted combo box is kilogram
                            case 1:
                                String mgToKg = Float.toString(Float.parseFloat(String.format("%.8f", (originalValue[0] * 0.000001))));
                                textFieldConverted.setText(mgToKg);
                                break;
                            // When converted combo box is milligram
                            case 2:
                                String mgToMg = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(mgToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String mgToMt = Float.toString(Float.parseFloat(String.format("%.10f", (originalValue[0] * 0.000000001))));
                                textFieldConverted.setText(mgToMt);
                                break;
                            // When converted combo box is ton
                            case 4:
                                String mgToTon = Float.toString(Float.parseFloat(String.format("%.11f", (originalValue[0] * 0.00000000102311))));
                                textFieldConverted.setText(mgToTon);
                                break;
                            // When converted combo box is ounce
                            case 5:
                                String mgToOunce = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.000035274))));
                                textFieldConverted.setText(mgToOunce);
                                break;
                            // When converted combo box is pound
                            case 6:
                                String mgToPound = Float.toString(Float.parseFloat(String.format("%.7f", (originalValue[0] * 0.0000022046))));
                                textFieldConverted.setText(mgToPound);
                                break;
                            // When converted combo box is stone
                            case 7:
                                String mgToStone = Float.toString(Float.parseFloat(String.format("%.8f", (originalValue[0] * 0.0000001577))));
                                textFieldConverted.setText(mgToStone);
                                break;

                        }
                        break;

                    // When original combo box is metric ton
                    case 3:
                        switch (convertedUnit) {
                            // When converted combo box is gram
                            case 0:
                                String mtToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000000))));
                                textFieldConverted.setText(mtToGram);
                                break;
                            // When converted combo box is kilogram
                            case 1:
                                String mtToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000))));
                                textFieldConverted.setText(mtToKg);
                                break;
                            // When converted combo box is milligram
                            case 2:
                                String mtToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 1000000000))));
                                textFieldConverted.setText(mtToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String mtToMt = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(mtToMt);
                                break;
                            // When converted box is ton
                            case 4:
                                String mtToTon = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 1.102311))));
                                textFieldConverted.setText(mtToTon);
                                break;
                            // When converted box is ounce
                            case 5:
                                String mtToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 35273.96))));
                                textFieldConverted.setText(mtToOunce);
                                break;
                            // When converted box is pound
                            case 6:
                                String mtToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2204.623))));
                                textFieldConverted.setText(mtToPound);
                                break;
                            // When converted box is stone
                            case 7:
                                String mtToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 157.473))));
                                textFieldConverted.setText(mtToStone);
                                break;

                        }
                        break;
                    // When original combo box is ton
                    case 4:
                        switch (convertedUnit) {
                            // When converted box is gram
                            case 0:
                                String tonToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 907184.7))));
                                textFieldConverted.setText(tonToGram);
                                break;
                            // When converted box is kilogram
                            case 1:
                                String tonToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 907.1847))));
                                textFieldConverted.setText(tonToKg);
                                break;
                            // When converted box is milligram
                            case 2:
                                String tonToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 907184700))));
                                textFieldConverted.setText(tonToMg);
                                break;
                            // When converted box is metric ton
                            case 3:
                                String tonToMt = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.9071847))));
                                textFieldConverted.setText(tonToMt);
                                break;
                            // When converted box is ton
                            case 4:
                                String tonToTon = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(tonToTon);
                                break;
                            // When converted box is ounce
                            case 5:
                                String tonToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 32000))));
                                textFieldConverted.setText(tonToOunce);
                                break;
                            // When converted box is pound
                            case 6:
                                String tonToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 2000))));
                                textFieldConverted.setText(tonToPound);
                                break;
                            // When converted box is stone
                            case 7:
                                String tonToStone = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 142.8571))));
                                textFieldConverted.setText(tonToStone);
                                break;

                        }
                        break;
                    // When original combo box is ounce
                    case 5:
                        switch (convertedUnit) {
                            // When converted combo box is gram
                            case 0:
                                String ounceToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 28.34952))));
                                textFieldConverted.setText(ounceToGram);
                                break;
                            // When converted combo box is kilogram
                            case 1:
                                String ounceToKg = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.02834952))));
                                textFieldConverted.setText(ounceToKg);
                                break;
                            // WHen converted combo box is milligram
                            case 2:
                                String ounceToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 28349.52))));
                                textFieldConverted.setText(ounceToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String ounceToMt = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.0000283495))));
                                textFieldConverted.setText(ounceToMt);
                                break;
                            // When converted combo box is ton
                            case 4:
                                String ounceToTon = Float.toString(Float.parseFloat(String.format("%.6f", (originalValue[0] * 0.00003125))));
                                textFieldConverted.setText(ounceToTon);
                                break;
                            // When converted combo box is ounce
                            case 5:
                                String ounceToOunce = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(ounceToOunce);
                                break;
                            // When converted combo box is pound
                            case 6:
                                String ounceToPound = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.0625))));
                                textFieldConverted.setText(ounceToPound);
                                break;
                            // When converted combo box is stone
                            case 7:
                                String ounceToStone = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.004464286))));
                                textFieldConverted.setText(ounceToStone);
                                break;

                        }
                        break;
                    // When original combo box is pound
                    case 6:
                        switch (convertedUnit) {
                            // When converted combo box is grams
                            case 0:
                                String poundToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 453.5924))));
                                textFieldConverted.setText(poundToGram);
                                break;
                            // When converted combo box is kilogram
                            case 1:
                                String poundToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 0.4535924))));
                                textFieldConverted.setText(poundToKg);
                                break;
                            // When converted combo box is milligram
                            case 2:
                                String poundToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 453592.4))));
                                textFieldConverted.setText(poundToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String poundToMt = Float.toString(Float.parseFloat(String.format("%.5f", (originalValue[0] * 0.0004535924))));
                                textFieldConverted.setText(poundToMt);
                                break;
                            // When converted combo box is ton
                            case 4:
                                String poundToTon = Float.toString(Float.parseFloat(String.format("%.5f", (originalValue[0] * 0.0005))));
                                textFieldConverted.setText(poundToTon);
                                break;
                            // When converted combo box is ounce
                            case 5:
                                String poundToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 16))));
                                textFieldConverted.setText(poundToOunce);
                                break;
                            // When converted combo box is pound
                            case 6:
                                String poundToPound = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(poundToPound);
                                break;
                            // When converted combo box is stone
                            case 7:
                                String poundToStone = Float.toString(Float.parseFloat(String.format("%.3f", (originalValue[0] * 0.07142857))));
                                textFieldConverted.setText(poundToStone);
                                break;
                        }
                        break;

                    // When original combo box is Stone
                    case 7:
                        switch (convertedUnit) {
                            // When converted combo box is gram
                            case 0:
                                String stoneToGram = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 6350.293))));
                                textFieldConverted.setText(stoneToGram);
                                break;
                            // When converted combo box is kilogram
                            case 1:
                                String stoneToKg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 6.350293))));
                                textFieldConverted.setText(stoneToKg);
                                break;
                            // When converted combo box is milligram
                            case 2:
                                String stoneToMg = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 6350293))));
                                textFieldConverted.setText(stoneToMg);
                                break;
                            // When converted combo box is metric ton
                            case 3:
                                String stoneToMt = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.006350293))));
                                textFieldConverted.setText(stoneToMt);
                                break;
                            // When converted combo box is ton
                            case 4:
                                String stoneToTon = Float.toString(Float.parseFloat(String.format("%.4f", (originalValue[0] * 0.007))));
                                textFieldConverted.setText(stoneToTon);
                                break;
                            // When converted combo box is ounce
                            case 5:
                                String stoneToOunce = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 224))));
                                textFieldConverted.setText(stoneToOunce);
                                break;
                            // When converted combo box is pound
                            case 6:
                                String stoneToPound = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 14))));
                                textFieldConverted.setText(stoneToPound);
                                break;
                            // When converted combo box is stone
                            case 7:
                                String stoneToStone = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(stoneToStone);
                                break;

                        }
                        break;
                }
            }
        });
    }
}
