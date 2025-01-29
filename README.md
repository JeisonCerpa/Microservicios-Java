# Proyecto de Microservicios

Este proyecto contiene dos microservicios: `tienda` y `objeto`. A continuación, se describen los pasos para configurar y ejecutar ambos microservicios, así como las pruebas.

## Prerrequisitos

- Java 21
- Maven
- MySQL (para el microservicio `objeto`)

## Configuración

### Microservicio `objeto`

1. Clona el repositorio y navega al directorio del microservicio `objeto`:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd objeto
    ```

2. Configura la base de datos MySQL:
    - Crea una base de datos llamada `objetosdb`.
    - Actualiza las credenciales de la base de datos en el archivo `application.properties`:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/objetosdb
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        ```

3. Compila y ejecuta el microservicio:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Microservicio `tienda`

1. Navega al directorio del microservicio `tienda`:
    ```bash
    cd ../tienda
    ```

2. Compila y ejecuta el microservicio:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

### Microservicio `objeto`

- **Obtener todos los objetos**: `GET /api/objetos`
- **Obtener un objeto por ID**: `GET /api/objetos/{id}`
- **Crear un nuevo objeto**: `POST /api/objetos`
- **Eliminar un objeto por ID**: `DELETE /api/objetos/{id}`

### Microservicio `tienda`

- **Obtener todos los productos**: `GET /productos`
- **Obtener un producto por ID**: `GET /productos/{id}`

## Pruebas

Para ejecutar las pruebas de ambos microservicios, utiliza el siguiente comando en sus respectivos directorios:

```bash
mvn test
```

Esto ejecutará las pruebas unitarias y de integración configuradas en el proyecto.

## Documentación de la API

Ambos microservicios utilizan Swagger para la documentación de la API. Una vez que los microservicios estén en ejecución, puedes acceder a la documentación en las siguientes URLs:

- **Microservicio `objeto`**: `http://localhost:8081/swagger-ui.html`
- **Microservicio `tienda`**: `http://localhost:8080/swagger-ui.html`

## Posibles Mejoras

1. **Autenticación y Autorización**: Implementar OAuth2 o JWT para asegurar las APIs.
2. **Despliegue en la Nube**: Configurar el despliegue en plataformas como AWS, Azure o Google Cloud.
3. **Monitoreo y Logging**: Integrar herramientas como ELK Stack (Elasticsearch, Logstash, Kibana) o Prometheus y Grafana para monitoreo y logging.
4. **Pruebas de Integración**: Añadir pruebas de integración más robustas utilizando herramientas como Testcontainers.
5. **Documentación Adicional**: Mejorar la documentación con ejemplos de uso y casos de prueba.
6. **Escalabilidad**: Implementar balanceo de carga y escalabilidad horizontal utilizando Kubernetes o Docker Swarm.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
