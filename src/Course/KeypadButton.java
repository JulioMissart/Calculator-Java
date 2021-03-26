package Course;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class KeypadButton extends JButton {

    Border emptyBorder = BorderFactory.createEmptyBorder();

    KeypadButton() {
        this.setBackground(new Color(229,229,229));
        this.setFocusable(false);
        this.setBorder(emptyBorder);
        this.setText("0");
    }

    KeypadButton(String numberText, int singleRGBColor, int singleRGBColorHover) {
        this.setBackground(new Color(singleRGBColor,singleRGBColor,singleRGBColor));
        this.setFocusable(false);
        this.setBorder(emptyBorder);
        this.setText(numberText);

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(singleRGBColorHover,singleRGBColorHover,singleRGBColorHover));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(singleRGBColor,singleRGBColor,singleRGBColor));
            }
        });
    }
}
