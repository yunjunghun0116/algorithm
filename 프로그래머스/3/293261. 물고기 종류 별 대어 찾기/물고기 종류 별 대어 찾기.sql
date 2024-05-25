-- 코드를 작성해주세요
with max_fish as (select fish_type, max(length) as length from fish_info 
group by fish_type)
select fi.id, fn.fish_name, mf.length from fish_info fi
join max_fish mf on fi.fish_type = mf.fish_type
join fish_name_info fn on fi.fish_type = fn.fish_type
where fi.length = mf.length
order by fi.id asc;