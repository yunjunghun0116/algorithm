-- 코드를 입력하세요
with car as 
(
    SELECT car_id from car_rental_company_rental_history
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5
)
select month(ch.start_date) as month, ch.car_id, count(*) as records from car_rental_company_rental_history ch
join car c on ch.car_id = c.car_id
where ch.start_date >= '2022-08-01' and ch.start_date < '2022-11-01'
group by month, ch.car_id
order by month asc, ch.car_id desc;