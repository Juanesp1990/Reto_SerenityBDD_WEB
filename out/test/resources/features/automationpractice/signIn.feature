Feature: Iniciar Sesión
  yo como cliente quiero poder ingresar a la opción de
  inicio de sesión para ingresar a la opción de compras
  de la empresa Automation Practice

  @LogInBad
  Scenario: Ingreso fallido
    Given el cliente se encuentra en la página inicial de automatización
    When el cliente navega hasta la opcion de inicio de sesión
    And ingresa datos que no están registrados
    Then la página deberá mostrar un mensaje de ingreso fallido

  @LogInGod
  Scenario: Ingreso exitoso
    Given el cliente se encuentra en la página principal
    When el cliente navega hasta inicio de sesión
    And selecciona registrarse, llenar su información y presiona registrarse
    Then la página deberá mostrar el nombre registrado en la parte superior de la página