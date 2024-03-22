package com.tealium.collect.visitor;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.AudienceAttribute;
import com.tealium.collect.attribute.BadgeAttribute;
import com.tealium.collect.attribute.DateAttribute;
import com.tealium.collect.attribute.FlagAttribute;
import com.tealium.collect.attribute.MetricAttribute;
import com.tealium.collect.attribute.PropertyAttribute;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class VisitorProfile extends a {
    private volatile int a;
    private final AttributeGroup<AudienceAttribute> b;
    private final AttributeGroup<BadgeAttribute> c;
    private final CurrentVisit d;
    private final String e;
    private final boolean f;

    public static final class Builder {
        private long a;
        private Collection<AudienceAttribute> b;
        private Collection<BadgeAttribute> c;
        private Collection<DateAttribute> d;
        private Collection<FlagAttribute> e;
        private Collection<MetricAttribute> f;
        private Collection<PropertyAttribute> g;
        private CurrentVisit h;
        private String i;
        private boolean j;

        public VisitorProfile build() {
            return new VisitorProfile(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.j, this.i);
        }

        public Builder setAudiences(Collection<AudienceAttribute> collection) {
            this.b = collection;
            return this;
        }

        public Builder setBadges(Collection<BadgeAttribute> collection) {
            this.c = collection;
            return this;
        }

        public Builder setCreationDate(long j2) {
            this.a = j2;
            return this;
        }

        public Builder setCurrentVisit(CurrentVisit currentVisit) {
            this.h = currentVisit;
            return this;
        }

        public Builder setDates(Collection<DateAttribute> collection) {
            this.d = collection;
            return this;
        }

        public Builder setFlags(Collection<FlagAttribute> collection) {
            this.e = collection;
            return this;
        }

        public Builder setIsNewVisitor(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setMetrics(Collection<MetricAttribute> collection) {
            this.f = collection;
            return this;
        }

        public Builder setProperties(Collection<PropertyAttribute> collection) {
            this.g = collection;
            return this;
        }

        public Builder setSource(String str) {
            this.i = str;
            return this;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private VisitorProfile(long j, Collection<AudienceAttribute> collection, Collection<BadgeAttribute> collection2, Collection<DateAttribute> collection3, Collection<FlagAttribute> collection4, Collection<MetricAttribute> collection5, Collection<PropertyAttribute> collection6, CurrentVisit currentVisit, boolean z, String str) {
        super(j, collection3, collection4, collection5, collection6);
        CurrentVisit currentVisit2 = currentVisit;
        if (currentVisit2 == null) {
            this.d = new CurrentVisit();
        } else {
            this.d = currentVisit2;
        }
        Collection<BadgeAttribute> collection7 = collection2;
        this.c = new AttributeGroup<>(collection2);
        Collection<AudienceAttribute> collection8 = collection;
        this.b = new AttributeGroup<>(collection);
        this.f = z;
        this.e = str;
    }

    private static Set<AudienceAttribute> a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            hashSet.add(new AudienceAttribute(obj, jSONObject.getString(obj)));
        }
        return hashSet;
    }

    private static Set<BadgeAttribute> b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(new BadgeAttribute(keys.next().toString()));
        }
        return hashSet;
    }

    private static Set<FlagAttribute> c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            hashSet.add(new FlagAttribute(obj, jSONObject.getBoolean(obj)));
        }
        return hashSet;
    }

    private static Set<MetricAttribute> d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            hashSet.add(new MetricAttribute(obj, jSONObject.optDouble(obj, 0.0d)));
        }
        return hashSet;
    }

    private static Set<PropertyAttribute> e(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            hashSet.add(new PropertyAttribute(obj, jSONObject.optString(obj, "")));
        }
        return hashSet;
    }

    private static Set<DateAttribute> f(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            hashSet.add(new DateAttribute(obj, jSONObject.optLong(obj, 0)));
        }
        return hashSet;
    }

    public static VisitorProfile fromJSON(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        return new Builder().setCreationDate(jSONObject.optLong("creation_ts", 0)).setAudiences(a(jSONObject.optJSONObject("audiences"))).setBadges(b(jSONObject.optJSONObject("badges"))).setDates(f(jSONObject.optJSONObject("dates"))).setFlags(c(jSONObject.optJSONObject("flags"))).setMetrics(d(jSONObject.optJSONObject("metrics"))).setProperties(e(jSONObject.optJSONObject("properties"))).setCurrentVisit(g(jSONObject.optJSONObject("current_visit"))).setIsNewVisitor(jSONObject.optBoolean("new_visitor", false)).setSource(str).build();
    }

    private static CurrentVisit g(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("dates");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new CurrentVisit(jSONObject.optLong("creation_ts", 0), f(jSONObject.optJSONObject("dates")), c(jSONObject.optJSONObject("flags")), d(jSONObject.optJSONObject("metrics")), e(jSONObject.optJSONObject("properties")), optJSONObject.optLong("last_event_ts", 0), jSONObject.optInt("total_event_count", 0));
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof VisitorProfile)) {
            return false;
        }
        VisitorProfile visitorProfile = (VisitorProfile) obj;
        return this.b.equals(visitorProfile.b) && this.c.equals(visitorProfile.c) && this.d.equals(visitorProfile.getCurrentVisit()) && this.f == visitorProfile.f && super.equals(visitorProfile);
    }

    public AttributeGroup<AudienceAttribute> getAudiences() {
        return this.b;
    }

    public AttributeGroup<BadgeAttribute> getBadges() {
        return this.c;
    }

    public CurrentVisit getCurrentVisit() {
        return this.d;
    }

    public String getSource() {
        return this.e;
    }

    public int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((((527 + super.hashCode()) * 31) + (this.f ? 1 : 0)) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        this.a = hashCode;
        return hashCode;
    }

    public boolean isNewVisitor() {
        return this.f;
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        return "Profile : {" + property + "    " + "creation_ts : " + getCreationTimestamp() + property + "    " + "is_new_visitor : " + this.f + property + "    " + "audiences : " + this.b.toString("    ") + property + "    " + "badges : " + this.c.toString("    ") + property + "    " + "dates : " + getDates().toString("    ") + property + "    " + "flags : " + getFlags().toString("    ") + property + "    " + "metrics : " + getMetrics().toString("    ") + property + "    " + "properties : " + getProperties().toString("    ") + property + "    " + "current_visit : " + this.d.toString("    ") + property + "}";
    }
}
