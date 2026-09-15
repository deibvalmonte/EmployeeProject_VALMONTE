package version2;

public class Name {
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
        this.firstName = normalizeNamePart(firstName, "N/A");
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? "" : middleName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = normalizeNamePart(lastName, "N/A");
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? "" : suffix.trim();
    }

    public String getMiddleInitial() {
        if (middleName == null || middleName.isBlank()) {
            return "";
        }

        String trimmed = middleName.trim();
        return trimmed.substring(0, 1).toUpperCase() + ".";
    }

    public void displayName() {
        System.out.println(this);
    }

    public static Name fromFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return new Name();
        }

        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) {
            return new Name(parts[0], "", "N/A", "");
        }
        if (parts.length == 2) {
            return new Name(parts[0], parts[1]);
        }

        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        String middleName = String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length - 1));
        return new Name(firstName, middleName, lastName, "");
    }

    private String normalizeNamePart(String value, String fallback) {
        if (value == null || value.trim().isEmpty()) {
            return fallback;
        }
        return value.trim();
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
