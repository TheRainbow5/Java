package Interface;

/**
 * Rainbow
 * 接口
 *
 * @DATE:2023/9/17 0017
 */
public class demo {
    public static void main(String[] args) {
        DBconnect dBconnect = new Mysql();   //向上转型
        dBconnect.connectDB();

        DBconnect dBconnect1 = new MongoDB();  //向上转型
        dBconnect1.connectDB();
    }

}

interface DBconnect {
    void connectDB();   //定义链接数据库的抽象方法
}

class Mysql implements DBconnect {
    @Override
    public void connectDB() {
        System.out.println("连接MySQL");
    }
}

class MongoDB implements DBconnect {
    @Override
    public void connectDB() {
        System.out.println("连接MongoDB");
    }
}
