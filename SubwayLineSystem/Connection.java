package SubwayLineSystem;

import java.util.Objects;

public class Connection {
    private Station station1,station2;
    private String lineName;
    public Connection(Station station1, Station station2, String lineName){
        this.station1=station1;
        this.station2=station2;
        this.lineName=lineName;
    }
    public Station getStation1(){
        return station1;
    }
    public Station getStation2(){
        return station2;
    }
    public String getLineName(){
        return lineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(station1, that.station1) && Objects.equals(station2, that.station2) && Objects.equals(lineName, that.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station1.hashCode(), station2.hashCode(), lineName);
    }
}
