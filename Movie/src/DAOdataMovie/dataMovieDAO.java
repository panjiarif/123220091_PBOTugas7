/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataMovie;
import DAOImplement.dataMovieImplement;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123220091_PanjiArif
 */
public class dataMovieDAO implements dataMovieImplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE movie SET judul=?, alur=?, penokohan=?, akting=?, nilai=? WHERE movie.judul=? ";
    final String delete = "DELETE from movie where judul=?";
    final String clear = "TRUNCATE TABLE movie";
    
    public dataMovieDAO(){
        connection = connector.connection();
        
    }

    @Override
    public void insert(dataMovie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, p.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setJudul(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
        }
    }
}

    @Override
    public void update(dataMovie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, p.getNilai());
            statement.setString(6, p.getJudul());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
        }
    }
}

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
                try{
                    statement.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void clear(){ //btn "reset tabel"
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(clear);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
                try{
                    statement.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
            }
        }
        
    }

    @Override
    public List<dataMovie> getAll() {
        List<dataMovie> db = null;
        try{
            db = new ArrayList<dataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataMovie movie = new dataMovie();
                movie.setJudul(rs.getString("judul"));
                movie.setAlur(rs.getDouble("alur"));
                movie.setPenokohan(rs.getDouble("penokohan"));
                movie.setAkting(rs.getDouble("akting"));
                movie.setNilai(rs.getDouble("nilai"));
                db.add(movie);
                
                
            }
        }catch(SQLException ex){
            Logger.getLogger(dataMovieDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return db;
    }
}
