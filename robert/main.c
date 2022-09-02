

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "head.h"  /* Declatations for these labs */

int i = 0;
int lives = 3;
int score = 0;
int new_game = 0;


int main(void) {
 	
	display_init();
	display_update();
	timer(); /* starta timer interrupt */

	while( 1 )
	{
	  space_attacker(); //start game
	}
	return 0;
}

void space_attacker( void ){
	
	start_screen();
	clear_screen();
	loading_screen();
	load_game(levelcounter);
	load_game2(levelcounter);
	load_game3(levelcounter);
	load_game4(levelcounter);
	while(!game_over){
		quicksleep(10);		
	}
	end_screen(score, &new_game, name);
	while (game_over){
    quicksleep(10);}
	clear_screen();
	display_update();
	reset_game(&lives, &score, &counter, &enemy_shot_counter,&game_over, &new_game, &levelcounter);//behöver inte återställa levelcounter??
}
