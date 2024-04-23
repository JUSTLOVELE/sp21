package gitlet;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class A_GitCommitTree implements Serializable {

    private List<A_Branch> branches = new ArrayList<A_Branch>();

    private A_Branch currentBranch;

    public List<A_Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<A_Branch> branches) {
        this.branches = branches;
    }

    public A_Branch getCurrentBranch() {
        return currentBranch;
    }

    public void setCurrentBranch(A_Branch currentBranch) {
        this.currentBranch = currentBranch;
    }
}
