package dmm.productfactory.databaseObjects;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {StoryObject.class}, version = 1)
public abstract class StoryDatabase extends RoomDatabase {
    public abstract StoryDao getStoryDao();
}
