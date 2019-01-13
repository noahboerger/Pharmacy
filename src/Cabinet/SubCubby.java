package Cabinet;

import Base.Drug;
import Base.Reason;
import Iterator.IIterator;
import Iterator.IteratorSubFx;

import java.util.*;

public class SubCubby implements ISubCubby {
    Drug[] drugs;
    Cubby listeners;


    public SubCubby(Cubby cubby) {
        drugs = new Drug[10];
        listeners = cubby;
    }

    public void check() {
        checkDoubleDrugs();
        checkDates();
        checkSubCubby();
    }

    private void checkSubCubby() {
        if(drugs[4] == null) {
            informListener(Reason.SUB_CUBBY_LOWER_50, this);
        }
    }

    private void checkDoubleDrugs() {
        if(numberOfDrugs() == 0) {
            return;
        }
        String actDrugLabel = drugs[0].getLabel();
        boolean second = false;
        for (int i = 1; i < numberOfDrugs(); i++) {
            if(actDrugLabel.equals(drugs[i].getLabel())) {
                second = true;
            } else {
                if(second) {
                    second = false;
                    actDrugLabel = drugs[i].getLabel();
                } else {
                    informListener(Reason.LAST_ONE, drugs[i - 1]);
                }
            }
        }
    }

    private void checkDates() {
        for(Drug drug : drugs) {
            if(drug == null) {
                break;
            }
            if(!drug.checkExpirationDate()) {
                informListener(Reason.EXPIRATION_DATE, drug);
            }
        }
    }

    private void informListener(Reason reason, Object object) {
        listeners.receive(reason, object);
    }

    public boolean add(Drug drug) {
        for (int i = 0; i < drugs.length; i++) {
            if (drugs[i] == null) {
                drugs[i] = drug;
                sort();
                return true;
            }
        }
        return false;
    }

    public Drug getDrug(int index) {
        if (index >= 0 && index <= 9) {
            return drugs[index];
        } else {
            return null;
        }
    }

    public Drug removeDrug(int index) {
        if (index >= 0 && index <= 9) {
            Drug removeDrug = drugs[index];
            drugs[index] = null;
            sort();
            return removeDrug;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (drugs[0] == null) {
            return true;
        }
        return false;
    }


    private void sort() {
       for(int i = 0; i < drugs.length; i++) {
           if(drugs[i] == null) {
               for(int j = (i + 1); j < drugs.length; j++) {
                   drugs[j - 1] = drugs[j];
               }
           }
       }
       Drug[] sorted = new Drug[numberOfDrugs()];
       for(int i = 0; i < sorted.length; i++) {
           sorted[i] = drugs[i];
       }
       Arrays.sort(sorted);
        for(int i = 0; i < sorted.length; i++) {
            drugs[i] = sorted[i];
        }
    }

    public int numberOfDrugs() {
        for(int i = 0; i < drugs.length;i++) {
            if(drugs[i] == null) {
                return i;
            }
        }
        return 10;
    }

    public IIterator iteratorSubCuby() {
        return new IteratorSubFx(this);
    }

    public Drug remove(String drugLabel) {
        for (int i = 0; i < drugs.length; i++) {
            if (drugs[i].getLabel() == drugLabel) {
                Drug returnDrug = drugs[i];
                drugs[i] = null;
                sort();
                return returnDrug;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(drugs);
    }
}
