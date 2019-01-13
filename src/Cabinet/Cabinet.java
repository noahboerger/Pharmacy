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

    public ICubby getCubby(char key) {
        return cubbyMap.get(key);
    }

    public boolean add(Drug drug) {
        if (drug.getLabel() == null) {
            return false;
        }
        Character key = drug.getLabel().charAt(0);
        return cubbyMap.get(key).add(drug);
    }

    public Drug remove(String drugLabel) {
        if(!cubbyMap.containsKey(drugLabel.charAt(0))) {
            return null;
        }
        check();
        return cubbyMap.get(drugLabel.charAt(0)).remove(drugLabel);
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

    private void informListeners(Reason reason, Object object) {
        for (ICabinetListener listener : listeners) {
            listener.receive(reason, object);
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

    public void receive(Reason reason, Object object) {
        informListeners(reason, object);
    }

    public void check() {
        for(Character key: cubbyMap.keySet()) {
            cubbyMap.get(key).check();
        }
    }
}
