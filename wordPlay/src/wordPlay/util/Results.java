package wordPlay.util;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;


/**
* Results is a utility to write results.
*
* @author Onkar Kulkarni
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private File outPutFile;
    private File metricsFile;

    private BufferedWriter outputWriter;
    private FileWriter metricsWriter;

    /**
    * Constructor for Results class, initializes empty output files
    * 
    * @return void
    *
    * @exception IOException
    */
    public Results(String outPutFile, String metricsFile) throws InvalidPathException, SecurityException, IOException {

        // this.outPutFile = outPutFile;
        

        // try{
        //     // new FileWriter(outPutFile, false).close();
        //     new FileWriter(metricsFile, false).close();
        // }
        // catch(IOException resultsFileNotEmpty){
        //     resultsFileNotEmpty.printStackTrace();
        // } 

        try {
            
            this.outPutFile = new File(outPutFile);
            this.metricsFile = new File(metricsFile);

            if (this.outPutFile.createNewFile()) {
                System.out.println("File created: " + this.outPutFile.getName());
            }
            else {
                new FileWriter(outPutFile, false).close();
            }

            if (this.metricsFile.createNewFile()) {
                System.out.println("File created: " + this.metricsFile.getName());
            }
            else {
                new FileWriter(metricsFile, false).close();
            }
        } 
        catch (IOException fileCreationError) {
          fileCreationError.printStackTrace();
        }


    }


    /**
    * Writes rotated words in the output file
    * 
    * @return void
    *
    * @exception IOException
    */
    public void writeRotated(String rotatedWord) throws IOException{

        System.out.println(rotatedWord);

        String fullStop = " ";
        if (rotatedWord.endsWith(".")){ fullStop = "\n";}

        try{
            this.outputWriter = new BufferedWriter(new FileWriter(this.outPutFile, true));
            outputWriter.write(rotatedWord+fullStop);
            outputWriter.close();
        }

        catch(IOException writeRotatedError){
            writeRotatedError.printStackTrace();
        }

        return;
    }
	

    /**
    * Writes stats in the metrics file
    * 
    * @return void
    *
    * @exception IOException
    */
    public void writeMatrix(float wordsPerSentense, float wordLength){

        float value = wordsPerSentense + wordLength;

        try{
            this.metricsWriter = new FileWriter(this.metricsFile);

            metricsWriter.write("AVG_NUM_WORDS_PERSENTENCE = " + String.format("%.2f", wordsPerSentense));
            metricsWriter.write("\nAVG_WORD_LENGTH = " + String.format("%.2f", wordLength)+"\n");
            metricsWriter.close();
        }

        catch(IOException writeMetricsError){
            writeMetricsError.printStackTrace();
        }
        
        return;
    }
}
