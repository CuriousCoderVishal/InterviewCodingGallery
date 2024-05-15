package samples;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class EmployeeImmutable {
    private final int id;
    private final Date dateofJoining;
    private final List<Address> adresses;

    public EmployeeImmutable(int id, Date dateofJoining, List<Address> adresses) {
        this.id = id;
        this.dateofJoining = new Date(dateofJoining.getTime()) ;
        this.adresses =adresses ;
    }

    public Date getDateofJoining() {
        return dateofJoining;
    }

    public List<Address> getAdresses() {
        return Collections.unmodifiableList(adresses);
    }
}
