/**
 * Created by admin on 10.03.2017.
 */
public class print {
    public static void print (PathInfo pi, String level) {
        System.out.println(level+pi.path.getFileName()+" "+pi.size);
        for (PathInfo child:pi.children) {
            print (child, level+" ");
        }
    }
}
