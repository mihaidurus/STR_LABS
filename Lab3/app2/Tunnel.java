package Lab3.app2;

import javax.swing.*;
import java.awt.*;

public class Tunnel extends JComponent {
    @Override
    public void paint(Graphics g){

        g.setColor(Color.BLACK);
        g.fillRect(0,0,Utils.RECT_WIDTH,Utils.RECT_HEIGHT);
    }
}
