#include <stdint.h>
#include <pic32mx.h>
#include "gameheader.h"

int getsw (void){
  int toggle = ((PORTD>>8) & 0xf);
  return toggle;
}

int getbtns (void){
  int btns = (((PORTD>>4)&0xe)|((PORTF>>1)&1));
  //(((PORTD >> 4) & 0x0E) | ((PORTF >> 1) & 0x1));
  return btns;
}
