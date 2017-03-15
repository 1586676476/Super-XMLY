package com.jieleo.xmly_plus.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by yuyongjie on 17/3/9.
 */


public class MapFragment extends BaseFragment {
    private MapView mapView;
    private BaiduMap baiduMap;

    private LocationClient locationClient;
    private TextView textView;
    private boolean isFirstLocation=true;


    @Override
    protected int bindLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mapView = (MapView) view.findViewById(R.id.fragment_map_mapView);
//        textView = (TextView) view.findViewById(R.id.fragment_map_text);
        baiduMap=mapView.getMap();
        baiduMap.setMyLocationEnabled(true);

    }

    @Override
    protected void initData() {

        locationClient = new LocationClient(MyApp.getContext());
        locationClient.registerLocationListener(new MyLoactionListener());

        List<String> permissionList = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED) {
            permissionList.add(android.Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            getActivity().requestPermissions(permissions, 1);
        } else {
            //每隔5秒更新当前位置
            LocationClientOption option=new LocationClientOption();
            option.setScanSpan(5000);
            option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            locationClient.setLocOption(option);
            locationClient.start();

        }
    }

    @Override
    protected void bindEvent() {

    }

    private void navigateTo(BDLocation location){
        if (isFirstLocation){
            LatLng ll=new LatLng(location.getLatitude(),location.getLongitude());
            MapStatusUpdate update= MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);
            update=MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocation=false;
        }
        MyLocationData.Builder builder=new MyLocationData.Builder();
        builder.latitude(location.getLatitude());
        builder.longitude(location.getLongitude());
        MyLocationData locationData=builder.build();
        baiduMap.setMyLocationData(locationData);

    }

    public class MyLoactionListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("纬度").append(bdLocation.getLatitude()).append("\n");
            currentPosition.append("经度").append(bdLocation.getLongitude()).append("\n");
            currentPosition.append("国家").append(bdLocation.getCountry()).append("\n");
            currentPosition.append("省").append(bdLocation.getProvince()).append("\n");
            currentPosition.append("市").append(bdLocation.getCity()).append("\n");
            currentPosition.append("区").append(bdLocation.getDistrict()).append("\n");

            currentPosition.append("定位方式");
            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                currentPosition.append("GPS");
            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }
            textView.setText(currentPosition);
            //移动到我的位置
            if (bdLocation.getLocType()==BDLocation.TypeNetWorkLocation||
                    bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
                navigateTo(bdLocation);
            }
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int request : grantResults) {
                        if (request != PackageManager.PERMISSION_GRANTED) {
                            getActivity().finish();
                            return;
                        }
                    }
                    locationClient.start();
                } else {
                    getActivity().finish();
                }
                break;
            default:
        }
    }
    //这三种方法是释放资源
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locationClient.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }

}
