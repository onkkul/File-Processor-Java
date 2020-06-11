package wordPlay.util;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.nio.file.InvalidPathException;
=======
>>>>>>> 4b27da8dcee0b3b215ec9059ce514d68e8b8f890


/**
* Results is a utility to write results.
*
* @author Onkar Kulkarni
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

<<<<<<< HEAD
    private File outPutFile;
    private File metricsFile;
=======
    private String outPutFile;
    private String metricsFile;
>>>>>>> 4b27da8dcee0b3b215ec9059ce514d68e8b8f890

    private BufferedWriter outputWriter;
    private FileWriter metricsWriter;

    /**
    * Constructor for Results class, initializes empty output files
    * 
    * @return void
    *
    * @exception IOException
    */
<<<<<<< HEAD
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


=======
    public Results(String outPutFile, String metricsFile){

        this.outPutFile = outPutFile;
        this.metricsFile = metricsFile;

        try{
            new FileWriter(outPutFile, false).close();
            new FileWriter(metricsFile, false).close();
        }
        catch(IOException resultsFileNotEmpty){
            resultsFileNotEmpty.printStackTrace();
        } 
>>>>>>> 4b27da8dcee0b3b215ec9059ce514d68e8b8f890
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
<<<<<<< HEAD

            metricsWriter.write("AVG_NUM_WORDS_PERSENTENCE = " + String.format("%.2f", wordsPerSentense));
            metricsWriter.write("\nAVG_WORD_LENGTH = " + String.format("%.2f", wordLength)+"\n");
=======
            metricsWriter.write("AVG_NUM_WORDS_PERSENTENCE = " + Float.toString(wordsPerSentense));
            metricsWriter.write("\nAVG_WORD_LENGTH = " + Float.toString(wordLength)+"\n");
>>>>>>> 4b27da8dcee0b3b215ec9059ce514d68e8b8f890
            metricsWriter.close();
        }

        catch(IOException writeMetricsError){
            writeMetricsError.printStackTrace();
        }
        
        return;
    }
}
