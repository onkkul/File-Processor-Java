package wordPlay.util;

import wordPlay.handler.StringRotator;
import wordPlay.metrics.MatrixCalculator;


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
* WordProcessor is a utility to be used to process the contents of the input file
* word by word.
*
* @author Onkar Kulkarni
*/
public class WordProcessor{

    private String outPutFile;
    private String matrixFile;
    private String pwd = System.getProperty("user.dir");

    
    private Results results;
    private StringRotator stringRotator;
    private MatrixCalculator matrixCalculator;


    /**
    * Constructor for WordProcessor class
    * 
    * @return void
    * 
    * @exception FileNotFoundException On input file not found.
    * @exception IOException On any I/O errors while reading lines from input file.
    */
    public WordProcessor(String outPutFile, String matrixFile) throws IOException{

        if (outPutFile.isEmpty() || matrixFile.isEmpty()){
            throw new FileNotFoundException("output and matrix file name cannot be empty");                 
        }

        // this.outPutFile = this.pwd + "/src/" + outPutFile;
        // this.matrixFile = this.pwd + "/src/" + matrixFile;

        // if (!Files.exists(Paths.get(this.outPutFile))) {
        //     throw new FileNotFoundException("invalid output file or output file in incorrect location");
        // }

        // if (!Files.exists(Paths.get(this.matrixFile))) {
        //     throw new FileNotFoundException("invalid matrix file or matrix file in incorrect location");
        // }

        this.stringRotator = new StringRotator();
        this.matrixCalculator = new MatrixCalculator();

        try{
            this.results = new Results(outPutFile, matrixFile);
        }
        catch (IOException wordProcessorError){
            wordProcessorError.printStackTrace();
        }
    }

    /**
    * Method to rotate the given string
    *
    * @return rotated word
    *
    * @exception IOException
    */
    private String rotateWord(String word, int index, String fullStop) throws Exception, IOException{
        
        word = word.replace(".", "");
        String rotatedWord = this.stringRotator.rotateString(word, index);
        
        this.results.writeRotated(rotatedWord+fullStop);

        return rotatedWord+fullStop;
    }

    /**
    * Method to calculate statics
    *
    * @return void
    *
    * @exception IOException
    */
    private void calculateMatrix(String word) throws Exception, IOException{
        this.matrixCalculator.calculateStats(word);
        float wordsPerSentense = this.matrixCalculator.wordsPerSentense;
        float wordLength = this.matrixCalculator.wordLength;

        this.results.writeMatrix(wordsPerSentense, wordLength);
        return;
    }


    /**
    * Method to process the word passed by fileProcessor
    *
    * @return rotated Word
    *
    * @exception IOException
    */
    public String processWord(String word, int index) throws Exception, IOException{
        
        String fullStop = "";
        if (word.endsWith(".")) {  fullStop = ".";}

        String rotatedWord = rotateWord(word, index, fullStop);
        
        calculateMatrix(word);

        return rotatedWord;
    }


}
