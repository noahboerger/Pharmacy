package Pharmacy;

import Cabinet.Reason;

public class Pharmacist implements ICabinetListener {

    String name;

    public Pharmacist(String name) {
        this.name = name;
    }

    @Override
    public void receive(Reason reason) {

    }
}
