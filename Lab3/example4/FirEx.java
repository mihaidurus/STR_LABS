package Lab3.example4;

class FirEx extends Thread {

    boolean stop;

    FirEx(ThreadGroup tg, String name) {

        super(tg, name);

        stop = false;

    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " pornit.");

        try {

            for (int i = 1; i < 1000; i++) {

                System.out.print(".");

                Thread.sleep(250);

                synchronized (this) {

                    if (stop)

                        break;

                }

            }

        } catch (Exception exc) {

            System.out.println(Thread.currentThread().getName() +

                    " intrerupt.");

        }

        System.out.println(Thread.currentThread().getName() + " sfarsit.");

    }

    synchronized void oprire() {

        stop = true;

    }

}
