package enums;

public enum USER_INFO {
    ALICI("","omerEnum","enumPass"),
    SATICI("","omer Satici" ,"satici passw"),
    THERAPIST("therapist","therapist2023@mailsac.com","12ASDasd.,asdASD34")
    ;

    private String name;
    private String email;

    private String password;

    USER_INFO(String name, String email,String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void login(){
        System.out.println(this.email +" " + this.name);
    }
}
