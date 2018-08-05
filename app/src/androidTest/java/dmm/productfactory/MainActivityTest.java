package dmm.productfactory;

import org.junit.Test;

import dmm.productfactory.activities.MainActivity;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {
    private static final String GENERAL_EXAMPLE_TEXT = "This is example text";
    private MainActivity mainActivity;

    @Test
    public void applicationDisplaysTextOnWholeScreen(){
        mainActivity.setGeneralText(GENERAL_EXAMPLE_TEXT);
        String textFromPage = mainActivity.getGeneralText();
        assertEquals(GENERAL_EXAMPLE_TEXT, textFromPage);
    }

    @Test
    public void applicationDisplaysTwoButtonsOfTheBottomOfPage(){

    }

    @Test
    public void leftButtonOfThePageMayMoveBack(){

    }

    @Test
    public void rightButtonOfThePageMayMoveForward(){

    }

    @Test
    public void buttonsMayMoveToExternalResources(){

    }

    @Test
    public void applicationMayDisplayMainScreenFromMenu(){

    }

    @Test
    public void applicationMayDisplayTextDependsOnDate(){

    }

    @Test
    public void applicationMayDisplayTextFromTableOfContents(){

    }

    @Test
    public void applicationDisplayTableOfContentsFromMenu(){

    }
}