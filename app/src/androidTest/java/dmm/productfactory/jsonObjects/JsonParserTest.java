package dmm.productfactory.jsonObjects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonParserTest {

    @Test
    public void applicationCountsObjects(){
        assertEquals(12,JsonParser.countObjects(JsonData.POEM_DATA));
    }

    @Test
    public void applicationGetsTitlesToToc(){
        String titles[] = JsonParser.getObjectsList(JsonData.POEM_DATA);
        assertEquals("Styczeń",titles[0]);
        assertEquals("Marzec",titles[2]);
        assertEquals("Sierpień",titles[7]);
        assertEquals("Grudzień",titles[11]);
    }

}