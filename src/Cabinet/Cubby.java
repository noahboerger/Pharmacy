package Cabinet;

import Base.Drug;
import Base.Reason;
import Iterator.IIterator;
import Iterator.IteratorFx;

import java.util.HashMap;
import java.util.Map;

public class Cubby implements ICubby {
    private Map<Character, ISubCubby> subCubbyMap;
    private Cabinet listener;

    public Cubby(Cabinet cabinet) {
        subCubbyMap = new HashMap();
        for (char c = 'A'; c <= 'Z'; c++) {
            subCubbyMap.put(c, new SubCubby(this));
        }
        listener = cabinet;
    }

    @Override
    public IIterator iteratorFx() {
        return new IteratorFx(this);
    }

    @Override
    public boolean add(Drug drug) {
        Character key = drug.getLabel().charAt(1);
        return subCubbyMap.get(key).add(drug);
    }

    @Override
    public ISubCubby getSubCubby(char key) {
        return subCubbyMap.get(key);
    }

    @Override
    public boolean isEmpty() {
        if (subCubbyMap.isEmpty()) {
            return true;
        }
        for (Character key : subCubbyMap.keySet()) {
            if (!subCubbyMap.get(key).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Drug remove(String drugLabel) {
        if (!subCubbyMap.containsKey(drugLabel.charAt(1))) {
            return null;
        }
        return subCubbyMap.get(drugLabel.charAt(0)).remove(drugLabel);
    }

    @Override
    public void receive(Reason reason, Object object) {
        listener.receive(reason, object);
    }

    @Override
    public void check() {
        for (Character key : subCubbyMap.keySet()) {
            subCubbyMap.get(key).check();
        }
        checkCubby();
    }

    private void checkCubby() {
        if (numberOfDrugs() < 130) {
            listener.receive(Reason.CUBBY_LOWER_50, this);
        }
    }

    @Override
    public int numberOfDrugs() {
        int numberOfDrugs = 0;
        for (Character key : subCubbyMap.keySet()) {
            numberOfDrugs += subCubbyMap.get(key).numberOfDrugs();
        }
        return numberOfDrugs;
    }
}
