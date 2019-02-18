-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 18-02-2019 a las 03:07:01
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
(22, 'Lorem ipsum dolor sit amet', 2, 1, 80, 55, 'consectetur adipiscing', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 100000, 'Vivamus in euismod justo. Mauris vestibulum tristique augue et sodales. Suspendisse et mollis nulla. Aliquam pellentesque congue malesuada. Maecenas porttitor dignissim diam, sit amet blandit risus. Morbi facilisis est vitae sem vehicula, sed faucibus lacus consectetur. Sed viverra semper luctus. Etiam ac convallis augue. Mauris a justo sed leo varius tristique. Etiam vestibulum et urna id faucibus. Morbi ultrices, augue sit amet tincidunt aliquam, arcu elit porttitor tortor, nec semper sapien nunc eu turpis.', 5, 3, 1, 1),
(23, 'Maravilloso apartamento en segunda linea de playa', 3, 2, 115, 0, 'Malva-Rosa', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 125000, 'Probablemente una de las mejores casas en primera línea de la playa de Valencia, recientemente construida y decorada con las tendencias actuales. Tiene detalles sorprendentes como ascensor, piscina, calefacción por suelo radiante, cuatro dormitorios con baño incorporado, etc. Desde las habitaciones superiores se ve perfectamente el mar al ser un primera línea. La casa tiene dos grandes terrazas en planta baja, una a la entrada y otra mucho más grande en la parte trasera donde se ubica la piscina, en la primera planta se situan los dormitorios con los baños y en la parte de arriba está la buhardilla, aprovechando la cubierta inclinada. La terraza de entrada es una delicia donde se disfruta de la brisa marina, especialmente en las tardes primaverales y veraniegas.', 4, 1, 2, 3),
(24, 'Piso en el mismo Centro reformado, y una terraza para disfrutar. en Castellón de la Plana', 2, 1, 86, NULL, 'Padre Jofre', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 50000, 'VIVE EN UN PISO EN PLANTA BAJA totalmente REFORMADO y amueblado en el centro de Castellón con 86 m2 de superficie. Distribuido en 2 habitaciones dobles, un baño con ducha, cocina equipada con office, puertas interiores en lacadas en blanco, suelo de gres porcelánico, carpintería exterior de aluminio / climalit. Además podrás disfrutar de su TERRAZA PRIVATIVA en la azotea con trastero incluido.', 6, 1, 3, 2),
(27, 'Piso en avenida doctor ramon y cajal primera línea de mar en Alicante', 5, 4, 256, NULL, 'Doctor Ramon Y Cajal, 11', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 625000, 'MAJESTUOSA PROPIEDAD EN RAMÓN Y CAJAL\nEsta magnífica propiedad se encuentra situada en la mejor zona de Alicante, en la primera línea de Ramón y Cajal y en una de las mejores fincas de la zona centro de Alicante. \nLa propiedad cuenta con 254 metros cuadrados construidos, distribuidos en un majestuoso salón con orientación sur y con gran luminosidad. Cocina comunicada con el salón con su galería y lavandería. \nLa zona de noche consta de 5 habitaciones y 4 baños, uno de ellos en suite con vestidor en la habitación principal, de gran tamaño con jacuzzi. \nLa propiedad cuenta con paredes lisas, suelos de parqué de madera de roble, puertas lacadas en blanco. La propiedad está climatizada con aire acondicionado frio y calor por conductos, además de radiadores cerámicos. \nLa propiedad dispone de una plaza de garaje con capacidad para dos coches, uno de gran tamaño y otro pequeño y dos trasteros lo que la convierte en una gran propiedad y muy práctica para todos los públicos.', 9, 1, 2, 5),
(28, 'Piso preciosa vivienda en venta con licencia de alquiler turistico!!', 3, 1, 87, 0, 'Lorem 21', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 130000, 'Integer aliquam tempus justo sit amet vehicula. Vivamus id augue nunc. Fusce vitae ex blandit, efficitur augue id, pulvinar neque. Aliquam eleifend dolor pharetra leo varius, nec iaculis libero euismod. Donec lorem ipsum, congue id nisi nec, dictum ornare enim. Sed feugiat elit vel sapien elementum porttitor elementum et nisi. Vivamus mattis turpis id urna consequat, eget lacinia erat finibus.\n\nDonec non justo ac purus egestas sagittis. Vivamus eu velit volutpat, elementum turpis quis, molestie nunc. Aliquam erat volutpat. Aenean sed diam facilisis, pellentesque quam et, dapibus ligula. Integer gravida risus turpis, eget sodales ligula fermentum nec. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper arcu dignissim nibh cursus, eget malesuada augue aliquet. Duis sagittis ante ut sapien consectetur, vitae posuere ex interdum. Morbi bibendum enim ac lectus tincidunt, quis finibus lacus maximus.', 3, 4, 1, 4),
(29, 'Sed quis consequat sem. Mauris id est eleifend, aliquet turpis ut', 2, 1, 58, NULL, 'sollicitudin tincidunt', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 55000, 'Suspendisse potenti. Quisque vitae gravida est. Quisque id lobortis justo, sit amet rhoncus diam. Aliquam sagittis metus eu massa porttitor, sed feugiat quam tincidunt. Curabitur id lorem massa. Integer in leo varius, aliquam magna nec, interdum augue. Maecenas id finibus nunc. Sed hendrerit luctus eros, eget aliquam tellus luctus at. Integer volutpat ante dolor, in accumsan lorem facilisis finibus. Vivamus scelerisque iaculis nisi, vitae fringilla neque volutpat at. Phasellus et nisl non nunc tincidunt lobortis. Ut gravida massa purus, in laoreet justo porta eu. Suspendisse potenti. Pellentesque eu pellentesque nibh, eget imperdiet sem. Proin placerat eros ligula, vel molestie augue viverra sodales. Curabitur malesuada tincidunt metus non maximus.\n\nPraesent interdum ultrices enim sed gravida. Suspendisse auctor rhoncus est, sit amet accumsan massa malesuada ut. Curabitur tristique mi enim, eget consectetur velit pretium pretium. Ut vitae consectetur mauris, sed semper tortor. Nulla fa', 3, 1, 4, 4),
(30, 'Vivamus nisi lectus, cursus sed tristique in, feugiat non elit.', 2, 1, 65, NULL, 'Locoman', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 69000, 'usce ornare laoreet nunc in vulputate. Sed vel efficitur metus. Donec ullamcorper urna non urna porttitor consectetur. Praesent mi libero, molestie nec nunc non, placerat maximus felis. Vestibulum laoreet nisl et laoreet luctus. Vestibulum ut tempor augue. Sed ut tortor tellus. Etiam ligula sapien, blandit fringilla rhoncus eget, eleifend sed nunc.\n\nDonec rhoncus tincidunt orci imperdiet ornare. Sed ut metus nec ex sollicitudin aliquam. Maecenas sit amet massa a nibh placerat tincidunt at vel odio. Cras at leo elit. Praesent a volutpat lectus. Vestibulum vel tincidunt nunc, in interdum neque. Nunc rhoncus dui nec sollicitudin molestie. Vivamus ornare elit ac est iaculis fermentum. Sed vel nisi sed neque lacinia dapibus. Donec feugiat tortor felis, sed blandit neque pellentesque ut. Etiam eu pulvinar nibh. Mauris at dui eros. In hac habitasse platea dictumst. Quisque vehicula ipsum ante, ut tincidunt ante rutrum id. Nunc egestas suscipit purus, id lobortis lectus volutpat sit amet.', 3, 2, 3, 3),
(31, 'Nullam sollicitudin tristique sem, sed congue odio facilisis eu.', 3, 2, 110, NULL, 'Doctor Lluch, 19', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 77000, 'Suspendisse potenti. Sed consectetur purus eu sapien sollicitudin, id tempus nisi ultrices. Vestibulum scelerisque ut tortor vitae ornare. Etiam in ultrices eros. In vestibulum aliquet urna, quis finibus sapien luctus in. Quisque vulputate condimentum metus, rutrum dictum ex suscipit id. Phasellus ac suscipit neque. Mauris condimentum convallis eros, sed aliquet elit.\n\nPellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque ultricies dapibus lacus, iaculis sodales sem elementum vel. Suspendisse ex quam, vestibulum et lorem ut, mattis bibendum sem. Ut eget ligula a massa cursus elementum at porta magna. Quisque at rhoncus risus, vel ultrices metus. Integer sodales, augue et lobortis volutpat, lorem arcu imperdiet enim, et blandit nunc ipsum sollicitudin libero. Phasellus ultrices ligula risus. Suspendisse potenti. Morbi dictum suscipit ante in commodo. Cras congue ante et blandit tincidunt. Mauris id odio quam.', 3, 1, 1, 1),
(32, 'Nunc vitae dui eget ligula gravida volutpat.', 3, 3, 91, NULL, 'Paquito', '2019-02-17 00:00:00', '2019-02-17 00:00:00', 81250, 'Morbi mollis turpis scelerisque, vehicula nisi et, dapibus tellus. In ex elit, pretium ut risus tincidunt, pharetra iaculis lacus. Donec sit amet vestibulum purus. Curabitur semper rutrum velit, quis egestas ante ullamcorper tristique. Nunc pharetra pharetra nunc at semper. Vivamus eu laoreet diam, nec imperdiet justo. Maecenas consectetur arcu quis enim tempus, a dapibus sapien auctor. Praesent non odio libero. Nunc cursus dictum nunc sed venenatis.\n\nInteger porttitor aliquam metus at blandit. Integer sed placerat velit. Quisque sed posuere felis. Suspendisse efficitur, felis at vestibulum placerat, libero enim laoreet ex, a porttitor ex ipsum sed felis. In porta faucibus commodo. Integer id ullamcorper erat, eu auctor purus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas nunc quam, posuere et tempor eget, maximus in mauris. Suspendisse potenti. Praesent bibendum viverra sem. Suspendisse pellentesque tortor in nulla dapibus, et imperdiet orci dignissim.', 3, 2, 3, 1),
(33, 'Vivamus cursus leo vel nibh placerat aliquet.', 3, 1, 90, NULL, 'Antonio Ponz', '2019-02-18 00:00:00', '2019-02-18 00:00:00', 99000, 'Phasellus facilisis, eros vel aliquam feugiat, erat erat rutrum ante, nec bibendum tortor orci accumsan ex. Curabitur fringilla suscipit neque eu laoreet. Donec quis risus id mauris viverra posuere. Morbi fermentum ante ac massa placerat, eget luctus justo tempor. Curabitur elit odio, commodo at nisi ac, maximus convallis velit. Nam nulla eros, tempor ac tempor sed, lobortis sit amet arcu. Donec eros mi, efficitur ultricies nibh eu, tempor ullamcorper quam. Nullam orci purus, accumsan non felis ut, tempor tincidunt nisi. Donec fermentum leo et blandit pellentesque. Maecenas non ipsum faucibus, cursus turpis aliquet, tempor mauris. Donec bibendum porta arcu.\n\nSuspendisse eu ultricies urna, vel posuere erat. Nam sit amet lorem erat. Fusce fringilla volutpat sapien, a semper diam tincidunt quis. Nam id ante sit amet dolor pretium tincidunt vel at leo. Vivamus mollis egestas laoreet. Sed nec mollis eros. Duis aliquam imperdiet ultrices. Suspendisse facilisis dui ipsum, eget lobortis neque', 3, 1, 1, 3);

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
(3, 'Malva-Rosa', 46011, 2),
(4, 'Campanar', 46015, 2),
(5, 'Altozano', 3010, 1);

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
(22, 1),
(24, 1),
(27, 1),
(30, 1),
(31, 1),
(32, 1),
(27, 2),
(31, 2),
(24, 3),
(27, 3),
(30, 3),
(31, 3),
(32, 3),
(33, 3),
(22, 4),
(23, 4),
(28, 4),
(31, 4);

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
(3, 29),
(3, 33);

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
(9, 'depositphotos_40307165-stock-photo-bright-hallway-with-built-in.jpg', 22),
(10, '152216748.jpg', 22),
(11, '5aa2f203bd572.jpeg', 22),
(12, 'se-alquila-piso-con-vistas-al-mar-en-la-malvarrosa-alquiler-valencia_9869-img2226161-49835G.jpg', 23),
(13, 'IMG_20150714_103840_opt-1.jpg', 23),
(14, 'febd918b_z.jpg', 23),
(15, 'qNzKYKjyAkj.jpg', 24),
(16, 'piso-en-venta-en-castellon-de-la-plana-de-79-m2-castellon_de_la_plana_9583-img3175414-545299G.jpg', 24),
(17, 'cocina-piso-castellon_de_la_plana_500-img2753879-9548943XL.jpg', 24),
(18, '969003455.jpg', 24),
(19, '159750682.jpg', 24),
(20, 'venta-piso-con-gran-terraza-y-vistas-al-mar-en-Sitges-Inmoven-Properties-Sitges-2.jpg', 27),
(21, 'urban-bathroom-design.jpeg', 27),
(22, 'Rotpunkt-Kuechen-Cocina-de-diseno-sin-tirador-Luxio.jpg', 27),
(23, 'obra-nueva-alicante-azara-black-friday01.jpg', 27),
(24, 'despacho-principal-mamparas-piso-alicante_10389-img2104042-7898131XL.jpg', 27),
(25, '97355347.jpg', 27),
(26, '601361762.jpg', 28),
(27, '201665706.jpg', 28),
(28, '3322147_813995072_3322147_0.jpg', 28),
(29, '-631149710.jpg', 28),
(30, 'no-pongas-tabiques-en-la-reforma-de-un-piso-pequeño-.jpg', 29),
(31, 'planta-baja-en-valencia-552444-7.jpg', 30),
(32, '580845323.jpg', 30),
(33, '61525489_2500989_foto_897758.jpg', 30),
(34, 'casa-valencia-cabanyal-salon-hacia-calle_c7a1b455_1500x930.jpg', 31),
(35, '143550341.jpg', 31),
(36, '61525489_2371240_foto_397702.jpg', 31),
(37, '500328_87598269875_10_20180929123102551.jpg', 31),
(38, 'PORTADA_Ambau_Cabanyal_02.jpg', 32),
(39, 'cabanyal-derribo.jpg', 32),
(40, '627870834.jpg', 32),
(41, '2984769_-1159296018_2984769_8.jpg', 32);

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
(3, 'clientesha', 'cliente', 'cliente', 'cliente', 'cliente@cliente.es', 647653423, 'a60b85d409a01d46023f90741e01b79543a3cb1ba048eaefbe5d7a63638043bf', 2),
(4, 'cliente1', 'Maria', 'Torrome', '', 'cliente1@cliente1.com', NULL, 'caae655b2617405e721d27d433331d27adb871354ce6c9be45acc90866df24f4', 2),
(5, 'cliente2', 'Paco', 'Ramis', 'null', 'cliente2@cliente.com', 963747461, 'd2c1e5a11019ad30e5e19ea15ad1f0ec0ea5107159099e34c66f72d192286dda', 2),
(6, 'cliente3', 'Rafael', 'Aznar', 'null', 'cliente3@cliente3.com', NULL, '937d7927a86d7619c9f3ac27584b726a57495e170c6c3374373a01c58169d32b', 2),
(9, 'cliente4', 'Yisus', 'Berisus', 'null', 'cliente4@cliente4.com', 675876565, 'b6a538131909740cab61b2b9c63b5a128092660d5c36f505158e174a83d45127', 2);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `barrio`
--
ALTER TABLE `barrio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
  ADD CONSTRAINT `fk_usuario_has_anuncio_anuncio1` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_has_anuncio_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

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
