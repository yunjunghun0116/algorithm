-- 코드를 입력하세요
SELECT animal_type,
case
    when name is not null then name
    else "No name"
end as name, sex_upon_intake
from animal_ins;