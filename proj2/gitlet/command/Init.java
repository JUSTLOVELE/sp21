package gitlet.command;

import java.io.File;

public class Init {

    public static void init() {

        String path = System.getProperty("user.dir");
        path += "/.gitlet";
        File file = new File(path);

        if(!file.exists()) {
            file.mkdir();
        }
    }
}
