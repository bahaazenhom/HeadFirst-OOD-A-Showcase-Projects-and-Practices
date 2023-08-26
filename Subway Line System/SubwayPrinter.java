package SubwayLineSystem;

import java.util.List;

public class SubwayPrinter {
    public void printDirections(List<Connection> route) {
        if(route.isEmpty())throw new RuntimeException("There's no route available fot the entered stations or stations entered do not exist on this subway.\n");
        Connection first = route.get(0);
        String currentLine = first.getLineName(), previousLine = first.getLineName();
        System.out.println("Start out at " + first.getStation1().getName() + ".");
        System.out.println("Get on the " + currentLine + " heading towards " + first.getStation2().getName() + ".");
        for (int i = 1; i < route.size(); i++) {
            first = route.get(i);
            currentLine = first.getLineName();
            if (currentLine.equals(previousLine)) {
                System.out.println(" Continue past " + first.getStation1().getName() + "...");
            } else {
                System.out.println("When you get to " + first.getStation1().getName() + ", get off the " + previousLine + ".");
                System.out.println("Switch over to the " + currentLine + ", heading towards " + first.getStation2().getName() + ".");
                previousLine = currentLine;
            }
        }
        System.out.println("Get off at " + first.getStation2().getName() + " and enjoy yourself!");
    }
}
