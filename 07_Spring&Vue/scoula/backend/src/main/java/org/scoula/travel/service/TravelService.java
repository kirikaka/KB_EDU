package org.scoula.travel.service;


import org.scoula.common.page.Page;
import org.scoula.common.page.PageRequest;
import org.scoula.travel.dto.TravelDTO;
import org.scoula.travel.dto.TravelImageDTO;

import java.util.List;

public interface TravelService {
    Page<TravelDTO> getPage(PageRequest pageRequest);

    List<TravelDTO> getList();

    TravelDTO get(Long no);

    TravelDTO create(TravelDTO board);

    TravelDTO update(TravelDTO board);

    TravelDTO delete(Long no);

    TravelImageDTO getImage(Long no);
    
    boolean deleteImage(Long no);
}
