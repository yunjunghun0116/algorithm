-- 코드를 입력하세요
SELECT book_id, date_format(published_date,"%Y-%m-%d") as published_date from book where category="인문" and published_date >= "2021-01-01" and published_date < "2022-01-01" order by published_date;