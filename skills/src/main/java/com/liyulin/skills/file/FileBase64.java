package com.liyulin.skills.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

/**
 * @author lixianchun
 * @Description
 * @date 2019/6/15 17:14
 */
@Slf4j
public class FileBase64 {

    public static void main(String args[]) throws Exception {
        String pricUrl = "http://b.hiphotos.baidu.com/image/pic/item/908fa0ec08fa513db777cf78376d55fbb3fbd9b3.jpg";
        String result = null;
        result = getPritureToBase64(pricUrl);
        System.out.println(result);

        String dataStr = result.substring(result.lastIndexOf(";base64,")+8);
        byte[] bytes =  Base64.getDecoder().decode(dataStr);
        File file = new File("./test.png");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    public static String getPritureToBase64(String pricUrl){
        InputStream in = null;
        URLConnection connection=null;
        ByteArrayOutputStream out=null;
        String builder=null;
        try {
            URL url=new URL(pricUrl);
            connection=url.openConnection();
            in=connection.getInputStream();
            out = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len=0;
            while ((len=in.read(bytes))!= -1){
                out.write(bytes,0,len);
            }
            builder="data:image/"+pricUrl.substring(pricUrl.lastIndexOf(".")+1)+";base64,"+ Base64.getEncoder().encodeToString(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != in) in.close();
                if(null != out) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder;
    }

}
