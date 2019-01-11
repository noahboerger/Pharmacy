package Cabinet;

import Iterator.IIterator;
import Iterator.IteratorSubFx;

import java.util.*;

public class SubCubby {
    Drug[] drugs;


    public SubCubby() {
        drugs = new Drug[10];
    }

    public boolean add(Drug drug) {
        for (int i = 0; i < drugs.length; i++) {
            if (drugs[i] == null) {
                drugs[i] = drug;
                return true;
            }
        }
        return false;
    }

    public Drug getDrug(int index) {
        if (index >= 0 && index <= 9) {
            return drugs[index];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (drugs[0] == null) {
            return true;
        }
        return false;
    }


    private void sort() {
        Arrays.sort(drugs);
    }
    public IIterator iteratorSubCuby() {
        return new IteratorSubFx(this);
    }
}
