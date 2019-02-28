package iterator;

import composite.CabinetUnit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorFx implements Iterator {

    //Notwendig da dieser direkt durch die Letzte Liste iterrieren muss

    private CabinetUnit unit;
    private Iterator<Iterator> subIteratorIterator;
    private Iterator actSubIterator;

    public IteratorFx(CabinetUnit unit) {
        this.unit = unit;
        reinitialize();
    }

    @Override
    public boolean hasNext() {
        return actSubIterator.hasNext();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            reinitialize();
        }
        Object next = actSubIterator.next();
        gotoNext();
        return next;
    }

    private boolean gotoNext() {
        while (!actSubIterator.hasNext() && subIteratorIterator.hasNext()) {
            actSubIterator = subIteratorIterator.next();
        }
        return actSubIterator.hasNext();
    }

    private void reinitialize() {
        List<Iterator> subIteratorList = new ArrayList<>();
        Iterator iteratorSub = unit.listUnits();
        while (iteratorSub.hasNext()) {
            subIteratorList.add(((CabinetUnit) iteratorSub.next()).listUnits());
        }
        subIteratorIterator = subIteratorList.iterator();
        actSubIterator = subIteratorIterator.next();
        gotoNext();
    }
}
