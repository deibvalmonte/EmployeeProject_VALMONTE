package version3;

import java.util.Locale;
import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("N/A", "", "N/A", "");
    }

    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName == null || firstName.trim().isEmpty()) ? "N/A" : firstName.trim();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null) ? "" : middleName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName == null || lastName.trim().isEmpty()) ? "N/A" : lastName.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }

    public String getMiddleInitial() {
        if (middleName == null || middleName.isBlank()) return "";
        return middleName.trim().substring(0, 1).toUpperCase() + ".";
    }

    public void displayName() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName == null || lastName.isBlank() ? "N/A" : lastName);
        sb.append(", ");
        sb.append(firstName == null || firstName.isBlank() ? "N/A" : firstName);
        if (middleName != null && !middleName.isBlank()) {
            sb.append(" ").append(getMiddleInitial());
        }
        if (suffix != null && !suffix.isBlank()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name other = (Name) obj;
        return equalsIgnoreCaseOrNull(firstName, other.firstName)
                && equalsIgnoreCaseOrNull(middleName, other.middleName)
                && equalsIgnoreCaseOrNull(lastName, other.lastName)
                && equalsIgnoreCaseOrNull(suffix, other.suffix);
    }

    private boolean equalsIgnoreCaseOrNull(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equalsIgnoreCase(b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName == null ? null : firstName.toLowerCase(Locale.ROOT),
                middleName == null ? null : middleName.toLowerCase(Locale.ROOT),
                lastName == null ? null : lastName.toLowerCase(Locale.ROOT),
                suffix == null ? null : suffix.toLowerCase(Locale.ROOT)
        );
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

