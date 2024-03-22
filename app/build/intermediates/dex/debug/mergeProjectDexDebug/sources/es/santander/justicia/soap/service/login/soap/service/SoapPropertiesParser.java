package es.santander.justicia.soap.service.login.soap.service;

import es.santander.justicia.minisJusticia.dto.SoapPropertyDTO;
import java.util.ArrayList;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class SoapPropertiesParser implements KvmSerializable {
    private ArrayList<SoapPropertyDTO> propertyList = new ArrayList<>();

    public Object getProperty(int index) {
        return this.propertyList.get(index).getValue();
    }

    public int getPropertyCount() {
        return this.propertyList.size();
    }

    public void setProperty(int index, Object value) {
        this.propertyList.get(index).setValue(value);
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        info.type = this.propertyList.get(index).getPropertyInfo().getType();
        info.name = this.propertyList.get(index).getPropertyInfo().getName();
    }

    /* access modifiers changed from: protected */
    public void createElement(String name, Object type, String value) {
        PropertyInfo propertyInfo = new PropertyInfo();
        propertyInfo.setName(name);
        propertyInfo.setType(type);
        this.propertyList.add(new SoapPropertyDTO(value, propertyInfo));
    }

    /* access modifiers changed from: protected */
    public void createElement(String tagName, Object type, Object value) {
        PropertyInfo propertyInfo = new PropertyInfo();
        propertyInfo.setName(tagName);
        propertyInfo.setType(type);
        this.propertyList.add(new SoapPropertyDTO(value, propertyInfo));
    }
}
