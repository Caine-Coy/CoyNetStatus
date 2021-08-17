import java.util.Date;
import java.util.Stack;
/**
 * This allows easy reporting of errors and general logging. 
 * @author 'Caine'/ Joe Benson
 * @version 1.1
 */
public class CoyDebug {
    
    boolean printDebug;
    boolean logDebug;
    static Stack<String> debugLog;
    static Date date;
    String debugClass = "Debug";
    
    /**
     * 
     * @param print the debug to the console?
     * @param log the debug to a file? WIP
     */
    public CoyDebug(boolean print, boolean log){
        printDebug = print;
        logDebug = log;
        debugLog = new Stack<String>();
        addToDebug(debugClass,"Debug Successfully Started");
        addToDebug(debugClass,"Coyfunctions Successfully Started");
    }

    /**
     * This is a general all purpose logging system. Stores data in
     * @param callingObject is the object that you want this log to be reported as.
     * @param string is the text you want put on the log
     */
    public void addToDebug(String callingObject, String string) {
        date = java.util.Calendar.getInstance().getTime();
        String currDebugLog = (date+" : " +callingObject+ " : " + string);
        debugLog.push(currDebugLog);
        System.out.println(currDebugLog);
    }
    
    /**
     * This catches errors and stores them in the debug log
     * @param callingObject is the object that you want this log to be reported as.
     * @param e is the exception message
     */
    public static void error(String callingObject, Exception e) {
        date = java.util.Calendar.getInstance().getTime();
        String currDebugLog = (date+" : CRITICAL ERROR!: " +callingObject+ " : " + e.getMessage());
        debugLog.push(currDebugLog);
        System.out.println(currDebugLog);
    }
    
    
}
