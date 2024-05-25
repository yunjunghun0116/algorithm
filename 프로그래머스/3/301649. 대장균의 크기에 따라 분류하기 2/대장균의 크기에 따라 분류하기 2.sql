with ecoli_rank as(
    select e1.id, 
        percent_rank() over (order by size_of_colony) as ranks
    from ecoli_data e1
)
select ed.id,
case 
    when er.ranks <= 0.25 then "LOW"
    when er.ranks <= 0.5 then "MEDIUM"
    when er.ranks <= 0.75 then "HIGH"
    else "CRITICAL"
end as colony_name
from ecoli_rank er join ecoli_data ed
on ed.id = er.id
order by ed.id asc;