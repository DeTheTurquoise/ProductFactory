package dmm.productfactory.activities;

import org.junit.Test;

import dmm.productfactory.jsonObjects.JsonData;
import dmm.productfactory.jsonObjects.JsonParser;

import static org.junit.Assert.assertEquals;

public class StoryActivityTest {

    private static final String POEM_TEXT = "Co to jest miłość\nNie wiem\nAle to miłe\nŻe chcę go mieć\nDla siebie\nNa nie wiem\nIle\n\nGdzie mieszka miłość\nNie wiem\nMoże w uśmiechu\nCzasem ją słychać\nW śpiewie\nA czasem\nW echu\n\nCo to jest miłość\nPowiedz\nAlbo nic nie mów\nJa chce cie miec\nPrzy sobie\nI nie wiem\nCzemu ";


    @Test
    public void applicationGetsPoemNumber(){
        assertEquals(24, JsonParser.countPoems(JsonData.POEM_DATA));
    }

    @Test
    public void applicationGetsPoemTitle(){
        assertEquals("To najdalsze",JsonParser.getPoemTitle(JsonData.POEM_DATA,22));
    }

    @Test
    public void applicationGetsPoemText(){
        assertEquals(POEM_TEXT,JsonParser.getPoemText(JsonData.POEM_DATA,5));
    }
}