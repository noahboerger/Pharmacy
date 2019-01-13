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
        System.out.println();
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().getCubby('A').getSubCubby('A').removeDrug(0);
        ph.getCabinet().check();
        System.out.println(ph.getCabinet().getCubby('A').getSubCubby('A'));
    }
}
