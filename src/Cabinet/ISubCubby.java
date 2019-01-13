package Cabinet;

import Base.Drug;
import Base.Reason;
import Iterator.IIterator;
import Iterator.IteratorSubFx;

import java.util.Arrays;

public interface ISubCubby {
    void check();

    boolean add(Drug drug);

    Drug getDrug(int index);

    Drug removeDrug(int index);

    boolean isEmpty();

    int numberOfDrugs();

    IIterator iteratorSubCuby();

    Drug remove(String drugLabel);
}
