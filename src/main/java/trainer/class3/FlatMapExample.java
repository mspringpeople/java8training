package trainer.class3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marutsingh on 6/6/16.
 */
public class FlatMapExample {

    public static void getLettersFromStringArray(String sentence) {
        Arrays.asList(sentence.split(" ")).stream()
                .map(i -> i.split(""))
                .flatMap(Arrays::stream).forEach(System.out::println);
    }

    public static void main(String[] args){
        getLettersFromStringArray("Hello World");
    }
}
