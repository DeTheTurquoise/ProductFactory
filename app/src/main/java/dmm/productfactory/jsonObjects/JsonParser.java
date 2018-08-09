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
        JSONArray resultArray = getArray(JSONResult, "poems");
        return resultArray.getJSONObject(poemNumber);
    }

    public static String getPoemTitle(String JSONResult, int poemNumber){
        JSONObject poem = null;
        String poemTitle;
        try {
            poem = poemObject(JSONResult, poemNumber);
            poemTitle = poem.getString("poemTitle");
        } catch (JSONException e) {
            e.printStackTrace();
            poemTitle = "";
        }
        return poemTitle;
    }

    public static String getPoemText(String JSONResult, int poemNumber){
        JSONObject poem = null;
        String poemText;
        try {
            poem = poemObject(JSONResult, poemNumber);
            poemText = poem.getString("poemText");
        } catch (JSONException e) {
            e.printStackTrace();
            poemText = "";
        }
        return poemText;
    }

    public static int countPoems(String JSONResult){
        JSONArray poems = null;
        try {
            poems = getArray(JSONResult, "poems");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return poems.length();
    }

    public static String getAuthor(String JSONResult){
        JSONObject object = null;
        try {
            object = new JSONObject(JSONResult);
            return object.getString("author");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getTitle(String JSONResult){
        JSONObject object = null;
        String title;
        try {
            object = new JSONObject(JSONResult);
            title = object.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
            title = "";
        }
        return title;
    }

    public static String[] getPoemList(String JSONResult){
        String poemList[] = new String[countPoems(JSONResult)];
        for (int i=0;i<countPoems(JSONResult);i++){
            poemList[i] = getPoemTitle(JSONResult,i);
        }
        return poemList;
    }

}


