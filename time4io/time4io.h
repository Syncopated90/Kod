#include <stdint.h>
#include <pic32mx.h>
#include "mipslab.h"

int getsw (void){
  int toggle = (PORTD & 0xf00)>>8;
  return toggle;
}

int getbtns (void){
  int btns = (PORTD & (7<<5))>>5;
  return btns;
}
