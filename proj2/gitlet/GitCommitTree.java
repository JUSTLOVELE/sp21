package gitlet;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GitCommitTree implements Serializable {

    private List<Branch> branches = new ArrayList<Branch>();

    private Branch currentBranch;

    private Commit header;

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

    public Commit getHeader() {
        return header;
    }

    public void setHeader(Commit header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "GitCommitTree{" +
                "branches=" + branches +
                ", currentBranch=" + currentBranch +
                ", header=" + header +
                '}';
    }
}
