package com.jsjrobotics.demeter.backend.downloader;

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
    private static final String JSON_TITLE = "title";
    private static final String JSON_SUMMARY = "summary";
    private static final String JSON_IMAGE = "image";
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

    static HomepageResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            boolean success = json.getBoolean(JSON_SUCCESS);
            List<HomepageBlurb> result = new ArrayList<>();
            JSONArray resultJson = json.getJSONArray(JSON_RESULT);
            for (int index = 0; index < resultJson.length(); index++ ){
                JSONObject current = resultJson.getJSONObject(index);
                String title = current.getString(JSON_TITLE);
                String summary = current.getString(JSON_SUMMARY);
                String image = current.getString(JSON_IMAGE);
                result.add(new HomepageBlurb(title, summary, image));
            }
            return new HomepageResponse(success,result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emptyResponse();
    }

    public static HomepageResponse emptyResponse() {
        return new HomepageResponse(false, Collections.emptyList());
    }
}
