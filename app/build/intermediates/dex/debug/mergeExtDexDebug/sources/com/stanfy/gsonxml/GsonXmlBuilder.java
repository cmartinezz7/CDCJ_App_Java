package com.stanfy.gsonxml;

import com.google.gson.GsonBuilder;
import com.stanfy.gsonxml.XmlReader;

public class GsonXmlBuilder {
    private GsonBuilder coreBuilder;
    private final XmlReader.Options options;
    private XmlParserCreator xmlParserCreator;

    public GsonXmlBuilder() {
        XmlReader.Options options2 = new XmlReader.Options();
        this.options = options2;
        options2.skipRoot = true;
        options2.namespaces = false;
        options2.sameNameList = false;
    }

    public GsonXmlBuilder wrap(GsonBuilder gsonBuilder) {
        this.coreBuilder = gsonBuilder;
        return this;
    }

    public GsonXmlBuilder setXmlParserCreator(XmlParserCreator xmlParserCreator2) {
        this.xmlParserCreator = xmlParserCreator2;
        return this;
    }

    public GsonXmlBuilder setSkipRoot(boolean value) {
        this.options.skipRoot = value;
        return this;
    }

    public GsonXmlBuilder setTreatNamespaces(boolean value) {
        this.options.namespaces = value;
        return this;
    }

    public GsonXmlBuilder setSameNameLists(boolean value) {
        this.options.sameNameList = value;
        return this;
    }

    public GsonXmlBuilder setPrimitiveArrays(boolean primitiveArrays) {
        this.options.primitiveArrays = primitiveArrays;
        return this;
    }

    public GsonXmlBuilder setRootArrayPrimitive(boolean rootArrayPrimitive) {
        this.options.rootArrayPrimitive = rootArrayPrimitive;
        return this;
    }

    public GsonXml create() {
        if (this.coreBuilder == null) {
            this.coreBuilder = new GsonBuilder();
        }
        return new GsonXml(this.coreBuilder.create(), this.xmlParserCreator, this.options);
    }
}
