/*
   This file written 2015 by Axel Isaksson,
   modified 2015, 2017 by F Lundevall

   Latest update 2022-02-22 by Fredrik Ehne

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "gameheader.h"  /* Declatations for these labs */

int main(void) {

	while(1){
    display_init();
    gameinit();
	  game(); /* Do game-specific things again and again */
  }
	return 0;
}
