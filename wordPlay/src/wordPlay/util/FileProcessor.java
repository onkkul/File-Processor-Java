
package wordPlay.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

/**
* FileProcessor is a utility to be used to read in the contents of the input file.
*
* DO NOT ALTER THIS FILE.
*
* @author Pradyumna Kaushik
*/
public final class FileProcessor {
    private BufferedReader reader;
    private Queue<String> words;

    private String pwd = System.getProperty("user.dir");

    /**
    * Constructs a FileProcessor that can stream the contents of the provided input file
    *       word by word.
    * @exception InvalidPathException On invalid path string.
    * @exception SecurityException On not having necessary read permissions to the input file.
    * @exception FileNotFoundException On input file not found.
    * @exception IOException On any I/O errors while reading lines from input file.
    */
    public FileProcessor(String inputFilePath)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

<<<<<<< HEAD
        if (!Files.exists(Paths.get(inputFilePath)) || inputFilePath.isEmpty()) {
            throw new FileNotFoundException("invalid input file or input file in incorrect location");
        }

        File fileToRead = new File(inputFilePath);
=======
        if (inputFilePath.isEmpty()){
        	throw new FileNotFoundException("Input file name cannot be empty");                	
        }
        
        String filePath = this.pwd + "/src/" + inputFilePath;

        if (!Files.exists(Paths.get(filePath)) || filePath.isEmpty()) {
            throw new FileNotFoundException("invalid input file or input file in incorrect location");
        }

        File fileToRead = new File(filePath);
>>>>>>> 4b27da8dcee0b3b215ec9059ce514d68e8b8f890
        if (fileToRead.length() == 0){
        	throw new IOException("File is empty");
        }

        reader = new BufferedReader(new FileReader(fileToRead));
        String line = reader.readLine();
        if (null != line) {
            words = new LinkedList<String>(Arrays.asList(line.split("\\s+")));
        }
    }
<<<<<<< HEAD
    
=======
>>>>>>> 4b27da8dcee0b3b215ec9059ce514d68e8b8f890

    /**
    * Retrieves and returns the next word in the input file.
    *
    * @return String The next word read from the input file. If the word is the last
    *       word in a sentence, it would include the period character.
    * @exception IOException On error encountered when reading from input file.
    */
    public String poll() throws IOException {
        if (null == words) {
        	return null;
        }
        if (0 == words.size()) {
            String nextLine = reader.readLine();
            if (null == nextLine) return null;
            words.addAll(Arrays.asList(nextLine.split("\\s+")));
        }
        return words.remove();
    }

}
