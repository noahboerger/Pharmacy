package Base;

import Iterator.IIterator;
import Pharmacy.Pharmacy;
import Pharmacy.IPharmacy;

public class Main {
    public static void main(String args[]) {


        IPharmacy ph = new Pharmacy("Test");
        IIterator it = ph.getCabinet().iteratorAll();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        ph.getCabinet().check();
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().check();
        System.out.println(ph.getCabinet().getCubby('A').getSubCubby('A'));


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
