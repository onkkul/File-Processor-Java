package wordPlay.util;
import java.util.Arrays;
import java.io.IOException;

public class StringRotator{
    public StringRotator(){}

    public String rotateString(String word, int index){ 
     char[] A = word.toCharArray();
     int len = A.length;
     index %= len;
     reverse(A, 0, len - index - 1);
     reverse(A, len - index, len - 1);
     reverse(A, 0, len - 1);

     return Arrays.toString(A);
    }

    private static void reverse(char[] str, int start, int end){
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

}