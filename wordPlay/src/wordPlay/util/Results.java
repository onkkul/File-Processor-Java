package wordPlay.util;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
* Results is a utility to write results.
*
* @author Onkar Kulkarni
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String outPutFile;
    private String metricsFile;

    private BufferedWriter outputWriter;
    private FileWriter metricsWriter;

    /**
    * Constructor for Results class, initializes empty files
    * 
    * @return void
    */
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
    }


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
    }
	
    public void writeMatrix(float wordsPerSentense, float wordLength){

        float value = wordsPerSentense + wordLength;

        try{
            this.metricsWriter = new FileWriter(this.metricsFile);
            metricsWriter.write("AVG_NUM_WORDS_PERSENTENCE = " + Float.toString(wordsPerSentense));
            metricsWriter.write("\nAVG_WORD_LENGTH = " + Float.toString(wordLength)+"\n");
            metricsWriter.close();
        }

        catch(IOException writeMetricsError){
            writeMetricsError.printStackTrace();
        }
    }
}
