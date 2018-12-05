import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ImageRenderer extends DefaultTableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel label = new JLabel();

        if (value!=null) {
            label.setHorizontalAlignment(JLabel.CENTER);
            //value is parameter which filled by byteOfImage
            //label.setIcon(new ImageIcon("./images/StarCreature.png"));
            ImageIcon icon = new ImageIcon(getClass().getResource("./images/StarCreature.png"));
            label.setIcon(icon);
        }
        return label;
    }
}