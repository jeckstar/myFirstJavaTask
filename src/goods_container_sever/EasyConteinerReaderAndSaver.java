package goods_container_sever;

import vehicles_store.GoodsStoreBasket;

import java.io.*;

public class EasyConteinerReaderAndSaver {
    private final String path = "C://Users//User//IdeaProjects//firstTask//src//goods_container_sever//save.out";

    public GoodsStoreBasket readBasket() throws IOException, ClassNotFoundException {
        if(checkFilePath()){
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            GoodsStoreBasket basket = (GoodsStoreBasket) ois.readObject();
            ois.close();
            return basket;
        }
        else {
            GoodsStoreBasket basket = new GoodsStoreBasket();
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(basket);
            oos.close();
            return basket;
        }
    }

    public void saveBasket(GoodsStoreBasket basket) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(basket);
        oos.close();
    }

    private boolean checkFilePath(){
        File file = new File(path);
        return file.exists();
    }
}
