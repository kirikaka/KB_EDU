#1번
select * from city;
select language,percentage from countrylanguage where countrycode='che';

insert into city( name,countrycode,district,population ) values ('Cairo','EGY','Cairo Governorate',9500000);

update city set name='GoodSite' where countrycode='png';

select * from country order by name desc;

#2번
select upper(name) from city ;

select concat_ws('-',id,countrycode) from city;
select length(district) from city;

select avg(population) from city;

select continent,max(gnp) from country group by continent having max(gnp) order by max(gnp) desc;

# 3번 조인
select city.name, country.name from city inner join country on city.countrycode=country.code;

select country.name, countrylanguage.language from country left outer join countrylanguage on country.code=countrylanguage.countrycode;

select * from country;
select * from countrylanguage;
select distinct code from country;
select distinct countrycode from countrylanguage;

select count(distinct countrycode) from countrylanguage;
select count(distinct code) from country;

select name from city where population = (select max(population) from city);

select * from city order by population desc;







