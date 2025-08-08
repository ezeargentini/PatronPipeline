📚 ¿Por qué usar este patrón?
Permite agregar o quitar validaciones fácilmente.

Cada validador está desacoplado.

Mejora la mantenibilidad del código.

---

# ✅ Consigna: Procesamiento de Pedidos con el Patrón Pipeline (Java + Spring Boot)

## 🎯 Objetivo

Implementar una API REST utilizando **Spring Boot** que reciba información de pedidos y aplique una serie de validaciones utilizando el **patrón de diseño Pipeline (Chain of Responsibility)**.

---

## 🧠 ¿Qué es el Patrón Pipeline?

Este patrón permite encadenar una serie de pasos (validaciones, transformaciones, etc.) que se ejecutan uno tras otro.  
Cada paso decide si continuar la ejecución o detener el flujo.  
Es ideal para desacoplar reglas de negocio y mejorar la extensibilidad del código.

---

## 🧪 Requisitos funcionales

Tu aplicación debe exponer un **endpoint POST** que reciba un objeto `Pedido` con los siguientes campos:

{
  "cliente": "string",
  "productos": ["string"],
  "montoTotal": number
}

Y validar lo siguiente:

✅ El nombre del cliente no debe estar vacío ni contener solo espacios.
✅ El pedido debe contener al menos 1 producto.
✅ El monto total debe ser mayor a 0.

🏗 Estructura del proyecto
├── src/
│   ├── main/
│   │   ├── java/com/example/pipeline_pedidos/
│   │   │   ├── controller/PedidoController.java
│   │   │   ├── model/Pedido.java
│   │   │   ├── pipeline/
│   │   │   │   ├── Validador.java
│   │   │   │   ├── NombreClienteValidador.java
│   │   │   │   ├── ProductosValidador.java
│   │   │   │   ├── MontoValidador.java
│   │   │   │   └── PipelineService.java
│   │   │   └── PipelinePedidosApplication.java
├── pom.xml
└── README.md
🛠️ Requisitos técnicos
Usar Java 17+.

Usar Spring Boot.

Aplicar el patrón Pipeline para implementar las validaciones.

Cada validación debe ser una clase independiente que implemente una interfaz común.

Las validaciones deben ejecutarse en orden, y si alguna falla, detener el flujo y devolver un mensaje de error apropiado.

📤 Endpoint esperado
POST /pedidos

Content-Type: application/json

Body:

{
  "cliente": "Ana López",
  "productos": ["Teclado", "Mouse"],
  "montoTotal": 2500
}
Respuesta esperada (200 OK):

{
  "mensaje": "Pedido validado correctamente"
}
Si alguna validación falla (Ej: montoTotal <= 0), debe responder con 400 Bad Request y un mensaje como:

{
  "error": "El monto total debe ser mayor a 0"
}
🧩 Extra (opcional)
Agregar validaciones como límite máximo de productos o monto máximo permitido.

Escribir tests unitarios para los validadores.

¡Buena suerte! 🚀
