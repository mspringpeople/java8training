package trainer.class3;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by marutsingh on 6/7/16.
 */
public class StringPatternExample {

    public void stringPattern(){
        Pattern.compile(":")
                .splitAsStream("foobar:foo:bar")
                .filter(s -> s.contains("bar"))
                .sorted()
                .collect(Collectors.joining(":")); //bar:foobar
    }

    public void stringRegex(){
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate())
                .count();// => 1
    }
}
