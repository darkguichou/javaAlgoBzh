package metier;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by guillaume on 04/04/16.
 *
 *
 */
public class TableClients extends AbstractTableModel {

    public List<Utilisateur> utilisateurs;
    public String[] title = {"id", "code", "mail", "nom", "codeZONE"};


    public TableClients(List utilisateurs){

        super();
        this.utilisateurs = utilisateurs;


    }


    @Override
    public int getRowCount() {
        return utilisateurs.size();
    }

    @Override
    public int getColumnCount() {
        return title.length;
    }

    @Override
    public String getColumnName(int column) {
        return title[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {


        switch (columnIndex){

            case 0:
                return utilisateurs.get(rowIndex).getId();
            case 1:
                return utilisateurs.get(rowIndex).getCode();
            case 2:
                return utilisateurs.get(rowIndex).getEmail();
            case 3:
                return utilisateurs.get(rowIndex).getNom();
            case 4:
                return utilisateurs.get(rowIndex).getCOdeZone();
            default:
                return null;

        }

    }
}
