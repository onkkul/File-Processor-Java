package wordPlay.util;
import java.util.Arrays;
import java.io.IOException;

/**
* StringRotator is a utility to be used to rotate the word.
*
* @author Onkar Kulkarni
*/
public class StringRotator{
    
    /*
    * Constructor for WordProcessor class
    * 
    * @return void
    */
    public StringRotator(){}

    /*
    * Method to rotate the string/word
    * 
    * @return rotated word
    */
    public String rotateString(String word, int index){ 
        char[] letters = word.toCharArray();
        int len = letters.length;
        index %= len;
        reverse(letters, 0, len - index - 1);
        reverse(letters, len - index, len - 1);
        reverse(letters, 0, len - 1);

        word = new String(letters);

        return word;
    }


    /*
    * Helper method to roate the string/word
    * 
    * @return void
    */
    private static void reverse(char[] letters, int start, int end){
        while (start < end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
    }

}