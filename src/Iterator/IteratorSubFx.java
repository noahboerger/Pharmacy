package Iterator;

import Cabinet.Cubby;
import Cabinet.Drug;
import Cabinet.SubCubby;

public class IteratorSubFx implements IIterator {
    SubCubby subCubby;
    int actIndex;

    public IteratorSubFx(SubCubby subCubby) {
        this.subCubby = subCubby;
        actIndex = 0;
    }

    @Override
    public void reinitialize() {
        actIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if(subCubby.getDrug(actIndex) != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        if(subCubby.isEmpty()) {
            return null;
        }
        if(!hasNext()) {
            reinitialize();
        }
        actIndex++;
        return subCubby.getDrug(actIndex - 1);
    }
}
