package DogDoorSimulator;
public class BarkRecognizer {
    private DogDoor door;
    public BarkRecognizer(DogDoor door){
        this.door=door;
    }
    public void recognize(Bark otherBark){
        System.out.println(otherBark.getSound()+" is recognized");
        if(door.getAllowedBark().contains(otherBark)) door.open();
        else System.out.println("This dog is not allowed");
    }
}
