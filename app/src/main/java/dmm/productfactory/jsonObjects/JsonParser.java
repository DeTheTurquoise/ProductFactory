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

    public static int countObjects(String JSONResult){
        JSONArray poems = null;
        try {
            poems = getArray(JSONResult, "months");
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

    public static String[] getObjectsList(String JSONResult){
        String poemList[] = new String[countObjects(JSONResult)];
        for (int i = 0; i< countObjects(JSONResult); i++){
            poemList[i] = getObjectName(JSONResult,i);
        }
        return poemList;
    }

    public static String[] getDGlist(String result, String field) throws JSONException {
        JSONObject object = new JSONObject(result);
        JSONObject response = object.getJSONObject("response");
        JSONArray items = response.getJSONArray("items");
        String titles[] = new String[items.length()];
        for (int i = 0; i<items.length();i++){
            object = items.getJSONObject(i);
            titles[i] = object.getString(field);
        }
        return titles;
    }


}


