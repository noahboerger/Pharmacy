package iterator;

import composite.CabinetUnit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorAll implements Iterator {
    private CabinetUnit unit;
    private Iterator<Iterator> fxIteratorIterator;
    private Iterator actFxIterator;

    public IteratorAll(CabinetUnit unit) {
        this.unit = unit;
        reinitialize();
    }

    @Override
    public boolean hasNext() {
        return actFxIterator.hasNext();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            reinitialize();
        }
        Object next = actFxIterator.next();
        gotoNext();
        return next;
    }

    private boolean gotoNext() {
        while (!actFxIterator.hasNext() && fxIteratorIterator.hasNext()) {
            actFxIterator = fxIteratorIterator.next();
        }
        return actFxIterator.hasNext();
    }

    private void reinitialize() {
        List<Iterator> subIteratorList = new ArrayList<>();
        Iterator iteratorSub = unit.listUnits();
        while (iteratorSub.hasNext()) {
            subIteratorList.add((new IteratorFx((CabinetUnit) iteratorSub.next())));
        }
        fxIteratorIterator = subIteratorList.iterator();
        actFxIterator = fxIteratorIterator.next();
        gotoNext();
    }
}
