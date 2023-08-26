package GuitarInventorySystem;

public enum InstrumentType {
    GUITAR, BANJO, DOBRO, FIDDLE, BASS, MANDOLIN;
    public String toString() {
        return switch (this) {
            case GUITAR -> "Guitar";
            case BANJO -> "Banjo";
            case DOBRO -> "Dobro";
            case FIDDLE -> "Fiddle";
            case BASS -> "Bass";
            case MANDOLIN -> "Mandolin";
            default -> "Unspecified";
        };
    }
}