package com.ctrip.di.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Created by guojh on 2015/11/23.
 */
public class Utils {

    public static void main(String[] args){
        randomInt("E:\\data.txt");
    }

    public static void randomInt(String filePath){
        String filepath = filePath;
        System.out.println(filepath);
        try
        {
            File file = new File(filepath);
            if(!file.exists())
            {
                file.createNewFile();
                System.out.println("data.txt创建完成");
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            Random random = new Random();
            for(int i=0;i<1000000;i++)
            {
                int randint =(int)Math.floor((random.nextDouble()*1000000.0));
                bw.write(String.valueOf(randint)+" ");

            }
            bw.close();
            fw.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
