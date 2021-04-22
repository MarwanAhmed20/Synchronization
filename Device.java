import java.io.IOException;

public class Device extends Thread{
    String name;
    String type;
    Router router ;
    int number;

    public Device(String name, String type, Router rt) {
        this.name = name;
        this.type = type;
        this.router = rt;
    }

    @Override
    public void run() {
        try {
            router.spaces.P(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            router.connect(this);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        try {
            router.active(this);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        try {
            router.disconnect(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        router.spaces.V(this);


    }

}
