package gitlet;


import java.io.Serializable;

public class A_Branch implements Serializable {

    private String name;

    private Commit header;

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
}
