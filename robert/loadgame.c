#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "head.h"  /* Declatations for these labs */

int enemy_shot_counter = 0;
int game_over = 0;
int levelcounter = 1;
int counter = 0;
int choice = 0;


void load_game(int x){
	if(x != 1)
		return;
	//skapar en spelare
	aliens[0] = make_player(19, 110, 0);
	//skapar 8 fiendeskepp
	for(i = 0; i < 4; i++){
		aliens[i+1] = make_alien((i*8), 0, i+1);
		aliens[i+5] = make_alien((i*8), 7, i+5); 
	}
	//initierar kulor
	for(i = 0; i < items; i++){
		kulor[i] = make_kula(1, i);
	}
	//sätter på skeppen
	toggle_player(&aliens[0], 1);
	for(i = 1; i < 9; i++){
		toggle_alien(&aliens[i], 1);
	}
	enemy_counter = 8;
	return;
}

void load_game2(int x){
	//T2CONSET = 0x8000; //sätter på timern igen
	if(x != 2)
		return;
	aliens[0] = make_player(19, 110, 0);
	for(i = 0; i < 4; i++){
		aliens[i+1] = make_alien((i*8), 0, i+1);
		aliens[i+5] = make_alien((i*8), 7, i+5); 
	}
	for(i = 0; i < items; i++){
		kulor[i] = make_kula(1, i);
	}
	toggle_player(&aliens[0], 1);
	for(i = 1; i < 9; i++){
		toggle_alien(&aliens[i], 1);
	}
	//bygger bärriärer
	for(i = 0; i < 32; i++){
		if(i < 16)
			set_pixel(i,100, 1);
		else
			set_pixel(i, 86, 1);
	}
	enemy_counter = 8;
	return;
}
void load_game3(int x){
	//T2CONSET = 0x8000; //sätter på timern igen
	if(x != 3)
		return;
	aliens[0] = make_player(19, 110, 0);
	for(i = 0; i < 4; i++){
		aliens[i+1] = make_alien((i*8), 0, i+1);
		aliens[i+5] = make_alien((i*8), 7, i+5); 
	}
	for(i = 0; i < items; i++){
		kulor[i] = make_kula(1, i);
	}
	toggle_player(&aliens[0], 1);
	for(i = 1; i < 9; i++){
		toggle_alien(&aliens[i], 1);
	}
	//bygger bärriärer
	for(i = 0; i < 32; i++){
		if(i < 16)
			set_pixel(i,86, 1);
		else
			set_pixel(i, 100, 1);
	}
	enemy_counter = 8;
	return;
}
void load_game4(int x){
	//T2CONSET = 0x8000; //sätter på timern igen
	if(x != 4)
		return;
	aliens[0] = make_player(19, 110, 0);
	for(i = 0; i < 4; i++){
		aliens[i+1] = make_alien((i*8), 0, i+1);
		aliens[i+5] = make_alien((i*8), 7, i+5); 
	}
	for(i = 0; i < items; i++){
		kulor[i] = make_kula(1, i);
	}
	toggle_player(&aliens[0], 1);
	for(i = 1; i < 9; i++){
		toggle_alien(&aliens[i], 1);
	}
	enemy_counter = 8;
	return;
}
void load_enemyshooting_level(void){
	int speed;
	if((levelcounter) == 1)
		speed = 40;
	else if((levelcounter) == 2)
		speed = 30;
	else
		speed = 20;
	enemy_shot_counter++;
	if(enemy_shot_counter == speed)
		if(aliens[5].live)
			shoot(&aliens[5]);
		else if(aliens[1].live)
			shoot(&aliens[1]);
	if(enemy_shot_counter == (speed * 2))
		if(aliens[6].live)
			shoot(&aliens[6]);
		else if(aliens[2].live)
			shoot(&aliens[2]);
	if(enemy_shot_counter == (speed * 3))
		if(aliens[7].live)
			shoot(&aliens[7]);
		else if(aliens[3].live)
			shoot(&aliens[3]);
	if(enemy_shot_counter == (speed * 4)){
		if(aliens[8].live)
			shoot(&aliens[8]);
		else if(aliens[4].live)
			shoot(&aliens[4]);
	enemy_shot_counter = 0;
	}
	return;
}


void game(int x){
	if(x)
		return;
	if(getsw() & 1 && levelcounter == 1)
		shoot(&aliens[0]);
	else if(getsw() & 1 && !counter){
		counter = 1;
		shoot(&aliens[0]);
	}
	if(!getsw())
		counter = 0;
	move_player(&aliens[0]);
	load_enemyshooting_level();	

	//kollar om det finns skott som är igång och flyttar skotten
	int i;
	for(i = 0; i <32; i++)
		if((kulor[i].live))
			move_kula(&kulor[i]);

	if(!enemy_counter){
		levelcounter++;
		//timer();
		if(levelcounter > 5){
			game_over = 1;
			return;
		}
		clear_screen();
		loading_screen();
		load_game2(levelcounter);
		load_game3(levelcounter);
		load_game4(levelcounter);
		//skicka till next level
	}
		return;
}
