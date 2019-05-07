package com.liyulin.skills.serial;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Auther: lixianchun
 * @Date: 2019/5/7 22:28
 * @Description:
 */
@Setter
@Getter
@ToString
public class Person extends PersonB implements Serializable {

    private static final long serialVersionUID = 1222222222222444L;

    private String name;

    private String idCard;

    private int age;

    //private Integer money;

    private Integer bb;

    public static void main(String[] args) throws Exception{
        Person person = new Person();
        person.setName("li chun");
        person.setIdCard("4211");
        person.setAge(22);
        person.setXxx("xxxxxxxx");
        //person.setMoney(999999999);

        File file = new File("./"+"test.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);



        //写入serialVersionUID
        //java.io.ObjectOutputStream#writeObject
        //java.io.ObjectStreamClass#writeNonProxy
        oos.writeObject(person);

    }


}
