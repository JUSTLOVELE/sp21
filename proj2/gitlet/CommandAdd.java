package gitlet;


import java.io.*;

public class CommandAdd {

    public static void add(String fileName) {

        if(fileName == null || "".equals(fileName)) {
            return;
        }

        File file = new File(Utils.BASE_PATH + "/" + fileName);

        if(!file.exists()) {
            System.out.println("File does not exist.");
            return ;
        }

        try {

            File stageFile = new File(Utils.POINT_GITLET_STAGE_PATH + "/" + fileName);

            if(!stageFile.exists()) {
                stageFile.createNewFile();
            }

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(stageFile);
            byte[] bytes=new byte[1024];
            int len;

            while((len=fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }

            fos.close();
            fis.close();
            A_StageModel stageModel = Utils.readObject(new File(Utils.POINT_GITLET_STAGE_MODEL_PATH), A_StageModel.class);
            A_Blob blob = new A_Blob();
            blob.setFileName(fileName);
            blob.setCompleteFileName(fileName);
            stageModel.getNameToBlob().put(fileName, blob);
            // save StageModel Object
            file = new File(Utils.POINT_GITLET_STAGE_MODEL_PATH);
            Utils.writeObject(file, stageModel);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
