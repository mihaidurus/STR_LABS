package Lab3.example4;

public class ThreadGroupDemo {
    public static void main(String args[]) throws Exception {

        ThreadGroup tg = new ThreadGroup("Grup De Fire");

        FirEx fir1 = new FirEx(tg, "FirEx #1");

        FirEx fir2 = new FirEx(tg, "FirEx #2");

        FirEx fir3 = new FirEx(tg, "FirEx #3");

        fir1.start();

        fir2.start();

        fir3.start();

        Thread.sleep(1000);

        System.out.println(tg.activeCount() + " fire în grup.");

        Thread thrds[] = new Thread[tg.activeCount()];

        tg.enumerate(thrds);

        for (Thread t : thrds){

            System.out.println(t.getName());

        }

        fir1.oprire();

        Thread.sleep(1000);

        System.out.println(tg.activeCount() + " fire în grup.");

        tg.interrupt();

    }
}
