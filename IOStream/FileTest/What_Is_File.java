package FileTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Rainbow
 * File对象详解
 *
 * @DATE:2023/9/23 File对象是专门对文件进行操作的类，只能对文件进行操作，不能对文件内容进行操作。
 * 主要用于文件或者目录的创建、删除、重命名、修改时间、修改权限等操作。
 * <p>
 *
 * <p>
 * 获取绝对路径
 */
public class What_Is_File {
    @Test
    public void testFile() throws IOException {
        /**
         * File常用的构造方法，既可以创建文件也可以创建文件夹
         * 1、File(String pathname) 创建一个File对象，参数是文件路径。
         * 2、File(File parent, String child) 创建一个File对象，参数是父目录和子目录。
         * 3、File(URI uri) 创建一个File对象，参数是URI，完成的文件路径。
         */
        String parent = "D:\\program_Lab_Report\\Computor\\programming_Language\\Java\\IOStream";
        String dir = "rainbow\\test";
        String fileName = "File.txt";


        File file = new File(parent, dir);     //创建文件夹对象
        File file2 = new File(parent, fileName); //创建文件对象，相当于D:\\.....\\File.txt

        /**
         * File创建删除方法
         * public boolean createNewFile()：创建文件，如果文件存在会失败，返回false
         * public boolean delete()：删除文件，如果文件不存在会失败，返回false
         * public boolean mkdir()：创建文件夹，只能创建一级目录，返回false
         * public bool mkdirs()：创建文件夹，可以创建多级目录，如果"rainbow//test"目录不存在，
         *                       则创建"rainbow"文件夹，再创建"test"文件夹，返回true
         *
         */
        if (file.mkdir()) {
            System.out.println("创建文件夹成功");
        }
        if (file.mkdirs()) {
            System.out.println("创建多级目录文件夹成功");
        }
        if (file2.createNewFile()) {
            System.out.println("创建文件成功");
        }

        /**
         * File常用的方法
         * public String getAbsolutePath() ：返回File的绝对路径
         * public String getPath() ：返回File的相对路径
         * public String getName() ：返回File的名称
         * public long length()：返回File的长度
         */
        String name = file.getName();
        File absoluteFile = file.getAbsoluteFile();
        long length = file.length();
        System.out.println("FileName is " + name + ",whose absoluteFile is " + absoluteFile);


        /**
         * File判断功能的方法，判断的是本地文件是否存在
         * public boolean isFile()：判断File是否是文件
         * public boolean isDirectory()：判断File是否是目录
         * public boolean exists()：判断File是否存在
         * public boolean canRead()：判断File是否可读
         */
        boolean isFile = file.isFile();
        boolean isDir = file.isDirectory();
        boolean isExist = file.exists();
        boolean canRead = file.canRead();
        System.out.println(isFile + " " + isDir + " " + isExist + " " + canRead);


        /**
         * 目录遍历常用方法
         * public String[] list()：返回一个String数组，数组中存的是当前目录下的文件和目录
         * public File[] listFiles()：返回一个File数组，数组中存的是当前目录下的文件和目录
         */
        File parentFile = new File(parent);
        String[] list = parentFile.list();
        File[] files = parentFile.listFiles();
        System.out.println(parentFile.getPath() + "目录下的文件有：");
        assert list != null;  //断言list不为空
        for (String n : list) {
            System.out.print(n + " ");
        }

        System.out.println("递归遍历目录下所有子文件的方法");
        Recursive(parentFile);

    }

    /**
     * 递归遍历目录下所有子文件的方法
     * 1、递归结束条件：判断是否是文件夹
     * 2、获取当前文件夹下的所有文件和文件夹
     * 3、遍历每个文件夹，递归获取文件夹下的所有文件
     *
     * @param file
     */
    public void Recursive(File file) {
        if (!file.isDirectory()) {   //不是目录就结束
            return;
        }
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isDirectory()) {   //如果是文件夹，就递归
                System.out.println(f.getName());
                Recursive(f);
            } else {
                System.out.println(f.getName());
            }
        }

    }
}
