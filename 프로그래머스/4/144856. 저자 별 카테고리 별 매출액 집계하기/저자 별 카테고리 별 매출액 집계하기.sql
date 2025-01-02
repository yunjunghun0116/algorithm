-- 코드를 입력하세요
with sale_data as
(SELECT book_id, sum(sales) as sales from book_sales 
where sales_date >= "2022-01-01" and sales_date < "2022-02-01"
group by book_id),
book_data as
(select a.author_id,a.author_name, b.book_id,b.price ,b.category
from book b 
join author a 
on b.author_id = a.author_id
)
select bd.author_id, bd.author_name, bd.category, sum(sd.sales*bd.price) as total_sales 
from sale_data sd 
join book_data bd on sd.book_id = bd.book_id
group by bd.author_id, bd.category
order by bd.author_id asc, bd.category desc;