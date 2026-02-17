-- 코드를 입력하세요
SELECT dr_name, dr_id, MCDP_CD, date_format(HIRE_YMD, '%Y-%m-%d') as hire_ymd
from doctor
where mcdp_cd = 'CS' or mcdp_cd = 'GS'
order by hire_ymd desc, dr_name asc;