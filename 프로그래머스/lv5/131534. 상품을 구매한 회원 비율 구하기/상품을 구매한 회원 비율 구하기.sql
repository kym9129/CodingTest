-- 2021년 가입자, 상품을 구매한 회원수, 상품 구매 회원 비율
-- (=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)

select year(o.sales_date) as YEAR,
        month(o.sales_date) as MONTH,
        count(distinct o.user_id) as PUCHASED_USERS,
        round(count(distinct o.user_id) / (
            select count(user_id)
            from user_info
            where joined < str_to_date('2022-01-01 00:00:00', '%Y-%m-%d %H:%i:%s')
        ), 1) AS PUCHASED_RATIO
from online_sale as o
join user_info as u on o.user_id = u.user_id
where u.joined < str_to_date('2022-01-01 00:00:00', '%Y-%m-%d %H:%i:%s')
group by year(sales_date), month(sales_date)
order by year(sales_date), month(sales_date);

# select *
# from online_sale as o
# join user_info as u on o.user_id = u.user_id
# where u.joined < str_to_date('2022-01-01 00:00:00', '%Y-%m-%d %H:%i:%s')
# and month(o.sales_date) = 3
# group by year(sales_date), month(sales_date);


# 2021년 가입자 수 158명
# select year(joined), count(user_id)
# from user_info
# group by year(joined)