-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, sum(fp.price * fo.amount) as total_sales from food_order fo
join food_product fp on fo.product_id = fp.product_id
where fo.produce_date >= "2022-05-01"
and fo.produce_date < "2022-06-01"
group by fo.product_id
order by total_sales desc, fo.product_id asc;