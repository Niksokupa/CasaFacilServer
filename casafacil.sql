-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 10-02-2019 a las 16:13:09
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `casafacil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncio`
--

CREATE TABLE `anuncio` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `habitaciones` int(11) DEFAULT NULL,
  `banyos` int(11) DEFAULT NULL,
  `metroscasa` int(11) DEFAULT NULL,
  `metrosterreno` int(11) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fechacreacion` datetime DEFAULT NULL,
  `fechaupdate` datetime DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `descripcion` mediumtext,
  `id_usuario` int(11) NOT NULL,
  `id_tipoinmueble` int(11) NOT NULL,
  `id_tipovia` int(11) NOT NULL,
  `id_barrio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `anuncio`
--

INSERT INTO `anuncio` (`id`, `titulo`, `habitaciones`, `banyos`, `metroscasa`, `metrosterreno`, `direccion`, `fechacreacion`, `fechaupdate`, `precio`, `descripcion`, `id_usuario`, `id_tipoinmueble`, `id_tipovia`, `id_barrio`) VALUES
(2, 'Increible piso en el Cabanyal', 3, 1, 110, NULL, 'reina 84', '2019-01-02 00:00:00', '2019-01-02 00:00:00', 150000, 'Piso en Valencia zona CABAÑAL, 131 m. de superficie, 30 m2 de salon, una habitación doble y 2 habitaciones sencillas, 2 baños, propiedad reformada, cocina equipada, carpinteria interior de madera, orientación suroeste, suelo de laminado, carpintería exterior de climalit.\r\nExtras: agua, armarios empotrados, ascensor, gas ciudad , luminoso, luz, patio, supermercados, t.v., trastero, videoportero, zona bien comunicada, zona comercial, zona de ocio, zona peatonal.\r\ncerca a esta propiedad tienes, autobuses, céntrico, centros comerciales, centros médicos, colegios, hospitales, parques, supermercados, zona de paso, zonas infantiles\r\nGastos de comunidad: 125 Eur. (€/trimestre)\r\n', 1, 1, 1, 1),
(3, 'anuncio13', 2, 2, 90, NULL, 'reina 84', '2019-01-02 00:00:00', '2019-01-02 00:00:00', 70, 'noseloco', 1, 1, 1, 1),
(4, 'castellon', 2, 2, 90, NULL, 'reina 84', '2019-01-02 00:00:00', '2019-01-02 00:00:00', 70, 'noseloco', 1, 1, 1, 2),
(14, 'titulo1', 2, 2, 121, 343, 'nombrevia', '2019-02-03 00:00:00', '2019-02-05 00:00:00', 2323232, 'asdasdasd', 3, 3, 2, 2),
(15, 'frfrfr', 2, 2, 121, NULL, 'sdasdasd', '2019-02-03 00:00:00', '2019-02-03 00:00:00', 222221, 'frfhthyjuef', 3, 4, 2, 1),
(16, 'yuyuyuy', 5, 3, 433, NULL, 'sfsdfsdf', '2019-02-03 00:00:00', '2019-02-03 00:00:00', 567664, 'sadasdasd', 3, 1, 4, 3),
(17, 'yjtyjtyj', 4, 4, 222, NULL, 'fgjyjyj', '2019-02-03 00:00:00', '2019-02-03 00:00:00', 666666, 'asdasdasd', 3, 1, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barrio`
--

CREATE TABLE `barrio` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `codpostal` int(11) DEFAULT NULL,
  `id_ciudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `barrio`
--

INSERT INTO `barrio` (`id`, `desc`, `codpostal`, `id_ciudad`) VALUES
(1, 'Cabanyal', 46011, 2),
(2, 'El Lledò', 12003, 3),
(3, 'Malva-Rosa', 46011, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id`, `desc`) VALUES
(1, 'Alicante'),
(2, 'Valencia'),
(3, 'Castellón');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extras`
--

CREATE TABLE `extras` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `extras`
--

INSERT INTO `extras` (`id`, `desc`) VALUES
(1, 'Trastero'),
(2, 'Parking'),
(3, 'Terraza'),
(4, 'Calefaccion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extras_anuncio`
--

CREATE TABLE `extras_anuncio` (
  `id_anuncio` int(11) NOT NULL,
  `id_extras` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `extras_anuncio`
--

INSERT INTO `extras_anuncio` (`id_anuncio`, `id_extras`) VALUES
(17, 1),
(2, 2),
(3, 2),
(4, 2),
(14, 2),
(17, 2),
(3, 3),
(4, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorito`
--

CREATE TABLE `favorito` (
  `id_usuario` int(11) NOT NULL,
  `id_anuncio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `favorito`
--

INSERT INTO `favorito` (`id_usuario`, `id_anuncio`) VALUES
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotos`
--

CREATE TABLE `fotos` (
  `id` int(11) NOT NULL,
  `ruta` varchar(255) DEFAULT NULL,
  `id_anuncio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `fotos`
--

INSERT INTO `fotos` (`id`, `ruta`, `id_anuncio`) VALUES
(1, 'asd1.png', 2),
(2, 'asd2.png', 2),
(3, 'asd81.png', 3),
(4, 'asd22.png', 3),
(5, 'asd81.png', 4),
(6, 'asd22.png', 4),
(8, 'Selección_009.png', 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoinmueble`
--

CREATE TABLE `tipoinmueble` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipoinmueble`
--

INSERT INTO `tipoinmueble` (`id`, `desc`) VALUES
(1, 'Piso'),
(2, 'Casa'),
(3, 'Chalet'),
(4, 'Ático');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE `tipousuario` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`id`, `desc`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipovia`
--

CREATE TABLE `tipovia` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipovia`
--

INSERT INTO `tipovia` (`id`, `desc`) VALUES
(1, 'Calle'),
(2, 'Avenida'),
(3, 'Plaza'),
(4, 'Camino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_tipousuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nickname`, `nombre`, `apellido1`, `apellido2`, `correo`, `telefono`, `password`, `id_tipousuario`) VALUES
(1, 'admin', 'nombre', 'ape1', 'ape2', 'correo@correo.es', 657465213, 'admin', 1),
(2, 'adminsha', 'adminsha', 'adminsha', 'adminsha', 'adminsha@adminsha.com', 675645436, '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1),
(3, 'clientesha', 'cliente', 'cliente', 'cliente', 'cliente@cliente.es', 647653423, 'a60b85d409a01d46023f90741e01b79543a3cb1ba048eaefbe5d7a63638043bf', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anuncio`
--
ALTER TABLE `anuncio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_anuncio_usuario1_idx` (`id_usuario`),
  ADD KEY `fk_anuncio_tipoinmueble1_idx` (`id_tipoinmueble`),
  ADD KEY `fk_anuncio_tipovia1_idx` (`id_tipovia`),
  ADD KEY `fk_anuncio_barrio1_idx` (`id_barrio`);

--
-- Indices de la tabla `barrio`
--
ALTER TABLE `barrio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_barrio_ciudad1_idx` (`id_ciudad`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `extras`
--
ALTER TABLE `extras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `extras_anuncio`
--
ALTER TABLE `extras_anuncio`
  ADD PRIMARY KEY (`id_anuncio`,`id_extras`),
  ADD KEY `fk_Anuncio_has_Extras_Extras1_idx` (`id_extras`),
  ADD KEY `fk_Anuncio_has_Extras_Anuncio_idx` (`id_anuncio`);

--
-- Indices de la tabla `favorito`
--
ALTER TABLE `favorito`
  ADD PRIMARY KEY (`id_usuario`,`id_anuncio`),
  ADD KEY `fk_usuario_has_anuncio_anuncio1_idx` (`id_anuncio`),
  ADD KEY `fk_usuario_has_anuncio_usuario1_idx` (`id_usuario`);

--
-- Indices de la tabla `fotos`
--
ALTER TABLE `fotos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_fotos_anuncio1_idx` (`id_anuncio`);

--
-- Indices de la tabla `tipoinmueble`
--
ALTER TABLE `tipoinmueble`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipovia`
--
ALTER TABLE `tipovia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario_tipousuario1_idx` (`id_tipousuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anuncio`
--
ALTER TABLE `anuncio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `barrio`
--
ALTER TABLE `barrio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `extras`
--
ALTER TABLE `extras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `fotos`
--
ALTER TABLE `fotos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tipoinmueble`
--
ALTER TABLE `tipoinmueble`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipovia`
--
ALTER TABLE `tipovia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anuncio`
--
ALTER TABLE `anuncio`
  ADD CONSTRAINT `fk_anuncio_barrio1` FOREIGN KEY (`id_barrio`) REFERENCES `barrio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_anuncio_tipoinmueble1` FOREIGN KEY (`id_tipoinmueble`) REFERENCES `tipoinmueble` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_anuncio_tipovia1` FOREIGN KEY (`id_tipovia`) REFERENCES `tipovia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_anuncio_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `barrio`
--
ALTER TABLE `barrio`
  ADD CONSTRAINT `fk_barrio_ciudad1` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `extras_anuncio`
--
ALTER TABLE `extras_anuncio`
  ADD CONSTRAINT `fk_Anuncio_has_Extras_Anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Anuncio_has_Extras_Extras1` FOREIGN KEY (`id_extras`) REFERENCES `extras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `favorito`
--
ALTER TABLE `favorito`
  ADD CONSTRAINT `fk_usuario_has_anuncio_anuncio1` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_has_anuncio_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `fotos`
--
ALTER TABLE `fotos`
  ADD CONSTRAINT `fk_fotos_anuncio1` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipousuario1` FOREIGN KEY (`id_tipousuario`) REFERENCES `tipousuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
