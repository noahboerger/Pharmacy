package composite;

import pharmacy.ICabinetListener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class CabinetUnit {
    private int indentDepth = 0;
    protected String unitName;
    private CabinetUnit parentUnit;
    protected List<CabinetUnit> units;


    public CabinetUnit(String unitName) {
        this.units = new ArrayList<>();
        this.unitName = unitName;
    }

    public abstract void check(List<ICabinetListener> listeners);

    public List<CabinetUnit> getUnits() {
        return units;
    }

    public String getUnitName() {
        return unitName;
    }

    public void addUnit(CabinetUnit cabinetUnit) {
        cabinetUnit.parentUnit = this;
        cabinetUnit.indentDepth = indentDepth + 1;
        units.add(cabinetUnit);

    }

    public boolean isEmpty() {
        for (CabinetUnit unit : units) {
            if (!unit.isEmpty() || unit instanceof DrugUnit) {
                return false;
            }
        }
        return true;
    }

    public final boolean isLastOne() {
        return units == null || units.isEmpty();
    }

    public final ListIterator<CabinetUnit> listUnits() {
        return units.listIterator();
    }

    protected String indent(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        do {
            stringBuilder.append("+ ");
        } while (depth-- > 0);

        return stringBuilder.toString();
    }

    public final void printStructure() {
        System.out.println(indent(indentDepth) + unitName +
                (isLastOne() ? " (leaf)" : " (node)"));
        for (CabinetUnit area : units) {
            area.indentDepth = indentDepth + 1;
            area.printStructure();
        }
    }

    public String getSuperiorUnit() {
        String parent;

        if (parentUnit == null)
            parent = "--- top level unit";
        else
            parent = this.parentUnit.unitName;

        return parent;
    }

    public void printStaffingInformation() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Unit name: ").append(this.unitName).append("\n");
        stringBuilder.append("Superior unit: ").append(getSuperiorUnit());

        if (!isLastOne()) {
            for (CabinetUnit cabinetUnit : units)
                cabinetUnit.printStaffingInformation();
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(unitName);
        CabinetUnit upUnit = this;
        while (upUnit.parentUnit != null) {
            upUnit = upUnit.parentUnit;
            stringBuilder.insert(0, upUnit.unitName);
        }
        return stringBuilder.toString();
    }
}