package GameSystemFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitGroup {
    private Map<Integer,Unit> units;
    public UnitGroup(List<Unit> unitList){
        units=new HashMap();
        for(Unit unit:unitList)units.put(unit.getId(),unit);
    }
    public void addUnits(Unit unit){
        units.put(unit.getId(),unit);
    }
    public Unit getUnit(int id){
        return units.get(id);
    }
    public Unit getUnit(Unit unit){
        return units.get(unit.getId());
    }
    public void removeUnit(int id){
        units.remove(id);
    }
    public void removeUnit(Unit unit) {
        units.remove(unit.getId());
    }
    public List<Unit> getUnits(){
        List<Unit> unitsList=new ArrayList<>();
        for(Unit unit:units.values())unitsList.add(unit);
        return unitsList;
    }
    public int getNumberOfUnits(){
        return units.size();
    }
}
