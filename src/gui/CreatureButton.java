package gui;

import creatures.SpeedDemon;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * A buttons that is shown in the gui and makes it possible for the user to
 * add players (creatures) to the game.
 * @author oi16jsn
 * @since 2018-12-12
 */
public class CreatureButton extends JButton {
   public CreatureButton(String text, ActionListener actionListener){
        super(text);
        addActionListener(actionListener);
       StringBuilder sb = new StringBuilder();
       createToolTip();
       sb.append("Cost: ");
       sb.append(SpeedDemon.COST);
       sb.append("\nSpeed: ");
       sb.append(SpeedDemon.SPEED);
       sb.append("\n" + "Fast as fuck");
       setToolTipText("<html> Cost: " + SpeedDemon.COST + "<br>Speed: "
               + SpeedDemon.COST + "<br>Fast as fuck </html>");
       ToolTipManager.sharedInstance().setInitialDelay(50);

   }

    /**
     * Shown cost and speed when hover over creature button.
      * @return ToolTip
     */
   public JToolTip createToolTip(){
       return new CreatureTooltip(this);
   }
}
