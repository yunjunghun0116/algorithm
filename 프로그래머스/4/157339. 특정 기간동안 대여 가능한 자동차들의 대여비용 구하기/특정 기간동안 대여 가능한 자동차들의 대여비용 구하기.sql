with discount as (
    select cdp.car_type, cdp.discount_rate from car_rental_company_discount_plan cdp
    where cdp.duration_type = "30일 이상"
    and cdp.car_type in ("SUV","세단")
), cant_use as (
    select car_id from car_rental_company_rental_history 
    where history_id not in (select distinct history_id 
    from car_rental_company_rental_history
    where end_date < "2022-11-01" or start_date >= "2022-12-01" )
)
select c.car_id, c.car_type, 
round(c.daily_fee *(1-d.discount_rate/100)*30) as fee
from car_rental_company_car c 
join discount d on c.car_type = d.car_type
where c.car_id not in (select car_id from cant_use)
and round(c.daily_fee *(1-d.discount_rate/100)*30) >= 500000
and round(c.daily_fee *(1-d.discount_rate/100)*30) < 2000000
order by fee desc, c.car_type asc, c.car_id desc