package Class;

import Interfaces.IClone;

public class Headquarters implements IClone {
    private String name;
    private String address;
    private int capacity;
    private int headquartersId;

    public Headquarters() {
    }
    
    public Headquarters(String name, String address, int capacity ,int headquartersId){
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.headquartersId = headquartersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHeadquartersId() {
        return headquartersId;
    }

    public void setHeadquartersId(int headquartersId) {
        this.headquartersId = headquartersId;
    }

    @Override
    public IClone clone() {
        IClone headquarters = new Headquarters(this.name, this.address, this.capacity, this.headquartersId);
        return headquarters;
    }

}
