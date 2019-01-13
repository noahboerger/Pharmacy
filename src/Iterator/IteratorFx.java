package Iterator;

import Cabinet.ICubby;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorFx implements IIterator {
    ICubby cubby;
    List<IIterator> iteratorSubFxList;


    Iterator<IIterator> iteratorSubFxListIterator;
    IIterator actSubFxIterator;

    public IteratorFx(ICubby cubby) {
        this.cubby = cubby;
        iteratorSubFxList = new ArrayList<>();

        for (char subCubbyKey = 'A'; subCubbyKey <= 'Z'; subCubbyKey++) {
            iteratorSubFxList.add(cubby.getSubCubby(subCubbyKey).iteratorSubCuby());
        }
        iteratorSubFxListIterator = iteratorSubFxList.iterator();
        actSubFxIterator = iteratorSubFxListIterator.next();
        gotoNext();
    }

    @Override
    public void reinitialize() {
        for (IIterator iteratorSubFx : iteratorSubFxList) {
            iteratorSubFx.reinitialize();
        }
        iteratorSubFxListIterator = iteratorSubFxList.iterator();
        actSubFxIterator = iteratorSubFxListIterator.next();
        gotoNext();
    }

    @Override
    public boolean hasNext() {
        if (actSubFxIterator.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean gotoNext() {
        while (!actSubFxIterator.hasNext() && iteratorSubFxListIterator.hasNext()) {
            actSubFxIterator = iteratorSubFxListIterator.next();
        }
        if (actSubFxIterator.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        if (cubby.isEmpty()) {
            return null;
        }
        if(!hasNext()) {
            reinitialize();
        }
            Object next = actSubFxIterator.next();
            gotoNext();
            return next;

    }
}
