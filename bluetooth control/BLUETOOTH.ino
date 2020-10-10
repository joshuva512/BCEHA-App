#include <SoftwareSerial.h>
SoftwareSerial Blue(2, 3);
long int data;
 
int LED1 = 13;
int LED2 = 12;
int LED3 = 11;
long int password1 = 10;
long int password2 = 20; 
long int password3 = 30;
long int password4 = 40;
long int password5 = 50;
long int password6 = 60;
char state = 0;
 
 
void setup()
{
   
pinMode(LED1, OUTPUT); 
pinMode(LED2,OUTPUT);
pinMode(LED3,OUTPUT);
Serial.begin(9600);
Blue.begin(9600);
 
}
 
void loop()
{
 
  while(Blue.available()==0) ;
 
 if(Blue.available()>0) 
{
data = Blue.parseInt();
 
} 
delay(1);
//Serial.print(data);
 
if (data == password1)
{
  
  digitalWrite(LED1,HIGH);
  
  
   }
   
   if( data == password2)
   {
       digitalWrite(LED1,LOW);
  
   }
   if (data == password3)
{
  
  digitalWrite(LED2,HIGH);
  
  
   }
   if (data == password4)
{
  
  digitalWrite(LED2,LOW);
 
  
   }

   if (data == password5)
{
  
  digitalWrite(LED3,HIGH);
 
  
   }
   if (data == password6)
{
  
  digitalWrite(LED3,LOW);
 
  
   }
 
 }
