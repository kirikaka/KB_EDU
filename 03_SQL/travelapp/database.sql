DROP TABLE IF EXISTS tbl_travel;
CREATE TABLE tbl_travel(
    no INT AUTO_INCREMENT not null primary key ,
    district varchar(50) not null ,
    title varchar(512) not null ,
    description TEXT,
    address varchar(512),
    phone varchar(256)

);


DROP TABLE IF EXISTS tbl_travel_image;
CREATE TABLE tbl_travel_image(
    no INT AUTO_INCREMENT not null primary key ,
    filename VARCHAR(512) NOT NULL ,
    travel_no int,
    CONSTRAINT FOREIGN KEY (travel_no) references tbl_travel(no) on delete cascade



);

select count(*) from tbl_travel_image;
