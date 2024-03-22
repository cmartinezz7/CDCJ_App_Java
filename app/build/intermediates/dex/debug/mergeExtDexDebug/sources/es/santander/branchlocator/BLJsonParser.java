package es.santander.branchlocator;

import android.util.Log;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BLJsonParser {
    private static final String TAG = "JsonParser";

    BLJsonParser() {
    }

    public List<List<HashMap<String, String>>> parse(JSONObject jObject) {
        JSONArray jLegs;
        JSONArray jRoutes;
        List<List<HashMap<String, String>>> routes = new ArrayList<>();
        try {
            JSONArray jRoutes2 = jObject.getJSONArray("routes");
            int i = 0;
            while (i < jRoutes2.length()) {
                try {
                    JSONArray jLegs2 = ((JSONObject) jRoutes2.get(i)).getJSONArray("legs");
                    try {
                        List path = new ArrayList();
                        int j = 0;
                        while (j < jLegs2.length()) {
                            JSONArray jSteps = ((JSONObject) jLegs2.get(j)).getJSONArray("steps");
                            int k = 0;
                            while (k < jSteps.length()) {
                                try {
                                    List list = decodePoly((String) ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline")).get("points"));
                                    int l = 0;
                                    while (l < list.size()) {
                                        HashMap<String, String> hm = new HashMap<>();
                                        jRoutes = jRoutes2;
                                        jLegs = jLegs2;
                                        try {
                                            hm.put("lat", Double.toString(((LatLng) list.get(l)).latitude));
                                            hm.put("lng", Double.toString(((LatLng) list.get(l)).longitude));
                                            path.add(hm);
                                            l++;
                                            jRoutes2 = jRoutes;
                                            jLegs2 = jLegs;
                                        } catch (JSONException e) {
                                            e = e;
                                            JSONArray jSONArray = jRoutes;
                                            JSONArray jSONArray2 = jLegs;
                                            Log.e(TAG, e.toString());
                                            return routes;
                                        } catch (Exception e2) {
                                            JSONArray jSONArray3 = jRoutes;
                                            JSONArray jSONArray4 = jLegs;
                                        }
                                    }
                                    jRoutes = jRoutes2;
                                    jLegs = jLegs2;
                                    k++;
                                } catch (JSONException e3) {
                                    e = e3;
                                    JSONArray jSONArray5 = jRoutes2;
                                    JSONArray jSONArray6 = jLegs2;
                                    Log.e(TAG, e.toString());
                                    return routes;
                                } catch (Exception e4) {
                                    JSONArray jSONArray7 = jRoutes2;
                                    JSONArray jSONArray8 = jLegs2;
                                    return routes;
                                }
                            }
                            jRoutes = jRoutes2;
                            jLegs = jLegs2;
                            routes.add(path);
                            j++;
                            jRoutes2 = jRoutes;
                            jLegs2 = jLegs;
                        }
                        jRoutes = jRoutes2;
                        jLegs = jLegs2;
                        i++;
                    } catch (JSONException e5) {
                        e = e5;
                        JSONArray jSONArray52 = jRoutes2;
                        JSONArray jSONArray62 = jLegs2;
                        Log.e(TAG, e.toString());
                        return routes;
                    } catch (Exception e6) {
                        JSONArray jSONArray72 = jRoutes2;
                        JSONArray jSONArray82 = jLegs2;
                        return routes;
                    }
                } catch (JSONException e7) {
                    e = e7;
                    JSONArray jSONArray9 = jRoutes2;
                    Log.e(TAG, e.toString());
                } catch (Exception e8) {
                    JSONArray jSONArray10 = jRoutes2;
                }
            }
            JSONArray jSONArray11 = jRoutes2;
        } catch (JSONException e9) {
            e = e9;
            Log.e(TAG, e.toString());
        } catch (Exception e10) {
        }
        return routes;
    }

    private List decodePoly(String encoded) {
        int index;
        int index2;
        int b;
        String str = encoded;
        List poly = new ArrayList();
        int b2 = 0;
        int lat = 0;
        int lng = 0;
        for (int len = encoded.length(); b2 < len; len = len) {
            int shift = 0;
            int result = 0;
            while (true) {
                index = b2 + 1;
                int b3 = str.charAt(b2) - 63;
                result |= (b3 & 31) << shift;
                shift += 5;
                if (b3 < 32) {
                    break;
                }
                b2 = index;
            }
            int lat2 = lat + ((result & 1) != 0 ? ~(result >> 1) : result >> 1);
            int shift2 = 0;
            int result2 = 0;
            while (true) {
                index2 = index + 1;
                b = str.charAt(index) - 63;
                result2 |= (b & 31) << shift2;
                shift2 += 5;
                if (b < 32) {
                    break;
                }
                int i = b;
                int i2 = len;
                index = index2;
            }
            lng += (result2 & 1) != 0 ? ~(result2 >> 1) : result2 >> 1;
            int i3 = b;
            poly.add(new LatLng(((double) lat2) / 100000.0d, ((double) lng) / 100000.0d));
            b2 = index2;
            lat = lat2;
        }
        return poly;
    }
}
