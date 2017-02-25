package com.vaxapp.data.entity;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import javax.inject.Inject;

public class GsonMapper {

    private static final String TAG = GsonMapper.class.getSimpleName();

    private final Gson mapper;

    @Inject
    public GsonMapper(final Gson mapper) {
        this.mapper = mapper;
    }

    public <T> T read(final String content, final Class<T> type) throws JsonSyntaxException {
        try {
            return this.mapper.fromJson(content, type);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Error mapping json to class '" + type + "' with contents: '" + content + "'", e);
            throw e;
        }
    }

    public <T> T read(final String content, final Type type) throws JsonSyntaxException {
        try {
            return this.mapper.fromJson(content, type);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Error mapping json to class '" + type + "' with contents: '" + content + "'", e);
            throw e;
        }
    }

    public <T> T read(final InputStream content, final Class<T> type) throws JsonIOException, JsonSyntaxException {
        try {
            return this.mapper.fromJson(new InputStreamReader(content), type);
        } catch (JsonIOException | JsonSyntaxException e) {
            Log.e(TAG, "Error mapping json to class '" + type + "' with contents: '" + content + "'", e);
            throw e;
        }
    }

    public <T> String write(final T content, final Class<T> type) {
        try {
            return this.mapper.toJson(content, type);
        } catch (JsonIOException | JsonSyntaxException e) {
            Log.e(TAG, "Error mapping class '" + type + "' to json with contents: '" + content + "'", e);
            throw e;
        }
    }
}
