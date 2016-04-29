package models.parts;

import models.entities.Visite;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by guillaume on 06/04/16.
 */
public class TableVisites extends AbstractTableModel {

    public List<Visite> visites;
    public String[] titles = { "nom", "ville", "date", "heure", "lieu", "interlocuteur"};



    public TableVisites(List visites){

        super();
        this.visites = visites;

    }


    @Override
    public int getRowCount() {
        return visites.size();
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }

    @Override
    public String getColumnName(int column) {
        return titles[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex){

            case 0:
                return visites.get(rowIndex).getNom();
            case 1:
                return visites.get(rowIndex).getVille();
            case 2:
                return visites.get(rowIndex).getDate();
            case 3:
                return visites.get(rowIndex).getHeure();
            case 4:
                return visites.get(rowIndex).getLieu();
            case 5:
                return visites.get(rowIndex).getInterlocuteur();
            default:
                return null;

        }



    }
}
