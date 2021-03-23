package Lab3.app2;

public class Controller {
    GUI gui;
    public Controller(GUI gui){
        gui.squaresControllers.forEach(sc->{
            sc.addObserver(gui);
        });
        this.gui=gui;
    }
}
