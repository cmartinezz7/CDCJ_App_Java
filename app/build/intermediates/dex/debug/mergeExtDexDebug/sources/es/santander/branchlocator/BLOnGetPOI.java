package es.santander.branchlocator;

interface BLOnGetPOI {
    void onGetPOIFailed(String str);

    void onGetPOISuccessfully(BLPoiResponse bLPoiResponse);
}
