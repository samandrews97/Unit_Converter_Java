import javax.swing.*;

public class InputError extends JFrame {
    private JButton btnError;
    private JLabel labelError;
    private JPanel panelInputError;

    public InputError() {

        // Set error frame attributes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setContentPane(panelInputError);
        setTitle("ERROR!");

    }
}
