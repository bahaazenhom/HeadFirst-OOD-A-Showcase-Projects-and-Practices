package DogDoorSimulator;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private boolean open;

    private List<Bark> allowedBark;
    public DogDoor() {
        this.open = false;
        allowedBark=new ArrayList<>();
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        },5000);
    }
    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
    public void addAllowedBark(Bark newBark){
        allowedBark.add(newBark);
    }
    public List<Bark> getAllowedBark(){
        return this.allowedBark;
    }
}
