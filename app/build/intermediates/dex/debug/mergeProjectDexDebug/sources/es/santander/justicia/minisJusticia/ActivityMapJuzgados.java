package es.santander.justicia.minisJusticia;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Response;

public class ActivityMapJuzgados extends ActivityAbstractLetrados implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {
    private final int INITIAL_ZOOM = 16;
    private final int RQ_PERMISSIONS = 1;
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_juzgados);
        initUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/localizar_juzgado");
    }

    private void initUi() {
        SupportMapFragment newInstance = SupportMapFragment.newInstance();
        this.mMapFragment = newInstance;
        newInstance.getMapAsync(this);
        getSupportFragmentManager().beginTransaction().add(R.id.mapView, this.mMapFragment).commit();
    }

    private void drawTribunals(LatLng latLng) {
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
        CommonUtils.addMarker(this.mMap, latLng, "Oficina", BitmapDescriptorFactory.fromResource(R.drawable.poi_juzgado));
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityMapJuzgados, android.app.Activity] */
    private void createMapView() {
        this.mMap.setMapType(1);
        this.mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public void onInfoWindowClick(Marker marker) {
            }
        });
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1);
        }
        this.mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            public View getInfoWindow(Marker marker) {
                return ActivityMapJuzgados.this.getLayoutInflater().inflate(R.layout.layout_info_window_tribunals, (ViewGroup) null);
            }

            public View getInfoContents(Marker marker) {
                return null;
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityMapJuzgados] */
    private void getDetalleJuzgado(String juzga) {
        ConnectionBuilder.getDetalleJuzgados(juzga).enqueue(new RetrofitCallbackInterface<DetalleJuzgadosResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r1v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityMapJuzgados] */
            public void onResponse(Call<DetalleJuzgadosResponseEnvelope> call, Response<DetalleJuzgadosResponseEnvelope> response) {
                String str;
                try {
                    ? r1 = ActivityMapJuzgados.this;
                    String str2 = null;
                    String securityToken = (response.body() == null || ((DetalleJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DetalleJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str2 = response.errorBody().string();
                    }
                    if (!super.finishConnection(r1, securityToken, str2)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        DatosJuzgado datosJuzgado = ((DetalleJuzgadosResponseEnvelope) response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados().get(0);
                        StringBuilder append = new StringBuilder().append(datosJuzgado.getTipoVia()).append(" ").append(datosJuzgado.getNombreVia()).append(" ");
                        if (datosJuzgado.getNumero() != null) {
                            str = datosJuzgado.getNumero();
                        } else {
                            str = " ";
                        }
                        ActivityMapJuzgados.this.getLocationFromAddress(append.append(str).append(" ").append(datosJuzgado.getProvincia()).append("  ").append(datosJuzgado.getCodpost()).toString());
                        return;
                    }
                    Toast.makeText(ActivityMapJuzgados.this.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
                } catch (IOException e) {
                    Log.e("getDetalleJuzgado", "IOException", e);
                }
            }
        });
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        createMapView();
        getDetalleJuzgado(getIntent().getStringExtra(Constants.EXTRA_JUZGA));
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityMapJuzgados] */
    public void getLocationFromAddress(String strAddress) throws IOException {
        Geocoder coder = new Geocoder(this);
        new Address(Locale.ENGLISH);
        List<Address> address = coder.getFromLocationName(strAddress, 5);
        if (address != null && address.size() > 0) {
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();
            drawTribunals(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityMapJuzgados] */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 1 || grantResults[0] != 0) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
    }
}
