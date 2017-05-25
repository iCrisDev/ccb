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

 Date: 05/25/2017 11:10:22 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `compra`
-- ----------------------------
CREATE Database ciberClub;
user ciberClub;

DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `importe` decimal(10,0) NOT NULL,
  `fecha` datetime NOT NULL,
  `empleado_id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `compra`
-- ----------------------------
BEGIN;
INSERT INTO `compra` VALUES ('3', '140', '2017-05-24 13:49:31', '1'), ('4', '20', '2017-05-24 23:14:21', '1'), ('5', '35', '2017-05-24 23:14:57', '1'), ('6', '20', '2017-05-24 23:15:38', '1');
COMMIT;

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
INSERT INTO `config` VALUES ('2', '4', '6', '8', '12', '4');
COMMIT;

-- ----------------------------
--  Table structure for `detalle_compra`
-- ----------------------------
DROP TABLE IF EXISTS `detalle_compra`;
CREATE TABLE `detalle_compra` (
  `id_detalle_compra` int(11) NOT NULL AUTO_INCREMENT,
  `compra_id_compra` int(11) NOT NULL,
  `producto_cod_producto` varchar(10) NOT NULL,
  `producto_costo` decimal(10,0) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `detalle_compra`
-- ----------------------------
BEGIN;
INSERT INTO `detalle_compra` VALUES ('1', '3', 'DIX', '1', '20'), ('2', '3', 'GOF', '7', '10'), ('3', '3', 'LPB', '5', '10'), ('4', '4', 'DIX', '1', '20'), ('5', '5', 'GOF', '7', '5'), ('6', '6', 'DIX', '1', '20');
COMMIT;

-- ----------------------------
--  Table structure for `detalle_renta_pc`
-- ----------------------------
DROP TABLE IF EXISTS `detalle_renta_pc`;
CREATE TABLE `detalle_renta_pc` (
  `id_detalle_renta_pc` int(11) NOT NULL AUTO_INCREMENT,
  `id_pc` int(11) DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `hora_fin` time DEFAULT NULL,
  `tiempo_total` time DEFAULT NULL,
  `venta_id_venta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_renta_pc`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `detalle_renta_pc`
-- ----------------------------
BEGIN;
INSERT INTO `detalle_renta_pc` VALUES ('4', '1', '22:42:00', '22:42:09', '00:01:25', '3'), ('5', '2', '22:49:04', '22:49:06', '00:00:10', '5'), ('6', '2', '22:49:13', '22:49:33', '00:03:10', '6'), ('7', '1', '23:04:00', '23:04:15', '00:02:30', '7'), ('8', '1', '00:27:32', '00:27:37', '00:00:43', '9'), ('9', '7', '00:47:51', '00:48:08', '00:02:45', '10'), ('10', '1', '10:42:48', '10:42:51', '00:00:26', '11'), ('11', '2', '10:45:22', '10:45:22', '00:00:03', '12');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `detalle_venta`
-- ----------------------------
BEGIN;
INSERT INTO `detalle_venta` VALUES ('1', '1', 'DIX', '3', '1'), ('2', '1', 'IC', '6', '1'), ('3', '1', 'IC', '5', '2'), ('4', '1', 'IBN', '2', '2'), ('5', '1', 'IBN', '1', '5'), ('6', '1', 'EMC', '10', '1'), ('7', '2', 'DIX', '3', '1'), ('8', '2', 'IBN', '1', '1'), ('9', '2', 'IC', '8', '1'), ('10', '4', 'IBN', '1', '2'), ('11', '4', 'IC', '5', '1'), ('12', '7', 'DIX', '3', '1'), ('13', '7', 'IBN', '1', '5'), ('14', '7', 'IC', '5', '1'), ('15', '8', 'DIX', '3', '2'), ('16', '8', 'GOF', '8', '1'), ('17', '8', 'LPB', '8', '3');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `empleado`
-- ----------------------------
BEGIN;
INSERT INTO `empleado` VALUES ('1', 'Cristopher Alejandro', 'Campuzano', 'Flores', '2281617932', 'Campuzano', '1', '2017-05-19', null, '0', 'En mi casa');
COMMIT;

-- ----------------------------
--  Table structure for `producto`
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `cod_producto` varchar(10) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT '1',
  `costo` decimal(10,2) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `tipo_producto` tinyint(4) DEFAULT NULL,
  `existencia` int(11) DEFAULT '0',
  `fecha_alta` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `producto`
-- ----------------------------
BEGIN;
INSERT INTO `producto` VALUES ('DIX', 'Diurex', '1', '1.00', '3.00', '0', '18', '2017-05-20', null), ('EMC', 'Enmicado', '1', '0.00', '10.00', '1', '0', '2017-05-07', null), ('ENG', 'Engargolado', '1', '0.00', '10.00', '1', '0', '2017-05-04', null), ('GOF', 'Goma Factis', '1', '7.00', '8.00', '0', '17', '2017-05-04', null), ('IBN', 'Impresion b/n', '1', '0.00', '1.00', '1', '0', '2017-05-04', null), ('IC', 'Impresion a color', '1', '0.00', '5.00', '1', '0', '2017-05-04', null), ('LAA', 'Lapicero Azul', '1', '5.00', '7.00', '0', '0', '2017-05-20', null), ('LAR', 'Lapicero Rojo', '1', '6.00', '8.00', '0', '7', '2017-05-07', null), ('LPB', 'Lapiz BIC', '1', '5.00', '8.00', '0', '17', '2017-05-04', null), ('PM', 'Portaminas', '1', '5.00', '8.00', '0', '0', '2017-05-08', null), ('SAM', 'Sacapuntas Mapedd', '1', '5.00', '7.50', '0', '0', '2017-05-04', null);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `usuario`
-- ----------------------------
BEGIN;
INSERT INTO `usuario` VALUES ('1', 'admin', 'sFuFOyugbgHGcRb4sHzcdQ==', '1', '1');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `venta`
-- ----------------------------
BEGIN;
INSERT INTO `venta` VALUES ('1', '38', '2017-05-21 00:00:00', '1', '0'), ('2', '12', '2017-05-21 00:00:00', '1', '0'), ('3', '3', '2017-05-22 00:00:00', '1', '1'), ('4', '7', '2017-05-22 00:00:00', '1', '0'), ('5', '3', '2017-05-22 00:00:00', '1', '1'), ('6', '3', '2017-05-22 00:00:00', '1', '1'), ('7', '16', '2017-05-22 00:00:00', '1', '2'), ('8', '38', '2017-05-24 23:16:26', '1', '0'), ('9', '2', '2017-05-25 00:32:17', '1', '1'), ('10', '2', '2017-05-25 00:48:16', '1', '1'), ('11', '2', '2017-05-25 10:45:43', '1', '1'), ('12', '2', '2017-05-25 10:45:47', '1', '1');
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
