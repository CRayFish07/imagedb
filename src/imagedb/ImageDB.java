/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagedb;

import java.io.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Eason Lu
 */
public class ImageDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            BlobPros blob=new BlobPros();
            blob.blobInsert("D:\\java\\ImageDB\\src\\imagedb\\1.jpg");//这里面的1.jpg代表的是本地照相机照出来的相片，然后存入数据库
//            blob.blobRead("1.jpg", 7);//这个地方的7代表就是数据库当中图片的id
        }catch(Exception e)
        {
            System.out.print("[Main func error: ]"+e.getMessage());
        }
    }

}
