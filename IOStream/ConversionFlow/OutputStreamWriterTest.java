package ConversionFlow;

import org.junit.Test;

import java.io.*;

/**
 * Rainbow
 *
 * @DATE:2023/9/25 0025
 */
public class OutputStreamWriterTest {

    /**
     * 使用GBK字符集，添加数据到hello.txt
     */
    @Test
    public void test() throws IOException {
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\ConversionFlow\\hello.txt";
        File file = new File(path);
        OutputStreamWriter osw;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
            osw.write("hello world\n");
            osw.write("你好世界");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
