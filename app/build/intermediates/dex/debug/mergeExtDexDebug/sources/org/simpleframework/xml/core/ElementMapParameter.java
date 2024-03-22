package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;

class ElementMapParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public ElementMapParameter(Constructor factory, ElementMap value, Format format, int index2) throws Exception {
        Contact contact2 = new Contact(value, factory, index2);
        this.contact = contact2;
        ElementMapLabel elementMapLabel = new ElementMapLabel(contact2, value, format);
        this.label = elementMapLabel;
        this.expression = elementMapLabel.getExpression();
        this.path = elementMapLabel.getPath();
        this.type = elementMapLabel.getType();
        this.name = elementMapLabel.getName();
        this.key = elementMapLabel.getKey();
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

    private static class Contact extends ParameterContact<ElementMap> {
        public Contact(ElementMap label, Constructor factory, int index) {
            super(label, factory, index);
        }

        public String getName() {
            return ((ElementMap) this.label).name();
        }
    }
}
