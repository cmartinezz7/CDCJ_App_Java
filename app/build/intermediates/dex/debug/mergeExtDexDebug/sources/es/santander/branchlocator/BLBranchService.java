package es.santander.branchlocator;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface BLBranchService {
    @GET("find/defaultView")
    Call<List<BLPoi>> getAllPOI(@Query("config") String str, @Query("country") String str2, @Query("customer") String str3, @Query("filterAttributeList") List<String> list, @Query("filterSubtype") List<String> list2, @Query("filterType") List<String> list3);

    @GET("atm/getSurchargefromCountry")
    Call<BLFeesResponse> getFees(@Query("country") String str);
}
