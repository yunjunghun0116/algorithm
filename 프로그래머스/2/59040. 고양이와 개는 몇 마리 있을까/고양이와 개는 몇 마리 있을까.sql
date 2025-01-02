-- 코드를 입력하세요
SELECT animal_type, count(*) as count from animal_ins 
group by animal_type
order by CASE 
        WHEN animal_type = 'Cat' THEN 1
        WHEN animal_type = 'Dog' THEN 2
        ELSE 3 -- 다른 동물들은 이후에 정렬됩니다.
    END;