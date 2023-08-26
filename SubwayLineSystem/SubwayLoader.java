package SubwayLineSystem;
import java.io.*;
import java.util.*;

public class SubwayLoader {
    private Subway subway;
    public SubwayLoader(){
        subway=new Subway();
    }
    public Subway loadFromFile(File subwayFile) throws FileNotFoundException {
        Scanner reader=new Scanner(new FileReader(subwayFile));
        loadStations(subway,reader);
        while(reader.hasNext()){
            String lineName=reader.nextLine();
            loadLine(subway,reader,lineName);
        }
        return subway;
    }

    private void loadLine(Subway subway, Scanner reader, String lineName) {
       String station1=reader.nextLine(),station2;
       while(station1.length()>0&&reader.hasNext()){
           station2=reader.nextLine();
           if(station2.length()==0)break;
           subway.addConnection(station1,station2, lineName);
           if(reader.hasNext())
           station1=station2;
           else break;

       }
    }

    private void loadStations(Subway subway, Scanner reader) {
        String stationName=reader.nextLine();
        while(reader.hasNext()&&stationName.length()>0){
            subway.addStation(stationName);
            stationName=reader.nextLine();
        }
    }
}
