package pharmacy;

import base.Reason;
import composite.CabinetUnit;

public class Pharmacist implements ICabinetListener, IPharmacist {

    private String name;

    public Pharmacist(String name) {
        this.name = name;
    }

    @Override
    public void receive(CabinetUnit unit, Reason reason) {
        System.out.println("Received=(" + reason + " " + unit + ")");
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
