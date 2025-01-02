-- 코드를 입력하세요
with maxs as 
(SELECT max(price) as price from food_product)
select fp.product_id, fp.product_name, fp.product_cd, fp.category, fp.price from food_product fp,maxs ms
where fp.price = ms.price