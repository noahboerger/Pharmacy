package Pharmacy;

import Base.Reason;

public class Pharmacist implements ICabinetListener, IPharmacist {

    private String name;

    public Pharmacist(String name) {
        this.name = name;
    }

    @Override
    public void receive(Reason reason, Object object) {
        System.out.println("Received=(" + reason + " " + object + ")");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
