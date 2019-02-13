import java.util.Objects;

public class StaffID {

    // attribute of the class StaffID

    private int employeeID;


    //constructor

    public StaffID(int employeeID) {

        this.employeeID = employeeID;
    }


    // create getters


    public int getEmployeeID() {

        return this.employeeID;
    }

    // create setters

    public void setEmployeeID(int newEmployeeID) {
        this.employeeID = newEmployeeID;
    }


    // Override to access staff ID equal employeeID (implement parent class) and to detect duplicates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffID staffID = (StaffID) o;
        return employeeID == staffID.employeeID;
    }
}