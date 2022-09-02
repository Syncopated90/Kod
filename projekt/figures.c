#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "mipslab.h"  /* Declatations for these labs */
#include <stdio.h>

//funktion för att skapa fiendeskepp
struct alien make_alien (uint8_t x, uint8_t y, int name) {
	struct alien make;
	make.x = x;
	make.y = y;
	make.height = 5;
	make.width = 7;
	make.name = name;
	make.live = 1;
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
//om skottet får dir 0 så är det fiender som skjuter.
//sätter y och x till där första pixeln ska tändas vid skott
//i går till kulors storlek sätta en fast variabel?
void shoot(struct alien *play){
	if((*play).live && !kulor[(*play).x].live){
				//kulor[(*play).name].dir = ((*play).name==0) ? 1:0;
				kulor[(*play).name].live = 1;
				kulor[(*play).name].x = (*play).x + 3;
				kulor[(*play).name].y = (kulor[i].dir) ? ((*play).y - 1):((*play).y + (*play).height);
			}
}
/*
void shoot(struct alien *play){
	if((*play).live){
		for(i = 0; i < 10; i++){
			if(!kulor[i].live){
				kulor[i].dir = ((*play).name==0) ? 1:0;
				kulor[i].live = 1;
				kulor[i].x = (*play).x + 3;
				kulor[i].y = (kulor[i].dir) ? ((*play).y - 1):((*play).y + (*play).height);
				break;
			}
		}
	}
}
*/
/*
void toggle_kulor(struct kula *kul){
	int index;
	for(index = 0; index < 10; index++){
		if(
	}
}
*/



void move_kula(struct kula *kul){
			if((*kul).live){
				set_pixel((*kul).x, (*kul).y, 0);
			}
			if((*kul).dir){
				set_pixel((*kul).x, (*kul).y, 0);
				(*kul).y--;
				set_pixel((*kul).x, (*kul).y, (*kul).live);
			}
			else{
				(*kul).y++;
				set_pixel((*kul).x, (*kul).y, (*kul).live);
			}
}


void toggle_player(struct alien *play){
	int element, index, rad, maxrad, maxindex;
	//if(((*ali).x) %8 <= (*ali).width){
	element = 0;
	maxrad = (*play).y + (*play).height;
	maxindex = (*play).x + (*play).width;
	for(rad = (*play).y; rad < maxrad; rad++){
		for(index = (*play).x; index < maxindex; index++){
			if((ship[element] >> ((index-(*play).x)%8)) & 1){
				set_pixel(index, rad, (*play).live);
			}
		}
		element++;
	}
}

void toggle_alien(struct alien *ali){
	int element, index, rad, maxrad, maxindex;
	//if(((*ali).x) %8 <= (*ali).width){
	element = 0;
	maxrad = (*ali).y + (*ali).height;
	maxindex = (*ali).x + (*ali).width;
	for(rad = (*ali).y; rad < maxrad; rad++){
		for(index = (*ali).x; index < maxindex; index++){
			if((alien2[element] >> ((index-(*ali).x)%8)) & 1){
				set_pixel(index, rad, (*ali).live);
			}
		}
		element++;
	}
}
