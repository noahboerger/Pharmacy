package composite;

import pharmacy.ICabinetListener;

import java.util.Iterator;

public interface ICabinet {
    CabinetUnit getCabinetRoot();

    boolean addDrugUnit(DrugUnit drugUnit);

    DrugUnit removeDrugUnit(String drugUnitLabel);

    Iterator iteratorAll();

    Iterator iteratorFx(char key);

    void registerListener(ICabinetListener listener);

    void checkCabinet();

    void unregisterListener(ICabinetListener listener);
}
