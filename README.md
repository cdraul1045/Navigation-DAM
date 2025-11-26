Para reflejar los casos de prueba de Teslink, los nuevos tests automatizados de backend (RestAssured, WebTestClient, Mockito, DataJpaTest), el análisis SonarQube, las pruebas Katalon y el despliegue en Tomcat sin inventar datos, actualiza estas secciones concretas de `Informe_Plan_Pruebas_Final.md`:

1. **Sección 4. Resultados de pruebas unitarias**  
   - Amplía el apartado 4.1 para mencionar los módulos cubiertos por `ProgramaEstudioServiceTest` y `ProgramaEstudioControllerTest` (Mockito/JUnit), incluyendo el uso de `CustomResponse` y validaciones de negocio.
   - En 4.2 (casos fallidos) añade, si aplica, referencias a incidentes hallados en esas suites.  
   - Aquí también debes indicar que los casos planificados/ejecutados en Teslink para nivel unitario se documentan en la matriz del Apéndice 9.1.

2. **Sección 5. Resultados de pruebas de integración**  
   - En 5.1 (estrategia), añade el detalle de las suites `ProgramaEstudioControllerIntegrateTest` (RestAssured) y `ProgramaEstudioControllerWebTestClientTest`, especificando que validan el controller expuesto en Spring Boot con tokens JWT reales.  
   - En 5.2 agrega una tabla/cita puntual para `/programas` (POST/GET/PUT/DELETE, `/programas/buscarmaxid`) indicando que se ejecutaron con RestAssured y WebTestClient.  
   - Vincula estos escenarios con los “casos Teslink de integración”, indicando que los identificadores se listan en el Apéndice 9.1.

3. **Sección 6. Resultados de pruebas de sistema**  
   - En 6.1 o 6.2 incorpora la ejecución de los flujos end-to-end automatizados en **Katalon** (por ejemplo: login, creación de programa, registro de asistencia) y referencia que su evidencia reside en el repositorio de casos (Teslink/Katalon).  
   - Si Teslink gestiona casos de sistema, acláralo aquí y remite nuevamente al Apéndice 9.1.

4. **Sección 7. Resultados de pruebas no funcionales**  
   - 7.1 (rendimiento): ya describe JMeter, no cambia.  
   - **7.2 (seguridad)**: menciona los hallazgos de **SonarQube** (sin vulnerabilidades críticas, cabecera pendiente) y el umbral de calidad usado.  
   - **7.4 (usabilidad y escalabilidad)**: añade que el despliegue continuo en **Tomcat** (CD) fue validado tras las suites automatizadas, indicando el entorno (Tomcat + MySQL) como parte de la verificaciones de escalabilidad.

5. **Sección 8. Resumen ejecutivo**  
   - Actualiza la tabla de estadísticas para reflejar los nuevos casos (unidad/integración/sistema) si el conteo cambió al incluir los tests de ProgramaEstudio.  
   - En 8.2 agrega un párrafo corto diciendo que la revisión SonarQube y la pipeline de CD (Tomcat) cumplieron los criterios de aceptación.

6. **Sección 9. Apéndices**  
   - En **9.1 Matriz de trazabilidad RF vs CP** indica explícitamente que los identificadores de Teslink se listan allí (por ejemplo, “CP-PRG-01 (Teslink)”).  
   - Si Teslink exporta un reporte, menciónalo en 9.2 (Logs) o 9.3 (Capturas) como archivo pendiente de adjuntar.

7. **Sección 10. Anexo**  
   - No hace falta mover nada, pero puedes anotar en 10.2 que las capturas futuras deben mostrar también los escenarios automatizados (Katalon/Tomcat) cuando se agreguen.

Siguiendo estos puntos, el informe seguirá respetando la estructura del docente, documentará exactamente los activos reales del proyecto y quedará claro dónde encaja cada tipo de prueba (Teslink incluidos).
