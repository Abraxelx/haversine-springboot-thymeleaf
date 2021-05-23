package com.abraxel.haversine.service;


import com.abraxel.haversine.model.Haversine;
import org.springframework.stereotype.Repository;

@Repository
public interface HaversineService {
    double getDistance(Haversine haversine);

}
