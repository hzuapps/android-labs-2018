package edu.hzuapps.androidlabs.Com1614080901208;

import android.databinding.ObservableField;

/**
 * Created by cnt on 2018/5/12.
 */

public class RVBean {
    private ObservableField<String> uri=new ObservableField<>();
    private ObservableField<String> text=new ObservableField<>();

    public RVBean(String text,String uri){
        this.setText(text);
        this.setUri(uri);
    }

    public ObservableField<String> getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri.set(uri);
    }

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }
}
