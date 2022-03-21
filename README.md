# Trabajo Final de Diplomado <br> Módulos : <br> AUTOMATIZACIÓN I <br> AGILE TESTING

#Realizado por: Roy Guido Salazar Herrera
#Tema: Automatización de Pruebas para portal Web de Test Psicotécnico

# Consideraciones para ejecutar los TestCase:
* Para el TestCase testStart, se dispondra varios datos de prueba para poder usar en la ejecución <br>
de las pruebas, cada dato de prueba solo funciona para una ejecución.<br>
 Ejemplo:  formTestPage.loginAs("5678888","60363"); <br>
 ruta archivo con datos de prueba: resources/DatosPrueba.xlsx <br> 
* Para el TestCase addReservationGru, actualizar la ruta del archivo con el nombre <br>
archivo.xlsx en la funcion:<br>
  createReservationGru
* Actualizar los driver de Chrome con la versión en la que esta instalado en navegador donde se va ejecutar las pruebas.
* Crearse una carpeta con el nombre de Reports en la raiz de la partición C, en caso de querer <br>
usar otra ruta actualizarla en la clase BaseTests función: setUpSuite
  
  