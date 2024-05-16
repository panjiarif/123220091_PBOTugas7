/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author 123220091_PanjiArif
 */
public class connector {
    static Connection konek;
    
    public static Connection connection(){
        if(konek==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("movie_db");
            data.setUser("root");
            data.setPassword("");
            try{
                konek = data.getConnection();
                System.out.println("Koneksi berhasil");
            }catch(SQLException ex){
                ex.printStackTrace();
                System.out.println("Koneksi gagal");
            }
        }
        
        return konek;
    }
}
