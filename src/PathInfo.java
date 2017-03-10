import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 10.03.2017.
 */
public class PathInfo {
    Path path;
    long size;
    List<PathInfo>children;

    public PathInfo(Path path, long size, List<PathInfo> children) {
        this.path = path;
        this.size = size;
        this.children = children;
    }
    static PathInfo scan (Path p) throws IOException {
        if (!Files.isDirectory(p)) {
            long size=Files.size(p);
            List<PathInfo>children= Collections.emptyList();
            return new PathInfo(p, size, children);
        }
        else
        {
            long sum=0;
            List<PathInfo>children=new ArrayList<>();
            try (DirectoryStream<Path> ds=Files.newDirectoryStream(p)) {
                for (Path child:ds) {
                    PathInfo info=scan(child);
                    children.add(info);
                    sum +=info.size;
                }
        }
        return new PathInfo(p, sum, children);
        }
    }
}
