package Cabinet;

import Iterator.IIterator;
import Iterator.IteratorFx;
import Iterator.IteratorSubFx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cubby {
    Map<Character, SubCubby> subCubbyMap;

    public Cubby() {
        subCubbyMap = new HashMap();
        for (char c = 'A'; c <= 'Z'; c++) {
            subCubbyMap.put(c, new SubCubby());
        }
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
        if(subCubbyMap.isEmpty()) {
            return true;
        }
        for(Character key: subCubbyMap.keySet()) {
            if(!subCubbyMap.get(key).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
