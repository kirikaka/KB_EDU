package org.scoula.module2;

import org.scoula.module2.dao.CityDao;
import org.scoula.module2.domain.City;
import org.scoula.module2.util.JDBCUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner sc;
    CityDao cityDao;


    public Main() {
        sc = new Scanner(System.in);
        cityDao = new CityDao(JDBCUtil.getConnection());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        while (true) {
            int choice = selectMenu();

            if (choice == 1) {
                insertData();
            } else if (choice == 2) {
                showList();
            } else if (choice == 3) {
                showOne();
            } else if (choice == 4) {
                onClose();
            } else {
                System.out.println("선택이 올바르지 않음.");
            }
        }

    }

    private void showList() {
        System.out.print("추출할 도시수>>  ");
        int size = sc.nextInt();

        List<City> list = cityDao.selectList(size);
        System.out.println("전체 도시수 : " + list.size());

        // 결과 출력 (헤더)
        System.out.println("----------- 도시 목록 ------------");
        for (City city : list) {
            printCity(city);
        }
    }

    // 문제 5-2. printCity()를 완성하시오.
    // 조건1) 한 개의 City 정보를 출력하고, 줄을 바꾼다.
    // 조건2) 출력 형식은 문제 pdf의 화면처럼 출력한다.
    public void printCity(City city) {
        System.out.printf("아이디>> %d, 국가코드>> %s,    지역명>> %s,    인구수>> %d "
                , city.getId(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
        System.out.println();
    }

    // 문제 6-2. showOne()을 완성하시오.
    // 조건1) 추출할 도시의 ID를 사용자로부터 입력 받는다.
    // 조건2) 해당 ID로 하나의 City를 찾는다.
    // 조건3) 데이터가 있으면 printCity()를 이용하여 출력한다.
    // 조건4) 데이터가 없다면 "해당 도시가 없습니다."를 출력한다.
    // 조건5) 입력 형식 및 출력 형식은 문제 pdf의 화면처럼 처리한다.
    public void showOne() {
        System.out.print("추출할 도시 ID>>  ");
        int id = sc.nextInt();

        City city = cityDao.selectOne(id);

        printCity(city);


    }

    public void insertData() {
        City city = new City();
        city.setName("Win");
        city.setCountryCode("OMN");
        city.setDistrict("Center");
        city.setPopulation(1000);
        cityDao.insert(city);
        System.out.println("삽입처리 호출 완료됨.");
    }

    public int selectMenu() {
        System.out.println("1) City 추가, 2) City 목록 보기, 3) 상세 보기, 4) 종료");
        System.out.print("선택>> ");
        return sc.nextInt();
    }

    public void onClose() {
        sc.close();
        JDBCUtil.close();
        System.exit(0);
    }

}
