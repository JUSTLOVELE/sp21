package gitlet;


import java.io.Serializable;

public class A_Branch implements Serializable {

    private String name;

    private Commit header;

    private A_StageRegion stageRegion = new A_StageRegion();

    public A_Branch(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getHeader() {
        return header;
    }

    public void setHeader(Commit header) {
        this.header = header;
    }

    public A_StageRegion getStageRegion() {
        return stageRegion;
    }

    public void setStageRegion(A_StageRegion stageRegion) {
        this.stageRegion = stageRegion;
    }
}
