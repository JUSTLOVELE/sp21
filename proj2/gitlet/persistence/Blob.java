package gitlet.persistence;


import java.io.Serializable;

public class Blob implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private byte[] data;

    private String completeFileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getCompleteFileName() {
        return completeFileName;
    }

    public void setCompleteFileName(String completeFileName) {
        this.completeFileName = completeFileName;
    }
}
