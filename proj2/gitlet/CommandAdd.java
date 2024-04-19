package gitlet;


import gitlet.persistence.stage.StageModel;

import java.io.File;
import java.io.FileInputStream;

public class CommandAdd {

    public static void add(String fileName) {

        if(fileName == null || "".equals(fileName)) {
            return;
        }

        File file = new File(Utils.BASE_PATH + "/" + fileName);

        if(!file.exists()) {
            return ;
        }

        try {

            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.readAllBytes().length];
            fis.read(data);
            fis.close();
            StageModel stageModel = Utils.readObject(new File(Utils.POINT_GITLET_STAGE_MODEL_PATH), StageModel.class);


            //保存信息到StageModel中,若存在则删除已有文件

            // 把文件保存到stage目录下

            //持久化StageModel对象


//            File file = new File(Utils.BASE_PATH + "/abcd.docx");
//            System.out.println(file.isFile());
//            System.out.println(file.exists());
//            System.out.println(file.length());
//            FileInputStream fis = new FileInputStream(file);
//            System.out.println(fis.available());
//            byte[] data = new byte[fis.readAllBytes().length];
//            System.out.println(data.length);
//            fis.read(data);
//            System.out.println(data.length);
//
//            File f = new File(Utils.GITLET_PATH + "/abcd");
//            Utils.writeObject(f, data);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
