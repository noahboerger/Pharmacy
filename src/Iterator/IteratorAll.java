package Iterator;

import Cabinet.Cabinet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.List;

public class IteratorAll implements IIterator {
    private Cabinet cabinet;
    private List<IIterator> iteratorFxList;


    private Iterator<IIterator> iteratorFxListIterator;
    private IIterator actFxIterator;

    public IteratorAll(Cabinet cabinet) {
        this.cabinet = cabinet;
        iteratorFxList = new ArrayList<>();

        for (char cubbyKey = 'A'; cubbyKey <= 'Z'; cubbyKey++) {
            iteratorFxList.add(cabinet.getCubby(cubbyKey).iteratorFx());
        }
        iteratorFxListIterator = iteratorFxList.iterator();
        actFxIterator = iteratorFxListIterator.next();
        gotoNext();
    }

    @Override
    public void reinitialize() {
        for (IIterator iteratorFx : iteratorFxList) {
            iteratorFx.reinitialize();
        }
        iteratorFxListIterator = iteratorFxList.iterator();
        actFxIterator = iteratorFxListIterator.next();
        gotoNext();
    }

    @Override
    public boolean hasNext() {
        if (actFxIterator.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean gotoNext() {
        while (!actFxIterator.hasNext() && iteratorFxListIterator.hasNext()) {
            actFxIterator = iteratorFxListIterator.next();
        }
        if (actFxIterator.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        if (cabinet.isEmpty()) {
            return null;
        }
        if (!hasNext()) {
            reinitialize();
        }
        Object next = actFxIterator.next();
        gotoNext();
        return next;

    }
}
