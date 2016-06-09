package trainer.class3;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by marutsingh on 6/7/16.
 */
public class FileNIO {

    /**
     * List all files in current directory
     * @throws IOException
     */
    public List<String> listFiles() throws IOException {
        //auto closesable...
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            List<String> joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.toList());

            return joined;
        }
    }

    public List<String> findFiles() throws IOException {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(".js"))) {
            List<String> fileList = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            return fileList;
        }
    }

    public List<String> walkFiles() throws IOException {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            List<String> fileList = stream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".js"))
                    .sorted()
                    .collect(Collectors.toList());

            return fileList;
        }
    }

    public boolean checkFileExists(String filePath){
        //Do not follow symbolic links
        return Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS);
    }

    public void deleteFile(String filePath) throws IOException{
        Files.deleteIfExists(Paths.get(filePath));
    }

    public void copyFile(String srcFile,String destFile) throws IOException {
        Files.copy(Paths.get(srcFile),Paths.get(destFile),StandardCopyOption.REPLACE_EXISTING);
    }

    public void moveFile(String srcFile,String destFile) throws IOException {
        Files.move(Paths.get(srcFile), Paths.get(destFile), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) throws IOException {
        FileNIO fileNIO = new FileNIO();
        fileNIO.copyFile("/Users/marutsingh/Documents/sample.txt","/Users/marutsingh/Downloads");
    }
}
