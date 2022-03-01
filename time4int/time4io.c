#include <stdint.h>
#include <pic32mx.h>
#include "mipslab.h"

int getsw (void){
  int toggle = ((PORTD>>8) & 0xf);
  return toggle;
}

int getbtns (void){
  int btns = ((PORTD>>5)&7);
  return btns;
}
