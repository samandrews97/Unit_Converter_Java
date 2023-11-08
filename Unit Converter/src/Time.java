import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time extends JFrame {
    private JButton btnTimeToMain;
    private JLabel testLabel;
    private JPanel panelTime;

    public Time() {

        // Set time frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelTime);
        setTitle("Time");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnTimeToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.main(null); // Create a new Main menu frame

                dispose(); // Close the time frame.
            }
        });
    }
}
