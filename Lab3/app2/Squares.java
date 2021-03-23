package Lab3.app2;
import javax.swing.*;
import java.awt.*;

public class Squares extends JComponent {
    public int squareSpeed;
    public Squares(int squareSpeed){
        this.squareSpeed=squareSpeed;
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Utils.FIGURE_SIZE, Utils.FIGURE_SIZE);
    }
}
