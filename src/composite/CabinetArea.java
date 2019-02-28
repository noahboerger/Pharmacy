package composite;

import base.Reason;
import pharmacy.ICabinetListener;

import java.util.List;

public class CabinetArea extends CabinetUnit {


    public CabinetArea(String unitName) {
        super(unitName);
    }

    @Override
    public void check(List<ICabinetListener> listeners) {
        checkCabinetArea(listeners);
        for (CabinetUnit unit : units) {
            unit.check(listeners);
        }
    }

    private void checkCabinetArea(List<ICabinetListener> listeners) {
        if (units.isEmpty()) {
            for (ICabinetListener listener : listeners) {
                listener.receive(this, Reason.CUBBY_LOWER_50);
            }
            return;
        } else if (units.get(0) instanceof CabinetArea) {
            return;
        } else if (units.size() < 5) {
            for (ICabinetListener listener : listeners) {
                listener.receive(this, Reason.CUBBY_LOWER_50);
            }
        }
        for (CabinetUnit unit : units) {
            DrugUnit drugUnit = (DrugUnit) unit;
            boolean second = false;
            for (CabinetUnit doubleUnit : units) {
                if (doubleUnit != drugUnit && drugUnit.unitName.equals(doubleUnit.unitName)) {
                    second = true;
                }
            }
            if (!second) {
                for (ICabinetListener listener : listeners) {
                    listener.receive(drugUnit, Reason.LAST_ONE);
                }
            }
        }
    }
}

