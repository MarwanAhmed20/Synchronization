import java.util.Random;
import java.util.Scanner;

public class Network {


    public static void main(String[] args) throws InterruptedException {

         int N = 0;
         int TC = 0;
         Device[] devices;
         Router router ;
         String type;
        Random r = new Random();
        int time = r.nextInt(999);

        Scanner input = new Scanner(System.in);

        System.out.println("What is number of WI-FI Connections?");
        N = input.nextInt();
        System.out.println("What is number of devices Clients want to connect?");
        TC = input.nextInt();
        router = new Router(N);
        devices = new Device[TC];
        for (int i = 0 ; i < TC; i++){
            type = input.next();
            devices[i] = new Device("C" + String.valueOf(i+1), type, router);
        }


        for (int i = 0; i < devices.length; i++ ){

            devices[i].start();
            Thread.sleep(time);
        }
    }

}
