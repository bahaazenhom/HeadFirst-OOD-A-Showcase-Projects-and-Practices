package GuitarInventorySystem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        instruments = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        Instrument instrument = new Instrument(serialNumber, price, instrumentSpec);
        instruments.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        for (Instrument instrument : instruments) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec specs) {
        ArrayList<Instrument> instrumentsNeeded = new ArrayList<>();
        for (Instrument instrument : instruments) {
            InstrumentSpec instrumentSpec = instrument.getInstrumentSpec();
            if (!instrumentSpec.equals(specs)) continue;
            instrumentsNeeded.add(instrument);
        }
        return instrumentsNeeded;
    }

    public int getSize() {
        return instruments.size();
    }
}
