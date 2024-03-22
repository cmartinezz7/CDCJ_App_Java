package com.stanfy.gsonxml;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Primitives;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.stanfy.gsonxml.XmlReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;

public class GsonXml {
    private final Gson core;
    private final XmlReader.Options options;
    private final XmlParserCreator xmlParserCreator;

    GsonXml(Gson gson, XmlParserCreator xmlParserCreator2, XmlReader.Options options2) {
        if (xmlParserCreator2 != null) {
            this.core = gson;
            this.xmlParserCreator = xmlParserCreator2;
            this.options = options2;
            return;
        }
        throw new NullPointerException("XmlParserCreator is null");
    }

    public Gson getGson() {
        return this.core;
    }

    public <T> T fromXml(String json, Class<T> classOfT) throws JsonSyntaxException {
        return Primitives.wrap(classOfT).cast(fromXml(json, (Type) classOfT));
    }

    public <T> T fromXml(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return fromXml((Reader) new StringReader(json), typeOfT);
    }

    public <T> T fromXml(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        XmlReader jsonReader = new XmlReader(json, this.xmlParserCreator, this.options);
        Object object = fromXml(jsonReader, (Type) classOfT);
        assertFullConsumption(object, jsonReader);
        return Primitives.wrap(classOfT).cast(object);
    }

    public <T> T fromXml(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        XmlReader jsonReader = new XmlReader(json, this.xmlParserCreator, this.options);
        T object = fromXml(jsonReader, typeOfT);
        assertFullConsumption(object, jsonReader);
        return object;
    }

    private static void assertFullConsumption(Object obj, JsonReader reader) {
        if (obj != null) {
            try {
                if (reader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IOException e2) {
                throw new JsonIOException((Throwable) e2);
            }
        }
    }

    public <T> T fromXml(XmlReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return this.core.fromJson((JsonReader) reader, typeOfT);
    }

    public String toString() {
        return this.core.toString();
    }
}
