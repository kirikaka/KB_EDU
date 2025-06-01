package org.example.dao;

import org.example.domain.TravelImageVO;
import org.example.domain.TravelVO;

import java.util.*;

public interface TravelDao {
    void insert(TravelVO travelVO);

    void insertImage(TravelImageVO image);

    int getTotalCount();

    List<String> getDistricts();
    List<TravelVO> getTravels();
    List<TravelVO> getTravels(int page);
    List<TravelVO> getTravels(String district);
    Optional<TravelVO> getTravel(Long no);


}
