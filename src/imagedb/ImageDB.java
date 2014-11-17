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
            blob.blobInsert("D:\\java\\ImageDB\\src\\imagedb\\1.jpg");
            blob.blobRead("1.jpg", 7);
        }catch(Exception e)
        {
            System.out.print("[Main func error: ]"+e.getMessage());
        }
    }

}
