package org.example.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.dao.TravelDao;
import org.example.dao.TravelDaoImpl;
import org.example.database.JDBCUtil;
import org.example.domain.TravelVO;

import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;

public class ImportTravelData {
    public static void main(String[] args) throws SQLException ,Exception {
        TravelDao dao = new TravelDaoImpl();
        List<TravelVO> travels =new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv")).withType(TravelVO.class).build().parse();

        travels.forEach(travel -> {
            System.out.println(travel);
            dao.insert(travel);
        });

        JDBCUtil.close();


    }
}
