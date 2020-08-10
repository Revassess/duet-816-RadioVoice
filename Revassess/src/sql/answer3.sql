select * 
from app_user au inner join study_set ss on au.user_id = ss.owner_id 
where au.user_id = 5;