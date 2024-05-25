-- 코드를 입력하세요
with a as 
(select cart_id from cart_products 
    where name = "Milk"
)
select c.cart_id from cart_products c
join a on c.cart_id = a.cart_id
where c.name = "Yogurt"
group by cart_id;



