package pharmacy;

import base.ICabinet;

public interface IPharmacy {
    String getName();

    void setName(String name);

    IPharmacist getPharmacist();

    void setPharmacist(IPharmacist pharmacist);

    ICabinet getCabinet();

    void setCabinet(ICabinet cabinet);
}
