package org.example.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.BoardAttachmentVO;
import org.example.board.domain.BoardVO;
import org.example.board.dto.BoardDTO;
import org.example.board.mapper.BoardMapper;
import org.example.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final private BoardMapper mapper;
    private final static String BASE_DIR = "c:/upload";

    @Override
    public List<BoardDTO> getList() {
        log.info("getList");
        return mapper.getList().stream().map(BoardDTO::of).toList();
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get");
        BoardDTO board =BoardDTO.of(mapper.get(no));
        return Optional.ofNullable(board).orElseThrow(NoSuchElementException::new);
    }


    @Transactional
    @Override
    public BoardDTO create(BoardDTO board) {
        BoardVO vo=board.toVo();
        mapper.create(vo);
        board.setNo(vo.getNo());
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) { // 첨부 파일이 있는  경우
            upload(vo.getNo(), files);
        }

        return get(vo.getNo());
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        mapper.update(board.toVo());
        return get(board.getNo());
    }

    @Override
    public BoardDTO delete(Long no) {
        BoardDTO board=get(no);
        mapper.delete(no);
        return board;
    }

    private void upload(Long bno, List<MultipartFile> files) {
        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {
                throw new RuntimeException(e);   // @Transactional에서 감지, 자동 rollback
            }
        }
    }

    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);
    }

    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }


}
