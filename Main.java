import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        FindRoots f = new FindRoots();
        f.showRoots();
        NewFiles n1 = new NewFiles();
        NewFiles n2 = new NewFiles();
        Scanner sc =  new Scanner(System.in);

        System.out.println("Enter the path1: ");
	    String path1 = sc.next();
        System.out.println("Enter the path2: ");
        String path2 = sc.next();
	    System.out.println("Enter key file: ");
        String key = sc.next();
        n1.setValue(key, path1);
        n2.setValue(key, path2);
        n1.start();
        n2.start();    
        sc.close(); 
    }
}
