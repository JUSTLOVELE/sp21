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
            byte[] bytes=new byte[fis.available()];
            fis.read(bytes);
            fos.write(bytes);
            fos.close();
            fis.close();
            String sha1 = Utils.sha1(bytes);
            String blobFolderName = sha1.substring(0, 2);
            String blobFileName = sha1.substring(2, sha1.length() - 1);
            File blobFolderFile = new File(Utils.POINT_GITLET_BLOBS_PATH + "/" + blobFolderName);

            if(!blobFolderFile.exists()) {
                blobFolderFile.mkdir();
            }

            String blobFilePath = Utils.POINT_GITLET_BLOBS_PATH + "/" + blobFolderName + "/" + blobFileName;
            File blobFile = new File(blobFilePath);
            Utils.writeObject(blobFile, bytes);

//            A_StageRegion stageModel = Utils.readObject(new File(Utils.POINT_GITLET_STAGE_MODEL_PATH), A_StageRegion.class);
//            A_Blob blob = new A_Blob();
//            blob.setHashCode(sha1);
//            blob.setFileName(fileName);
//            blob.setBlobFileName(blobFilePath);
//            stageModel.getNameToBlob().put(fileName, blob);
//            // save StageModel Object
//            file = new File(Utils.POINT_GITLET_STAGE_MODEL_PATH);
//            Utils.writeObject(file, stageModel);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
