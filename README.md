

---

## Lista de Chequeo

1. **Realiza conexiones con bases de datos utilizando JDBC** ✅
   La clase `paqueteloginserver` utiliza `DriverManager.getConnection(URL, USER, PASSWORD)` para establecer conexiones con la base de datos MySQL mediante JDBC.

2. **Aplica el CRUD** ✅
   El servlet implementa métodos para crear (`insertarUsuario`), leer (`consultarUsuario`, `listarUsuarios`), actualizar (`actualizarUsuario`) y eliminar (`eliminarUsuario`) registros en la tabla `usuarios`.

3. **Utiliza herramientas de versionamiento para el proyecto** ✅
   El proyecto está configurado para ser gestionado con Git, facilitando el control de versiones y la colaboración.

4. **Utiliza un estándar de codificación definido** ✅
   El código sigue estándares de codificación definidos:
   - **Nombramiento de variables** ✅
     Las variables se nombran de manera descriptiva, como `usuario` y `id`.
   - **Nombramiento de métodos** ✅
     Los métodos se nombran de manera clara, como `insertarUsuario`, `consultarUsuario`.
   - **Nombramiento de clases** ✅
     Las clases se nombran en CamelCase, como `paqueteloginserver`.
   - **Nombramiento de paquetes** ✅
     Los paquetes se nombran utilizando el dominio invertido, como `com.mycompany.mavenproject1.paquetelogin`.
   - **Funcionalidades de inserción, consulta, actualización y eliminación** ✅
     Implementadas mediante los métodos `insertarUsuario`, `consultarUsuario`, `actualizarUsuario` y `eliminarUsuario`.

---

