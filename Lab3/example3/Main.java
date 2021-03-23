package Lab3.example3;

import java.util.Random;

public class Main {
    public static int divthrd=0;
    public static void main(String[] args){

        Random random=new Random();
        int randomInt=random.nextInt(50000)+50000;
        JoinTestThread w1 = new JoinTestThread("Thread 1",null,randomInt);
        randomInt=random.nextInt(80000)+20000;
        JoinTestThread w2 = new JoinTestThread("Thread 2",w1,randomInt);

        w1.start();

        w2.start();

    }

}