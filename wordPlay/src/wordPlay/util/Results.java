package wordPlay.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String outPutFile;
    private String metricsFile;
    public Results(String outPutFile, String metricsFile){
        this.outPutFile = outPutFile;
        this.metricsFile = metricsFile;
    }


    public void writeRotated(String rotatedWord){
        // do something
        // return ;
        String rotateedd = rotatedWord;
    }
	
    public void writeMatrix(float wordsPerSentense, float wordLength){

        float value = wordsPerSentense + wordLength;

        // return;
    }
}
