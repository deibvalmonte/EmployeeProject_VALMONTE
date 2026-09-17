package version4;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("N/A", "N/A", "N/A", "");
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
        this.firstName = (firstName != null && !firstName.trim().isEmpty()) ? firstName.trim() : "N/A";
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName != null) ? middleName.trim() : "";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName != null && !lastName.trim().isEmpty()) ? lastName.trim() : "N/A";
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = (suffix != null) ? suffix.trim() : "";
    }

    public void displayName() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(", ").append(firstName);

        if (middleName != null && !middleName.isEmpty() && !middleName.equalsIgnoreCase("N/A")) {
            sb.append(" ").append(Character.toUpperCase(middleName.charAt(0))).append(".");
        }

        if (suffix != null && !suffix.isEmpty()) {
            sb.append(" ").append(suffix);
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name name = (Name) obj;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(middleName, name.middleName) &&
                Objects.equals(lastName, name.lastName) &&
                Objects.equals(suffix, name.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Name(firstName, middleName, lastName, suffix);
        }
    }
}
