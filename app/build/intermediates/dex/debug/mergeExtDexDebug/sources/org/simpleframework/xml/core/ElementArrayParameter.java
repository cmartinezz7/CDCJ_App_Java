package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.stream.Format;

class ElementArrayParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public ElementArrayParameter(Constructor factory, ElementArray value, Format format, int index2) throws Exception {
        Contact contact2 = new Contact(value, factory, index2);
        this.contact = contact2;
        ElementArrayLabel elementArrayLabel = new ElementArrayLabel(contact2, value, format);
        this.label = elementArrayLabel;
        this.expression = elementArrayLabel.getExpression();
        this.path = elementArrayLabel.getPath();
        this.type = elementArrayLabel.getType();
        this.name = elementArrayLabel.getName();
        this.key = elementArrayLabel.getKey();
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

    public String toString() {
        return this.contact.toString();
    }

    private static class Contact extends ParameterContact<ElementArray> {
        public Contact(ElementArray label, Constructor factory, int index) {
            super(label, factory, index);
        }

        public String getName() {
            return ((ElementArray) this.label).name();
        }
    }
}
