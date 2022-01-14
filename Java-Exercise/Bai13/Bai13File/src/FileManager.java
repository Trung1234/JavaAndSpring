import java.io.File;

/**
 * Created by My PC on 15/11/2017.
 */
public class FileManager {
	private File fileSrc;
	

	
	public FileManager(String pathSrc) {
		this.fileSrc = new File(pathSrc);
	}
	public void findByExtension(String extension){

		File[] listOfFiles = fileSrc.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			
			if (listOfFiles[i].isFile()&&getFileExtension(listOfFiles[i]).equals(extension)) {
				System.out.println("File " + listOfFiles[i].getName());
			}
		}
	}
	public String getFileExtension(File file) {
		String fileName = file.getName();
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".")+1);
		else return "";
	}
}
