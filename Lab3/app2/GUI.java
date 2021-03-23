package Lab3.app2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GUI extends JFrame implements Observer {
    ArrayList<SquareController> squaresControllers = new ArrayList<>();
    public GUI() {
        super("app2");
        this.setLayout(null);
        setSize(Utils.WIN_WIDTH, Utils.WIN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int aux = 0;
        int aux1 = 0;
        for (int i = 0; i < 4; i++) {
            Tunnel tunnel = new Tunnel();
            if (i < 2) {
                tunnel.setSize(Utils.RECT_WIDTH, Utils.RECT_HEIGHT);
                tunnel.setLocation(0, aux);
                aux += 265;
                this.add(tunnel);
            } else {
                tunnel.setSize(Utils.SMALL_RECT_WIDTH, Utils.SMALL_RECT_HEIGHT);
                tunnel.setLocation(215, Utils.RECT_HEIGHT + aux1);
                aux1 += 125;
                this.add(tunnel);
            }
        }
        aux=0;
        for (int i = 0; i < 3; i++) {
            if (i != 1) {
                SquareController squareController = new SquareController(1, 2);
                squareController.squares.setSize(Utils.FIGURE_SIZE,Utils.FIGURE_SIZE);
                squareController.squares.setLocation(30+aux,155);
                aux+=70;
                squaresControllers.add(squareController);
                this.add(squareController.squares);
            } else {
                SquareController squareController = new SquareController(2, 3);
                squareController.squares.setSize(Utils.FIGURE_SIZE,Utils.FIGURE_SIZE);
                squareController.squares.setLocation(Utils.WIN_WIDTH-aux*2-20,155);
                squaresControllers.add(squareController);
                this.add(squareController.squares);
            }
        }

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_S) {

                    for(int i=0;i<3;i++) {
                        if (i != 1) {
                            Thread t = new Thread(squaresControllers.get(i), "SqCntrlThread");
                            t.start();
                            squaresControllers.get(i).startSquare = true;
                        }
                    }

                }
               // System.out.println("All threads started");
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        SquareController squareObserver=((SquareController) o);
        squareObserver.squares.setLocation(squareObserver.squares.getX()+1,155);
        if(squareObserver.squares.getX()==Utils.WIN_WIDTH-230){
           for(int i=0;i<3;i++){
                try {
                    squaresControllers.get(i).wait(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            squaresControllers.get(0).notify();
            squaresControllers.get(1).notify();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Observer notified");
    }
}
