package org.scoula.app;

import org.scoula.dao.DiaryDao;
import org.scoula.dao.DiaryDaoImpl;
import org.scoula.vo.DiaryVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class DiaryApp {
    static DiaryDao diaryDao = new DiaryDaoImpl();
    static Scanner sc=new Scanner(System.in);
    static BufferedReader br;
    static DiaryVO diaryVO;

    static void create() throws IOException {
        diaryVO= new DiaryVO();
        br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("============================1. Add Diary============================");
        System.out.print("Enter Diary Title : ");
        String diaryTitle = br.readLine();

        System.out.print("Enter Diary Content : ");
        String diaryContent = br.readLine();
        diaryVO.setTitle(diaryTitle);
        diaryVO.setContent(diaryContent);

        diaryDao.createDiary(diaryVO);



    }
    static void update() throws IOException {
        diaryVO=new DiaryVO();
        System.out.println("============================2. Update Diary==============================");
        System.out.print("Modify Diary ID : ");
        Long id = (long)sc.nextInt();
        sc.nextLine();
        System.out.print("Modify Diary Title : ");
        String title =br.readLine();
        System.out.print("Modify Diary Content : ");
        String content = br.readLine();
        diaryVO.setId(id);
        diaryVO.setTitle(title);
        diaryVO.setContent(content);
        diaryDao.updateDiary(diaryVO);

    }
    static void delete(){
        diaryVO=new DiaryVO();
        System.out.println("==============================3. Delete Diary==============================");
        System.out.print("Delete Diary ID : ");
        Long id = (long)sc.nextInt();
        diaryVO.setId(id);
        diaryDao.deleteDiary(diaryVO);


    }
    static void read(){
        System.out.println("==============================4. Read Diary===============================");
        List<DiaryVO> diaryVOList=diaryDao.readDiary();
        for(DiaryVO diaryVO:diaryVOList){

            System.out.println(diaryVO);
        }
    }

    public static void main(String[] args) throws IOException {

        while(true){
            System.out.println("=============Diary Menu=============");
            System.out.println("1. Add Diary");
            System.out.println("2. Update Diary");
            System.out.println("3. Delete Diary");
            System.out.println("4. Read Diary");
            System.out.println("5. Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    create();
                    continue;
                case 2:
                    update();
                    continue;
                case 3:
                    delete();
                    continue;
                case 4:
                    read();
                    continue;
                case 5:
                    System.exit(0);
            }
        }

    }
}
