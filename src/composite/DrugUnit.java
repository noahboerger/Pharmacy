package composite;

import base.Reason;
import pharmacy.ICabinetListener;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DrugUnit extends CabinetUnit {

    private UUID id;
    private Date expirationDate;
    private String category;

    public DrugUnit(String unitName, Date expirationDate, String category) {
        super(unitName);
        this.expirationDate = expirationDate;
        this.category = category;
        id = UUID.randomUUID();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return super.unitName;
    }

    @Override
    public String toString() {
        return "Drug[id=" + id + " label=" + super.unitName + " expirationDate=" + expirationDate + " category=" + category + "]";
    }

    @Override
    public void check(List<ICabinetListener> listeners) {
        if (expirationDate.before(new Date(System.currentTimeMillis()))) {
            for (ICabinetListener listener : listeners) {
                listener.receive(this, Reason.EXPIRATION_DATE);
            }
        }
    }
}
