package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.*;

/**
 * Created by marutsingh on 6/12/16.
 */
public class DemoClass4 {


    public static void main(String[] args){
        LocalDate localDate = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2015, 3, 1);
        LocalDate usDate = LocalDate.now(ZoneId.of("America/Los_Angeles"));

        LocalTime localTime = LocalTime.now();
        LocalTime usLocalTime = LocalTime.now(ZoneId.of("America/Los_Angeles"));

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime usDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        String formattedTime = getFormattedDate();

       // System.out.println("Local Date " + localDate.toString()  + "Local Time" + localTime.toString());
       // System.out.println("Local Date and time " + localDateTime.toString());

        Instant nowInstant = Instant.now();

        Instant newInstant = Instant.now();
        Duration duration = Duration.between(newInstant,nowInstant);

        LocalDateTime firstMay2016 = LocalDateTime.of(2016, 5, 1,0,0,0);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(firstMay2016,ZoneId.of("America/Los_Angeles"));

        boolean isExist = FileNIOExample.fileExists("/Users/marutsingh/Documents/filebeat/folder1/someFile.txt");

        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 10; i++){
            integerList.add(random.nextInt(i));
        }

        int finalResult = ParallelStreamExample.addIntegersInParallel(integerList);
        ParallelStreamExample.printSortedIntegersWithParallelStream(integerList);
        System.out.println("***********************************************");
        ParallelStreamExample.printSortedIntegersWithParallelStream(integerList);
        System.out.println(finalResult);

//        try {
//           // FileNIOExample.deleteFile("/Users/marutsingh/Documents/filebeat/folder1/folder1.txt");
//            FileNIOExample.copyFile("/Users/marutsingh/Documents/filebeat/folder1/folder1.txt","/Users/marutsingh/Documents/filebeat/folder1/folder2/folder1.txt");
//            List<String> filePaths = FileNIOExample.walkAllFiles("/Users/marutsingh/Documents/filebeat/", 2);
//            filePaths.stream().forEach(System.out::println);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Elapsed duration : " + duration);
    }

    static class ParallelStreamExample{

        //1,2,3,4,5,6,7,8,9 -> 3 + 3 -> 6 + 4 -> 10 -> 5 ....so on
        //1,2 -> 3
        //3,4,5 -> 7 + 5 -> 12
        //6,7,8,9 -> 13 + 8 -> 21 + 9 -> 30

        //final -> 3 + 12 + 30


        public static int addIntegersInParallel(List<Integer> integers){
            Optional<Integer> integerSum = integers.parallelStream()
                    .reduce((i,j) -> i + j);

            return integerSum.get();
        }

        public static void printSortedIntegers(List<Integer> integers){
            integers.stream().sorted().forEach(System.out::println);
        }

        public static void printSortedIntegersWithParallelStream(List<Integer> integers){
            integers.parallelStream().sorted().forEach(System.out::print);
        }
    }

    static class FileNIOExample{

        public static boolean fileExists(String filePath){
            return Files.exists(Paths.get(filePath));
        }

        public static void deleteFile(String filePath) throws IOException {
            Files.delete(Paths.get(filePath));
        }

        public static void copyFile(String srcPath, String targetPath) throws IOException {
            Files.copy(Paths.get(srcPath),Paths.get(targetPath), REPLACE_EXISTING);
        }

        public static List<String> listAllFiles(String folderPath) throws IOException {
            return Files.list(Paths.get(folderPath))
                    .map(path -> path.toString())
                    .collect(Collectors.toList());
        }

        public static List<String> walkAllFiles(String folderPath, int depth) throws IOException {
            return Files.walk(Paths.get(folderPath), depth)
                    .map(path -> path.toString())
                    .collect(Collectors.toList());
        }
    }

    public static String getFormattedDate(){
        LocalDate localDate = LocalDate.now();
        return localDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    }
}
