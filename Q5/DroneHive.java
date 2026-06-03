import java.util.concurrent.atomic.AtomicInteger;

public class DroneHive {
    private static volatile boolean emergencyAbort = false;
    private static AtomicInteger totalDronesReturned = new AtomicInteger(0);
    static class Drone extends Thread {
        @Override
        public void run() {
          if (emergencyAbort) {
                System.out.println(getName() + " : Emergency detected! Altering route.");
                return;
            }
            int count = totalDronesReturned.incrementAndGet();
            System.out.println(getName() + " landed. Total returned = " + count);
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            Drone drone = new Drone();
            drone.setName("Drone-" + i);
            drone.start();
            if (i == 5000) {
                emergencyAbort = true;
                System.out.println("\n*** STORM DETECTED - EMERGENCY ABORT ACTIVATED ***\n");
            }
        }
        System.out.println("\nFinal Returned Drones Count: "+ totalDronesReturned.get());
    }
}
