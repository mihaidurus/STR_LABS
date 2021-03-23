package Lab3.app1;

import java.util.Date;

public class RThread extends Thread {

    FileService service;

    public RThread(FileService service, String name) {

        super(name);
        this.service = service;

    }

    public void run() {

        while (!Main.isStopThreads()) {

            try {
                synchronized (this) {
                    String iterator, last = "no message to read";
                    while ((iterator = this.service.in.readLine()) != null) {
                        last = new Date(System.currentTimeMillis()) + " - " + iterator;
                    }
                    System.out.println(last);
                }
                Thread.sleep(3000);
            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}