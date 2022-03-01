/* mipslabwork.c

   This file written 2015 by F Lundevall
   Updated 2017-04-21 by F Lundevall

   This file should be changed by YOU! So you must
   add comment(s) here with your name(s) and date(s):

   This file modified 2022-02-16 by Fredrik Ehne

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "mipslab.h"  /* Declatations for these labs */

int i = 0;
int j = 0;
int shot_counter = 0;
int shot_pos;
int prime = 1234567;
int timeoutcount = 0;
int shot_timeout = 0;
int mytime = 0x5958;
volatile int* LED = (volatile int*) 0xbf886110;

char textstring[] = "text, more text, and even more text!";

void movement (void){
  int buttons = getbtns();
  int switches = getsw();
  if ((buttons & 8) != 0){
    i -= 2;
    display[i+2] = 255;
    display[i+3] = 255;
  }
  if ((buttons & 0x1) != 0){
    i += 2;
    if(i>=2){
      display[i-2] = 255;
      display[i-1] = 255;
    }
  }
  if ((buttons&4) != 0){
    i -= 128;
    display[i+128] = 255;
    display[i+129] = 255;
  }
  if ((buttons&2)!= 0){
    i += 128;
    display[i-128] = 255;
    display[i-127] = 255;
    if(i>=2){
      display[i-2] = 255;
      display[i-1] = 255;
    }
  }
  if(i>=511)
    i -= 511;
  display[511] = 255;
  display[510] = 255;
  if(i<0)
    i+=511;
  display[i] = 0;
  display[i+1] = 0;
  return;
}

/*int shot_pos fire_shot(int last_shot_pos){
  int buttons = getbtns();
  int switches = getsw();
  if(((switches&8)!=0) && shot_counter!=1){
    shot_pos = display[i-4];
    shot_counter = 1;
  }
}*/

void enable_interrupt(void){
  asm volatile("ei");
}
/* Interrupt Service Routine */
void user_isr( void )
{
  int buttons = getbtns();
  int switches = getsw();
  timeoutcount++;
  shot_counter++;
  IFS(0) = 0; //nollställer interruptstatusregistret
  if (timeoutcount == 1){
    movement();
    /*if(((switches&8)!=0) && shot_counter==0){
      shot_pos = display[i-4];
      shot_counter = 1;
    }
    if(shot_pos > 0){
      shot_pos -= 3;
      display[shot_pos] = 9;
      display[shot_pos +3] = 255;
    }*/
    timeoutcount = 0;
  }
  if (shot_counter == 20){
    shot_timeout = 0;
    shot_counter = 0;
  }
  (*LED)++;
  //display_image(0, display);
  display_image(0, display);
  tick( &mytime );
  return;
}

/* Lab-specific initialization goes here */
void labinit( void )
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
  T2CON += (1<<15); //sätter på timern igen
  return;
}

/* This function is called repetitively from the main program */
void labwork( void )
{
  //prime = nextprime( prime );
  //display_string( 0, itoaconv( prime ) );
  //display_update();

  int buttons = getbtns();
  int switches = getsw();
  /*if ((buttons & 8) != 0){
  }
  if ((buttons & 4) != 0){
    mytime = (mytime&0x0fff) + (switches<<12);
  }
  if ((buttons &2) != 0){
    mytime = (mytime&0xf0ff) + (switches<<8);
  }
  if ((buttons & 1) != 0){
    mytime = (mytime&0xff0f) + (switches<<4);
  }*/

  //display_image(96, icon);
}
