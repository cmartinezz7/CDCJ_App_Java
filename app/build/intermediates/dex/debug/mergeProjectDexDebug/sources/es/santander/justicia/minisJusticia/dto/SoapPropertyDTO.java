package es.santander.justicia.minisJusticia.dto;

import org.ksoap2.serialization.PropertyInfo;

public class SoapPropertyDTO {
    private PropertyInfo propertyInfo;
    private Object value;

    public SoapPropertyDTO(Object value2, PropertyInfo propertyInfo2) {
        this.value = value2;
        this.propertyInfo = propertyInfo2;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value2) {
        this.value = value2;
    }

    public PropertyInfo getPropertyInfo() {
        return this.propertyInfo;
    }

    public void setPropertyInfo(PropertyInfo propertyInfo2) {
        this.propertyInfo = propertyInfo2;
    }
}
