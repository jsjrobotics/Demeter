package com.jsjrobotics.demeter.backend;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.FileUtils;
import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.dataStructures.resources.HomeScreenResource;

import java.io.File;


public class HomepageApi {

    private final RequestQueue mRequestQueue;
    private final String mBaseUrl;

    public HomepageApi(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        mBaseUrl = context.getString(R.string.base_url);
    }

    public void downloadData(String urlPath, Receiver<HomepageResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                mBaseUrl + urlPath,
                buildSuccessListener(listener),
                buildErrorListener(listener)
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildErrorListener(Receiver<HomepageResponse> listener) {
        return volleyError -> {
            volleyError.printStackTrace();
            listener.accept(HomepageResponse.emptyResponse());
        };
    }

    private Response.Listener<String> buildSuccessListener(final Receiver<HomepageResponse> listener) {
        return response -> {
            HomepageResponse result = HomepageResponse.parse(response);
            listener.accept(result);
        };
    }
}
