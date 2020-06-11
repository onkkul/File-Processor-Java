package wordPlay.handler;
import java.util.Arrays;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* StringRotator is a utility to be used to rotate the word.
*
* @author Onkar Kulkarni
*/
public class StringRotator{
    
    private Pattern pattern;
    /**
    * Constructor for WordProcessor class
    * 
    * @return void
    */
    public StringRotator(){
        this.pattern = Pattern.compile("[^A-Za-z0-9]");
    }


    /**
    * Method to rotate the string/word
    * 
    * @return rotated word
    */
    public String rotateString(String word, int index){ 


        try{
            Matcher match = pattern.matcher(word);
            boolean val = match.find();
            if (val == true)
                System.out.println("Special characters found in the string.");
        }
        catch (NullPointerException emptryWord){
            emptryWord.printStackTrace();
        }
        char[] letters = word.toCharArray();
        int len = letters.length;
        index %= len;
        reverse(letters, 0, len - index - 1);
        reverse(letters, len - index, len - 1);
        reverse(letters, 0, len - 1);

        word = new String(letters);

        return word;
    }


    /**
    * Helper method to rotate the string/word
    * 
    * @return void
    */
    private void reverse(char[] letters, int start, int end){
        while (start < end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
        return;
    }

}