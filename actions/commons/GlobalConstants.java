package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	public static final String OS_NAME=System.getProperty("os.name");
	public static final String UPLOAD_FILE=PROJECT_PATH+ File.separator+"uploadFiles";
	public static final String DOWNLOAD_FILE=PROJECT_PATH+ File.separator+"downloadFiles";
	public static final String BROWSER_LOG=PROJECT_PATH+File.separator+"browserLogs";
	
}
