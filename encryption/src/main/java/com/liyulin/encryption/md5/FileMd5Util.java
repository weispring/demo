package com.liyulin.encryption.md5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lixianchun
 * @Date: 2019/6/2 19:27
 * @Description:
 */
public class FileMd5Util {

    private static String key = "";

    public static void main(String[] args) throws Exception {
        String path = "E:\\wcode\\lifeplan.txt";
        writeFile(path);
        decodeFile("E:\\wcode\\lifeplanen.txt");
    }

    public static List<String> readLine(String fiePath) throws IOException {
        List list = new ArrayList<String>();
        FileInputStream fis=new FileInputStream(fiePath);
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line= "";
        while ((line=br.readLine())!=null) {
            list.add(line);
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }


    public static void writeFile(String path) throws IOException {
        List<String> list = readLine(path);
        //写入中文字符时解决中文乱码问题
        int index = path.lastIndexOf(".");
        String suffix = path.substring(index);
        File file = new File(path);
        path = path.substring(0,index) + "en"+suffix;
        FileOutputStream fos = new FileOutputStream(new File(path));
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        for(String source : list){
            String s = encrypt(source, key);
            bw.write(s+"\n");
        }
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }


    public static String encrypt(String inStr,String key) {
        char[] a = inStr.toCharArray();
        for (char k : key.toCharArray()){
            for (int i = 0; i < a.length; i++) {
                a[i] = (char) (a[i] ^ k);
            }
        }
        return new String(a);
    }





    public static void decodeFile(String path) throws IOException {
        List<String> list = readLine(path);
        //写入中文字符时解决中文乱码问题
        int index = path.lastIndexOf(".");
        String suffix = path.substring(index);
        path = path.substring(0,index) + "de"+suffix;

        FileOutputStream fos = new FileOutputStream(new File(path));
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        for(String source : list){
            String s = encrypt(source, key);
            System.out.print(s);
            bw.write(s+"\n");
        }
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }




}
