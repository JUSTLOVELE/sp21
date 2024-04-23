package gitlet;


import java.io.Serializable;

public class A_Blob implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private String blobFileName;

    private String hashCode;

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBlobFileName() {
        return blobFileName;
    }

    public void setBlobFileName(String blobFileName) {
        this.blobFileName = blobFileName;
    }
}
