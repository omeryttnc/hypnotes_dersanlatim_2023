package enums;

public enum ROLE {
    ROLE_Client("ROLE_CLIENT"),
    ROLE_Client_Verified("ROLE_CLIENT_VERIFIED")
    ;

    public String getRole() {
        return role;
    }

    ROLE(String role) {
        this.role = role;
    }

    private String role;
}
