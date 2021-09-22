import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class NewFiles extends Thread{

  private String key, path;
  private String fileNameToSearch;
  private List<String> result = new ArrayList<String>();
	
  public String getFileNameToSearch() {
	return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
	this.fileNameToSearch = fileNameToSearch;
  }

  public List<String> getResult() {
	return result;
  }

  public void searchDirectory (File directory, String fileNameToSearch) {

	setFileNameToSearch(fileNameToSearch);

	if (directory.isDirectory()) {
	    search(directory);
	} else {
	    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
	}

  }

  private void search(File file) {

	if (file.isDirectory()) {
	  System.out.println("Searching directory ... " + file.getAbsoluteFile());
			
	    if (file.canRead()) {
			for (File temp : file.listFiles()) {
		    	if (temp.isDirectory()) {
					search(temp);
		    	} 
				else {
					if (fileNameToSearch.equals(temp.getName())) {			
			    		result.add(temp.getAbsoluteFile().toString());
		    		}

				}
	    	}

	 	} 
		
		else {
			System.out.println(file.getAbsoluteFile() + "Permission Denied");
	 	}
      }

  }
  public void setValue(String key, String path){
		this.key  = key;
		this.path = path;
  }

  public void run(){
	
	NewFiles fileSearch = new NewFiles();
    LogReader w1 = new LogReader();
	WriteLogEntriesToLogFile w2 = new WriteLogEntriesToLogFile();
	String file = w1.search(path+"/"+key);
	System.out.println("Output: "+file);
	if (file == "File not found"){
		fileSearch.searchDirectory(new File(path), key);

		int count = fileSearch.getResult().size();
		if(count ==0){
	    	System.out.println("\nNo result found!");
		}
		else{
	    	System.out.println("\nFound " + count + " result!\n");
	    	for (String matched : fileSearch.getResult()){
		    	System.out.println("Found : " + matched);
            	w2.WriteLog(matched);

	    	}
		}
	}
	else{
		File op = new File(file);
		if(op.exists()){
			System.out.println("File previously logged. can be found in: "+file);
		}
		else{
			fileSearch.searchDirectory(new File(path), key);

			int count = fileSearch.getResult().size();
			if(count ==0){
	    		System.out.println("\nNo result found!");
			}
			else{
	    		System.out.println("\nFound " + count + " result!\n");
	    		for (String matched : fileSearch.getResult()){
		    		System.out.println("Found : " + matched);
            		w2.WriteLog(matched);

	    		}
			}
		}
	}
	
	
  }

}