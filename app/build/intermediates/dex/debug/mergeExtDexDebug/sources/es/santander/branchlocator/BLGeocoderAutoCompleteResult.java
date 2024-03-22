package es.santander.branchlocator;

import android.location.Address;

public class BLGeocoderAutoCompleteResult {
    private Address address;

    BLGeocoderAutoCompleteResult(Address address2) {
        this.address = address2;
    }

    public String getAddress() {
        String addressToDisplay = "" + this.address.getAddressLine(0) + "\n";
        for (int i = 1; i < this.address.getMaxAddressLineIndex(); i++) {
            addressToDisplay = addressToDisplay + this.address.getAddressLine(i) + ", ";
        }
        return addressToDisplay.substring(0, addressToDisplay.length() - 1);
    }

    public String toString() {
        String addressToDisplay = "";
        if (this.address.getFeatureName() != null) {
            addressToDisplay = addressToDisplay + this.address + ", ";
        }
        for (int i = 0; i < this.address.getMaxAddressLineIndex(); i++) {
            addressToDisplay = addressToDisplay + this.address.getAddressLine(i);
        }
        return addressToDisplay;
    }

    /* access modifiers changed from: package-private */
    public String getStreetAndNumber() {
        String addressToDisplay = "" + this.address.getAddressLine(0) + "\n";
        for (int i = 1; i < this.address.getMaxAddressLineIndex(); i++) {
            addressToDisplay = addressToDisplay + this.address.getAddressLine(i) + ", ";
        }
        String addressToDisplay2 = addressToDisplay.substring(0, addressToDisplay.length() - 1);
        if (this.address.getPostalCode() != null && addressToDisplay2.contains(this.address.getPostalCode())) {
            addressToDisplay2 = addressToDisplay2.replaceFirst(this.address.getPostalCode(), "");
        }
        if (this.address.getLocality() != null && addressToDisplay2.contains(this.address.getLocality())) {
            addressToDisplay2 = addressToDisplay2.replaceFirst(this.address.getLocality(), "");
        }
        if (this.address.getCountryName() != null && addressToDisplay2.contains(this.address.getCountryName())) {
            addressToDisplay2 = addressToDisplay2.replaceFirst(this.address.getCountryName(), "");
        }
        String addressToDisplay3 = addressToDisplay2.trim();
        while (addressToDisplay3.endsWith(",")) {
            addressToDisplay3 = addressToDisplay3.substring(0, addressToDisplay3.length() - 1).trim();
        }
        return addressToDisplay3;
    }

    /* access modifiers changed from: package-private */
    public String getLocaltyCountry() {
        String addressToResult = "";
        if (this.address.getLocality() != null && !this.address.getLocality().equals("")) {
            addressToResult = addressToResult + this.address.getLocality();
        }
        if (this.address.getCountryName() == null || this.address.getCountryName().equals("")) {
            return addressToResult;
        }
        if (!addressToResult.equals("")) {
            addressToResult = addressToResult + ", ";
        }
        return addressToResult + this.address.getCountryName();
    }
}
