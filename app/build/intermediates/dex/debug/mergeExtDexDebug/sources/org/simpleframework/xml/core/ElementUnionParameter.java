package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

class ElementUnionParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public ElementUnionParameter(Constructor factory, ElementUnion union, Element element, Format format, int index2) throws Exception {
        Contact contact2 = new Contact(element, factory, index2);
        this.contact = contact2;
        ElementUnionLabel elementUnionLabel = new ElementUnionLabel(contact2, union, element, format);
        this.label = elementUnionLabel;
        this.expression = elementUnionLabel.getExpression();
        this.path = elementUnionLabel.getPath();
        this.type = elementUnionLabel.getType();
        this.name = elementUnionLabel.getName();
        this.key = elementUnionLabel.getKey();
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

    private static class Contact extends ParameterContact<Element> {
        public Contact(Element element, Constructor factory, int index) {
            super(element, factory, index);
        }

        public String getName() {
            return ((Element) this.label).name();
        }
    }
}
