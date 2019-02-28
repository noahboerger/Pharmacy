import pharmacy.Pharmacy;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.getCabinet().getCabinetRoot().printStructure();

        Iterator it = pharmacy.getCabinet().iteratorAll();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        System.out.println(it.next());
        System.out.println();

        //Entfernen von Medikamenten, um zu testen ob eine Meldung generiert wird, wenn ein Teil des Schrankes schlecht bestückt ist
        for (int i = 0; i < 5; i++) {
            String removal = pharmacy.getCabinet().getCabinetRoot().listUnits().next().listUnits().next().listUnits().next().getUnitName();
            System.out.println("Removing drug: " + removal);

            pharmacy.getCabinet().removeDrugUnit(removal);
        }

        //Die Methode checkCabinet würde man normalerweise direkt beim Einfügen/Entfernen von Medikamenten ausführen, dies würde jedoch zum Testen zu viele Meldungen generieren
        pharmacy.getCabinet().checkCabinet();
    }
}
