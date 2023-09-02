import java.util.Properties;

public class Test{

    public static void printSystemProperties(){
        System.out.println("printing system properties using java");
        Properties pops = System.getProperties();
        System.out.println(pops);
    }


    public static void main(String[] args) {
        System.out.println("Hello, World ");
        System.out.println("Welcome to the java project for containerization");
        Integer x = 23;

        Integer y = 25;

        System.out.println("Sum = "+(x+y));

        printSystemProperties();
    }
}

