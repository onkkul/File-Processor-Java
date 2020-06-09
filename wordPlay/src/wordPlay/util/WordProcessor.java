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


public class WordProcessor{

    private String outPutFile;
    private String matrixFile;

    private Results results;
    private StringRotator stringRotator;
    private MatrixCalculator matrixCalculator;

    private String pwd = System.getProperty("user.dir");

    public WordProcessor(String outPutFile, String matrixFile) throws FileNotFoundException{

        if (outPutFile.isEmpty() || matrixFile.isEmpty()){
            throw new FileNotFoundException("output and matrix file name cannot be empty");                 
        }

        this.outPutFile = this.pwd + "/src/" + outPutFile;
        this.matrixFile = this.pwd + "/src/" + matrixFile;

        if (!Files.exists(Paths.get(this.outPutFile))) {
            throw new FileNotFoundException("invalid output file or output file in incorrect location");
        }

        if (!Files.exists(Paths.get(this.matrixFile))) {
            throw new FileNotFoundException("invalid matrix file or matrix file in incorrect location");
        }

        this.stringRotator = new StringRotator();
        this.matrixCalculator = new MatrixCalculator();
        this.results = new Results(this.outPutFile, this.matrixFile);
    }


    public void rotateWord(String word, int index) throws Exception, IOException{
        String rotatedWord = this.stringRotator.rotateString(word, index);
        this.results.writeRotated(rotatedWord);
    }

    public void calculateMatrix(String word) throws Exception, IOException{
        this.matrixCalculator.calculateStats(word);
        float wordsPerSentense = this.matrixCalculator.wordsPerSentense;
        float wordLength = this.matrixCalculator.wordLength;

        this.results.writeMatrix(wordsPerSentense, wordLength);
    }

}
