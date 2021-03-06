package wordPlay.metrics;
import java.io.IOException;


/**
* MatrixCalculator is a utility to be used to calculate the statistics.
*
* @author Onkar Kulkarni
*/
public class MatrixCalculator{

    public float wordsPerSentense;
    public float wordLength;

    private int numberOfWords = 0;
    private int sumOfWordLengths;
    private int numberOfSentenses;


    /**
    * Constructor for MatrixCalculator class
    * 
    * @return void
    */
    public MatrixCalculator(){}


    /**
    * Method to calculate the statistics
    * 
    * @return void
    *
    * @exception ArithmeticException
    */
    public void calculateStats(String word) throws ArithmeticException{


        this.numberOfWords++;
        this.sumOfWordLengths = this.sumOfWordLengths + word.length();
        if (word.endsWith(".")){
            this.sumOfWordLengths--;
            this.numberOfSentenses++;   
        }
        
        try{
            if (this.numberOfSentenses > 0){ this.wordsPerSentense = (float)this.numberOfWords / this.numberOfSentenses;}
            this.wordLength = (float)this.sumOfWordLengths / this.numberOfWords;
        }

        catch(ArithmeticException calculationError){
            calculationError.printStackTrace();
        }

        return;
    }



}
