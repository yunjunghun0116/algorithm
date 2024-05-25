-- 코드를 입력하세요
SELECT 
a.animal_id, a.name, date_format(a.datetime,"%Y-%m-%d")
from animal_ins a
order by a.animal_id;