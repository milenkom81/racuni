package moji_razredi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

    interface JsonSupport
    {
        public String toJSON();
        public <T> T fromJSON(String json);
    }
