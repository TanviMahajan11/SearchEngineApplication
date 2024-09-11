import java.io.File;

class FindRoots{
      
    public void showRoots(){
        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                System.out.println("**************** Directories *******************");
                System.out.println(aDrive);
                System.out.println("************************************************");
            }
        }
    }
   
}