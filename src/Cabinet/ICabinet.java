package Cabinet;

import Base.Drug;
import Base.Reason;
import Iterator.IIterator;
import Iterator.IteratorAll;
import Iterator.IteratorFx;
import Pharmacy.ICabinetListener;

public interface ICabinet {
    ICubby getCubby(char key);

    boolean add(Drug drug);

    Drug remove(String drugLabel);

    void registerListener(ICabinetListener listener);

    void unregisterListener(ICabinetListener listener);

    IIterator iteratorAll();

    IIterator iteratorFx(char cubbyLabel);


    boolean isEmpty();

    void receive(Reason reason, Object object);

    void check();

}
