package com.example.examen_unidadii_estrella;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapasFragment extends Fragment implements OnMapReadyCallback, LocationListener {


    GoogleMap gMap;
    LocationManager lm;
    Location location;

    double longitude = 0;
    double latitude = 0;

    public MapasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_mapas, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        String[] tienda = {"Panttony Tacna 1","Panttony Tacna 2"};
        ArrayAdapter adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_dropdown_item, tienda);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item;
                item = (String) parent.getItemAtPosition(position);



                if(item.equals("Panttony Tacna 1")){

                    LatLng tienda1 = new LatLng(-18.004800, -70.247563);
                    gMap.addMarker(new MarkerOptions().position(tienda1).title("Av. General Varela 686"))
                            .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker_tiendas));

                    float zoomLevel = 16.0f;
                    gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tienda1, zoomLevel));
                    gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }

                if(item.equals("Panttony Tacna 2")){

                    LatLng tienda2 = new LatLng(-18.013275, -70.251029);
                    gMap.addMarker(new MarkerOptions().position(tienda2).title("Calle Hipólito Unanue N° 155"))
                            .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker_tiendas));;

                    float zoomLevel = 16.0f;
                    gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tienda2, zoomLevel));
                    gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        gMap = googleMap;

        lm = (LocationManager) getContext()
                .getSystemService(Context.LOCATION_SERVICE);
        if (getActivity().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && getActivity().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  this);
        location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        LatLng aqui = new LatLng(latitude, longitude);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(aqui)
                .zoom(150)//zoom
                .bearing(50)//inclinacion
                .build();

        gMap.addMarker(new MarkerOptions().position(aqui).title("Mi ubicación"));
        gMap.animateCamera(CameraUpdateFactory.newLatLng(aqui));


    }


    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.v("Location Changed", latitude + " and " + longitude);
            lm.removeUpdates(this);
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

}
