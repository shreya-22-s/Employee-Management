package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash() {
        // Original image
        ImageIcon i1 = new ImageIcon("C:/Users/srish/Downloads/EmployeeManagementSystem/EmployeeManagementSystem/src/icon/front.png");
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));

        image.setBounds(0, 0, 1170, 650);
        add(image);

        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        // Timer to close splash once
        Timer timer = new Timer(5000, e -> {
            setVisible(false);
            dispose(); // Close splash
            new Login(); // Open login window
        });
        timer.setRepeats(false); // Important! Run only once
        timer.start();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
