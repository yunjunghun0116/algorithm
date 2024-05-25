-- 코드를 작성해주세요
with gr as 
(select emp_no, sum(score) as score from hr_grade
group by emp_no)

select emp.emp_no, emp.emp_name, 
case 
    when g.score >= 192 then "S"
    when g.score >= 180 then "A"
    when g.score >= 160 then "B"
    else "C"
end as grade,
case 
    when g.score >= 192 then emp.sal * 0.2
    when g.score >= 180 then emp.sal * 0.15
    when g.score >= 160 then emp.sal * 0.1
    else 0
end as bonus
from hr_employees emp
join gr g on emp.emp_no = g.emp_no
