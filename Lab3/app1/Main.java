package Lab3.app1;

public class Main {

    private static boolean stopThreads = false;

    public static void main(String[] args) {

        FileService service = new FileService("messages.txt");

        RThread reader = new RThread(service, "ReadThread");

        WThread writer = new WThread(service, "WriteThread");

        reader.start();

        writer.start();

    }

    public static boolean isStopThreads() {

        return stopThreads;

    }

}