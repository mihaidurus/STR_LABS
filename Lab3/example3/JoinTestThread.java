package Lab3.example3;

class JoinTestThread extends Thread {

    Thread t;
    int randomInt;
    int sum;

    JoinTestThread(String n, Thread t, int randomInt) {

        this.setName(n);
        this.randomInt = randomInt;
        this.t = t;

    }

    public void run() {
        System.out.println(this.getName() + " has entered the run() method");
        try {
            if (t != null) t.join();
            System.out.println("Thread " + this.getName() + " executing operation.");
            System.out.println("Divisors are: ");
            for (int i = 1; i <= randomInt; i++)
                if (randomInt % i == 0) {
                    System.out.print(i + " ");
                    sum += i;
                }
            System.out.println();
            System.out.println(this.getName() + " is assining to static variable.");
            Main.divthrd = sum;
            Thread.sleep(3000);
            System.out.println("Sum of dividers is: "+Main.divthrd);
            System.out.println(this.getName() + " has terminated operation.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}