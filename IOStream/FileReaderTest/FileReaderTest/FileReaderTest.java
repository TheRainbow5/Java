package FileReaderTest.FileReaderTest;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Rainbow
 *
 * @DATE:2023/9/23 0023
 */
public class FileReaderTest {

    /**
     * FileReader相关方法
     * 1、new FileReader(File/String)  创建FileReader对象
     * 2、read()：读取单个字符
     * 3、read(char[])：批量读取字符
     * 相关Api
     * new String(char[])：将char[]转换成String
     * new String(char[],off,len)：将char[]指定范围转为String
     */
    @Test
    public void test() {
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\FileReaderTest\\FileReaderTest\\hello.txt";
        File file = new File(path);

        try {
            char[] chars = new char[1024];
            FileReader fr = new FileReader(file);
            int readLength;
            while ((readLength = fr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readLength));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
