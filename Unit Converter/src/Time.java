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
                            // When conversion combo box is seconds
                            case 0:
                                String secondsToSecondsString = Float.toString(Float.parseFloat(String.format("%.2f", originalValue[0])));
                                textFieldConverted.setText(secondsToSecondsString);
                                break;
                            // When conversion combo box is minutes
                            case 1:
                                float secondsToMinutes = Float.parseFloat(String.format("%.2f", (originalValue[0] / 60.00)));
                                String secondsToMinutesString = Float.toString(secondsToMinutes);
                                textFieldConverted.setText(secondsToMinutesString);
                                break;
                            // When conversion combo box is hours
                            case 2:
                                float secondsToHours = Float.parseFloat(String.format("%.2f", (originalValue[0] * (float) Math.pow(60, -2))));
                                String secondsToHoursString = Float.toString(secondsToHours);
                                textFieldConverted.setText(secondsToHoursString);
                                break;
                            // When conversion combo box is days
                            case 3:
                                float secondsToDays = Float.parseFloat(String.format("%.2f", (originalValue[0] * (float) Math.pow(60, -2)) / 24.0 ));
                                String secondsToDaysString = Float.toString(secondsToDays);
                                textFieldConverted.setText(secondsToDaysString);
                                break;
                            // When conversion combo box is weeks
                            case 4:
                                float secondsToWeeks = Float.parseFloat(String.format("%.2f", ((originalValue[0] * (float) Math.pow(60, -2) / 24.0) / 7.0)));
                                String secondsToWeeksString = Float.toString(secondsToWeeks);
                                textFieldConverted.setText(secondsToWeeksString);
                                break;
                            // When conversion combo box is months
                            case 5:
                                float secondsToMonths = Float.parseFloat(String.format("%.2f", (((originalValue[0] * (float) Math.pow(60, -2) / 24.0) / 7.0) / 4.3452381))); // 4.3452381 is the value google gives for weeks in a month.
                                String secondsToMonthsString = Float.toString(secondsToMonths);
                                textFieldConverted.setText(secondsToMonthsString);
                                break;
                            // When conversion combo box is years
                            case 6:
                                float secondsToYears = Float.parseFloat(String.format("%.2f", ((((originalValue[0] * (float) Math.pow(60, -2) / 24.0) / 7.0) / 4.3452381) / 12.0)));
                                String secondsToYearsString = Float.toString(secondsToYears);
                                textFieldConverted.setText(secondsToYearsString);
                                break;
                        }
                        break;
                    // When original combo box is minutes
                    case 1:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                float minutesToSeconds = Float.parseFloat(String.format("%.2f", (originalValue[0] * 60.0)));
                                String minutesToSecondsString = Float.toString(minutesToSeconds);
                                textFieldConverted.setText(minutesToSecondsString);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                float minutesToMinutes = Float.parseFloat(String.format("%.2f", originalValue[0]));
                                String minutesToMinutesString = Float.toString(minutesToMinutes);
                                textFieldConverted.setText(minutesToMinutesString);
                                break;
                            // When converted combo box is hours
                            case 2:
                                float minutesToHours = Float.parseFloat(String.format("%.2f", (originalValue[0] / 60.0)));
                                String minutesToHoursString = Float.toString(minutesToHours);
                                textFieldConverted.setText(minutesToHoursString);
                                break;
                            // When converted combo box is days
                            case 3:
                                float minutesToDays = Float.parseFloat(String.format("%.2f", ((originalValue[0] / 60.0) / 24.0)));
                                String minutesToDaysString = Float.toString(minutesToDays);
                                textFieldConverted.setText(minutesToDaysString);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                float minutesToWeeks = Float.parseFloat(String.format("%.2f", (((originalValue[0] / 60.0) / 24.0) / 7.0)));
                                String minutesToWeeksString = Float.toString(minutesToWeeks);
                                textFieldConverted.setText(minutesToWeeksString);
                                break;
                            // When converted combo box is months
                            case 5:
                                float minutesToMonths = Float.parseFloat(String.format("%.2f", ((((originalValue[0] / 60.0) / 24.0) / 7.0) / 4.3452381)));
                                String minutesToMonthsString = Float.toString(minutesToMonths);
                                textFieldConverted.setText(minutesToMonthsString);
                                break;
                            // When converted combo box is years
                            case 6:
                                float minutesToYears = Float.parseFloat(String.format("%.2f", (((((originalValue[0] / 60.0) / 24.0) / 7.0) / 4.3452381) / 12.0)));
                                String minutesToYearsString = Float.toString(minutesToYears);
                                textFieldConverted.setText(minutesToYearsString);
                                break;
                        }
                        break;
                    // When original combo box is hours
                    case 2:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                float hoursToSeconds = Float.parseFloat(String.format("%.2f", (originalValue[0] * (float) Math.pow(60, 2))));
                                String hoursToSecondsString = Float.toString(hoursToSeconds);
                                textFieldConverted.setText(hoursToSecondsString);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                float hoursToMinutes = Float.parseFloat(String.format("%.2f", (originalValue[0] * 60.0)));
                                String hoursToMinutesString = Float.toString(hoursToMinutes);
                                textFieldConverted.setText(hoursToMinutesString);
                                break;
                            // When converted combo box is hours
                            case 2:
                                float hoursToHours = Float.parseFloat(String.format("%.2f", originalValue[0]));
                                String hoursToHoursString = Float.toString(hoursToHours);
                                textFieldConverted.setText(hoursToHoursString);
                                break;
                            // When converted combo box is days
                            case 3:
                                float hoursToDays = Float.parseFloat(String.format("%.2f", (originalValue[0] / 24.0)));
                                String hoursToDaysString = Float.toString(hoursToDays);
                                textFieldConverted.setText(hoursToDaysString);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                float hoursToWeeks = Float.parseFloat(String.format("%.2f", ((originalValue[0] / 24.0) / 7.0)));
                                String hoursToWeeksString = Float.toString(hoursToWeeks);
                                textFieldConverted.setText(hoursToWeeksString);
                                break;
                            // When converted combo box is months
                            case 5:
                                float hoursToMonths = Float.parseFloat(String.format("%.2f", (((originalValue[0] / 24.0) / 7.0) / 4.3452381)));
                                String hoursToMonthsString = Float.toString(hoursToMonths);
                                textFieldConverted.setText(hoursToMonthsString);
                                break;
                            // When converted combo box is years
                            case 6:
                                float hoursToYears = Float.parseFloat(String.format("%.2f", ((((originalValue[0] / 24.0) / 7.0) / 4.3452381) / 12.0)));
                                String hoursToYearsString = Float.toString(hoursToYears);
                                textFieldConverted.setText(hoursToYearsString);
                                break;
                        }
                        break;
                    // When the original combo box is days
                    case 3:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                float daysToSeconds = Float.parseFloat(String.format("%.2f", ((originalValue[0] * 24.0) * (float) Math.pow(60, 2))));
                                String daysToSecondsString = Float.toString(daysToSeconds);
                                textFieldConverted.setText(daysToSecondsString);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                float daysToMinutes = Float.parseFloat(String.format("%.2f", ((originalValue[0] * 24.0) * 60.0)));
                                String daysToMinutesString = Float.toString(daysToMinutes);
                                textFieldConverted.setText(daysToMinutesString);
                                break;
                            // When converted combo box is hours
                            case 2:
                                float daysToHours = Float.parseFloat(String.format("%.2f", (originalValue[0] * 24.0)));
                                String daysToHoursString = Float.toString(daysToHours);
                                textFieldConverted.setText(daysToHoursString);
                                break;
                            // When converted combo box is days
                            case 3:
                                float daysToDays = Float.parseFloat(String.format("%.2f", originalValue[0]));
                                String daysToDaysString = Float.toString(daysToDays);
                                textFieldConverted.setText(daysToDaysString);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                float daysToWeeks = Float.parseFloat(String.format("%.2f", (originalValue[0] / 7.0)));
                                String daysToWeeksString = Float.toString(daysToWeeks);
                                textFieldConverted.setText(daysToWeeksString);
                                break;
                            // When converted combo box is months
                            case 5:
                                float daysToMonths = Float.parseFloat(String.format("%.2f", ((originalValue[0] / 7.0) / 4.3452381)));
                                String daysToMonthsString = Float.toString(daysToMonths);
                                textFieldConverted.setText(daysToMonthsString);
                                break;
                            // When converted combo box is years
                            case 6:
                                float daysToYears = Float.parseFloat(String.format("%.2f", (((originalValue[0] / 7.0) / 4.3452381) / 12.0)));
                                String daysToYearsString = Float.toString(daysToYears);
                                textFieldConverted.setText(daysToYearsString);
                                break;
                        }
                        break;
                    // When the original combo box is weeks
                    case 4:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                float weeksToSeconds = Float.parseFloat(String.format("%.2f", (((originalValue[0] * 7.0) * 24.0) * (float) Math.pow(60, 2))));
                                String weeksToSecondsString = Float.toString(weeksToSeconds);
                                textFieldConverted.setText(weeksToSecondsString);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                float weeksToMinutes = Float.parseFloat(String.format("%.2f", (((originalValue[0] * 7.0) * 24.0) * 60.0)));
                                String weeksToMinutesString = Float.toString(weeksToMinutes);
                                textFieldConverted.setText(weeksToMinutesString);
                                break;
                            // When converted combo box is hours
                            case 2:
                                float weeksToHours = Float.parseFloat(String.format("%.2f", ((originalValue[0] * 7.0) * 24.0)));
                                String weeksToHoursString = Float.toString(weeksToHours);
                                textFieldConverted.setText(weeksToHoursString);
                                break;
                            // When converted combo box is days
                            case 3:
                                float weeksToDays = Float.parseFloat(String.format("%.2f", (originalValue[0] * 7.0)));
                                String weeksToDaysString = Float.toString(weeksToDays);
                                textFieldConverted.setText(weeksToDaysString);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                float weeksToWeeks = Float.parseFloat(String.format("%.2f", originalValue[0]));
                                String weeksToWeeksString = Float.toString(weeksToWeeks);
                                textFieldConverted.setText(weeksToWeeksString);
                                break;
                            // When converted combo box is months
                            case 5:
                                float weeksToMonths = Float.parseFloat(String.format("%.2f", (originalValue[0] / 4.3452381)));
                                String weeksToMonthsString = Float.toString(weeksToMonths);
                                textFieldConverted.setText(weeksToMonthsString);
                                break;
                            // When converted combo box is years
                            case 6:
                                float weeksToYears = Float.parseFloat(String.format("%.2f", ((originalValue[0] / 4.3452381) / 12.0)));
                                String weeksToYearsString = Float.toString(weeksToYears);
                                textFieldConverted.setText(weeksToYearsString);
                                break;
                        }
                        break;
                    // When the original combo box is months
                    case 5:
                        switch (convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                float monthsToSeconds = Float.parseFloat(String.format("%.2f", ((((originalValue[0] * 4.3452381) * 7.0) * 24.0) * (float) Math.pow(60, 2))));
                                String monthsToSecondsString = Float.toString(monthsToSeconds);
                                textFieldConverted.setText(monthsToSecondsString);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                float monthsToMinutes = Float.parseFloat(String.format("%.2f", ((((originalValue[0] * 4.3452381) * 7.0) * 24.0) * 60.0)));
                                String monthsToMinutesString = Float.toString(monthsToMinutes);
                                textFieldConverted.setText(monthsToMinutesString);
                                break;
                            // When converted combo box is hours
                            case 2:
                                float monthsToHours = Float.parseFloat(String.format("%.2f", (((originalValue[0] * 4.3452381) * 7.0) * 24.0)));
                                String monthsToHoursString = Float.toString(monthsToHours);
                                textFieldConverted.setText(monthsToHoursString);
                                break;
                            // When converted combo box is days
                            case 3:
                                float monthsToDays = Float.parseFloat(String.format("%.2f", ((originalValue[0] * 4.3452381) * 7.0)));
                                String monthsToDaysString = Float.toString(monthsToDays);
                                textFieldConverted.setText(monthsToDaysString);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                float monthsToWeeks = Float.parseFloat(String.format("%.2f", (originalValue[0] * 4.3452381)));
                                String monthsToWeeksString = Float.toString(monthsToWeeks);
                                textFieldConverted.setText(monthsToWeeksString);
                                break;
                            // When converted combo box is months
                            case 5:
                                float monthsToMonths = Float.parseFloat(String.format("%.2f", originalValue[0]));
                                String monthsToMonthsString = Float.toString(monthsToMonths);
                                textFieldConverted.setText(monthsToMonthsString);
                                break;
                            // When converted combo box is years
                            case 6:
                                float monthsToYears = Float.parseFloat(String.format("%.2f", (originalValue[0] / 12.0)));
                                String monthsToYearsString = Float.toString(monthsToYears);
                                textFieldConverted.setText(monthsToYearsString);
                                break;
                        }
                        break;
                    // When original combo box is years
                    case 6:
                        switch(convertedUnit) {
                            // When converted combo box is seconds
                            case 0:
                                float yearsToSeconds = Float.parseFloat(String.format("%.2f", (((((originalValue[0] * 12.0) * 4.3452381) * 7.0) * 24.0) * (float) Math.pow(60, 2))));
                                String yearsToSecondsString = Float.toString(yearsToSeconds);
                                textFieldConverted.setText(yearsToSecondsString);
                                break;
                            // When converted combo box is minutes
                            case 1:
                                float yearsToMinutes = Float.parseFloat(String.format("%.2f", (((((originalValue[0] * 12.0) * 4.3452381) * 7.0) * 24.0) * 60.0)));
                                String yearsToMinutesString = Float.toString(yearsToMinutes);
                                textFieldConverted.setText(yearsToMinutesString);
                                break;
                            // When converted combo box is hours
                            case 2:
                                float yearsToHours = Float.parseFloat(String.format("%.2f", ((((originalValue[0] * 12.0) * 4.3452381) * 7.0) * 24.0)));
                                String yearsToHoursString = Float.toString(yearsToHours);
                                textFieldConverted.setText(yearsToHoursString);
                                break;
                            // When converted combo box is days
                            case 3:
                                float yearsToDays = Float.parseFloat(String.format("%.2f", (((originalValue[0] * 12.0) * 4.3452381) * 7.0)));
                                String yearsToDaysString = Float.toString(yearsToDays);
                                textFieldConverted.setText(yearsToDaysString);
                                break;
                            // When converted combo box is weeks
                            case 4:
                                float yearsToWeeks = Float.parseFloat(String.format("%.2f", ((originalValue[0] * 12.0) * 4.3452381)));
                                String yearsToWeeksString = Float.toString(yearsToWeeks);
                                textFieldConverted.setText(yearsToWeeksString);
                                break;
                            // When converted combo box is months
                            case 5:
                                float yearsToMonths = Float.parseFloat(String.format("%.2f", (originalValue[0] * 12.0)));
                                String yearsToMonthsString = Float.toString(yearsToMonths);
                                textFieldConverted.setText(yearsToMonthsString);
                                break;
                            // When converted combo box is years
                            case 6:
                                float yearsToYears = Float.parseFloat(String.format("%.2f", originalValue[0]));
                                String yearsToYearsString = Float.toString(yearsToYears);
                                textFieldConverted.setText(yearsToYearsString);
                                break;
                        }
                        break;

                }

            }

        });
        
    }
}
