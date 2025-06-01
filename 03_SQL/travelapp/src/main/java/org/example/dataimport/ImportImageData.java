package org.example.dataimport;

import org.example.dao.TravelDao;
import org.example.dao.TravelDaoImpl;
import org.example.database.JDBCUtil;
import org.example.domain.TravelImageVO;

import java.io.*;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao =new TravelDaoImpl();

        File dir=new File("../travel-image");
        File[] files=dir.listFiles();
        for(File file:files){
            String filename=file.getName();
            long travelNo=Long.parseLong(filename.split("-")[0]);

            TravelImageVO image= org.example.domain.TravelImageVO.builder().filename(filename).travelNo(travelNo).build();

            System.out.println(image);
            dao.insertImage(image);
        }
        JDBCUtil.close();
    }

}
