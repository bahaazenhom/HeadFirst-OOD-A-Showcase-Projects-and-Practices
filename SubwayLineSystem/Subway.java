package SubwayLineSystem;
import java.util.*;
public class Subway {
    private List<Station> stations;
    private List<Connection> connections;
    private Map<Station,Set<Connection>> network;
    public Subway(){
        this.stations=new ArrayList<>();
        this.connections=new ArrayList<>();
        this.network=new HashMap<>();
    }
    public void addStation(String station){
        if(!hasStation(station)) stations.add(new Station(station));
    }
    public boolean hasStation(String name){
        return stations.contains(new Station(name));
    }
    public void addConnection(String station1, String station2, String lineName){
        if(this.hasStation(station1)&&this.hasStation(station2)){
            connections.add(new Connection(new Station(station1),new Station(station2),lineName));
            connections.add(new Connection(new Station(station2),new Station(station1),lineName));
            addToNetwork(new Station(station1), new Station(station2),lineName);
            addToNetwork(new Station(station2), new Station(station1),lineName);
        }
        else throw new RuntimeException("Invalid connection!");
    }
    public void addToNetwork(Station station1, Station station2,String lineName){
        if(network.containsKey(station1))network.get(station1).add(new Connection(station1,station2,lineName));
        else{
            network.put(station1,new HashSet<>());
            network.get(station1).add(new Connection(station1,station2,lineName));
        }
    }
    private List<Connection> minRoute=new ArrayList<>();
    public List<Connection> getDirections(String station1, String station2){
        if(!hasStation(station1)||!hasStation(station2))throw new RuntimeException("There's no route available fot the entered stations or stations entered do not exist on this subway.");
        getRoutes(station1,station2);
        return minRoute;
    }
    private List<Connection> route=new ArrayList<>();
    private HashSet<Station> visitedStations=new HashSet<>();
    private int min=Integer.MAX_VALUE;

    private void getRoutes(String station1, String station2) {
        Station current= new Station(station1),end=new Station(station2);
        Set<Connection> neighbours=network.get(current);
        visitedStations.add(current);
        for(Connection station:neighbours){
            if(visitedStations.contains(station.getStation2()))continue;
            if(station.getStation2().equals(end)){
                route.add(new Connection(current,station.getStation2(),station.getLineName()));
                if(route.size()<min){
                    min=route.size();
                    minRoute=new ArrayList<>(route);
                }
                route.remove(route.size()-1);
                return;
            }
            else{
               route.add(new Connection(current,station.getStation2(),station.getLineName()));
               getRoutes(station.getStation2().getName(),station2);
               route.remove(route.size()-1);
               visitedStations.remove(station.getStation2());
            }

        }
    }

    public boolean hasConnection(String station1,String station2,String lineName){
        return connections.contains(new Connection(new Station(station1),new Station(station2),lineName));
    }
    public List<Connection> getConnections(){
        return connections;
    }
    public List<Station> getStations(){
        return stations;
    }
    public Map<Station,Set<Connection>> getNetwork(){
        return network;
    }

}
