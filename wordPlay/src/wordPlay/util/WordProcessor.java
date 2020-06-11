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


    public float wordsPerSentense;
    public float wordLength;
    public String sentenseToWrite = "";


    /**
    * Constructor for WordProcessor class
    * 
    * @return void
    * 
    * @exception FileNotFoundException On input file not found.
    * @exception IOException On any I/O errors while reading lines from input file.
    */
    public WordProcessor(String outPutFile, String matrixFile) throws IOException{

        this.stringRotator = new StringRotator();
        this.matrixCalculator = new MatrixCalculator();
    }


    /**
    * Method to store the rotated string
    *
    * @return void
    *
    * @exception IOException
    */
    private void storeRotated(String rotatedWord){

        String fullStop = " ";
        if (rotatedWord.endsWith(".")){ fullStop = "\n";}

        this.sentenseToWrite = this.sentenseToWrite + rotatedWord + fullStop;
        return;
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
        
        storeRotated(rotatedWord+fullStop);

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
        this.wordsPerSentense = this.matrixCalculator.wordsPerSentense;
        this.wordLength = this.matrixCalculator.wordLength;

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

