package gui;
import javax.swing.*;
import java.awt.*;

/**
 * TODO Comment purpose.
 *
 * @author oi16jsn
 * @since 2018-12-12
 */
public class CreatureTooltip extends JToolTip {
    /**
     * TODO Comment purpose.
     * @param component
     */
    public CreatureTooltip(JComponent component){
        super();
        setComponent(component);
        setBackground(Color.black);
        setForeground(Color.red);
    }


}
