package base;

import composite.CabinetUnit;
import composite.DrugUnit;
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
