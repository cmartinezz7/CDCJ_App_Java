package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class TextParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public TextParameter(Constructor factory, Text value, Format format, int index2) throws Exception {
        Contact contact2 = new Contact(value, factory, index2);
        this.contact = contact2;
        TextLabel textLabel = new TextLabel(contact2, value, format);
        this.label = textLabel;
        this.expression = textLabel.getExpression();
        this.path = textLabel.getPath();
        this.type = textLabel.getType();
        this.name = textLabel.getName();
        this.key = textLabel.getKey();
        this.index = index2;
    }

    public Object getKey() {
        return this.key;
    }

    public String getPath() {
        return this.path;
    }

    public String getName() {
        return this.name;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public String getPath(Context context) {
        return getPath();
    }

    public String getName(Context context) {
        return getName();
    }

    public Class getType() {
        return this.type;
    }

    public Annotation getAnnotation() {
        return this.contact.getAnnotation();
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isRequired() {
        return this.label.isRequired();
    }

    public boolean isPrimitive() {
        return this.type.isPrimitive();
    }

    public boolean isText() {
        return true;
    }

    public String toString() {
        return this.contact.toString();
    }

    private static class Contact extends ParameterContact<Text> {
        public Contact(Text label, Constructor factory, int index) {
            super(label, factory, index);
        }

        public String getName() {
            return "";
        }
    }
}
