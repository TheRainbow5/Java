package FileStream.OutputStream;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Rainbow
 *
 * @DATE:2023/9/23 0023
 * <p>
 * OutputStream子类共有的方法
 * 1、public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
 * 2、public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
 * 3、 public void write(byte[] b)：将 b.length个字节从指定的字节数组写入此输出流。
 * 4、public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
 * 也就是说从off个字节数开始读取一直到len个字节结束
 * 5、public abstract void write(int b) ：将指定的字节输出流。
 */
public class outputStreamTest {
    @Test
    public void test() throws IOException {
        /**
         * OutputStream常用构造方法
         *
         */
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\InputStream\\hello.txt";
        File file = new File(path);

        FileOutputStream fileOutputStream = null;
        try {
            //创建FileOutputStream对象
            fileOutputStream = new FileOutputStream(file);  //默认字节是覆盖
//            fileOutputStream = new FileOutputStream(file, true);  //字节追加
            //写入一个字节
            fileOutputStream.write('h');
            //写入一个字符串，将字符串转为byte数组
            fileOutputStream.write("hello".getBytes());
            //写入一个字符串，自定义写入的起始位置
            fileOutputStream.write("hello".getBytes(), 0, "hello".length());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            fileOutputStream.close();
        }
    }

    /**
     * 需求：
     * 1. 将“hello world”字符串写入hello.txt文件中
     * 2. 如果没有则创建文件
     */
    @Test
    public void ins1() throws IOException {
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\OutputStream\\hello.txt";
        File file = new File(path);
        //1、判断是否存在文件
        if (!file.exists()) {
            System.out.println("创建该文件");
            file.createNewFile();
        }

        FileOutputStream fos = null;
        StringBuilder sb = new StringBuilder();
        //2、文件追加
        try {

            fos = new FileOutputStream(file);      //创建对象
            fos.write("hello world".getBytes());   //覆盖文件内容
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                fos.close();   //关闭输出流
            }
        }
    }
}
