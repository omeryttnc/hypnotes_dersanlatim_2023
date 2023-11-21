package stepDefinitions;

import org.junit.Test;

public class JavaCalismalari {
    static  private String nameStatic;
    private String name;

    @Test
    public void sss2() {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home")+"\\Downloads");
        nameStatic ="ben bir static objeyim";
        name ="ben bir garip";
    }

    @Test
    public void pname() {
        nameStatic="nasilsiniz ???";
        System.out.println("nameStatic = " + nameStatic);
        System.out.println("name = " + name);
    }
}
