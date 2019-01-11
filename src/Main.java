import Cabinet.Cabinet;
import Cabinet.Drug;
import Iterator.IIterator;
import Iterator.IteratorSubFx;
import Cabinet.SubCubby;
import Cabinet.Cubby;
import Pharmacy.Pharmacy;

import java.util.Date;

public class Main {
    public static void main(String args[]) {

        Pharmacy ph = new Pharmacy("Test");
        IIterator it = ph.getCabinet().iteratorAll();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        /*Cabinet cabinet = new Cabinet();
        cabinet.add(new Drug("AA293", new Date(1, 2, 3), "Test"));
        cabinet.add(new Drug("AA293", new Date(1, 2, 3), "Test"));
        cabinet.add(new Drug("BC849", new Date(1,1,1), "Test"));

        IIterator iteratortest = cabinet.iteratorAll();
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());*/

        /*Cubby cubby = new Cubby();
        cubby.add(new Drug("AA293", new Date(1, 2, 3), "Test"));
        cubby.add(new Drug("AA293", new Date(1, 2, 3), "Test"));

        IIterator iteratortest = cubby.iteratorFx();
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        */

       /* SubCubby subCubby = new SubCubby();
        subCubby.add(new Drug("AA293", new Date(1, 2, 3), "Test"));
        subCubby.add(new Drug("AA293", new Date(1, 2, 3), "Test"));

        IIterator iteratortest = subCubby.iteratorSubCuby();
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());
        System.out.println(iteratortest.hasNext());
        System.out.println(iteratortest.next());*/

        /*Cabinet cabinet = new Cabinet();
        cabinet.add(new Drug("AA293", new Date(1, 2, 3), "Test"));
        cabinet.add(new Drug("AA293", new Date(1, 2, 6), "Test"));*/
    }
}
