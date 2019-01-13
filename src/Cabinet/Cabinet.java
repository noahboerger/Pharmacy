package Cabinet;

import Base.Drug;
import Base.Reason;
import Iterator.IIterator;
import Iterator.IteratorAll;
import Iterator.IteratorFx;
import Pharmacy.ICabinetListener;

import java.util.*;

public class Cabinet implements ICabinet {
    private Map<Character, ICubby> cubbyMap;
    private List<ICabinetListener> listeners;


    public Cabinet() {
        listeners = new ArrayList<>();
        cubbyMap = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            cubbyMap.put(c, new Cubby(this));
        }
    }

    @Override
    public ICubby getCubby(char key) {
        return cubbyMap.get(key);
    }

    @Override
    public boolean add(Drug drug) {
        if (drug.getLabel() == null) {
            return false;
        }
        Character key = drug.getLabel().charAt(0);
        return cubbyMap.get(key).add(drug);
    }

    @Override
    public Drug remove(String drugLabel) {
        if (!cubbyMap.containsKey(drugLabel.charAt(0))) {
            return null;
        }
        check();
        return cubbyMap.get(drugLabel.charAt(0)).remove(drugLabel);
    }

    @Override
    public void registerListener(ICabinetListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(ICabinetListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    @Override
    public IIterator iteratorAll() {
        IIterator iteratorAll = new IteratorAll(this);
        return iteratorAll;
    }

    private void informListeners(Reason reason, Object object) {
        for (ICabinetListener listener : listeners) {
            listener.receive(reason, object);
        }
    }

    @Override
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

    @Override
    public void receive(Reason reason, Object object) {
        informListeners(reason, object);
    }

    @Override
    public void check() {
        for (Character key : cubbyMap.keySet()) {
            cubbyMap.get(key).check();
        }
    }
}
