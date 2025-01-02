-- 코드를 입력하세요
SELECT 
    ub.TITLE, 
    ub.BOARD_ID, 
    ur.REPLY_ID, 
    ur.WRITER_ID, 
    ur.CONTENTS, 
    date_format(ur.created_date,"%Y-%m-%d") as CREATED_DATE 
from used_goods_reply ur 
join used_goods_board ub on ur.board_id = ub.board_id
where ub.created_date >= "2022-10-01" and ub.created_date < "2022-11-01"
order by ur.created_date asc, ub.title asc;