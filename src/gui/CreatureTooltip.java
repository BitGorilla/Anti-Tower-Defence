package gui;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author oi16jsn
 * @since 2018-12-12
 */
public class CreatureTooltip extends JToolTip {
    public CreatureTooltip(JComponent component){
        super();
        setComponent(component);
        setBackground(Color.black);
        setForeground(Color.red);
    }


}
