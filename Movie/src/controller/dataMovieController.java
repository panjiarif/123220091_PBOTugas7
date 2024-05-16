/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdataMovie.dataMovieDAO;
import DAOImplement.dataMovieImplement;
import model.*;
import view.MainView;

/**
 *
 * @author 123220091_PanjiArif
 */
public class dataMovieController {
    MainView frame;
    dataMovieImplement implDataMovie;
    List<dataMovie> db;
    
    public dataMovieController(MainView frame){
        this.frame = frame;
        implDataMovie = new dataMovieDAO();
        db = implDataMovie.getAll();
    }
    
    public void isiTabel(){
        db = implDataMovie.getAll();
        modelTabelDataMovie mb = new modelTabelDataMovie(db);
        frame.getTabelDataMovie().setModel(mb);
    }
    
    public void insert(){
        dataMovie dm = new dataMovie();
        dm.setJudul(frame.getJTxtJudul().getText());
        Double alur = Double.parseDouble(frame.getJTxtAlur().getText());
        dm.setAlur(alur);
        Double penokohan = Double.parseDouble(frame.getJTxtPenokohan().getText());
        dm.setPenokohan(penokohan);
        Double akting = Double.parseDouble(frame.getJtxtAkting().getText());
        dm.setAkting(akting);
        Double nilai = (alur + penokohan + akting)/3;
        dm.setNilai(nilai);
        implDataMovie.insert(dm);
    }
    
    public void update(){
        dataMovie dm = new dataMovie();
        dm.setJudul(frame.getJTxtJudul().getText());
        Double alur = Double.parseDouble(frame.getJTxtAlur().getText());
        dm.setAlur(alur);
        Double penokohan = Double.parseDouble(frame.getJTxtPenokohan().getText());
        dm.setPenokohan(penokohan);
        Double akting = Double.parseDouble(frame.getJtxtAkting().getText());
        dm.setAkting(akting);
        Double nilai = (alur + penokohan + akting)/3;
        dm.setNilai(nilai);
        dm.setJudul(frame.getJTxtJudul().getText());
        implDataMovie.update(dm);
    }
    
    public void delete(){
        String judul = frame.getJTxtJudul().getText();
        implDataMovie.delete(judul);
    }
    
    public void clear(){ //btn "reset tabel"
        implDataMovie.clear();
    }    

}
