package com.tealium.collect.attribute;

import com.tealium.collect.attribute.BaseAttribute;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class AttributeGroup<T extends BaseAttribute> implements Iterable<T> {
    /* access modifiers changed from: private */
    public final BaseAttribute[] a;
    private volatile int b;

    public AttributeGroup() {
        this.b = 0;
        this.a = new BaseAttribute[0];
    }

    public AttributeGroup(Collection<T> collection) {
        int i = 0;
        this.b = 0;
        if (collection == null) {
            this.a = new BaseAttribute[0];
            return;
        }
        int i2 = 0;
        for (T t : collection) {
            if (t != null) {
                i2++;
            }
        }
        BaseAttribute[] baseAttributeArr = new BaseAttribute[i2];
        for (T t2 : collection) {
            if (t2 != null) {
                int i3 = i - 1;
                while (i3 >= 0 && i > 0) {
                    if (!baseAttributeArr[i3].getId().equals(t2.getId())) {
                        i3--;
                    } else {
                        throw new IllegalArgumentException("The provided collection is not valid. There are duplicate entries with the same ids.");
                    }
                }
                baseAttributeArr[i] = t2;
                i++;
            }
        }
        this.a = baseAttributeArr;
    }

    public boolean contains(T t) {
        for (BaseAttribute equals : this.a) {
            if (equals.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(AttributeGroup<T> attributeGroup) {
        if (attributeGroup == null || attributeGroup.a.length > this.a.length) {
            return false;
        }
        int i = 0;
        while (true) {
            BaseAttribute[] baseAttributeArr = attributeGroup.a;
            if (i >= baseAttributeArr.length) {
                return true;
            }
            if (!contains(baseAttributeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public boolean containsAllIds(AttributeGroup<T> attributeGroup) {
        if (attributeGroup == null || attributeGroup.a.length > this.a.length) {
            return false;
        }
        int i = 0;
        while (true) {
            BaseAttribute[] baseAttributeArr = attributeGroup.a;
            if (i >= baseAttributeArr.length) {
                return true;
            }
            if (!containsId(baseAttributeArr[i].getId())) {
                return false;
            }
            i++;
        }
    }

    public boolean containsId(T t) {
        return t != null && containsId(t.getId());
    }

    public boolean containsId(String str) {
        for (BaseAttribute id : this.a) {
            if (id.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean equalIds(AttributeGroup<T> attributeGroup) {
        if (attributeGroup == null || attributeGroup.size() != size()) {
            return false;
        }
        for (BaseAttribute id : this.a) {
            if (!attributeGroup.containsId(id.getId())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AttributeGroup)) {
            return false;
        }
        AttributeGroup attributeGroup = (AttributeGroup) obj;
        BaseAttribute[] baseAttributeArr = this.a;
        if (baseAttributeArr.length != attributeGroup.a.length) {
            return false;
        }
        int length = baseAttributeArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            BaseAttribute baseAttribute = baseAttributeArr[i];
            int i2 = 0;
            while (true) {
                BaseAttribute[] baseAttributeArr2 = attributeGroup.a;
                if (i2 >= baseAttributeArr2.length) {
                    z = false;
                    break;
                } else if (baseAttribute.equals(baseAttributeArr2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    public T get(String str) {
        for (T t : this.a) {
            if (t.getId().equals(str)) {
                return t;
            }
        }
        return null;
    }

    public int hashCode() {
        int i = this.b;
        if (i == 0) {
            i = 17;
            for (BaseAttribute hashCode : this.a) {
                i = (i * 31) + hashCode.hashCode();
            }
            this.b = i;
        }
        return i;
    }

    public boolean isEmpty() {
        return this.a.length == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int b = 0;

            /* renamed from: a */
            public T next() {
                if (hasNext()) {
                    T[] a2 = AttributeGroup.this.a;
                    int i = this.b;
                    this.b = i + 1;
                    return a2[i];
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return this.b < AttributeGroup.this.a.length;
            }

            public void remove() {
                throw new UnsupportedOperationException("Removal is not supported.");
            }
        };
    }

    public int size() {
        return this.a.length;
    }

    public T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (BaseAttribute[]) ((BaseAttribute[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        for (int i = 0; i < size; i++) {
            tArr[i] = this.a[i];
        }
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public Object[] toArray() {
        BaseAttribute[] baseAttributeArr = this.a;
        Object[] objArr = new Object[baseAttributeArr.length];
        System.arraycopy(baseAttributeArr, 0, objArr, 0, baseAttributeArr.length);
        return objArr;
    }

    public String toString() {
        return toString((String) null);
    }

    public String toString(String str) {
        String str2;
        String str3;
        Iterator it = iterator();
        String str4 = "";
        if (str == null || str.length() == 0) {
            str3 = str4;
            str2 = str3;
        } else {
            str4 = System.getProperty("line.separator");
            str2 = str + str;
            str3 = str;
        }
        StringBuilder append = new StringBuilder("[").append(str4);
        while (it.hasNext()) {
            append.append(str2).append(((BaseAttribute) it.next()).toString());
            if (it.hasNext()) {
                append.append(',');
            }
            append.append(str4);
        }
        return append.append(str3).append(']').toString();
    }
}
