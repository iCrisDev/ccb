/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost
 Source Database       : ciberClub

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : utf-8

 Date: 05/17/2017 10:05:05 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `compra`
-- ----------------------------

CREATE Database ciberClub;

USE ciberClub;

DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `importe` decimal(10,0) NOT NULL,
  `fecha` datetime NOT NULL,
  `id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `min15` float DEFAULT NULL,
  `min30` float DEFAULT NULL,
  `min45` float DEFAULT NULL,
  `hora` float DEFAULT NULL,
  `num_pcs` int(11) DEFAULT NULL,
  `pcs_por_fila` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `config`
-- ----------------------------
BEGIN;
INSERT INTO `config` VALUES ('3', '6', '9', '12', '6', '4');
COMMIT;

-- ----------------------------
--  Table structure for `detalle_compra`
-- ----------------------------
DROP TABLE IF EXISTS `detalle_compra`;
CREATE TABLE `detalle_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_compra` int(11) NOT NULL,
  `cod_producto` varchar(10) NOT NULL,
  `costo` decimal(10,0) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `detalle_renta_pc`
-- ----------------------------
DROP TABLE IF EXISTS `detalle_renta_pc`;
CREATE TABLE `detalle_renta_pc` (
  `id_detalle_renta_pc` int(11) NOT NULL,
  `id_pc` int(11) DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `hora_fin` time DEFAULT NULL,
  `tiempo_total` time DEFAULT NULL,
  PRIMARY KEY (`id_detalle_renta_pc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `detalle_venta`
-- ----------------------------
DROP TABLE IF EXISTS `detalle_venta`;
CREATE TABLE `detalle_venta` (
  `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT,
  `venta_id_venta` int(11) NOT NULL,
  `producto_cod_producto` varchar(10) NOT NULL,
  `producto_precio` decimal(10,0) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `detalle_venta`
-- ----------------------------
BEGIN;
INSERT INTO `detalle_venta` VALUES ('3', '0', 'EMC', '10', '1'), ('4', '0', 'GOF', '8', '1'), ('5', '0', 'LAR', '8', '3'), ('6', '0', 'EMC', '10', '1'), ('7', '0', 'EMC', '10', '1'), ('8', '0', 'ENG', '10', '1'), ('9', '0', 'EMC', '10', '1'), ('10', '0', 'GOF', '8', '1'), ('11', '0', 'EMC', '10', '1'), ('12', '0', 'ENG', '10', '1'), ('13', '0', 'EMC', '10', '1'), ('14', '0', 'ENG', '10', '1'), ('15', '0', 'IBN', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `empleado`
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `ap_paterno` varchar(20) NOT NULL,
  `ap_materno` varchar(20) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `sexo` tinyint(4) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `empleado`
-- ----------------------------
BEGIN;
INSERT INTO `empleado` VALUES ('1', 'Cristopher Alejandro', 'Campuzano', 'Flores', '2281586179', 'Campuzano', '1', '2017-04-14', null, '0', 'en su casa :v'), ('2', 'Aimme Nayeli', 'Dominguez', 'Jimenez', '12345678', 'Dominguez', '2', '2017-05-02', null, '1', 'Por donde no paso Dios'), ('3', 'Francisco', 'Sanchez', 'Morales', '12345678', 'Perez', '3', '2017-05-02', null, '0', 'Por algun lugar de su colonia'), ('4', 'Claudia Sofia', 'Campuzano', 'Flores', '12345678', 'Campuzano', '22', '2017-05-02', null, '1', 'En su casa'), ('5', 'Axel', 'Perez', 'Lopez', '12345678', 'Perez', '23', '2017-05-11', null, '0', 'en su casa :v'), ('6', 'Ernestina', 'Martinez', 'Soto', '12345678', 'ernes@gmail.com', '24', '2017-05-11', null, '0', 'en algun lugar de este jodido pais');
COMMIT;

-- ----------------------------
--  Table structure for `producto`
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `cod_producto` varchar(20) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT '1',
  `costo` decimal(10,0) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `tipo_producto` tinyint(4) DEFAULT NULL,
  `existencia` int(11) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `producto`
-- ----------------------------
BEGIN;
INSERT INTO `producto` VALUES ('EMC', 'Enmicado', '1', '0', '10', '1', '0', '2017-05-07', null), ('ENG', 'Engargolado', '1', '0', '10', '1', '0', '2017-05-04', null), ('GOF', 'Goma Factis', '1', '7', '8', '0', '3', '2017-05-04', null), ('IBN', 'Impresion b/n', '1', '0', '1', '1', '0', '2017-05-04', null), ('IC', 'Impresion a color', '1', '0', '5', '1', '0', '2017-05-04', null), ('LAR', 'Lapicero Rojo', '1', '6', '8', '0', '7', '2017-05-07', null), ('LPB', 'Lapiz BIC', '1', '5', '8', '0', '10', '2017-05-04', null), ('PM', 'Portaminas', '1', '5', '8', '0', '0', '2017-05-08', null), ('SAM', 'Sacapuntas Maped', '1', '4', '6', '0', '0', '2017-05-04', null);
COMMIT;

-- ----------------------------
--  Table structure for `usuario`
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(20) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `tipo_usuario` tinyint(4) NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `usuario`
-- ----------------------------
BEGIN;
INSERT INTO `usuario` VALUES ('1', 'cris', 'sFuFOyugbgHGcRb4sHzcdQ==', '1', '1'), ('2', 'aimee', 'Hoi9zeFU3MF3vb89rNIXbw==', '0', '1'), ('3', 'franco', '7Vk/Qs+LppK9vC4VqPncnQ==', '0', '0'), ('22', 'sofi', 'HWEuAyjHg61lBJJ9+oL8MQ==', '0', '1'), ('23', 'axel', 'ALZ8WzWl0fvmqTHkLRemEw==', '0', '1'), ('24', 'ernes', 'J+y1pupQb7h7z/qEOdzYwQ==', '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `venta`
-- ----------------------------
DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `importe` decimal(10,0) NOT NULL,
  `fecha` datetime NOT NULL,
  `empleado_id_empleado` int(11) NOT NULL,
  `tipo_venta` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `venta`
-- ----------------------------
BEGIN;
INSERT INTO `venta` VALUES ('2', '42', '2017-05-14 00:00:00', '1', '0'), ('3', '10', '2017-05-16 00:00:00', '1', '0'), ('4', '20', '2017-05-16 00:00:00', '1', '0'), ('5', '18', '2017-05-16 00:00:00', '1', '0'), ('9', '20', '2017-05-16 00:00:00', '1', '0'), ('10', '21', '2017-05-17 00:00:00', '1', '0');
COMMIT;

-- ----------------------------
--  Procedure structure for `insertUsuario`
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertUsuario`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUsuario`(IN _nombre_usuario varchar(20), IN _contrasenia varchar(20), IN _tipo_usuario tinyint, IN _estado tinyint, IN _nombre varchar(20), IN _ap_paterno varchar(20), IN _ap_materno varchar(20), IN _telefono varchar(20), IN _correro varchar(30), IN id_usuario int)
BEGIN

	INSERT INTO usuario(nombre_usuario, contrasenia, tipo_usuario, estado) VALUES (_nombre_usuario, _contrasenia, _tipo_usuario, _estado);
END
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
