package es.santander.branchlocator;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class BLRepository {
    private static final String TAG = "Repository";
    public static String lastCoords = null;
    private final BLBranchService service;

    public BLRepository(BLBranchService service2) {
        this.service = service2;
    }

    public void onGetFees(final BLOnGetFees blOnGetFees, final BLPoi poi) {
        this.service.getFees(poi.getLocation().getCountry()).enqueue(new Callback<BLFeesResponse>() {
            public void onResponse(Call<BLFeesResponse> call, Response<BLFeesResponse> response) {
                if (response.errorBody() == null) {
                    blOnGetFees.onGetFeesSuccessfully(poi, response.body());
                } else {
                    blOnGetFees.onGetFeesFailed("");
                }
            }

            public void onFailure(Call<BLFeesResponse> call, Throwable t) {
                blOnGetFees.onGetFeesFailed("");
            }
        });
    }

    private List<String> getFiltersStrings(List<BLFilter> filters, String filterType) {
        if (filters == null || filters.isEmpty()) {
            return null;
        }
        List<String> strings = new ArrayList<>();
        for (BLFilter filter : filters) {
            if (filter.getFilter_type().equals(filterType) && !TextUtils.isEmpty(filter.getRequest_name())) {
                strings.add(filter.getRequest_name() != null ? filter.getRequest_name().trim() : filter.getRequest_name());
            }
        }
        return strings;
    }

    /* access modifiers changed from: private */
    public List<BLPoi> cleanDuplicates(List<BLPoi> pois) {
        List<BLPoi> poisWithoutDuplicates = new ArrayList<>();
        List<BLPoi> branchesArray = new ArrayList<>();
        for (BLPoi poi : pois) {
            if (poi.getObjectType() == null || poi.getObjectType().getCode() == null) {
                break;
            } else if (poi.getObjectType().getCode().toLowerCase().equals("branch") || poi.getObjectType().getCode().toLowerCase().equals("branch / atm")) {
                poi.getObjectType().setCode("BRANCH");
                branchesArray.add(poi);
            }
        }
        List<BLPoi> atmsArray = new ArrayList<>();
        for (BLPoi poi2 : pois) {
            if (poi2.getObjectType() == null || poi2.getObjectType().getCode() == null) {
                break;
            } else if (poi2.getObjectType().getCode().toLowerCase().equals("atm")) {
                atmsArray.add(poi2);
            }
        }
        List<BLPoi> corresponsalArray = new ArrayList<>();
        for (BLPoi poi3 : pois) {
            if (poi3.getObjectType() == null || poi3.getObjectType().getCode() == null) {
                break;
            } else if (poi3.getObjectType().getCode().toLowerCase().equals("corresponsales")) {
                corresponsalArray.add(poi3);
            }
        }
        for (BLPoi branch : branchesArray) {
            for (BLPoi atm : atmsArray) {
                if (!(branch.getLatLng() == null || atm.getLatLng() == null || !branch.getLatLng().equals(atm.getLatLng()))) {
                    branch.getAtms().add(atm);
                    atm.setInBranch(true);
                }
            }
            poisWithoutDuplicates.add(branch);
        }
        for (BLPoi atm2 : atmsArray) {
            if (!atm2.isInBranch()) {
                poisWithoutDuplicates.add(atm2);
            }
        }
        for (BLPoi corresponsal : corresponsalArray) {
            poisWithoutDuplicates.add(corresponsal);
        }
        Collections.sort(poisWithoutDuplicates, new Comparator<BLPoi>() {
            public int compare(BLPoi poi1, BLPoi poi2) {
                return Double.compare(poi1.getDistanceInKm(), poi2.getDistanceInKm());
            }
        });
        return poisWithoutDuplicates;
    }

    /* access modifiers changed from: package-private */
    public void onGetPOI(final BLOnGetPOI blOnGetPoi, String coords, String country, String customer, List<BLFilter> filters) {
        lastCoords = coords;
        BLBranchService bLBranchService = this.service;
        if (bLBranchService != null) {
            bLBranchService.getAllPOI(coords, country, customer, getFiltersStrings(filters, "filterAttributeList"), getFiltersStrings(filters, "filterSubtype"), getFiltersStrings(filters, "filterType")).enqueue(new Callback<List<BLPoi>>() {
                public void onResponse(Call<List<BLPoi>> call, Response<List<BLPoi>> response) {
                    if (response == null) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        try {
                            blOnGetPoi.onGetPOISuccessfully(new BLPoiResponse(BLRepository.this.cleanDuplicates(response.body())));
                        } catch (Exception e) {
                            Log.e(BLRepository.TAG, e.toString());
                        }
                    } else {
                        try {
                            blOnGetPoi.onGetPOIFailed(response.errorBody().string());
                        } catch (IOException e2) {
                            Log.e(BLRepository.TAG, e2.toString());
                        }
                    }
                }

                public void onFailure(Call<List<BLPoi>> call, Throwable t) {
                    Log.e(BLRepository.TAG, t.toString());
                    blOnGetPoi.onGetPOIFailed(t.getMessage());
                }
            });
        }
    }
}
