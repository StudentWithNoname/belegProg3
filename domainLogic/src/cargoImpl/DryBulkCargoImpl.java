// Version: 1.0
// Date: 2023-04-27
// author: Stefan Ernes;
// description: This class is responsible for the implementation of the DryBulkCargo.
package cargoImpl;

import administration.Customer;
import administration.Storable;
import administration.Storage;
import cargo.DryBulkCargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Date;

public class DryBulkCargoImpl implements DryBulkCargo, Storable {
    private final Customer owner;

    public Date getEingelagertAm() {
        return eingelagertAm;
    }

    private Date eingelagertAm;
    private Date lastInspectionDate;
    private int storageLocation;
    private final BigDecimal value;
    private final Collection<Hazard> hazards;
    private final int grainSize;
    private Duration durationOfStorage;

    public DryBulkCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, int grainSize) {
        this.owner = owner;
        this.eingelagertAm = new Date();
        this.storageLocation = Storage.getKapazitaet();
        this.value = value;
        this.hazards = hazards;
        this.grainSize = grainSize;
        this.durationOfStorage = durationOfStorage;
    }

    /*public DryBulkCargoImpl(Customer owner, int storageLocation, BigDecimal value, Collection<Hazard> hazards, int grainSize, Duration durationOfStorage) {
        this.owner = owner;
        this.storageLocation = storageLocation;
        this.value = value;
        this.hazards = hazards;
        this.grainSize = grainSize;
        this.durationOfStorage = durationOfStorage;
    }*/


    @Override
    public Customer getOwner() {
        return owner;
    }

    @Override
    public Duration getDurationOfStorage() {
        return Duration.between((Temporal) eingelagertAm, (Temporal) lastInspectionDate);
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
        return storageLocation;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public Collection<Hazard> getHazards() {
        return hazards;
    }

    @Override
    public int getGrainSize() {
        return 0;
    }
}
