package dmm.productfactory.databaseObjects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StoryDao {

    @Query("SELECT * FROM storyobject")
    List<StoryObject> getAll();

    @Insert
    void insertAll(StoryObject... objects);

    @Delete
    void delete(StoryObject object);
}
