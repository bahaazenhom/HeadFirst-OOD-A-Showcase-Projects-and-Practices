package DogDoorSimulator;
import java.util.Objects;

public class Bark {
    private String sound;
    public Bark(String sound){
        this.sound=sound;
    }
    public String getSound(){
        return sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bark otherBark = (Bark) o;
        return Objects.equals(sound, otherBark.sound);
    }

}
