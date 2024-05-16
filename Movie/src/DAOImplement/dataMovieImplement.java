/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author 123220092_PanjiArif
 */
public interface dataMovieImplement {
    public void insert(dataMovie p);
    public void update(dataMovie p);
    public void delete(String judul);
    public void clear(); //btn "reset tabel"
    public List<dataMovie> getAll();
}
