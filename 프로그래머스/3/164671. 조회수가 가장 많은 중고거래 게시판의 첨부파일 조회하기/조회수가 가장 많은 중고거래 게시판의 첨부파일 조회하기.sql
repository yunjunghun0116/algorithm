-- 코드를 입력하세요
SELECT concat("/home/grep/src/",uf.board_id,"/",uf.file_id,uf.file_name,uf.file_ext) as file_path from used_goods_file uf 
join (
    select board_id from used_goods_board
    order by views desc limit 1
) as ub
on uf.board_id = ub.board_id
order by uf.file_id desc;