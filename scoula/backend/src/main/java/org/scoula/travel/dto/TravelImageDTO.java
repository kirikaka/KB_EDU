package org.scoula.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.travel.domain.TravelImageVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelImageDTO {
    private static final String BASE = "c:/upload/travel/";
    private long no;
    private String filename;
    private long travelNo;

    public static TravelImageDTO of(TravelImageVO vo) {
        return TravelImageDTO.builder()
                .no(vo.getNo())
                .filename(vo.getFilename())
                .travelNo(vo.getTravelNo())
                .build();
    }

    @JsonIgnore
    public String getPath() {
        return BASE + filename;
    }

    public String getUrl() {
        return "/api/travel/image/" + no;
    }
}
