package wordPlay.driver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import wordPlay.util.FileProcessor;
import wordPlay.util.WordProcessor;
import wordPlay.util.Results;

/**
 * @author Onkar Kulkarni
 *
 */
public class Driver {

    /**
    * Starts file processing
    * @exception InvalidPathException On invalid path string.
    * @exception SecurityException On not having necessary read permissions to the input file.
    * @exception FileNotFoundException On input file not found.
    * @exception IOException On any I/O errors while reading lines from input file.
    *
    * @return void
    */
	private static void executeProcess(String inputFile, String outputFile, String metricFile){
        try {
        	FileProcessor fileProcessor	= new FileProcessor(inputFile);
        	WordProcessor wordProcessor = new WordProcessor(outputFile, metricFile);

        	String word = fileProcessor.poll();
        	int index = 1;
          	while(word != null){
          		if(!word.isEmpty()){

	        		String rotatedWordd = wordProcessor.processWord(word, index);
	        		index++;
	        		if (word.endsWith(".")){
	        			index = 1;
	        		}
	        	}
        		word = fileProcessor.poll();
        	}


        	Results writeResults = new Results(outputFile, metricFile);

        	writeResults.writeToFile(wordProcessor.sentenseToWrite ,wordProcessor.wordsPerSentense, wordProcessor.wordLength);
        	writeResults.writeToStdout();
        }


        catch(Exception e){
			e.printStackTrace();
        }

	}

    public static void main(String[] args) {

        /**
         * As the build.xml specifies the arguments as input,output or metrics, in case the
         * argument value is not given java takes the default value specified in
         * build.xml. To avoid that, below condition is used
         */
        if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
            System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
            System.exit(0);
        }

        System.out.println("Hello World! Lets get started with the assignment");

        executeProcess(args[0], args[1], args[2]);
    }
}