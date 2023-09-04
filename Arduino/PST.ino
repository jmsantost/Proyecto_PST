#include <SoftwareSerial.h>

SoftwareSerial ss(10, 9); /

char entrada = 0;

//Control
int Modo = 2;  // Modo de operacion 1: Modo manual (lazo abierto)
               //                   2: Modo automatico (lazo cerrado)
               
// Parametros para analisis a lazo abierto
float Potencia_1 = 0;     // valor inicial del cambio escalon. (min = 0)
float Potencia_2 = 97;   // Valor final del cambio escalon. (max = 97|98)

// Parametros para analisis a lazo cerrado
float Setpoint = 0;       // Celsius
//Esta variable representa el valor de la temperatura objetivo que deseas mantener en el sistema cuando estás operando en modo de control a lazo cerrado.

// Constantes de PID
float Kc = 1; float Tao_I = 61.4; //Si queremos que sea mas rapido se disminuye el valor de Tao_I

int Tiempo0 = 1000;     // Retardo (en milisegundos) para ejecutar cambio escalon cuando se encuentra 
                         //a lazo abierto o cambio en el septpoint a lazo cerrado 

int A = 0;           // Pin A0 de entrada analogica para sensor LM35 (Variable de salida)
float Potencia = 0;  // Potencia inicial enviada al dimmer en rango de 0 a 100 (Variable de entrada)

//  Declaracion de variables
int pin_disparo = 3; //Pin 3
int pin_cruce_cero = 8; //Pin 8

int last_CH1_state = 0;
int detectado = 0;
int valor=0;

unsigned long Tiempo_previo = 0; 
unsigned long Tiempo_actual = 0;
int Read_Delay = 1000;     // Periodo de muestreo en milisegundos
int Temperatura = 0;       // Celsius
float sp = 0;    

// Variables para PID
float PID_error = 0;
float previous_error = 0;
float PID_value = 0;
float Error_INT = 0;

void setup() {
  ss.begin(9600);
  Serial.begin(9600);
  //Definicion de pines
  pinMode (pin_disparo,OUTPUT); 
  pinMode (pin_cruce_cero,INPUT);
  PCICR |= (1 << PCIE0);                                                     
  PCMSK0 |= (1 << PCINT0);  
}

void loop() {
  //Bluetooth
    if(ss.available()) {
      entrada = ss.read()();//Leemos el dato enviado desde la aplicacion.
  //Seleccion de temperatura a partir de iniciales
  switch(entrada){
    case 'G': //Gallina
      Setpoint = 39;
      break;
    case 'P': //Pato
      Setpoint = 37;
      break;
    case 'C': //Codorniz
      Setpoint = 38;
      break;
    case 'O': //GansO
      Setpoint = 37.7;
      break;
    default: //Comando no reconocido
      Setpoint = 0; //Se apaga el Dimmer
      break;
  }
  }
    Tiempo_actual = millis(); // Tiempo Actual    
    
    valor = map(Potencia,0,100,7600,10);
    if (detectado)
    {
      delayMicroseconds(valor);
      digitalWrite(3,HIGH);
      delayMicroseconds(100);
      digitalWrite(3,LOW);
      detectado=0;

    if(Tiempo_actual - Tiempo_previo >= Read_Delay){
       Tiempo_previo += Read_Delay;                
    
    Temperatura = 5.0*100.0*analogRead(A)/1024.0;         //Lectura del sensor LM35

    if(Modo == 1){
      // Modo manual (lazo abierto)
      if(Tiempo_actual <= Tiempo0) {
        Potencia = Potencia_1;
      }
      else if(Tiempo_actual >= Tiempo0) {
        Potencia = Potencia_2;
      } 
      
    }
    else if(Modo == 2){
    // Modo automatico (lazo cerrado)
    if(Tiempo_actual <= Tiempo0) {
       PID_value = 0;
    }
    else if (Tiempo_actual >= Tiempo0){
      PID_error = Setpoint - Temperatura;                   //Calculo del error    
      Error_INT = Error_INT + PID_error*(1000/Read_Delay);  //Calculo de la integral del error
      PID_value = Kc*(PID_error + (1/Tao_I)*Error_INT);     //Calculo de la salida del controlador PI

      sp = Setpoint;
      
    }
    // Limite de salida del controlador
    if(PID_value < 0)
    {      PID_value = 0;       }
    if(PID_value > 100)
    {      PID_value = 100;    }

    Potencia = PID_value;   //Asignacion a la entrada de la planta.
    }    
    
        Serial.print(Potencia);
        Serial.print(" ");
        Serial.print(Temperatura);
        Serial.print(" ");
        Serial.println(sp);    
    }
    
    } 
}

//This is the interruption routine
//----------------------------------------------

ISR(PCINT0_vect){
  /////////////////////////////////////               //Input from optocoupler
  if(PINB & B00000001){                               //We make an AND with the pin state register, We verify if pin 8 is HIGH???
    if(last_CH1_state == 0){                          //If the last state was 0, then we have a state change...
      detectado=1;                                    //We haev detected a state change!
    }
  }
  else if(last_CH1_state == 1){                       //If pin 8 is LOW and the last state was HIGH then we have a state change      
    detectado=1;                                      //We haev detected a state change!
    last_CH1_state = 0;                               //Store the current state into the last state for the next loop
    }
}