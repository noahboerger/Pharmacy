package Cabinet;

import Base.Drug;
import Base.Reason;
import Iterator.IIterator;
import Iterator.IteratorFx;

public interface ICubby {
    IIterator iteratorFx();

    boolean add(Drug drug);

    ISubCubby getSubCubby(char key);

    boolean isEmpty();

    Drug remove(String drugLabel);

    void receive(Reason reason, Object object);

    void check();

    int numberOfDrugs();
}
