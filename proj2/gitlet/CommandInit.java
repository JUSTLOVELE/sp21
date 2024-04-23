package gitlet;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandInit {

    public static void init() {

        File file = new File(Utils.POINT_GITLET_PATH);

        if(!file.exists()) {

            file.mkdir();
            //create commit
            Commit commit = new Commit();
            commit.setDate(getInitDate());
            commit.setMessage(null);
            //create branch
            A_Branch master = new A_Branch("master");
            master.setHeader(commit);
            //create tree
            A_GitCommitTree tree = new A_GitCommitTree();
            tree.setCurrentBranch(master);
            tree.getBranches().add(master);
            //save GitCommitTree class
            file = new File(Utils.POINT_GITLET_TREE_PATH);
            Utils.writeObject(file, tree);
            //create stage
            file = new File(Utils.POINT_GITLET_STAGE_PATH);
            file.mkdir();
            //
            A_StageModel stageModel = new A_StageModel();
            file = new File(Utils.POINT_GITLET_STAGE_MODEL_PATH);
            Utils.writeObject(file, stageModel);

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
