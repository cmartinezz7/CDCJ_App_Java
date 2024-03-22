package es.santander.branchlocator;

interface BLOnGetFees {
    void onGetFeesFailed(String str);

    void onGetFeesSuccessfully(BLPoi bLPoi, BLFeesResponse bLFeesResponse);
}
