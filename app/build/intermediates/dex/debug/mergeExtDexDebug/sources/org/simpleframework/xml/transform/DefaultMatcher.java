package org.simpleframework.xml.transform;

class DefaultMatcher implements Matcher {
    private Matcher array = new ArrayMatcher(this);
    private Matcher matcher;
    private Matcher primitive = new PrimitiveMatcher();
    private Matcher stock = new PackageMatcher();

    public DefaultMatcher(Matcher matcher2) {
        this.matcher = matcher2;
    }

    public Transform match(Class type) throws Exception {
        Transform value = this.matcher.match(type);
        if (value != null) {
            return value;
        }
        return matchType(type);
    }

    private Transform matchType(Class type) throws Exception {
        if (type.isArray()) {
            return this.array.match(type);
        }
        if (type.isPrimitive()) {
            return this.primitive.match(type);
        }
        return this.stock.match(type);
    }
}
