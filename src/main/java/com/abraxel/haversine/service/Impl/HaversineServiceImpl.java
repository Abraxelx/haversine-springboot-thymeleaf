package com.abraxel.haversine.service.Impl;

import com.abraxel.haversine.model.Haversine;
import com.abraxel.haversine.service.HaversineService;
import org.springframework.stereotype.Service;

@Service
public class HaversineServiceImpl implements HaversineService{

    @Override
    public double getDistance(Haversine haversine) {

        double radiusOfWorld = 6371;
        double phi1 = Math.toRadians(haversine.getLat1());
        double phi2 = Math.toRadians(haversine.getLat2());
        double deltaPhi = Math.toRadians(haversine.getLat2() - haversine.getLat1());
        double deltaLambda = Math.toRadians(haversine.getLong2() - haversine.getLong1());
        double thetaOfLats = Math.pow(Math.sin(deltaPhi/2), 2);
        double thetaOfLongs = Math.pow(Math.sin(deltaLambda/2), 2);
        double perform = thetaOfLats + Math.cos(phi1) * Math.cos(phi2) * thetaOfLongs;
        double sqrt= 2*Math.asin(Math.sqrt(perform));
        return sqrt*radiusOfWorld;
    }
}
