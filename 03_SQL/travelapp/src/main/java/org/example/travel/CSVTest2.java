package org.example.travel;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.domain.TravelVO;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws Exception {
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv")).withType(TravelVO.class).build().parse();
        travels.forEach(travel->{
            System.out.println(travel);
        });

    }
}
