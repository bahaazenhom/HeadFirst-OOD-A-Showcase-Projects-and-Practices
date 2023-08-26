package GuitarInventorySystem;

import java.util.Map;
import java.util.Objects;

public class InstrumentSpec {
    private final Map<String,Object> properties;
    public InstrumentSpec(Map<String,Object> properties){
        this.properties=properties;
    }
    public Object getProperty(String propertyName){
        return properties.get(propertyName);
    }
    public Map<String,Object> getProperties(){
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentSpec that = (InstrumentSpec) o;
        return Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(properties);
    }
}
