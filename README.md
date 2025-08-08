🛒 Procesamiento de Pedidos con Patrón Pipeline (Java + Spring Boot)

Este repositorio está organizado para ayudarte a comprender y aplicar el patrón de diseño **Pipeline (o Chain of Responsibility)** en un proyecto Java con Spring Boot.

🔹 La carpeta `CONSIGNA` contiene la descripción del ejercicio propuesto.  
🔹 La carpeta `EJERCICIO RESUELTO` incluye la solución implementada usando Spring Boot.  
🔹 El archivo `README.md` (este archivo) explica el funcionamiento del proyecto, cómo ejecutarlo y los conceptos detrás del patrón utilizado.

Este proyecto demuestra cómo aplicar el patrón Pipeline para procesar pedidos en una API REST, validando su contenido antes de confirmarlos.

---

## 🧠 ¿Qué es el patrón Pipeline?

Es un patrón de diseño que permite procesar una secuencia de pasos (validaciones, transformaciones, etc.) de manera desacoplada y extensible.  
Cada paso en la "cadena" recibe una entrada, realiza una acción y pasa el control al siguiente.

---

## 💡 ¿Qué hace esta app?

Recibe un objeto `Pedido` vía HTTP POST y lo somete a una serie de validaciones:

1. El nombre del cliente no debe estar vacío.  
2. El pedido debe contener al menos un producto.  
3. El monto total debe ser mayor a 0.

---

## 📦 Estructura del código

- `Validador.java`: Interfaz que define un paso en el pipeline.  
- `NombreClienteValidador`, `ProductosValidador`, `MontoValidador`: Implementaciones concretas del pipeline.  
- `PipelineService`: Ejecuta la cadena de validadores.  
- `PedidoController`: Controlador REST que recibe los datos y ejecuta la lógica.

---

## ▶️ Cómo ejecutar

1. Clona el repositorio.  
2. Ejecuta con Maven:

```bash
./mvnw spring-boot:run
```

Opciones para probarlo:
🧪 Opción A: Usar curl en la terminal

```bash
curl -X POST http://localhost:8080/pedidos \
  -H "Content-Type: application/json" \
  -d '{"cliente":"Ana López", "productos":["Teclado", "Mouse"], "montoTotal":2500}'
```

🧪 Opción B: Usar Postman o Insomnia
Método: POST

```bash
URL: http://localhost:8080/pedidos
```

Body: raw JSON (application/json)

```json
{
  "cliente": "Ana López",
  "productos": ["Teclado", "Mouse"],
  "montoTotal": 2500
}
```

📚 ¿Por qué usar este patrón?
Permite agregar o quitar validaciones fácilmente.

Cada validador está desacoplado.

Mejora la mantenibilidad del código.
