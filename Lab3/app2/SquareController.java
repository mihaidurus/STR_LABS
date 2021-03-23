package Lab3.app2;

import java.util.Observable;
import java.util.Random;

public class SquareController extends Observable implements Runnable {
    public Squares squares;
    public boolean startSquare = false;
    Random rand = new Random();

    public SquareController(int lowerLimit, int upperLimit) {
        this.squares = new Squares(rand.nextInt(upperLimit) + lowerLimit);
    }

    @Override
    public void run() {
        while (startSquare) {
        this.notifyObservers();
        this.setChanged();
        }
    }
}
