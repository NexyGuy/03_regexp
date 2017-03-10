import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by admin on 10.03.2017.
 */
public class main {
    public static void main (String[] args) throws IOException {
        Path dir=Paths.get("C:\\Qt\\Tools\\QtCreator\\bin");
        PathInfo info=PathInfo.scan(dir);
        print.print (info, " ");
    }
}
