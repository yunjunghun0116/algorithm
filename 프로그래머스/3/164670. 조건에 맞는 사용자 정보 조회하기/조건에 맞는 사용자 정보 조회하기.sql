-- 코드를 입력하세요
SELECT uu.user_id, uu.nickname, concat(uu.city," ",uu.street_address1," ",uu.street_address2) as "전체주소",
concat(left(uu.tlno,3),'-',substring(uu.tlno,4,4),'-',right(uu.tlno,4)) as "전화번호" from used_goods_board ub
join used_goods_user uu on ub.writer_id = uu.user_id
group by ub.writer_id
having count(*) > 2
order by uu.user_id desc;