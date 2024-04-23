package gitlet;


import java.io.Serializable;

public class A_Blob implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private String completeFileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCompleteFileName() {
        return completeFileName;
    }

    public void setCompleteFileName(String completeFileName) {
        this.completeFileName = completeFileName;
    }
}
