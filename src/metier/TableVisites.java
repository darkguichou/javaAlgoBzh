package metier;

import gui.ListeClientView;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by guillaume on 06/04/16.
 */
public class TableVisites extends AbstractTableModel {

    public List<Visite> visites;
    public String[] titles = {"id", "date", "heure", "lieu", "interlocuteur", "idClient", "zone"};



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
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex){

            case 0:
                return visites.get(rowIndex).getId();
            case 1:
                return visites.get(rowIndex).getDate();
            case 2:
                return visites.get(rowIndex).getHeure();
            case 3:
                return visites.get(rowIndex).getLieu();
            case 4:
                return visites.get(rowIndex).getInterlocuteur();
            case 5:
                return visites.get(rowIndex).getIdClient();
            case 6:
                return visites.get(rowIndex).getZone();
            default:
                return null;

        }



    }
}
