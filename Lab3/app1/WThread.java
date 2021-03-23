package Lab3.app1;

import java.util.Date;

public class WThread extends Thread {

    FileService service;

    public WThread(FileService service, String name) {

        super(name);
        this.service = service;

    }

    public void run() {

        while (!Main.isStopThreads()) {

            String msg = String.valueOf(Math.round(Math.random() * 100));
            try {
                synchronized (this) {
                    Date date = new Date(System.currentTimeMillis());
                    this.service.out.println("Date: " + date);
                    this.service.out.println("Message: " + msg);
                    this.service.out.flush();
                }

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}