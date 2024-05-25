-- 코드를 입력하세요
select p.id, p.name, p.host_id from places p
join (SELECT host_id from places
group by host_id
having count(*) > 1) as a
on p.host_id = a.host_id
order by p.id asc;