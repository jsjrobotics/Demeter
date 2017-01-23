package com.jsjrobotics.demeter.backend.downloader;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;


public class HomepageApi {

    private final RequestQueue mRequestQueue;
    private static final String BASE_URL = "http://jsjrobotics.nyc/";
    private static final String URL = BASE_URL + "cgi-bin/homepage.pl";

    public HomepageApi(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public void downloadData(Receiver<HomepageResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
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
