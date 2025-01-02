SELECT uu.user_id,uu.nickname,sum(ub.price) as total_sales from used_goods_board ub left join used_goods_user uu on ub.writer_id = uu.user_id
where ub.status = "DONE"
group by uu.user_id
having sum(ub.price) >= 700000 
order by sum(ub.price) asc;