/* mipslabwork.c

   This file written 2015 by F Lundevall
   Updated 2017-04-21 by F Lundevall

   This file should be changed by YOU! So you must
   add comment(s) here with your name(s) and date(s):

   This file modified 2022-02-16 by Fredrik Ehne

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "gameheader.h"  /* Declarations for these labs */
int new_game =0;
int score = 237;
int score_counter = 0;
int ship_x = 5;
int ship_y = 115;
int i = 0;
int j = 0;
int char_marker = 0;
int timeoutcount = 0;
int update_count = 0;
int game_over = 0;
char name[3] = {'A','A','A'};
volatile int* LED = (volatile int*) 0xbf886110;


void player_movement (void){
  int buttons = getbtns();
  int switches = getsw();

  if ((buttons & 8) != 0){//move left
    if(ship_y > 1){
        clear_ship(ship_x, ship_y);
        ship_y-=3;
    }
  }

  if ((buttons & 1) != 0){//move right
    if(ship_y < 118 ){
      clear_ship(ship_x, ship_y);
      ship_y += 3;
    }
  }

  if ((buttons&2) != 0){//move up
    if(ship_x > 4){
      clear_ship(ship_x, ship_y);
      ship_x-= 2;
    }
  }
  if ((buttons&4) != 0){//move down
    if(ship_x < 27){
      clear_ship(ship_x, ship_y);
      ship_x+= 2;
    }
  }
  return;
}


/* Interrupt Service Routine */
void user_isr( void )
{
  int buttons = getbtns();
  int switches = getsw();
  timeoutcount++;

  IFS(0) = 0; //nollställer interruptstatusregistret
  if (/*timeoutcount == 1 && */game_over == 0){
    player_movement();
    draw_ship(ship_x ,ship_y);
    //timeoutcount = 0;
    display_image(0,display);
  }
  else if(timeoutcount >= 2 && game_over == 1){
		if ((buttons&4) != 0){
			name[char_marker]--;
		  if(name[char_marker] == 64)
		    name[char_marker] = 90;
    }
	  if ((buttons&2) != 0){
		  name[char_marker]++;
		  if(name[char_marker] == 91)
			  name[char_marker] = 65;
		}

		if ((buttons&8) != 0){
			char_marker--;
			if(char_marker < 0)
				char_marker = 2;
		}
		if ((buttons&1) != 0){
			char_marker++;
			if(char_marker == 3)
				char_marker = 0;
		}
    timeoutcount = 0;
		textbuffer[3][0] = name[0];
		textbuffer[3][1] = name[1];
		textbuffer[3][2] = name[2];
    for (i = 0; i < 3; i++)
      higscores[score_counter][i] = name[i];
    display_update();
    if (switches == 4)
      new_game = 1;
  }
  (*LED)++;
  if (switches == 1)
    game_over = 1;

  return;
}

/* Lab-specific initialization goes here */
void gameinit( void )
{
  volatile int* trise = (volatile int*) 0xbf886100;
  *trise = *trise & 0xffffff00;//sätter 8 lsb som 0 = LEDportarna är outputs
  *LED = 0;
  TRISD = TRISD & (127<<5);//s'tter bit 11-5 som 1, input
  TRISF |= 0x02;

  T2CON = 0x70; //Sätter prescalingbitarna 6:4 i T2CON till 111, dvs 1/256 prescaling. Stänger också av timern.
  PR2 = 31250; //80000000/256/önskade perioden 10 per sekund = 31250
  TMR2 = 0; //nollställer timervärdet
  IEC(0) = (1 << 8); //interrupt enable för timer2
  IPC(2) = 4; //prioritet
  enable_interrupt(); //global interrupt enable
  return;
}

/* This function is called repetitively from the main program */
void game()
{
  start_screen();
	while(1){
	  if (game_over == 1)
      break;
  }
  for(i = 0; i < 512; i++)
    display[i] = 0;
  while (new_game == 0)
    end_screen(score);
  new_game = 0;
  game_over = 0;
  score = 0;
  score_counter = 0;
  ship_x = 5;
  ship_y = 115;
  char_marker = 0;
  timeoutcount = 0;
  update_count = 0;

  return;
}
