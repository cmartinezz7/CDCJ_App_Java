package es.santander.branchlocator;

import java.util.ArrayList;
import java.util.List;

class BLPoiResponse {
    private List<BLPoi> pointsOfInterest;

    public BLPoiResponse(List<BLPoi> pointsOfInterest2) {
        this.pointsOfInterest = new ArrayList(pointsOfInterest2);
    }

    public List<BLPoi> getPointsOfInterest() {
        if (this.pointsOfInterest != null) {
            return new ArrayList(this.pointsOfInterest);
        }
        return null;
    }
}
