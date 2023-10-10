package pojos;

public record Record_Person(String email, String password) {
   public void login(){
        System.out.println("email : " + email+ " password : " + password);
    }
}
