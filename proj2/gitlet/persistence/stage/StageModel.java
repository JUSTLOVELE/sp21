package gitlet.persistence.stage;


import gitlet.persistence.Blob;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StageModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Blob> nameToBlob = new HashMap<>();

    public Map<String, Blob> getNameToBlob() {
        return nameToBlob;
    }

    public void setNameToBlob(Map<String, Blob> nameToBlob) {
        this.nameToBlob = nameToBlob;
    }
}
