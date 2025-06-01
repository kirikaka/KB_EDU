package org.example.service;

public interface TravelService {
    //전체 관광지 목록 출력
    void printTravels();


    // 특정 권역 관광지 목록 출력
    void printTravelByDistrict();

    // 특정 페이지 관광지 목록 출력
    void printTravelByPage();

    // 관광지 상세보기
    void printTravel();

}
