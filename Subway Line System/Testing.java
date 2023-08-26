package SubwayLineSystem;

import java.io.File;
import java.io.FileNotFoundException;

public class Testing {
    public static void main(String[] argus) throws FileNotFoundException {
        SubwayLoader loader=new SubwayLoader();
        Subway subway=loader.loadFromFile(new File("input.txt"));
        SubwayPrinter printer=new SubwayPrinter();
        printer.printDirections(subway.getDirections("Ajax Rapids","Objectville PizzaStore"));
    }
}
