package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.BaseAttribute;
import com.tealium.internal.c.j;
import com.tealium.internal.listeners.MainListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

abstract class a<L extends MainListener, A extends BaseAttribute> extends j<L> {
    private final AttributeGroup<A> a;
    private List<A> b;
    private List<A> c;
    private List<A> d;

    a(Class<L> cls, AttributeGroup<A> attributeGroup, AttributeGroup<A> attributeGroup2) {
        super(cls);
        this.a = attributeGroup;
        a(attributeGroup, attributeGroup2);
    }

    private void a(AttributeGroup<A> attributeGroup, AttributeGroup<A> attributeGroup2) {
        if (attributeGroup != null || attributeGroup2 != null) {
            if (attributeGroup == null) {
                Iterator<A> it = attributeGroup2.iterator();
                while (it.hasNext()) {
                    h().add(it.next());
                }
            } else if (attributeGroup2 == null) {
                Iterator<A> it2 = attributeGroup.iterator();
                while (it2.hasNext()) {
                    g().add(it2.next());
                }
            } else {
                Iterator<A> it3 = attributeGroup.iterator();
                while (it3.hasNext()) {
                    BaseAttribute baseAttribute = (BaseAttribute) it3.next();
                    A a2 = attributeGroup2.get(baseAttribute.getId());
                    if (a2 == null) {
                        g().add(baseAttribute);
                    } else if (!baseAttribute.equals(a2)) {
                        i().add(a2);
                    }
                }
                Iterator<A> it4 = attributeGroup2.iterator();
                while (it4.hasNext()) {
                    BaseAttribute baseAttribute2 = (BaseAttribute) it4.next();
                    if (!attributeGroup.containsId(baseAttribute2)) {
                        h().add(baseAttribute2);
                    }
                }
            }
        }
    }

    private List<A> g() {
        List<A> list = this.b;
        if (list != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        this.b = linkedList;
        return linkedList;
    }

    private List<A> h() {
        List<A> list = this.c;
        if (list != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        this.c = linkedList;
        return linkedList;
    }

    private List<A> i() {
        List<A> list = this.d;
        if (list != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        this.d = linkedList;
        return linkedList;
    }

    public final boolean a() {
        return (this.b == null && this.d == null && this.c == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public final AttributeGroup<A> b() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final List<A> c() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public final List<A> d() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final List<A> e() {
        return this.d;
    }
}
