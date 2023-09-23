package FileReaderTest.FileWriterTest;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Rainbow
 *
 * @DATE:2023/9/23 0023
 */
public class FileWriterTest {
    /**
     * FileWriter常用方法
     * 1、new FileWriter(File/String)：覆盖模式
     * 2、new FileWriter(File/String,true)：追加模式
     * 3、write(int)：写入单个字符
     * 4、write(char[])：写入多个字符
     * 5、write(char[],off,len)：写入指定字符部分
     * 6、write(String)：写入整个字符串
     * 7、write(String,off,len)：写入指定字符串
     * <p>
     * 在FileWriter使用后，必须close()/flush()，否则无法写入指定的文件
     */
    @Test
    public void test() throws IOException {
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\FileReaderTest\\FileWriterTest\\hello.txt";
        File file = new File(path);
        FileWriter fw = null;

        try {
            fw = new FileWriter(file, true);
            fw.write("hello world");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fw != null) {
                fw.close();
            }
        }


    }
}
