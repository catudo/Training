import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReport {

    public static List<String> report(List<File> file, List<String> archives) {
        for (File f : file) {
            if(f.isDirectory()){
                report(Arrays.asList(f.listFiles()), archives);
            }

            if(f.getAbsolutePath().endsWith(".java")){
                archives.add(f.getAbsolutePath());
            }


        }

        return archives;

    }

    public static void main(String[] args) {
        System.out.println(FileReport.report(Arrays.stream(new File("/Users/c.gutierrezospina/Documents").listFiles()).toList(), new ArrayList<>()));
    }
}
