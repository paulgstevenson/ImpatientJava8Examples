import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;

public class Chapter1 {

    public Integer[] exercise1(Integer[] intArray){
        Arrays.sort(intArray, Comparator.<Integer>naturalOrder());
        return intArray;
    }

    public File[] subDirectoryOld(File file) {
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File passedFile) {
                return passedFile.isDirectory();
            }
        });
    }

    public File[] subDirectoryLambda(File file) {
        return file.listFiles(f -> f.isDirectory());
    }

    public File[] subDirectoryMethRef(File file) {
        return file.listFiles(File::isDirectory);
    }

    public String[] filterExtension(File dir, String ext){
        return dir.list((curFile,name) -> name.endsWith(ext));
    }

    public File[] orderFiles(File dir){
        File[] files = dir.listFiles();
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
            }
        });
        Arrays.asList(files).forEach(System.out::println);
        return files;
    }
}
