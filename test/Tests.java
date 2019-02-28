import composite.Cabinet;
import composite.DrugUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;

public class Tests {

    @Test
    public void testIteratorAll() {
        //Da der IteratorAll über IteratorFx läuft, werden diese direkt mitgetestet
        //Deshalb sind hier nicht mehr Tests für die Iterator notwendig
        Cabinet cabinet = testCabinet();
        DrugUnit one = testDrugOne();
        DrugUnit two = testDrugTwo();
        cabinet.addDrugUnit(one);
        cabinet.addDrugUnit(two);
        Iterator iterator = cabinet.iteratorAll();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next() == one);
        Assert.assertTrue(iterator.next() == two);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertTrue(iterator.next() == one);
    }

    private Cabinet testCabinet() {
        return new Cabinet();
    }

    private DrugUnit testDrugOne() {
        return new DrugUnit("AA345", new Date(System.currentTimeMillis() + 99999), "Body");
    }

    private DrugUnit testDrugTwo() {
        return new DrugUnit("BB645", new Date(System.currentTimeMillis() + 99999), "Soul");
    }
}