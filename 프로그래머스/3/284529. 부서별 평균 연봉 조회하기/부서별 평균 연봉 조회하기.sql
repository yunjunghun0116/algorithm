-- 코드를 작성해주세요

with dept as (select emp.dept_id, round(avg(emp.sal),0) as avg_sal from hr_employees emp
group by emp.dept_id)
select 
dp.dept_id, dp.dept_name_en, dt.avg_sal
from hr_department dp
join dept dt on dp.dept_id = dt.dept_id 
order by dt.avg_sal desc;
