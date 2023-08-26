package GuitarInventorySystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testing {
    private static void initializeInventory(Inventory inventory) {
        Map<String,Object> properties = new HashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.MAPLE);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(new HashMap<>(properties)));
        //-------------new Instrument
        properties.put("builder", Builder.MARTIN);
        properties.put("model", "D-18");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.ADIRONDACK);
        inventory.addInstrument("122784", 5495.95, new InstrumentSpec(new HashMap<>(properties)));
        //-------------new Instrument
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("topWood", Wood.ALDER);
        properties.put("backWood", Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(new HashMap<>(properties)));
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(new HashMap<>(properties)));

    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);
        Map<String,Object> properties= new HashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.MAPLE);
        InstrumentSpec clientSpec = new InstrumentSpec(properties);
        List<Instrument> matchingInstruments = inventory.search(clientSpec);
        if (!matchingInstruments.isEmpty()) {
            System.out.println("You might like these instruments:");
            for (Instrument matchingInstrument : matchingInstruments) {
                InstrumentSpec spec = matchingInstrument.getInstrumentSpec();
                System.out.println("We have a " + spec.getProperty("instrumentType") + " with the following properties: with serial: "+matchingInstrument.getSerialNumber());
                for (String propertyName : spec.getProperties().keySet()) {
                    if (propertyName.equals("instrumentType"))
                        continue;
                    System.out.println(" " + propertyName + ": " +
                            spec.getProperty(propertyName));
                }
                System.out.println(" You can have this " +
                        spec.getProperty("instrumentType") + " for $" +
                        matchingInstrument.getPrice() + "\n---");
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
    }
}
