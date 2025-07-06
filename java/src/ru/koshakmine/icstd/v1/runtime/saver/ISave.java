package ru.koshakmine.icstd.v1.runtime.saver;

import org.json.JSONException;
import org.json.JSONObject;

public interface ISave {
    JSONObject save() throws JSONException;
}
