package GameSystemFramework;

import java.util.*;

public class Unit {
    private String type;
    private int id;
    private String name;
    private List weapons;
    private Map properties;
    public Unit(int id){
        this.id=id;
        weapons=new ArrayList();
        properties=new HashMap();
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }
    public List getWeapons(){
        if(weapons.size()==0)return null;
        return weapons;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public void setProperty(String property, Object value){
        properties.put(property,value);
    }
    public Object getProperty(String property) throws Exception {
        if(properties.size()==0)return null;
        Object value=properties.get(property);
        if(value==null)throw new Exception("Request for non-existent property.");
        else return value;
    }
}
