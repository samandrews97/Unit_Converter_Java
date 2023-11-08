import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton btnTemp;
    private JLabel labelMain;
    private JButton btnTime;
    private JPanel panelMenu;

    public Menu() {

        // Open temperature JFrame when Temperature button clicked
        btnTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Create a new temperature frame
                Temperature temperature = new Temperature();
                temperature.setVisible(true);

                dispose();  // Close menu frame
            }
        });

        // Open time JFrame when time button clicked
        btnTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Create a new time frame
                Time time = new Time();
                time.setVisible(true);

                dispose();  // Close menu frame
            }
        });
    }

    public static void main(String[] args) {

        // Creates the main menu frame and sets its attributes
        Menu menu = new Menu();
        menu.setContentPane(menu.panelMenu);
        menu.setTitle("Main Menu");
        menu.setSize(800,800);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
