package Test;

import Base.Drug;
import Cabinet.Cabinet;
import Iterator.IIterator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class Tests {

    @Test
    public void testIteratorAll() {
        //Da er über IteratorFx und SubFx läuft, werden diese direkt mitgetestet
        //Deshalb sind hier nicht mehr Tests notwendig
        Cabinet cabinet = testCabinet();
        Drug one = testDrugOne();
        Drug two = testDrugTwo();
        cabinet.add(one);
        cabinet.add(two);
        IIterator iterator = cabinet.iteratorAll();
        if (iterator.hasNext() && iterator.next() == one && iterator.next() == two && !iterator.hasNext() && iterator.next() == one) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    private Cabinet testCabinet() {
        return new Cabinet();
    }

    private Drug testDrugOne() {
        return new Drug("AA345", new Date(System.currentTimeMillis() + 99999), "body");
    }

    private Drug testDrugTwo() {
        return new Drug("AA345", new Date(System.currentTimeMillis() + 99999), "body");
    }
}
