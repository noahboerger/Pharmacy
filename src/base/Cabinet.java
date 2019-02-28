package base;

import composite.CabinetArea;
import composite.CabinetUnit;
import composite.DrugUnit;
import iterator.IteratorAll;
import iterator.IteratorFx;
import pharmacy.ICabinetListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cabinet implements ICabinet {
    private CabinetUnit cabinetRoot;
    private List<ICabinetListener> listeners;

    public Cabinet() {
        cabinetRoot = new CabinetArea("Cabinet");
        for (char drugLabel0 = 'A'; drugLabel0 <= 'Z'; drugLabel0++) {
            CabinetUnit cabinetCubby = new CabinetArea(drugLabel0 + "");
            cabinetRoot.addUnit(cabinetCubby);
            for (char druglabel1 = 'A'; druglabel1 <= 'Z'; druglabel1++) {
                CabinetUnit cabinetSubCubby = new CabinetArea(druglabel1 + "");
                cabinetCubby.addUnit(cabinetSubCubby);
            }
        }
        listeners = new ArrayList<>();
    }

    @Override
    public CabinetUnit getCabinetRoot() {
        return cabinetRoot;
    }

    @Override
    public boolean addDrugUnit(DrugUnit drugUnit) {
        for (CabinetUnit cubby : cabinetRoot.getUnits()) {
            if (cubby.getUnitName().equals(drugUnit.getUnitName().charAt(0) + "")) {
                for (CabinetUnit subCubby : cubby.getUnits()) {
                    if (subCubby.getUnitName().equals(drugUnit.getUnitName().charAt(1) + "")) {
                        if (subCubby.getUnits().size() < 10) {
                            subCubby.addUnit(drugUnit);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public DrugUnit removeDrugUnit(String drugUnitLabel) {
        for (CabinetUnit cubby : cabinetRoot.getUnits()) {
            if (cubby.getUnitName().equals(drugUnitLabel.charAt(0) + "")) {
                for (CabinetUnit subCubby : cubby.getUnits()) {
                    if (subCubby.getUnitName().equals(drugUnitLabel.charAt(1) + ""))
                        for (CabinetUnit drugUnit : subCubby.getUnits()) {
                            if (drugUnit.getUnitName().equals(drugUnitLabel)) {
                                DrugUnit removeDrugUnit = (DrugUnit) drugUnit;
                                subCubby.getUnits().remove(removeDrugUnit);
                                return (DrugUnit) drugUnit;
                            }
                        }
                }
            }
        }
        return null;
    }

    @Override
    public Iterator iteratorAll() {
        return new IteratorAll(cabinetRoot);
    }

    @Override
    public Iterator iteratorFx(char key) {
        for (CabinetUnit cubby : cabinetRoot.getUnits()) {
            if (cubby.getUnitName().equals(key + "")) {
                return new IteratorFx(cubby);
            }
        }
        return null;
    }

    @Override
    public void registerListener(ICabinetListener listener) {
        listeners.add(listener);
    }

    @Override
    public void checkCabinet() {
        cabinetRoot.check(listeners);
    }

    @Override
    public void unregisterListener(ICabinetListener listener) {
        listeners.remove(listener);
    }
}
