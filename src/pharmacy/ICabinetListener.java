package pharmacy;

import base.Reason;
import composite.CabinetUnit;

public interface ICabinetListener {
    void receive(CabinetUnit unit, Reason reason);
}
