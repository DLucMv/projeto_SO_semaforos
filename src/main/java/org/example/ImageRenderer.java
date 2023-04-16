package org.example;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ImageRenderer extends DefaultTableCellRenderer {
    private ImageIcon playingIcon;
    private ImageIcon quietIcon;

    public ImageRenderer() {
        playingIcon = new ImageIcon(getClass().getResource("/playing.jpg"));
        quietIcon = new ImageIcon(getClass().getResource("/quiet.jpg"));
    }

    public void setImageForValue(Object value, ImageIcon imageIcon) {
        if ("Sim".equals(value)) {
            playingIcon = imageIcon;
        } else if ("Não".equals(value)) {
            quietIcon = imageIcon;
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == 5) { // "Brincando"
            label.setIcon(playingIcon);
        } else if (column == 6) { // "Quieta"
            label.setIcon(quietIcon);
        }

        return label;
    }
}
