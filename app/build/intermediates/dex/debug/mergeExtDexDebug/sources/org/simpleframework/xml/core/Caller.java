package org.simpleframework.xml.core;

class Caller {
    private final Function commit;
    private final Function complete;
    private final Context context;
    private final Function persist;
    private final Function replace;
    private final Function resolve;
    private final Function validate;

    public Caller(Scanner schema, Context context2) {
        this.validate = schema.getValidate();
        this.complete = schema.getComplete();
        this.replace = schema.getReplace();
        this.resolve = schema.getResolve();
        this.persist = schema.getPersist();
        this.commit = schema.getCommit();
        this.context = context2;
    }

    public Object replace(Object source) throws Exception {
        Function function = this.replace;
        if (function != null) {
            return function.call(this.context, source);
        }
        return source;
    }

    public Object resolve(Object source) throws Exception {
        Function function = this.resolve;
        if (function != null) {
            return function.call(this.context, source);
        }
        return source;
    }

    public void commit(Object source) throws Exception {
        Function function = this.commit;
        if (function != null) {
            function.call(this.context, source);
        }
    }

    public void validate(Object source) throws Exception {
        Function function = this.validate;
        if (function != null) {
            function.call(this.context, source);
        }
    }

    public void persist(Object source) throws Exception {
        Function function = this.persist;
        if (function != null) {
            function.call(this.context, source);
        }
    }

    public void complete(Object source) throws Exception {
        Function function = this.complete;
        if (function != null) {
            function.call(this.context, source);
        }
    }
}
