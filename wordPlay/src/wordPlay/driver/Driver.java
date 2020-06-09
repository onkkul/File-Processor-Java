package wordPlay.driver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import wordPlay.util.FileProcessor;

/**
 * @author John Doe
 *
 */
public class Driver {
        public static void main(String[] args) {

                /*
                 * As the build.xml specifies the arguments as input,output or metrics, in case the
                 * argument value is not given java takes the default value specified in
                 * build.xml. To avoid that, below condition is used
                 */
                if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
                        System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
                        System.exit(0);
                }
                System.out.println("Hello World! Lets get started with the assignment");

                try {
                	FileProcessor fileProcessor	= new FileProcessor(args[0]);
                	String nextWord = fileProcessor.poll();
                	System.out.println(nextWord);
                }

                catch(Exception e){
					e.printStackTrace();
					System.out.println("In main");
                }


                

        }
}


// /*
// ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

// ant -buildfile wordPlay/src/build.xml run -Dinput="none.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

// ant -buildfile wordPlay/src/build.xml run -Dinput="~/DP/Assignments/csx42-summer-2020-assign1-onkkul/wordPlay/src/" -Doutput="output.txt" -Dmetrics="metrics.txt"

// ant -buildfile wordPlay/src/build.xml run -Dinput="~/DP/Assignments/csx42-summer-2020-assign1-onkkul/wordPlay/src/input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

// */