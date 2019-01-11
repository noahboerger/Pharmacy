package Iterator;

public interface IIterator {
    boolean hasNext();

    Object next();

    public void reinitialize();
}
