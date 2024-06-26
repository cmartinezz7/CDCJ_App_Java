package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class ElementListUnionLabel extends TemplateLabel {
    private Contact contact;
    private GroupExtractor extractor;
    private Label label;
    private Expression path;

    public ElementListUnionLabel(Contact contact2, ElementListUnion union, ElementList element, Format format) throws Exception {
        this.label = new ElementListLabel(contact2, element, format);
        this.extractor = new GroupExtractor(contact2, union, format);
        this.contact = contact2;
    }

    public boolean isUnion() {
        return true;
    }

    public Contact getContact() {
        return this.contact;
    }

    public Annotation getAnnotation() {
        return this.label.getAnnotation();
    }

    public Type getType(Class type) {
        return getContact();
    }

    public Label getLabel(Class type) {
        return this;
    }

    public Converter getConverter(Context context) throws Exception {
        Expression path2 = getExpression();
        Type type = getContact();
        if (type != null) {
            return new CompositeListUnion(context, this.extractor, path2, type);
        }
        throw new UnionException("Union %s was not declared on a field or method", this.label);
    }

    public String[] getNames() throws Exception {
        return this.extractor.getNames();
    }

    public String[] getPaths() throws Exception {
        return this.extractor.getPaths();
    }

    public Object getEmpty(Context context) throws Exception {
        return this.label.getEmpty(context);
    }

    public Decorator getDecorator() throws Exception {
        return this.label.getDecorator();
    }

    public Type getDependent() throws Exception {
        return this.label.getDependent();
    }

    public String getEntry() throws Exception {
        return this.label.getEntry();
    }

    public String getName() throws Exception {
        return this.label.getName();
    }

    public String getPath() throws Exception {
        return this.label.getPath();
    }

    public Expression getExpression() throws Exception {
        if (this.path == null) {
            this.path = this.label.getExpression();
        }
        return this.path;
    }

    public String getOverride() {
        return this.label.getOverride();
    }

    public Class getType() {
        return this.label.getType();
    }

    public boolean isTextList() {
        return this.extractor.isTextList();
    }

    public boolean isCollection() {
        return this.label.isCollection();
    }

    public boolean isData() {
        return this.label.isData();
    }

    public boolean isInline() {
        return this.label.isInline();
    }

    public boolean isRequired() {
        return this.label.isRequired();
    }

    public String toString() {
        return this.label.toString();
    }
}
