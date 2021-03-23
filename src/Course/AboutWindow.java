package Course;

import javax.swing.*;
import java.awt.*;

public class AboutWindow {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Calculator 1.0");
    AboutWindow() {

        label.setBounds(0,0,420,50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);

        frame.setVisible(true);


    }
}
