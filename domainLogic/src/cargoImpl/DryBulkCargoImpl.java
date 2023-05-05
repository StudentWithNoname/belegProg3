// Version: 1.0
// Date: 2023-04-27
// author: Stefan Ernes;
// description: This class is responsible for the implementation of the DryBulkCargo.
package cargoImpl;

import administration.Customer;
import administration.Storable;
import cargo.DryBulkCargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DryBulkCargoImpl implements DryBulkCargo, Storable {

    private Date lastInspectionDate;

    @Override
    public Customer getOwner() {
        return null;
    }

    @Override
    public Duration getDurationOfStorage() {
        return null;
    }

    @Override
    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    // Methode zum Setzen des letzten Inspektionsdatums, muss hier sein, weil Interface nicht angefasst werden darf!
    public void setLastInspectionDate(Date date) {
        this.lastInspectionDate = date;

    }

    @Override
    public int getStorageLocation() {
        return 0;
    }

    @Override
    public BigDecimal getValue() {
        return null;
    }

    @Override
    public Collection<Hazard> getHazards() {
        return null;
    }

    @Override
    public int getGrainSize() {
        return 0;
    }
}
