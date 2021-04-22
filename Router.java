import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Router {


    int size = 0; // the buffer bound
    Semaphores spaces;

    Random r = new Random();
    int time = r.nextInt(999);

    Device store[] ;
    Boolean check[] ;



    public Router(int sizee) {

        size = sizee;
        this.store = new Device[size];
        this.check = new Boolean[size];

        spaces = new Semaphores(size);
        for (int i = 0; i < check.length; i++){

            check[i] = false;
        }
        for (int i = 0; i < size; i++){
            store[i] = null;
        }
    }

    public synchronized  void connect(Device device) throws InterruptedException, IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("answer.txt",true));


        for (int i = 0; i < size; i++) {
            if (store[i] == null) {
                store[i] = device;
                device.number = i + 1;
                System.out.println("Connection " + device.number + " " + device.name + " Occupied");
                writer.write("Connection " + device.number + " " + device.name + " Occupied");
                writer.newLine();
                sleep(time);
                break;
            }

        }
        writer.close();

    }

    public  void active(Device device) throws InterruptedException,IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("answer.txt",true));
        System.out.println(device.name + " performs online activity");
        writer.write(device.name + " performs online activity");
        writer.newLine();
        writer.close();
        sleep(time);

    }

    public synchronized Device disconnect(Device device) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("answer.txt",true));
        Device value;
        value = store[device.number - 1];
        store[device.number - 1] = null;
        System.out.println("Connection " + device.number + " " + device.name + " Logged out");
        writer.write("Connection " + device.number + " " + device.name + " Logged out");
        writer.newLine();
        writer.close();
        return  value;
    }

}