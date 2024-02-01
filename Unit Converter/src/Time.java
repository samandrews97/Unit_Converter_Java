import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time extends JFrame {
    private JButton btnTimeToMain;
    private JPanel panelTime;
    private JComboBox comboBoxOriginal;
    private JComboBox comboBoxConverted;
    private JTextField textFieldOriginal;
    private JTextField textFieldConverted;
    private JButton btnConvert;
    private JLabel labelToConvert;
    private JLabel labelConverted;

    public Time() {

        // Set time frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelTime);
        setTitle("Time");

        btnTimeToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.main(null); // Create a new Main menu frame

                dispose(); // Close the time frame.

            }

        });

        // List of time units for the combo boxes
        String[] timeStrings = {"Seconds", "Minutes", "Hours", "Days", "Weeks", "Months", "Years"};

        // Populate original combo box and set initial value
        for (String time : timeStrings) {

            comboBoxOriginal.addItem(time);

        }
        comboBoxOriginal.setSelectedIndex(0);

        // Populate converted combo box and set initial value
        for (String time : timeStrings) {

            comboBoxConverted.addItem(time);

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
                    // When original combo box is seconds
                    case 0:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String secondsToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(secondsToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String secondsToMinutes = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] / 60.00))));
                                textFieldConverted.setText(secondsToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String secondsToHours = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * (float) Math.pow(60, -2)))));
                                textFieldConverted.setText(secondsToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String secondsToDays = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * (float) Math.pow(60, -2)) / 24.0 )));
                                textFieldConverted.setText(secondsToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String secondsToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] * (float) Math.pow(60, -2) / 24.0) / 7.0))));
                                textFieldConverted.setText(secondsToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String secondsToMonths = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] * (float) Math.pow(60, -2) / 24.0) / 7.0) / 4.3452381))));
                                textFieldConverted.setText(secondsToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String secondsToYears = Float.toString(Float.parseFloat(String.format("%.2f", ((((originalValue[0] * (float) Math.pow(60, -2) / 24.0) / 7.0) / 4.3452381) / 12.0))));
                                textFieldConverted.setText(secondsToYears);
                                break;
                        }
                        break;
                    // When original combo box is minutes
                    case 1:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String minutesToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 60.0))));
                                textFieldConverted.setText(minutesToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String minutesToMinutes = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(minutesToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String minutesToHours = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] / 60.0))));
                                textFieldConverted.setText(minutesToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String minutesToDays = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] / 60.0) / 24.0))));
                                textFieldConverted.setText(minutesToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String minutesToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] / 60.0) / 24.0) / 7.0))));
                                textFieldConverted.setText(minutesToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String minutesToMonths = Float.toString(Float.parseFloat(String.format("%.2f", ((((originalValue[0] / 60.0) / 24.0) / 7.0) / 4.3452381))));
                                textFieldConverted.setText(minutesToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String minutesToYears = Float.toString(Float.parseFloat(String.format("%.2f", (((((originalValue[0] / 60.0) / 24.0) / 7.0) / 4.3452381) / 12.0))));
                                textFieldConverted.setText(minutesToYears);
                                break;
                        }
                        break;
                    // When original combo box is hours
                    case 2:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String hoursToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * (float) Math.pow(60, 2)))));
                                textFieldConverted.setText(hoursToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String hoursToMinutes = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 60.0))));
                                textFieldConverted.setText(hoursToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String hoursToHours = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(hoursToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String hoursToDays = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] / 24.0))));
                                textFieldConverted.setText(hoursToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String hoursToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] / 24.0) / 7.0))));
                                textFieldConverted.setText(hoursToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String hoursToMonths = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] / 24.0) / 7.0) / 4.3452381))));
                                textFieldConverted.setText(hoursToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String hoursToYears = Float.toString(Float.parseFloat(String.format("%.2f", ((((originalValue[0] / 24.0) / 7.0) / 4.3452381) / 12.0))));
                                textFieldConverted.setText(hoursToYears);
                                break;
                        }
                        break;
                    // When the original combo box is days
                    case 3:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String daysToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] * 24.0) * (float) Math.pow(60, 2)))));
                                textFieldConverted.setText(daysToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String daysToMinutes = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] * 24.0) * 60.0))));
                                textFieldConverted.setText(daysToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String daysToHours = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 24.0))));
                                textFieldConverted.setText(daysToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String daysToDays = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(daysToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String daysToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] / 7.0))));
                                textFieldConverted.setText(daysToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String daysToMonths = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] / 7.0) / 4.3452381))));
                                textFieldConverted.setText(daysToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String daysToYearsString = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] / 7.0) / 4.3452381) / 12.0))));
                                textFieldConverted.setText(daysToYearsString);
                                break;
                        }
                        break;
                    // When the original combo box is weeks
                    case 4:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String weeksToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] * 7.0) * 24.0) * (float) Math.pow(60, 2)))));
                                textFieldConverted.setText(weeksToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String weeksToMinutes = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] * 7.0) * 24.0) * 60.0))));
                                textFieldConverted.setText(weeksToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String weeksToHours = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] * 7.0) * 24.0))));
                                textFieldConverted.setText(weeksToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String weeksToDays = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 7.0))));
                                textFieldConverted.setText(weeksToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String weeksToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(weeksToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String weeksToMonths = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] / 4.3452381))));
                                textFieldConverted.setText(weeksToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String weeksToYears = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] / 4.3452381) / 12.0))));
                                textFieldConverted.setText(weeksToYears);
                                break;
                        }
                        break;
                    // When the original combo box is months
                    case 5:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String monthsToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", ((((originalValue[0] * 4.3452381) * 7.0) * 24.0) * (float) Math.pow(60, 2)))));
                                textFieldConverted.setText(monthsToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String monthsToMinutes= Float.toString(Float.parseFloat(String.format("%.2f", ((((originalValue[0] * 4.3452381) * 7.0) * 24.0) * 60.0))));
                                textFieldConverted.setText(monthsToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String monthsToHours = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] * 4.3452381) * 7.0) * 24.0))));
                                textFieldConverted.setText(monthsToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String monthsToDays = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] * 4.3452381) * 7.0))));
                                textFieldConverted.setText(monthsToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String monthsToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 4.3452381))));
                                textFieldConverted.setText(monthsToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String monthsToMonths = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(monthsToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String monthsToYears = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] / 12.0))));
                                textFieldConverted.setText(monthsToYears);
                                break;
                        }
                        break;
                    // When original combo box is years
                    case 6:
                        switch(convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                String yearsToSeconds = Float.toString(Float.parseFloat(String.format("%.2f", (((((originalValue[0] * 12.0) * 4.3452381) * 7.0) * 24.0) * (float) Math.pow(60, 2)))));
                                textFieldConverted.setText(yearsToSeconds);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                String yearsToMinutes = Float.toString(Float.parseFloat(String.format("%.2f", (((((originalValue[0] * 12.0) * 4.3452381) * 7.0) * 24.0) * 60.0))));
                                textFieldConverted.setText(yearsToMinutes);
                                break;
                            // When converted combo box is hours
                            case 2:
                                String yearsToHours = Float.toString(Float.parseFloat(String.format("%.2f", ((((originalValue[0] * 12.0) * 4.3452381) * 7.0) * 24.0))));
                                textFieldConverted.setText(yearsToHours);
                                break;
                            // When converted combo box is days
                            case 3:
                                String yearsToDays = Float.toString(Float.parseFloat(String.format("%.2f", (((originalValue[0] * 12.0) * 4.3452381) * 7.0))));
                                textFieldConverted.setText(yearsToDays);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                String yearsToWeeks = Float.toString(Float.parseFloat(String.format("%.2f", ((originalValue[0] * 12.0) * 4.3452381))));
                                textFieldConverted.setText(yearsToWeeks);
                                break;
                            // When converted combo box is months
                            case 5:
                                String yearsToMonths = Float.toString(Float.parseFloat(String.format("%.2f", (originalValue[0] * 12.0))));
                                textFieldConverted.setText(yearsToMonths);
                                break;
                            // When converted combo box is years
                            case 6:
                                String yearsToYears = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(yearsToYears);
                                break;
                        }
                        break;

                }

            }

        });
        
    }
}
