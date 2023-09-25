package ConversionFlow;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rainbow
 * 字节->InputStreamReader（字符集）->字符
 *
 * @DATE:2023/9/25 0025
 */
public class InputStreamReaderTest {
    /**
     * 读取hello.txt文件中的数据
     */
    @Test
    public void test() {
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\Demo\\CopyFile\\hello.txt";
        File file = new File(path);

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK")) {
            char[] chars = new char[1024];
            int readLength;
            while ((readLength = isr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readLength));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
