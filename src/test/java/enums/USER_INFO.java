package enums;

public enum USER_INFO {
    ALICI("omerEnum","enumPass"),
    SATICI("omer Satici" ,"satici passw")
    ;

    private String name;
    private String email;

    USER_INFO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void login(){
        System.out.println(this.email +" " + this.name);
    }
}
