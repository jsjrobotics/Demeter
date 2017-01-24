package com.jsjrobotics.demeter.backend.downloader;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.R;


public class VolleyDownloader {

    private final RequestQueue mRequestQueue;

    public VolleyDownloader(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void downloadData(String url, Receiver<Optional<String>> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response -> listener.accept(Optional.of(response)),
                buildErrorListener(listener)
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildErrorListener(Receiver<Optional<String>> listener) {
        return volleyError -> {
            volleyError.printStackTrace();
            listener.accept(Optional.empty());
        };
    }

    private Response.Listener<String> buildSuccessListener(final Receiver<HomepageResponse> listener) {
        return response -> {
            HomepageResponse result = HomepageResponse.parse(response);
            listener.accept(result);
        };
    }
}
