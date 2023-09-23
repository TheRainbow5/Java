package Demo.CopyFile;

import java.io.*;

/**
 * Rainbow
 *
 * @DATE:2023/9/23 0023
 */


public class CopyFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream\\Demo\\CopyFile\\hello.txt";
        File file1 = new File(path);
        CopyFile cf = new CopyFile(file1);
        cf.copyFile();
    }

    private File file;
    private String fileName = "Rainbow.txt";           //保存的路径
    private FileInputStream fis = null;
    private FileOutputStream fos = null;

    public CopyFile(File file) {
        this.file = file;
    }

    public CopyFile(File file, String fileName) {
        this.file = file;
        this.fileName = fileName;
    }


    /**
     * 文件复制
     * 思路分析：
     * 1、创建文件输入流，read(byte[] b)将数据读取到byte[]数组
     * 2、创建文件输出流，write(byte[] b)将byte[]数据存储到输出流
     */
    public void copyFile() throws IOException {
        try {
            fis = new FileInputStream(file);   //输入流对象
            String absolutePath = (String) file.getAbsoluteFile().toString().subSequence(0, file.getAbsoluteFile().toString().lastIndexOf("\\"));
            File ofp = new File(absolutePath, fileName);
            System.out.println(ofp.getPath());
            if (!ofp.exists()) {
                ofp.createNewFile();
            }
            fos = new FileOutputStream(ofp, true);   //数据是追加形式

            byte[] buf = new byte[1024];
            int readLength;
            while ((readLength = fis.read(buf)) != -1) {   //一次读取1024字节
                //写入文件
                fos.write(buf, 0, readLength);

            }
            System.out.println("拷贝成功!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
