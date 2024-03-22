package es.santander.branchlocator;

import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class DataRepository {
    private static final DataRepository instance = new DataRepository();
    public GoogleMap map;
    public MutableLiveData<List<BLPoi>> pointsOfInterestLiveData = new MutableLiveData<>();

    public static DataRepository getInstance() {
        return instance;
    }

    public void setPois(List<BLPoi> pointsOfInterest) {
        this.pointsOfInterestLiveData.postValue(pointsOfInterest);
    }

    public void setMap(GoogleMap map2) {
        this.map = map2;
    }

    public GoogleMap getMap() {
        return this.map;
    }
}
