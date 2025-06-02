CREATE DATABASE board_db;
USE board_db;

CREATE TABLE board (
                       articleNo INT AUTO_INCREMENT PRIMARY KEY, -- 자동 증가하는 기본 키
                       subject VARCHAR(255) NOT NULL, -- 제목 (255자까지 입력 가능, NULL 불가)
                       content TEXT NOT NULL, -- 내용 (긴 텍스트, NULL 불가)
                       userId VARCHAR(100) NOT NULL, -- 사용자 ID (100자까지 입력 가능, NULL 불가)
                       registerTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL -- 등록 시간 (오늘 날짜 자동 입력)
);
