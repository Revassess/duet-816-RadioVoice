select username, c."name", f.question, f.answer 
from app_user au inner join study_set ss 
	on au.user_id = ss.owner_id 
	inner join study_set_card ssc 
	on ss.study_set_id = ssc.study_set_id 
	inner join flashcard f 
	on ssc.flashcard_id = f.flashcard_id
	inner join category c
	on f.category_id = c.category_id 
where au.user_id = 4;