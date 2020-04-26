package com.alexthekap.societe_generale.app.presentation_layer.Map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alexthekap.societe_generale.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapContract.View {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private MapsPresenter mPresenter;
    private Unbinder unbinder;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mPresenter = MapsPresenter.getInstance();
        unbinder = ButterKnife.bind(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMapClickListener(latLng -> {
            mPresenter.onMapClick(latLng);
        });
        Toast t = Toast.makeText(this, getString(R.string.click_on_me), Toast.LENGTH_LONG);
        t.setGravity(Gravity.TOP, 0,100);
        t.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.wire(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unWire();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showTime(String time) {
        Toast.makeText(this, getString(R.string.show_time_toast, time), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean enable) {
        if(enable) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setClickable(boolean clickable) {
        if(clickable) {
            mMap.setOnMapClickListener(latLng -> {
                mPresenter.onMapClick(latLng);
            });
        } else {
            mMap.setOnMapClickListener(null);
        }
    }

    @Override
    public void onDataNotAvailable() {
        Toast.makeText(this, "Ошибка сети", Toast.LENGTH_SHORT).show();
    }
}
