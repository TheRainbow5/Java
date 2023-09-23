package FileStream.InputStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Rainbow
 *
 * @DATE:2023/9/23 0023
 */
public class InputStreamTest {

    @Test
    public void test() throws IOException {
        /**
         * FileInputStream常用的构造方法
         * public FileInputStream(File file)  创建FileInputStream ，该文件由文件系统中的 File对象 file命名。
         * public FileInputStream(String name) 创建 FileInputStream ，该文件由文件系统中的路径名 name
         */

        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\InputStream\\hello.txt";
        File file = new File(path);
        FileInputStream fileInput = null;

        try {
            //创建FileInputStream对象，读取文件
            fileInput = new FileInputStream(file);


            /**
             * 常用方法
             * 1、fileInput.read()，读取一个字节数据，效率较低，且中文容易乱码
             * 2、fileInput.read(byte[] b) ，读取b.length个字节，返回读取到的有效字节个数
             */
            int readData;
            while ((readData = fileInput.read()) != -1) { //读取一个字节数据，如果文件中有中文（3个字节），则容易乱码
                System.out.print((char) readData);  //转成char显示
            }

            byte[] bytes = new byte[8];   //初始化字节数组为8个字节
            int readLength;
            //一次读取最多读取8个字节
            while ((readLength = fileInput.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readLength));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileInput.close();  //关闭输入流
        }
    }
}
