package wordPlay.util;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
* Results is a utility to write results.
*
* @author Onkar Kulkarni
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private File outPutFile;
    private File metricsFile;

    private BufferedReader reader;
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


        if (outPutFile.isEmpty() || metricsFile.isEmpty()){
            throw new FileNotFoundException("output and matrix file name cannot be empty");                 
        }

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
    public void writeRotated(String rotatedWord){
        try{
            this.outputWriter = new BufferedWriter(new FileWriter(this.outPutFile, true));
            outputWriter.write(rotatedWord);
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


    /**
    * implements the writeToFile method from FileDisplayInterface
    *
    * @return void
    *
    */
    @Override
    public void writeToFile(String rotatedValues, float wordPerSentence, float wordLength){
        writeRotated(rotatedValues);
        writeMatrix(wordPerSentence, wordLength);
        return;
    }


    /**
    * implements the writeToStdout method from StdoutDisplayInterface
    *
    * @return void
    *
    * @exception IOException
    */
    @Override
    public void writeToStdout(){

        try{
            Scanner myReader = new Scanner(this.outPutFile);
            System.out.println("\n##OUTPUT FILE##:\n");
            String data = myReader.nextLine();
            while (myReader.hasNextLine()) {
                data = data + "\n" + myReader.nextLine();
            }
            myReader.close();
            System.out.println(data);

            myReader = new Scanner(this.metricsFile);
            System.out.println("\n##METRICS FILE##:\n");
            String metrix_data = myReader.nextLine();
            while (myReader.hasNextLine()) {
                metrix_data = metrix_data + "\n" + myReader.nextLine();
            }
            myReader.close();
            System.out.println(metrix_data);
        }
        catch (IOException readerError){
            readerError.printStackTrace();    
        }

        return;
    }

}
