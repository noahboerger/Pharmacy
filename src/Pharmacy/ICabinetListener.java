package Pharmacy;

import Base.Reason;

public interface ICabinetListener {
    void receive(Reason reason, Object object);
}
