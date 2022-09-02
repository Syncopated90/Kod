

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "head.h"  /* Declatations for these labs */


#define DISPLAY_CHANGE_TO_COMMAND_MODE (PORTFCLR = 0x10)
#define DISPLAY_CHANGE_TO_DATA_MODE (PORTFSET = 0x10)

#define DISPLAY_ACTIVATE_RESET (PORTGCLR = 0x200)
#define DISPLAY_DO_NOT_RESET (PORTGSET = 0x200)

#define DISPLAY_ACTIVATE_VDD (PORTFCLR = 0x40)
#define DISPLAY_ACTIVATE_VBAT (PORTFCLR = 0x20)

#define DISPLAY_TURN_OFF_VDD (PORTFSET = 0x40)
#define DISPLAY_TURN_OFF_VBAT (PORTFSET = 0x20)
#define TMR2Period ((8000000/256/3))
int interuptcount = 0;
volatile int* portEled = (volatile int*) 0xbf886110;
char name[3] = {'A','A','A'};
int game_over_counter = 20;
char highscore_names[4][3] = {};
int highscore_scores[4] = {};
int score_marker = 0;

int enemy_counter = 8;//måste återställa mellan varje omgång

void user_isr( void )
{
	game_over_func(game_over);
	game(game_over);
	game_over_counter++;
	(*portEled)++;
	IFSCLR(0) = 0x100;
	IFSCLR(0) = 0x800;
	display_update();
}

/* Lab-specific initialization goes here */
void timer( void )
{
	volatile int* trisE = (volatile int*) 0xbf886100; //Adressen
	*trisE &= ~0xFF; 								 //sätter 7:0 till output
	*portEled &= 0; 								 //sätter alla led till 0.
	TRISD |= 0x01E0;								//Sätter port 5-11 som input
	TRISF |= 0x02;									//sätter port 1 som input för BTN1
	//Timer 2
	T2CON = 0X070; //Stop timer and clear the control register, prescaler 1:256 internal clock source
	TMR2 = 0x0; //clear timer register
	PR2 = TMR2Period; //load period register ((80000000/256) /10) 10times per second
	IFSCLR(0) = 0x100; //Reset interuptflag
	IPCSET(2) = 0x1D; //Sätter högsta prioritet för timer2 flaggan
	IECSET(0) = 0x100; //Sätter på timer 2 interuptflag
	//T2CONSET = 0x8000; //Start timer med 1:256 prescale
	//Interrupt startup
	IFSCLR(0) = 0x800;//Reset interrupt2 external
	IPCSET(2) = 0x01f000000; //Set priority level till max
	IECSET(0) = 0x800;//enable external interrupt 2
	enable_interrupt ();

	return;
}


int pixel_on(uint8_t x, uint8_t y){
	return (display[((x/8) * 128) + y] >> x%8) & 0x1;
}


void set_pixel(int x, int y, int set){
	if(set)
		display[((x/8) * 128) + y] |= (pow(2, (x%8)));
	else
		display[((x/8) * 128) + y] &= ~(pow(2, (x%8)));
}
void clear_screen(void){
	int i;
	for(i = 0; i < 512; i++)
		display[i] = 0;
	return;
}

int pow(int val1, int val2){
	int value = 1;
	while(val2 > 0){
		value = value * val1;
		val2--;
	}
	return value;
}
/* quicksleep:
   A simple function to create a small delay.
   Very inefficient use of computing resources,
   but very handy in some special cases. */
void quicksleep(int cyc) {
	int i;
	for(i = cyc; i > 0; i--);
}
int getsw(void)
{
	volatile int switches = ((PORTD >> 8) & 0x00001);
	return switches;
}

int getbtns(void)
{
	volatile int btn = (((PORTD >> 4) & 0x0E) | ((PORTF >> 1) & 0x1)) ;
	return btn;
}
void start_screen(){
	display_string(0, "     Space");
	display_string(1, "    Attacker");
	display_string(2, "   av Robert");
	display_string(3, "  och Fredrik");
	display_image();
	while (!getbtns()){
		quicksleep(1000);
		display_image();
	}
	quicksleep(10000);
	game_meny();
}

void end_screen(int score, int* new_game, char name[]){

	for(i = 0; i < 512; i++)
    display[i] = 0;
	int char_marker = 0;
	int score_counter = 0;
	char score_array[3] = {};//{'1','3','4'};
	score_array[0] = score / 100 + '0';
	score_array[1] = ((score/ 10) % 10) + '0';
	score_array[2] = score % 10 + '0';
	display_string(0, " ");
    display_string(1, " ");
    display_string(2, " ");
    display_string(3, " ");
	display_string(0, "Score");
	display_string(1, score_array);
	display_string(2, "Name");
	display_string(3, " ");
}
void show_highscore(){
	quicksleep(1000000);
	display_string(0, " ");
    display_string(1, " ");
    display_string(2, " ");
    display_string(3, " ");
	timer();
	while (!getbtns()){
		int j = 0;
		char dummy[3];
		for(i = 1;i<4;i++){
			if(highscore_scores[i] > highscore_scores[i-1]){
				for(j=0;j<3;j++){
				dummy[j] = highscore_names[i-1][j];
				highscore_names[i-1][j] = highscore_names[i][j];
				highscore_names[i][j] = dummy[j];
			}
				j = highscore_scores[i-1];
				highscore_scores[i-1] = highscore_scores[i];
				highscore_scores[i] = j;
			}
		}
		for(i = 0; i < 4;i++){
			textbuffer[i][0] = highscore_names[i][0];
			textbuffer[i][1] = highscore_names[i][1];
			textbuffer[i][2] = highscore_names[i][2];
			textbuffer[i][4] = (highscore_scores[i]/ 100) + '0';
			textbuffer[i][5] = ((highscore_scores[i]/ 10) % 10) + '0';
			textbuffer[i][6] = (highscore_scores[i] % 10) + '0';
		}
		display_image();
		quicksleep(100);
	}
	if(getbtns())
		game_meny();

}
void game_over_func(int x){
	if(!x)
		return;
	//T2CONSET = 0x8000; //sätter på timern igen
	while(game_over){
		game_over_counter++;
		if(game_over_counter > 150)
		{
			IFSCLR(0) = 0x100;
			IFSCLR(0) = 0x800;
			game_over_counter = 0;
			if ((getbtns()&4) != 0)
				name[char_marker]--;
			if(name[char_marker] == 64)
				name[char_marker] = 90;
			if ((getbtns()&2) != 0)
			name[char_marker]++;
			if(name[char_marker] == 91)
				name[char_marker] = 65;
			if ((getbtns()&8) != 0)
				char_marker--;
			if(char_marker < 0)
				char_marker = 2;
			if ((getbtns()&1) != 0)
				char_marker++;
			if(char_marker == 3)
				char_marker = 0;
		}
		textbuffer[3][0] = name[0];
		textbuffer[3][1] = name[1];
		textbuffer[3][2] = name[2];
		/*for (i = 0; i < 3; i++)
			higscores[score_counter][i] = name[i];*/
		display_image();
			if (getsw() == 1){
	   		display_string(0, " ");
				display_string(1, " ");
				display_string(2, " ");
				display_string(3, " ");
				new_game = 1;
				int i, j;
				for(i = score_marker; i < 4; i++ ){
					if(score >= highscore_scores[i]){
						highscore_names[i][0] = name [0];
						highscore_names[i][1] = name [1];
						highscore_names[i][2] = name [2];
						highscore_scores[i] = score;
						score = 0;
						score_marker++;
						break;
					}
				}
			if(score_marker == 4)
				score_marker = 0;
			for(i=0;i<3;i++)
				name[i] = 'A';
			game_over = 0;
			timer();
		}
	}
}
void game_meny(){
	quicksleep(1000000);
	timer();
	clear_screen();

	display_string(0, " 1. Game");
	display_string(1, " 2. Highscore");
	display_string(2, "   ");
	display_string(3, "  ");
	display_image();
	while (!getbtns()){
		quicksleep(10000);
		display_image();
	}
	if(getbtns() & 8 || getbtns() & 2 || getbtns() & 1){
		 level();
	}
	/*
	if(getbtns() & 4)
		higscore();*/
	if(getbtns() & 4)
		show_highscore();
	quicksleep(10000);
}
void level(void){
	quicksleep(1000000);
	timer();
	display_string(0, "  Level 1");
	display_string(1, "  Level 2");
	display_string(2, "  Level 3");
	display_string(3, "  Level 4");
	display_image();
	/*while(i > 0){
		quicksleep(100000);
		quicksleep(10000);
		i--;
		display_image();
	}*/
	while (!getbtns()){
		quicksleep(1000);
		display_image();
	}
	if(getbtns() & 8)
		levelcounter = 1;
	if(getbtns() & 4)
		levelcounter= 2;
	if(getbtns() & 2)
		levelcounter = 3;
	if(getbtns() & 1)
		levelcounter = 4;
	//new_game = 1;
	quicksleep(10000);

}
void loading_screen(){
	quicksleep(1000000);
	timer();
	if(levelcounter ==1)
		display_string(1, "     level 1");
	if(levelcounter == 2)
		display_string(1, "    	level  2");
	if(levelcounter == 3)
		display_string(1, "    	level  3");
	if(levelcounter == 4)
		display_string(1, "    	level  4");
	display_string(0, "     Loading");
	display_string(2, "   	 prepare");
	display_string(3, "  	  yourself");
	//display_update();
	display_image();
	while (!getbtns()){
		quicksleep(1000);
		display_image();
	}
	quicksleep(10000);
	T2CONSET = 0x8000; //sätter på timern igen
}
void reset_game(int* lives,int* score,int* counter, int* enemy_shot_counter, int* game_over, int* new_game, int* levelcounter){//
	*lives = 3;
	*score = 0;
	*counter = 0;
	*enemy_shot_counter = 0;
	*game_over = 0;
	*levelcounter = 1;
	//*new_game = 0;
}




/* display_debug
   A function to help debugging.

   After calling display_debug,
   the two middle lines of the display show
   an address and its current contents.

   There's one parameter: the address to read and display.

   Note: When you use this function, you should comment out any
   repeated calls to display_image; display_image overwrites
   about half of the digits shown by display_debug.
*/
/*
void display_debug( volatile int * const addr )
{
  display_string( 1, "Addr" );
  display_string( 2, "Data" );
  num32asc( &textbuffer[1][6], (int) addr );
  num32asc( &textbuffer[2][6], *addr );
  display_update();
}
*/
uint8_t spi_send_recv(uint8_t data) {
	while(!(SPI2STAT & 0x08));
	SPI2BUF = data;
	while(!(SPI2STAT & 1));
	return SPI2BUF;
}

void display_init(void) {

		SYSKEY = 0xAA996655;  /* Unlock OSCCON, step 1 */
	SYSKEY = 0x556699AA;  /* Unlock OSCCON, step 2 */
	while(OSCCON & (1 << 21)); /* Wait until PBDIV ready */
	OSCCONCLR = 0x180000; /* clear PBDIV bit <0,1> */
	while(OSCCON & (1 << 21));  /* Wait until PBDIV ready */
	SYSKEY = 0x0;  /* Lock OSCCON */

	/* Set up output pins */
	AD1PCFG = 0xFFFF;
	ODCE = 0x0;
	TRISECLR = 0xFF;
	PORTE = 0x0;

	/* Output pins for display signals */
	PORTF = 0xFFFF;
	PORTG = (1 << 9);
	ODCF = 0x0;
	ODCG = 0x0;
	TRISFCLR = 0x70;
	TRISGCLR = 0x200;

	/* Set up input pins */
	TRISDSET = (1 << 8);
	TRISFSET = (1 << 1);

	/* Set up SPI as master */
	SPI2CON = 0;
	SPI2BRG = 4;
	/* SPI2STAT bit SPIROV = 0; */
	SPI2STATCLR = 0x40;
	/* SPI2CON bit CKP = 1; */
        SPI2CONSET = 0x40;
	/* SPI2CON bit MSTEN = 1; */
	SPI2CONSET = 0x20;
	/* SPI2CON bit ON = 1; */
	SPI2CONSET = 0x8000;

        DISPLAY_CHANGE_TO_COMMAND_MODE;
	quicksleep(10);
	DISPLAY_ACTIVATE_VDD;
	quicksleep(1000000);

	spi_send_recv(0xAE);
	DISPLAY_ACTIVATE_RESET;
	quicksleep(10);
	DISPLAY_DO_NOT_RESET;
	quicksleep(10);

	spi_send_recv(0x8D);
	spi_send_recv(0x14);

	spi_send_recv(0xD9);
	spi_send_recv(0xF1);

	DISPLAY_ACTIVATE_VBAT;
	quicksleep(10000000);

	spi_send_recv(0xA1);
	spi_send_recv(0xC8);

	spi_send_recv(0xDA);
	spi_send_recv(0x20);

	spi_send_recv(0xAF);

}


void display_string(int line, char *s) {
	int i;
	if(line < 0 || line >= 4)
		return;
	if(!s)
		return;

	for(i = 0; i < 16; i++)
		if(*s) {
			textbuffer[line][i] = *s;
			s++;
		} else
			textbuffer[line][i] = ' ';
}

void display_image(void) {
	int i, j, k;
	int c;
	for(i = 0; i < 4; i++) {
		DISPLAY_CHANGE_TO_COMMAND_MODE;
		spi_send_recv(0x22);
		spi_send_recv(i);

		spi_send_recv(0x0);
		spi_send_recv(0x10);

		DISPLAY_CHANGE_TO_DATA_MODE;

		for(j = 0; j < 16; j++) {
			c = textbuffer[i][j];
			if(c & 0x80)
				continue;

			for(k = 0; k < 8; k++)
				spi_send_recv(font[c*8 + k]);
		}
	}
}




void display_update(void) {
	int i, j;
	for(i = 0; i < 4; i++) {
		DISPLAY_CHANGE_TO_COMMAND_MODE;
		spi_send_recv(0x22);
		spi_send_recv(i);

		spi_send_recv(0x0);
		spi_send_recv(0x10);

		DISPLAY_CHANGE_TO_DATA_MODE;

		for(j = 0; j < 128; j++) {
			spi_send_recv(display[i*128 + j]);
		}
	}
}
