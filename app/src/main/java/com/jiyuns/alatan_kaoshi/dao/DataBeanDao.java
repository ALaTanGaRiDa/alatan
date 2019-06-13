package com.jiyuns.alatan_kaoshi.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jiyuns.alatan_kaoshi.bean.DataBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATA_BEAN".
*/
public class DataBeanDao extends AbstractDao<DataBean, Long> {

    public static final String TABLENAME = "DATA_BEAN";

    /**
     * Properties of entity DataBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Lid = new Property(0, Long.class, "lid", true, "_id");
        public final static Property Id = new Property(1, String.class, "id", false, "ID");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Pic = new Property(3, String.class, "pic", false, "PIC");
        public final static Property Collect_num = new Property(4, String.class, "collect_num", false, "COLLECT_NUM");
        public final static Property Food_str = new Property(5, String.class, "food_str", false, "FOOD_STR");
        public final static Property Num = new Property(6, int.class, "num", false, "NUM");
    }


    public DataBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DataBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATA_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: lid
                "\"ID\" TEXT," + // 1: id
                "\"TITLE\" TEXT," + // 2: title
                "\"PIC\" TEXT," + // 3: pic
                "\"COLLECT_NUM\" TEXT," + // 4: collect_num
                "\"FOOD_STR\" TEXT," + // 5: food_str
                "\"NUM\" INTEGER NOT NULL );"); // 6: num
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATA_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DataBean entity) {
        stmt.clearBindings();
 
        Long lid = entity.getLid();
        if (lid != null) {
            stmt.bindLong(1, lid);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(4, pic);
        }
 
        String collect_num = entity.getCollect_num();
        if (collect_num != null) {
            stmt.bindString(5, collect_num);
        }
 
        String food_str = entity.getFood_str();
        if (food_str != null) {
            stmt.bindString(6, food_str);
        }
        stmt.bindLong(7, entity.getNum());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DataBean entity) {
        stmt.clearBindings();
 
        Long lid = entity.getLid();
        if (lid != null) {
            stmt.bindLong(1, lid);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(4, pic);
        }
 
        String collect_num = entity.getCollect_num();
        if (collect_num != null) {
            stmt.bindString(5, collect_num);
        }
 
        String food_str = entity.getFood_str();
        if (food_str != null) {
            stmt.bindString(6, food_str);
        }
        stmt.bindLong(7, entity.getNum());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DataBean readEntity(Cursor cursor, int offset) {
        DataBean entity = new DataBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // lid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // pic
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // collect_num
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // food_str
            cursor.getInt(offset + 6) // num
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DataBean entity, int offset) {
        entity.setLid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPic(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCollect_num(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFood_str(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setNum(cursor.getInt(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DataBean entity, long rowId) {
        entity.setLid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DataBean entity) {
        if(entity != null) {
            return entity.getLid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DataBean entity) {
        return entity.getLid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
