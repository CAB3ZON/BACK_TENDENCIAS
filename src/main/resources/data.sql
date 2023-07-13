/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  USUARIO
 * Created: 06/07/2023
 */
INSERT INTO `persona`( `correo`, `direccion`, `identificacion`, `nombre_per`, `telefono`) VALUES ('oscarosmany@gmail.com','parque industrial','0150076537','Oscar Cabrera','0958814375');

INSERT INTO `persona`( `correo`, `direccion`, `identificacion`, `nombre_per`, `telefono`) VALUES ('kevinortiz@gmail.com','maria auxiliadora','0149675943','Kevin Ortiz','0999965745');

INSERT INTO `persona`( `correo`, `direccion`, `identificacion`, `nombre_per`, `telefono`) VALUES ('marcos@gmail.com','sayausi','0150066686','Marcos Pillco','0956647564');


INSERT INTO `rol`( `descripcion`, `estado`, `nombre`) VALUES ('Usuario Administrador que accede a lo mas intimo del sistema',1,'Administrador');

INSERT INTO `rol`( `descripcion`, `estado`, `nombre`) VALUES ('Usuario Empleador que accede a lo mas facil del sistema',2,'Empleado');



INSERT INTO `usuario` (`id_usuario`, `clave`, `username`, `id_persona`, `id_rol`) VALUES
(1, '1234', 'Oscar123', 1, 1),
(2, '1234', 'kevin123', 2, 1),
(3, '1234', 'Marcos123', 3, 2);

INSERT INTO `maquina`( `precio`, `tamano`) VALUES (4.90,'PEQUEÑA'),(6.90,'MEDIANA'),(8.90,'GRANDE');


INSERT INTO `servicio`( `descripcion`, `nombre`, `precio`) VALUES ('secado de chaqueta de cuero en seco', 'secado chaqueta de cuero',35.00),('secado de terno de 3 piezas en seco mas tintura','secado terno 3 piezas',12.00);

INSERT INTO `config_empresa` (`id_config`, `nombre_empresa`, `ruc`, `telefono`, `ubicacion`) VALUES
(1, 'Lavaflash', '0150067589001', '2803066', 'RACAR');

INSERT INTO `venta` (`id_venta`, `descuento`, `fecha`, `iva`, `subtotal`, `tipo_pago`, `total`, `id_config`, `id_persona`) VALUES
(1, 0.12, '2023-07-03 00:00:00.000000', 0.12, 17.8, 'efectivo', 20.4, 1, 1);

INSERT INTO `orden` (`id_orden`, `estado`, `total_orden`, `id_persona`, `id_venta`) VALUES
(1, 1, 17.8, 1, 1);


INSERT INTO `item`( `cantidad`, `precio_total`, `id_maq`, `id_orden`) VALUES (2, 17.80, 3, 1);

