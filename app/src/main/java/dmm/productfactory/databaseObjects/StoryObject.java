package dmm.productfactory.databaseObjects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class StoryObject {

    @PrimaryKey
    private int storyId;

    @ColumnInfo(name = "main_text")
    private String mainText;

    @ColumnInfo(name = "additional_text")
    private String additionalText;

    @ColumnInfo(name = "external_text")
    private String externalText;

    @ColumnInfo(name = "external_link")
    private String externalLink;

    @ColumnInfo(name = "display_date")
    private String displayDate;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public String getExternalText() {
        return externalText;
    }

    public void setExternalText(String externalText) {
        this.externalText = externalText;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }
}
