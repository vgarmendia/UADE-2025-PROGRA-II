# UADE-2025-PROGRA-II

Gestión de un Centro de Emergencias
Trabajo Práctico I – Algoritmos II / Programación II
UADE-2025-PROGRA-II

Integrantes del Grupo
Valentino Garmendia

Tomás Ricoy

Objetivo
Desarrollar un sistema en Java que permita gestionar la atención de pacientes en un centro de emergencias médicas. El sistema debe registrar pacientes, clasificar su nivel de urgencia, asignar médicos disponibles al paciente de mayor prioridad, atender a los pacientes y generar reportes de la eficiencia operativa. La interacción se realizará a través de la línea de comandos y la información se mantendrá en memoria durante la ejecución.

Requerimientos
Ingreso y Clasificación de Pacientes

Registrar pacientes con su nombre y nivel de urgencia (Alta, Media, Baja).

Clasificar a los pacientes según su nivel de urgencia (se puede usar un criterio distinto a String, por ejemplo, valores numéricos o enums).

Asignación de Recursos

Dar de alta nuevos médicos.

Asignar un médico disponible al paciente con mayor prioridad.

Atención de Pacientes

Atender a los pacientes en orden de prioridad, retirándolos y actualizando el estado de los recursos asignados.

Liberar el médico asignado cuando finaliza la atención de un paciente.

Registrar los pacientes atendidos para su posterior análisis.

Reportes y Análisis

Generar reportes que incluyan, por ejemplo, el número de pacientes pendientes de atención.

Estructura del Proyecto