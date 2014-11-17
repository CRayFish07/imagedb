/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagedb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Eason Lu
 */
public class BlobPros {

    private static final String URL = "jdbc:mysql://localhost:3306/imagedb";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private File file = null;
    String username = "root";
    String password = "1234";

    public void blobInsert(String infile) throws Exception {
        FileInputStream fis = null;
        try {
            conn = DriverManager.getConnection(URL, username, password);
            file = new File(infile);
            fis = new FileInputStream(file);
            pstmt = conn.prepareStatement("insert into imgt(name,pic) values(?,?)");
            pstmt.setString(1, file.getName());
            pstmt.setBinaryStream(2, fis, fis.available());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.printf("[blobInsert error : ]" + ex.toString());
        } finally {
            pstmt.close();
            fis.close();
            conn.close();
        }
    }

    public void blobRead(String outfile, int picID) throws Exception {
        FileOutputStream fos = null;
        InputStream is = null;
        byte[] Buffer = new byte[4096];
        try {
            conn = DriverManager.getConnection(URL, username, password);
            pstmt=conn.prepareStatement("Select pic from imgt where id=?");
            pstmt.setInt(1, picID);
            rs=pstmt.executeQuery();
            rs.next();
            file=new File(outfile);
            if(!file.exists())
            {
                file.createNewFile();
            }
            fos=new FileOutputStream(file);
            is=rs.getBinaryStream("pic");
            int size=0;
            while((size=is.read(Buffer))!=-1)
            {
                fos.write(Buffer,0,size);
            }
        }catch(Exception e)
        {
            System.out.printf("[OutPutFile error : ]"+e.getMessage());
        }
        finally
        {
            fos.close();
            rs.close();
            pstmt.close();
            conn.close();
        }
    }
}
