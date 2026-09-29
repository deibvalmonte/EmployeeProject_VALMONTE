package version6;

import java.util.Locale;

public final class Name implements Cloneable {
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
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.firstName = firstName.trim();
    }

    public String getMiddleName() {
        return middleName == null ? "" : middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? "" : middleName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.lastName = lastName.trim();
    }

    public String getSuffix() {
        return suffix == null ? "" : suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? "" : suffix.trim();
    }

    public String getMiddleInitial() {
        if (middleName == null || middleName.trim().isEmpty()) {
            return "";
        }
        return middleName.trim().substring(0, 1).toUpperCase(Locale.ROOT) + ".";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        sb.append(", ");
        sb.append(firstName);
        if (!middleName.isBlank()) {
            sb.append(" ").append(getMiddleInitial());
        }
        if (!suffix.isBlank()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
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
