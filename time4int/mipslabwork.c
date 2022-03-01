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

int prime = 1234567;
int timeoutcount = 0;
int mytime = 0x5958;
volatile int* LED = (volatile int*) 0xbf886110;

char textstring[] = "text, more text, and even more text!";

void enable_interrupt(void){
  asm volatile("ei");
}
/* Interrupt Service Routine */
void user_isr( void )
{
  timeoutcount++;
  if ((IFS(0)&3) == 1)
    PORTE++;
  IFS(0) = 0; //nollställer interruptstatusregistret
  if (timeoutcount == 10){
    time2string( textstring, mytime );
    display_string( 3, textstring );
    display_update();
    tick( &mytime );
    timeoutcount = 0;
    (*LED)++;
  }

  display_image(96, icon);
  return;
}

/* Lab-specific initialization goes here */
void labinit( void )
{
  volatile int* trise = (volatile int*) 0xbf886100;
  //*trise = *trise & 0xffffff00;//sätter 8 lsb som 0 = LEDportarna är outputs
  *LED = 0;
  TRISD = TRISD & (127<<5);//s'tter bit 11-5 som 1, input

  T2CON = 0x70; //Sätter prescalingbitarna 6:4 i T2CON till 111, dvs 1/256 prescaling. Stänger också av timern.
  PR2 = 31250; //80000000/256/önskade perioden 10 per sekund = 31250
  TMR2 = 0; //nollställer timervärdet
  IEC(0) = (1 << 8); //interrupt enable för timer2
  IPC(2) = 4; //prioritet
  enable_interrupt(); //global interrupt enable
//  T2CONSET = 0x8000;
  T2CON += (1<<15); //sätter på timern igen

  //surprise
  IEC0CLR = 0x00008000;
  TRISECLR = 0xff;
  IEC(3) =
  IPC(3) = 5;

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
  if ((buttons & 0x4) != 0){
    mytime = (mytime&0x0fff) + (switches<<12);
  }
  if ((buttons &2) != 0){
    mytime = (mytime&0xf0ff) + (switches<<8);
  }
  if ((buttons & 1) != 0){
    mytime = (mytime&0xff0f) + (switches<<4);
  }

  //display_image(96, icon);
}
