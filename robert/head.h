/* mipslab.h
   Header file for all labs.
   This file written 2015 by F Lundevall
   Some parts are original code written by Axel Isaksson

   Latest update 2015-08-28 by F Lundevall

   For copyright and licensing, see file COPYING */
#define items 32
/* Declare display-related functions from mipslabfunc.c */
void display_image(void);
void display_init(void);
void display_string(int line, char *s);
void display_update(void);
uint8_t spi_send_recv(uint8_t data);



/* Declare lab-related functions from mipslabfunc.c */

void labwork(void);
void quicksleep(int cyc);
void level(void);
void loading_screen();
void game_meny();
uint32_t alien2[5];
uint32_t ship[9];
uint8_t display[512];
int pow(int val1, int val2);
//void set_pixel(int x, int y, int set);
int pixel_on(uint8_t x, uint8_t y);

//Variabler
extern int enemy_shot_counter;
extern int game_over;
extern int levelcounter;
extern int counter;
extern int choice;
extern int game_over_counter;
extern char name[3];
extern int new_game;
extern int lives;
extern int score;
extern int enemy_counter;
int char_marker;

/* Declare display_debug
 - a function to help debugging.

   After calling display_debug,
   the two middle lines of the display show
   an address and its current contents.

   There's one parameter: the address to read and display.

   Note: When you use this function, you should comment out any
   repeated calls to display_image; display_image overwrites
   about half of the digits shown by display_debug.
*/
void display_debug( volatile int * const addr );

/* Declare bitmap array containing font */
extern const uint8_t const font[128*8];
/* Declare bitmap array containing icon */
/* Declare text buffer for display output */
extern char textbuffer[4][16];

void space_attacker( void );
void game_over_func(int x);

/* Declare functions written by students.
   Note: Since we declare these functions here,
   students must define their functions with the exact types
   specified in the laboratory instructions. */
/* Written as part of asm lab: delay, time2string */
void delay(int);
/* Written as part of i/o lab: getbtns, getsw, enable_interrupt */
//int getbtns(void);
//int getsw(void);
//void enable_interrupt(void);
//void load_game(void);
//void clear_screen(void);
void load_game2(int x);
struct alien{
	uint8_t x;
	uint8_t y;
	uint8_t height;
	uint8_t width;
	int name;
	int live;
};

struct kula{
	uint8_t x;
	uint8_t y;
	uint8_t height;
	int dir;
	int live;
	int name;
};
//variabler
int i;
struct kula kulor[items]; //ändra variabelstorlek
struct kula make_kula(int dir, int name);

//struct player play[2];//ändra till en annan variabel
struct alien make_player(uint8_t x, uint8_t y, int name);

struct alien aliens[items];//ändra storleksvariabeln
struct alien make_alien(uint8_t x, uint8_t y, int name);
//void shoot(struct aliens *play);
void move_kula(struct kula *kul);