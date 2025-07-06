package org.example.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.board.domain.BoardAttachmentVO;
import org.example.board.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
    private List<BoardAttachmentVO> attaches;
    List<MultipartFile> files=new ArrayList<MultipartFile>();

    public static BoardDTO of(BoardVO vo) {
        return vo==null?null:BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .updateDate(vo.getUpdateDate())
                .attaches(vo.getAttaches())
                .regDate(vo.getRegDate())
                .build();
    }
    public BoardVO toVo() {
        return BoardVO.builder()
                .no(no)
                .title(title)
                .attaches(attaches)
                .content(content)
                .writer(writer)
                .updateDate(updateDate)
                .regDate(regDate)
                .build();
    }
}
