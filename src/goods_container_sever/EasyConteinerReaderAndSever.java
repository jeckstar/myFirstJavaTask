package goods_container_sever;

import java.io.*;

public class EasyConteinerReaderAndSever {
    public static void main(String[] args) throws IOException {
        EasyGoodsContainer easyGoodsContainer = new EasyGoodsContainer();

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Username\\Desktop\\save.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(easyGoodsContainer);
        oos.close();
    }
}
