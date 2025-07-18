package org.example.travel.app;

import org.example.dao.TravelDao;
import org.example.dao.TravelDaoImpl;
import org.example.database.JDBCUtil;
import org.example.service.TravelService;
import org.example.service.TravelServiceImpl;

import java.util.Scanner;

public class TravelApp {
    TravelService service;
    MenuItem[] menu;
    Scanner sc = new Scanner(System.in);

    public TravelApp(){
        TravelDao dao = new TravelDaoImpl();
        service = new TravelServiceImpl(dao);

        menu = new MenuItem[]{
                new MenuItem("전체목록",service::printTravels),
                new MenuItem("PageLsit",service::printTravelByPage),
                new MenuItem("DistrictPage",service::printTravelByDistrict),
                new MenuItem("상세보기",service::printTravel),
                new MenuItem("종료",this::exit),

        };
    }
    public void exit(){
        sc.close();
        JDBCUtil.close();
        System.exit(0);
    }

    public void printMenu(){
        System.out.println("=============================================================================");
        for(int i = 0; i < menu.length; i++){
            MenuItem menuItem = menu[i];
            System.out.printf("%d) %s ",i+1,menuItem.getTitle());
        }
        System.out.println();
        System.out.println("=============================================================================");
    }
    public int getMenuIndex(){
        System.out.print("선택: ");
        String line = sc.nextLine();
        int ix = Integer.parseInt(line) - 1;
        return ix;


    }

    public void run(){
        while(true){
            printMenu();
            int ix=getMenuIndex();
            Runnable command =menu[ix].getCommand();
            command.run();

        }
    }

    public static void main(String[] args) {
        TravelApp app = new TravelApp();
        app.run();
    }


}

