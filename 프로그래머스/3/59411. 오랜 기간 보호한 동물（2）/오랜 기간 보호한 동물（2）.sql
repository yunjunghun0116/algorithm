-- 코드를 입력하세요
SELECT ao.animal_id, ao.name from animal_outs ao left join animal_ins ai on ao.animal_id = ai.animal_id
order by ao.datetime - ai.datetime desc limit 2;