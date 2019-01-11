package Cabinet;

import Iterator.IIterator;
import Iterator.IteratorAll;
import Iterator.IteratorFx;
import Pharmacy.ICabinetListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cabinet {
    //Hat cubys
    Map<Character, Cubby> cubbyMap;
    List<ICabinetListener> listeners;


    public Cabinet() {
        listeners = new ArrayList<>();
        cubbyMap = new HashMap();
        for (char c = 'A'; c <= 'Z'; c++) {
            cubbyMap.put(c, new Cubby());
        }
    }

    public Cubby getCubby(char key) {
        return cubbyMap.get(key);
    }

    public boolean add(Drug drug) {
        if (drug.label == null) {
            return false;
        }
        Character key = drug.getLabel().charAt(0);
        return cubbyMap.get(key).add(drug);
    }

    public void remove(Drug drug) {

    }

    public void registerListener(ICabinetListener listener) {
        listeners.add(listener);
    }

    public void unregisterListener(ICabinetListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public IIterator iteratorAll() {
        IIterator iteratorAll = new IteratorAll(this);
        return iteratorAll;
    }

    public IIterator iteratorFx(char cubbyLabel) {
        if (!cubbyMap.containsKey(cubbyLabel)) {
            return null;
        }
        IIterator iteratorFx = new IteratorFx(cubbyMap.get(cubbyLabel));
        return iteratorFx;
    }

    private void informListeners(Reason reason) {
        for (ICabinetListener listener : listeners) {
            listener.receive(reason);
        }
    }

    public boolean isEmpty() {
        if (cubbyMap.isEmpty()) {
            return true;
        }
        for (Character key : cubbyMap.keySet()) {
            if (!cubbyMap.get(key).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
