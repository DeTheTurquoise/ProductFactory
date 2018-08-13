package dmm.productfactory.jsonObjects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    private static JSONArray getArray(String JSONResult, String arrayField) throws JSONException {
        JSONObject searchResult = new JSONObject(JSONResult);
        return searchResult.getJSONArray(arrayField);
    }

    private static JSONObject poemObject(String JSONResult, int poemNumber) throws JSONException {
        JSONArray resultArray = getArray(JSONResult, "months");
        return resultArray.getJSONObject(poemNumber);
    }

    public static String getObjectName(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"name");
    }

    public static String getObjectPerspective(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"perspective");
    }
    public static String getObjectBegin(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"start");
    }
    public static String getObjectEnd(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"end");
    }
    public static String getObjectMiddle(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"middle");
    }
    public static String getObjectQuestion(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"question");
    }
    public static String getObjectDescription(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"description");
    }
    public static String getObjectQuote(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"quote_text");
    }
    public static String getObjectQuoteAuthor(String JSONResult, int poemNumber){
        return getObjectFromField(JSONResult, poemNumber,"quote_author");
    }

    public static String getObjectFromField(String JSONResult, int poemNumber, String jsonField){
        JSONObject poem = null;
        String poemTitle;
        try {
            poem = poemObject(JSONResult, poemNumber);
            poemTitle = poem.getString(jsonField);
        } catch (JSONException e) {
            e.printStackTrace();
            poemTitle = "";
        }
        return poemTitle;
    }

    public static String getObjectMotivation(String JSONResult, int poemNumber, int motNumber){
        JSONObject month = null;
        JSONArray motArray = null;
        JSONObject motObject = null;
        String motivation;
        try {
            month = poemObject(JSONResult, poemNumber);
            motArray = month.getJSONArray("motivation");
            motObject = motArray.getJSONObject(0);
            motivation = motObject.getString("m" + motNumber);
        } catch (JSONException e) {
            e.printStackTrace();
            motivation = "";
        }
        return motivation;
    }

    public static String getObjectWork(String JSONResult, int poemNumber, int week){
        JSONObject month = null;
        JSONArray workArray = null;
        JSONObject weekObject = null;
        String work;
        try {
            month = poemObject(JSONResult, poemNumber);
            workArray = month.getJSONArray("week");
            weekObject = workArray.getJSONObject(0);
            work = weekObject.getString("w" + week);
        } catch (JSONException e) {
            e.printStackTrace();
            work = "";
        }
        return work;
    }


    public static int countObjects(String JSONResult){
        JSONArray poems = null;
        try {
            poems = getArray(JSONResult, "months");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return poems.length();
    }

    public static String[] getObjectsList(String JSONResult){
        String poemList[] = new String[countObjects(JSONResult)];
        for (int i = 0; i< countObjects(JSONResult); i++){
            poemList[i] = getObjectName(JSONResult,i);
        }
        return poemList;
    }

}


