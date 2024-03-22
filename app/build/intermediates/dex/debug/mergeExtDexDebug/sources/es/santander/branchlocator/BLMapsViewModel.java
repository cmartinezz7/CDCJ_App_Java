package es.santander.branchlocator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class BLMapsViewModel extends ViewModel implements BLOnGetPOI, BLOnGetFees {
    private MutableLiveData<BLFeesResponse> feesResponseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<BLPoi>> pointsOfInterestLiveData = new MutableLiveData<>();
    private BLRepository repository;

    /* access modifiers changed from: package-private */
    public BLRepository getRepository() {
        return this.repository;
    }

    /* access modifiers changed from: package-private */
    public void setRepository(BLRepository repository2) {
        this.repository = repository2;
    }

    /* access modifiers changed from: package-private */
    public void onGetPOI(String coords, String country, String customer, List<BLFilter> filters) {
        this.repository.onGetPOI(this, coords, country, customer, filters);
    }

    /* access modifiers changed from: package-private */
    public void onGetFees(BLPoi poi) {
        this.repository.onGetFees(this, poi);
    }

    public void onGetPOISuccessfully(BLPoiResponse response) {
        List<BLPoi> pointsOfInterest = response.getPointsOfInterest();
        for (BLPoi poi : pointsOfInterest) {
            poi.setClusterInfo();
        }
        this.pointsOfInterestLiveData.postValue(pointsOfInterest);
        DataRepository.getInstance().setPois(pointsOfInterest);
    }

    public void onGetPOIFailed(String message) {
    }

    /* access modifiers changed from: package-private */
    public LiveData<List<BLPoi>> getPointsOfInterestLiveData() {
        return this.pointsOfInterestLiveData;
    }

    public void onGetFeesSuccessfully(BLPoi poi, BLFeesResponse response) {
        poi.setFees(response);
        BLPreferencesManager.addFee(response);
        this.feesResponseMutableLiveData.postValue(response);
    }

    public void onGetFeesFailed(String message) {
    }

    public MutableLiveData<BLFeesResponse> getFeesResponseMutableLiveData() {
        return this.feesResponseMutableLiveData;
    }
}
