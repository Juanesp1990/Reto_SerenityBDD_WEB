Feature: Contáctenos
  yo como cliente quiero poder ingresar a la opción de
  contactenos para comunicarme con el departamento de
  compras de la empresa Automation Practice

  @customerBad
  Scenario: informacion incompleta
    Given el cliente se encuentra en la página de inicio
    When el cliente navega hasta el formulario de contáctenos
    And ingresa la información incompleta y presiona el botón enviar
    Then la página debería mostrar un mensaje de error

  @customerGod
  Scenario:informacion completa
    Given el clientre se encuentra en la página inicial
    When el cliente navega hasta la opción contáctenos
    And ingresa la información completa y presiona el botón enviar
    Then la página debería indicarle la recepción del mensaje