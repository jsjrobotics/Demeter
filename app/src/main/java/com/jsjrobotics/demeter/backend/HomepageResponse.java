package com.jsjrobotics.demeter.backend;

import com.jsjrobotics.demeter.dataStructures.HomepageBlurb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomepageResponse {
    private static final String JSON_SUCCESS = "success";
    private static final String JSON_RESULT = "result";
    private final boolean mSuccess;
    private final List<HomepageBlurb> mResult;

    private HomepageResponse(boolean success, List<HomepageBlurb> result) {
        mSuccess = success;
        mResult = result;
    }

    public boolean getSuccess() {
        return mSuccess;
    }

    public List<HomepageBlurb> getResult() {
        return mResult;
    }

    public static HomepageResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            boolean success = json.getBoolean(JSON_SUCCESS);
            JSONArray resultJson = json.getJSONArray(JSON_RESULT);
            List<HomepageBlurb> result = inflateResultList(resultJson);
            return new HomepageResponse(success,result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emptyResponse();
    }

    private static List<HomepageBlurb> inflateResultList(JSONArray array) {
        List<HomepageBlurb> result = new ArrayList<>();
        try {
            for (int index = 0; index < array.length(); index++) {
                JSONObject current = array.getJSONObject(index);
                HomepageBlurb.parse(current).ifPresent(result::add);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static HomepageResponse emptyResponse() {
        return new HomepageResponse(false, Collections.emptyList());
    }

    public String getJson() {
        try {
            JSONObject json = new JSONObject();
            json.put(JSON_SUCCESS, mSuccess);
            json.put(JSON_RESULT, buildJsonArray());
            return json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    private JSONArray buildJsonArray() {
        JSONArray array = new JSONArray();
        for (HomepageBlurb blurb : mResult) {
            array.put(blurb.getJson());
        }
        return array;
    }
}
