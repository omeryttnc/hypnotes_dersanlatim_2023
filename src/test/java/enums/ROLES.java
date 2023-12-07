package enums;

public enum ROLES {
    ROLE_CLIENT("ROLE_CLIENT"),
    ROLE_CLIENT_VERIFIED("ROLE_CLIENT_VERIFIED");



    private String role;
    ROLES(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
