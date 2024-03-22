package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.stream.Format;

class ElementListParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public ElementListParameter(Constructor factory, ElementList value, Format format, int index2) throws Exception {
        Contact contact2 = new Contact(value, factory, index2);
        this.contact = contact2;
        ElementListLabel elementListLabel = new ElementListLabel(contact2, value, format);
        this.label = elementListLabel;
        this.expression = elementListLabel.getExpression();
        this.path = elementListLabel.getPath();
        this.type = elementListLabel.getType();
        this.name = elementListLabel.getName();
        this.key = elementListLabel.getKey();
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

    private static class Contact extends ParameterContact<ElementList> {
        public Contact(ElementList label, Constructor factory, int index) {
            super(label, factory, index);
        }

        public String getName() {
            return ((ElementList) this.label).name();
        }
    }
}
