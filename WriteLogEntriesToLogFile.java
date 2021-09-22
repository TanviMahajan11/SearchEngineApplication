import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;





public class WriteLogEntriesToLogFile  {
     
	public void WriteLog(String path){
		boolean append = true;
        FileHandler handler;
		try {
			handler = new FileHandler("search_history.log", append);
		
 
        	Logger logger = Logger.getLogger(WriteLogEntriesToLogFile.class.getName());
        
			logger.addHandler(handler);
   
			logger.log(Level.INFO,path);

			logger.config("config message");
 
  			logger.fine("fine message");
 
  			logger.finer("finer message");
 
  			logger.finest("finest message");
		} 
		catch (SecurityException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
}