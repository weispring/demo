package com.liyulin.skills.serial;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * @Auther: lixianchun
 * @Date: 2019/5/7 22:28
 * @Description:
 */
@Setter
@Getter
public class PersonB  implements Serializable {

    private static final long serialVersionUID = 1222222222222444L;

  /*  private String name;

    private String idCard;

    private int age;

    private Integer money;*/

  private String xxx ;

    /**
     * 可以没有serialVersionUID，但必须实现接口，且类定不能改动，包括注释
     * persion serialVersionUID 序列化前后必须一致，
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{


        File file = new File("./"+"test.txt");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        //写入serialVersionUID
        //java.io.ObjectOutputStream#writeObject
        //java.io.ObjectStreamClass#writeNonProxy

        Person person = (Person) ois.readObject();

        System.out.print(person);

    }


}
