package es.santander.justicia.minisJusticia.dto;

import org.ksoap2.serialization.PropertyInfo;

public class SoapPropertyDTO {
   private Object value;
   private PropertyInfo propertyInfo;

   public SoapPropertyDTO(Object value, PropertyInfo propertyInfo) {
      this.value = value;
      this.propertyInfo = propertyInfo;
   }

   public Object getValue() {
      return this.value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   public PropertyInfo getPropertyInfo() {
      return this.propertyInfo;
   }

   public void setPropertyInfo(PropertyInfo propertyInfo) {
      this.propertyInfo = propertyInfo;
   }
}
