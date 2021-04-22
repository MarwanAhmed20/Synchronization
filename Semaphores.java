import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Semaphores {

    protected int value = 0 ;

    protected Semaphores() { value = 0 ; }

    protected Semaphores(int initial) { value = initial ; }

    public synchronized void P(Device device) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("answer.txt",true));
        //System.out.println(value);
        value-- ;
        if (value < 0){
            System.out.println(device.name + " Arrived and Waiting");
            writer.write(device.name + " Arrived and Waiting");
            writer.newLine();
            try { wait() ; } catch(  InterruptedException e ) { }}
            else {
            System.out.println(device.name + " Arrived");
            writer.write(device.name + " Arrived");
            writer.newLine();
        }
            writer.close();
    }

    public synchronized void V(Device device) {
        value++ ; if (value <= 0) notify() ;
    }

}





