package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("N/A", null, "N/A", null);
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, null);
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName == null ? "N/A" : firstName;
        this.middleName = middleName;
        this.lastName = lastName == null ? "N/A" : lastName;
        this.suffix = suffix;
    }

    public static Name fromFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            return new Name("N/A", null, "N/A", null);
        }

        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) {
            return new Name(parts[0], null, "N/A", null);
        }

        if (parts.length == 2) {
            return new Name(parts[0], null, parts[1], null);
        }

        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        String middle = String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length - 1));
        return new Name(firstName, middle, lastName, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "N/A" : firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "N/A" : lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMiddleInitial() {
        if (middleName == null || middleName.isBlank()) {
            return "";
        }

        String trimmed = middleName.trim();
        return trimmed.length() == 1 ? trimmed + "." : trimmed.substring(0, 1) + ".";
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(lastName == null || lastName.isBlank() ? "N/A" : lastName);
        output.append(", ");
        output.append(firstName == null || firstName.isBlank() ? "N/A" : firstName);

        if (middleName != null && !middleName.isBlank()) {
            output.append(" ").append(getMiddleInitial());
        }

        if (suffix != null && !suffix.isBlank()) {
            output.append(" ").append(suffix);
        }

        return output.toString();
    }
}
