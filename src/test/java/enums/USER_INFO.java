package enums;

public enum USER_INFO {
    ALICI(false,"omerEnum","enumPass"),
    SATICI(true,"omer Satici" ,"satici passw"),
    THERAPIST(true,"therapist2023@mailsac.com","12ASDasd.,asdASD34")
    ;

    private boolean isTestEnvironment;
    private String email;

    private String password;

    USER_INFO(boolean isTestEnvironment, String email, String password) {
        this.isTestEnvironment = isTestEnvironment;
        this.email = email;
        this.password = password;
    }

    public boolean isTestEnvironment() {
        return isTestEnvironment;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
