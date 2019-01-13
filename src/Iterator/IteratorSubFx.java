package Iterator;

import Cabinet.ISubCubby;

public class IteratorSubFx implements IIterator {
    private ISubCubby subCubby;
    private int actIndex;

    public IteratorSubFx(ISubCubby subCubby) {
        this.subCubby = subCubby;
        actIndex = 0;
    }

    @Override
    public void reinitialize() {
        actIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if (subCubby.getDrug(actIndex) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        if (subCubby.isEmpty()) {
            return null;
        }
        if (!hasNext()) {
            reinitialize();
        }
        actIndex++;
        return subCubby.getDrug(actIndex - 1);
    }
}
