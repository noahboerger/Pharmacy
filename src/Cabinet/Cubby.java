package Cabinet;

import Iterator.IIterator;
import Iterator.IteratorFx;
import Iterator.IteratorSubFx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cubby {
    Map<Character, SubCubby> subCubbyMap;
    Cabinet listener;

    public Cubby(Cabinet cabinet) {
        subCubbyMap = new HashMap();
        for (char c = 'A'; c <= 'Z'; c++) {
            subCubbyMap.put(c, new SubCubby(this));
        }
        listener = cabinet;
    }

    public IIterator iteratorFx() {
        return new IteratorFx(this);
    }

    public boolean add(Drug drug) {
        Character key = drug.getLabel().charAt(1);
        return subCubbyMap.get(key).add(drug);
    }

    public SubCubby getSubCubby(char key) {
        return subCubbyMap.get(key);
    }

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

    public Drug remove(String drugLabel) {
        if (!subCubbyMap.containsKey(drugLabel.charAt(1))) {
            return null;
        }
        return subCubbyMap.get(drugLabel.charAt(0)).remove(drugLabel);
    }

    public void receive(Reason reason, Object object) {
        listener.receive(reason, object);
    }

    public void check() {
        for(Character key: subCubbyMap.keySet()) {
            subCubbyMap.get(key).check();
        }
        checkCubby();
    }

    private void checkCubby() {
        if(numberOfDrugs() < 130) {
            listener.receive(Reason.CUBBY_LOWER_50, this);
        }
    }

    public int numberOfDrugs() {
        int numberOfDrugs = 0;
        for(Character key: subCubbyMap.keySet()) {
            numberOfDrugs += subCubbyMap.get(key).numberOfDrugs();
        }
        return numberOfDrugs;
    }
}
