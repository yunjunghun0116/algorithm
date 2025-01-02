select warehouse_id, warehouse_name, address,
case 
    when freezer_yn is not null then freezer_yn
    else "N"
end as freezer_yn
from food_warehouse 
where warehouse_name like "%경기%"
order by warehouse_id asc;