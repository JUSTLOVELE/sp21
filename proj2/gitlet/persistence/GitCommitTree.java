package gitlet.persistence;


import gitlet.Commit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GitCommitTree implements Serializable {

    private List<Branch> branches = new ArrayList<Branch>();

    private Branch currentBranch;


    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public Branch getCurrentBranch() {
        return currentBranch;
    }

    public void setCurrentBranch(Branch currentBranch) {
        this.currentBranch = currentBranch;
    }
}
