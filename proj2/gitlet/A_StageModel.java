package gitlet;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class A_StageModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, A_Blob> nameToBlob = new HashMap<>();

    public Map<String, A_Blob> getNameToBlob() {
        return nameToBlob;
    }

    public void setNameToBlob(Map<String, A_Blob> nameToBlob) {
        this.nameToBlob = nameToBlob;
    }
}
