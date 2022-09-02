#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "head.h"  /* Declatations for these labs */
//#include <stdio.h>

//funktion för att skapa fiendeskepp
struct alien make_alien (uint8_t x, uint8_t y, int name) {
	struct alien make;
	make.x = x;
	make.y = y;
	make.height = 5;
	make.width = 7;
	make.name = name;
	make.live = 3;
	return make;
}
//funktion för att skapa en spelare
struct alien make_player (uint8_t x, uint8_t y, int name) {
	struct alien make;
	make.x = x;
	make.y = y;
	make.height = 9;
	make.width = 7;
	make.name = name;
	make.live = 1;
	return make;
}

struct kula make_kula(int dir, int name){
	struct kula make;
	make.x = 0;
	make.y = 0;
	make.height = 2;
	make.dir = dir;
	make.name = name;
	make.live = 0;
	return make;
}
void toggle_player(struct alien *play, int set){
	int element, index, rad, maxrad, maxindex;
	//if(((*ali).x) %8 <= (*ali).width){
	element = 0;
	maxrad = (*play).y + (*play).height;
	maxindex = (*play).x + (*play).width;
	for(rad = (*play).y; rad < maxrad; rad++){
		for(index = (*play).x; index < maxindex; index++){
			if((ship[element] >> ((index-(*play).x)%8)) & 1){
				set_pixel(index, rad, set);
			}
		}
		element++;
	}
}
void toggle_alien(struct alien *ali, int set){
	int element, index, rad, maxrad, maxindex;
	element = 0;
	maxrad = (*ali).y + (*ali).height;
	maxindex = (*ali).x + (*ali).width;
	for(rad = (*ali).y; rad < maxrad; rad++){
		for(index = (*ali).x; index < maxindex; index++){
			if((alien2[element] >> ((index-(*ali).x)%8)) & 1){
				set_pixel(index, rad, set);
			}
		}
		element++;
	}
}
/*void explosion(int x, int y){
  int i;
	set_pixel(x , y , 1);
	for(i = 1; i<5;i++){
		set_pixel(x + i, y + i, 1);
		set_pixel(x - i, y - i, 0);
	}
	set_pixel(x + 5, y  + 5, 0);
}*/
void move_aliens(struct alien *ali){
	toggle_alien(ali, 0);
	if((*ali).y + (*ali).height < 127){
		int y = (*ali).y;
		int i = 0;
		(*ali).y++;
		for(i = 0; i < (*ali).width; i++){
			if(pixel_on(((*ali).x + i), ((*ali).y + (*ali).height))){
				(*ali).y = y;
			}
		}
	}
	toggle_alien(ali, 1);	
	return;
}
void move_player(struct alien *play){
	toggle_player((play), 0);
	int x, y;
	if((getbtns() & 8) && (*play).y > 0){//move left
		x = (*play).x;
		y = (*play).y;
		(*play).y--;
		if(pixel_on((*play).x , (*play).y)||pixel_on((*play).x + (*play).width, (*play).y)){
			(*play).x = x;
			(*play).y = y;
		}
	}
	if((getbtns() & 1) && (*play).y + (*play).height < 127){//move right
		x = (*play).x;
		y = (*play).y;
		(*play).y++;
		if(pixel_on((*play).x , (*play).y) || pixel_on((*play).x, (*play).y + (*play).height)){
			(*play).x = x;
			(*play).y = y;
		}
	}
	if((getbtns() & 2) && (*play).x > 0){//move up
		x = (*play).x;
		y = (*play).y;
		(*play).x--;
		for(i = 0; i < (*play).height; i++){
			if(pixel_on((*play).x , ((*play).y + i))){
				(*play).x = x;
				(*play).y = y;
				break;
			}
		}
	}
	if((getbtns() & 4) && ((*play).x + (*play).width) < 31){//move down
		x = (*play).x;
		y = (*play).y;
		(*play).x++;
		for(i = 0; i <(*play).width; i++){
			if(pixel_on(((*play).x + (*play).width) , ((*play).y) + i)){
				(*play).x = x;
				(*play).y = y;
			}
		}
	}
	toggle_player(play, 1);
}
//kontrollera om kulan träffar något, kontrollera mot matrisen med aliens figur och aliens arrayn om det är träff.
void hit(struct kula *kul){
	if(!(*kul).dir){
		if(aliens[0].live){
			if((*kul).x >= aliens[0].x  && (*kul).x <= aliens[0].x + aliens[0].width && (*kul).y >= aliens[0].y && 
					(*kul).y <= aliens[0].y + aliens[0].height){
				aliens[0].live--;
				toggle_player(&aliens[0], 0);
				(*kul).live = 0;
				game_over = 1;
			}
			/*else
				(*kul).live = 0;*///om fienden inte ska kunna ta sönder barriärerna
		}
		return;
	}
	else{
		int i;
		for(i = 1; i < items; i++){
			if((*kul).x >= aliens[i].x && (*kul).x <= aliens[i].x + aliens[i].width && (*kul).y >= aliens[i].y &&
				(*kul).y <= aliens[i].y + aliens[i].height){
				if(!aliens[i].live){
					enemy_counter--;
					toggle_alien(&aliens[i], 0);
					(*kul).live = 0;
				}
				else{
				aliens[i].live--;
				(*kul).live = 0;
				score++;
				}
			}
			else{
				(*kul).live = 0;
			}
		}
	}
	return;
}	

//om skottet får dir 0 så är det fiender som skjuter.
//lägga till en randomize för att låta vissa fiender skjuta.
//sätter y och x till där första pixeln ska tändas vid skott
//i går till kulors storlek sätta en fast variabel? 
void shoot(struct alien *play){
	if((*play).live && !kulor[(*play).x].live){
		kulor[(*play).x].dir = ((*play).name==0) ? 1:0;
		kulor[(*play).x].live = 1;
		kulor[(*play).x].x = (*play).x + 3;
		kulor[(*play).x].y = ((*play).name==0) ? ((*play).y - 1):((*play).y + (*play).height);
	}
}
//Lägga till o kolla om det finns något innan man tooglar och i såfall skickar till 
//en annan funktion för att markera hit.
void move_kula(struct kula *kul){
	if((*kul).live){
		set_pixel((*kul).x, (*kul).y, 0); 
	}
	if((*kul).dir)
		(*kul).y--;
	else
		(*kul).y++;
	if(pixel_on((*kul).x, (*kul).y)){
		hit(kul);
	}
	if((*kul).y <= 0 || (*kul).y >= 127){
		(*kul).live = 0;
	}
	if((*kul).live)
		set_pixel((*kul).x, (*kul).y, (*kul).live);
}




