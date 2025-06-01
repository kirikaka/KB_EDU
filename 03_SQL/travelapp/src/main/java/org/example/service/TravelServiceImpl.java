package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TravelDao;
import org.example.domain.TravelImageVO;
import org.example.domain.TravelVO;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService{
    final TravelDao dao;

    private int getNumber(String prompt){
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        int num=Integer.parseInt(scanner.nextLine());
        return num;
    }
    private void printDistricts(List<String> districts){
        for(int i=0; i<districts.size(); i++){
            System.out.printf("%d] %s\n",i+1,districts.get(i));
        }
    }
    private void printTravels(List<TravelVO> travels){
        for(TravelVO travel : travels){
            System.out.printf("%3d %6s %s\n ", travel.getNo(),travel.getDistrict(),travel.getTitle());

        }
    }



    @Override
    public void printTravels() {
        List<TravelVO> travels = dao.getTravels();
        printTravels(travels);
    }

    @Override
    public void printTravelByDistrict() {
        List<String> districts = dao.getDistricts();
        printDistricts(districts);

        int ix=getNumber("Enter Travel ID : ");
        String district=districts.get(ix);
        List<TravelVO> travels = dao.getTravels(district);
        printTravels(travels);
    }

    @Override
    public void printTravelByPage() {
        int totalPage=(int) Math.ceil(dao.getTravels().size()/10.0);
        System.out.println("Total Page: "+totalPage);
        int page=getNumber(String.format("페이지 선택(1 ~ %d) : ", totalPage));
        List<TravelVO> travels = dao.getTravels(page);
        printTravels(travels);

    }

    @Override
    public void printTravel() {
        long no=getNumber("관광지 ID : ");
        TravelVO travelVO= dao.getTravel(no).orElseThrow(NoSuchElementException::new);
        System.out.println("권역 : " +  travelVO.getDistrict());
        System.out.println(travelVO.getTitle());
        System.out.println(travelVO.getTitle());
        System.out.println(travelVO.getDescription());
        System.out.println(travelVO.getAddress());
        System.out.println(travelVO.getPhone());
        System.out.println("photos");
        for(TravelImageVO image: travelVO.getImages()){
            System.out.printf("[%3d] %s\n",image.getNo(),image.getFilename());
        }


    }
}
