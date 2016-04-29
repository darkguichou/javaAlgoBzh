package dao;

/**
 * Created by guillaume on 28/04/16.
 */
public abstract class Dao {


    private Db db;



    public Dao(Db db){


        this.db = db;

    }


    public Db getDb() {
        return db;
    }
}
