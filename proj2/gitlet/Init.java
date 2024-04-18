package gitlet;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Init {

    public static final String BASE_PATH = System.getProperty("user.dir");

    public static final String GITLET_PATH = BASE_PATH + "/.gitlet";

    public static final String GITLET_MODEL_PATH = GITLET_PATH + "/model";

    public static final String GITLET_MODEL_TREE_PATH = GITLET_MODEL_PATH + "/tree";

    public static void init() {

        File file = new File(GITLET_PATH);

        if(!file.exists()) {

            file.mkdir();
            //create commit
            Commit commit = new Commit();
            commit.setDate(getInitDate());
            commit.setMessage(null);
            //create branch
            Branch master = new Branch("master");
            GitCommitTree tree = new GitCommitTree();
            tree.setCurrentBranch(master);
            tree.getBranches().add(master);
            file = new File(GITLET_MODEL_PATH);
            file.mkdir();
            file = new File(GITLET_MODEL_TREE_PATH);
            Utils.writeObject(file, tree);

        }else{
            System.out.println("A Gitlet version-control system already exists in current directory.");
//            path += "/model/tree";
//            file = new File(path);
//            System.out.println(path);
//            GitCommitTree gitCommitTree = Utils.readObject(file, GitCommitTree.class);
//            System.out.println(gitCommitTree.toString());
//            System.out.println(gitCommitTree.getCurrentBranch().getName());
        }
    }

    private static Date getInitDate() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse("1970-01-01 00:00:00");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
