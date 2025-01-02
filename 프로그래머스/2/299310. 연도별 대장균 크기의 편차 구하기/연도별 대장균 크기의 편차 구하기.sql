-- 코드를 작성해주세요
with max_ecoli as
(
    select year(differentiation_date) as year, max(size_of_colony) as max 
    from ecoli_data
    group by year(differentiation_date)
)
select 
    year(ed.differentiation_date) as year,
    me.max - ed.size_of_colony as year_dev,
    ed.id
from ecoli_data ed
left join max_ecoli me on year(ed.differentiation_date) = me.year
order by year asc, year_dev asc