-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 30-05-2024 a las 07:32:50
-- Versión del servidor: 8.3.0
-- Versión de PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `standcustom`
--
CREATE database standcustom;
USE standcustom;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` bigint NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(10, 'Phantom Blood'),
(11, 'Battle Tendency'),
(12, 'Stardust Crusaders'),
(13, 'Diamond is Unbreakable'),
(14, 'Vento Aureo'),
(15, 'Stone Ocean'),
(16, 'Steel Ball Run'),
(17, 'Jojolion'),
(18, 'Custom');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_partida`
--

CREATE TABLE `detalle_partida` (
  `id` bigint NOT NULL,
  `id_usuario` bigint NOT NULL,
  `id_stand` bigint NOT NULL,
  `id_partida` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorito`
--

CREATE TABLE `favorito` (
  `id` int NOT NULL,
  `id_usuario` int NOT NULL,
  `id_stand` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `favorito`
--

INSERT INTO `favorito` (`id`, `id_usuario`, `id_stand`) VALUES
(13, 1, 119);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opinion`
--

CREATE TABLE `opinion` (
  `id` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `numero_estrellas` int DEFAULT NULL,
  `id_usuario` bigint NOT NULL,
  `id_stand` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `id` bigint NOT NULL,
  `fecha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`id`, `fecha`) VALUES
(1, '18-02-2024'),
(2, '18-02-2024'),
(3, '18-02-2024'),
(4, '18-02-2024'),
(5, '18-02-2024'),
(6, '18-02-2024'),
(7, '18-02-2024'),
(8, '18-02-2024'),
(9, '18-02-2024'),
(10, '18-02-2024');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stand`
--

CREATE TABLE `stand` (
  `id` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` longblob,
  `id_usuario` int NOT NULL,
  `velocidad` varchar(1) NOT NULL,
  `alcance` varchar(1) NOT NULL,
  `poder` varchar(1) NOT NULL,
  `aguante` varchar(1) NOT NULL,
  `acierto` varchar(1) NOT NULL,
  `desarollo` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `id_categoria` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `stand`
--

INSERT INTO `stand` (`id`, `nombre`, `descripcion`, `imagen`, `id_usuario`, `velocidad`, `alcance`, `poder`, `aguante`, `acierto`, `desarollo`, `id_categoria`) VALUES
(112, 'Nombre del Stand 0', 'Descripción del Stand 0', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 27, 'A', 'B', 'A', 'B', 'C', 'D', 18),
(113, 'Nombre del Stand 1', 'Descripción del Stand 1', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 28, 'A', 'B', 'A', 'B', 'C', 'D', 14),
(114, 'Nombre del Stand 2', 'Descripción del Stand 2', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 30, 'A', 'B', 'A', 'B', 'C', 'D', 16),
(115, 'Nombre del Stand 3', 'Descripción del Stand 3', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 27, 'A', 'B', 'A', 'B', 'C', 'D', 11),
(116, 'Nombre del Stand 4', 'Descripción del Stand 4', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 30, 'A', 'B', 'A', 'B', 'C', 'D', 10),
(117, 'Nombre del Stand 5', 'Descripción del Stand 5', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 27, 'A', 'B', 'A', 'B', 'C', 'D', 18),
(118, 'Nombre del Stand 6', 'Descripción del Stand 6', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 30, 'A', 'B', 'A', 'B', 'C', 'D', 11),
(119, 'Nombre del Stand 7', 'Descripción del Stand 7', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 29, 'A', 'B', 'A', 'B', 'C', 'D', 16),
(120, 'Nombre del Stand 8', 'Descripción del Stand 8', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 1, 'A', 'B', 'A', 'B', 'C', 'D', 15),
(121, 'Nombre del Stand 9', 'Descripción del Stand 9', 0x687474703a2f2f6c6f63616c686f73743a383038332f6d656469612f6865726d6974707572706c652e706e67, 1, 'A', 'B', 'A', 'B', 'C', 'D', 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `telefono` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_is_0900_ai_ci DEFAULT NULL,
  `role` bit(1) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `token_password` varchar(256) CHARACTER SET utf16 COLLATE utf16_unicode_ci DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `verified` tinyint NOT NULL,
  `token` varchar(255) CHARACTER SET utf16 COLLATE utf16_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `email`, `telefono`, `password`, `role`, `username`, `token_password`, `active`, `verified`, `token`) VALUES
(1, 'tyrty', 'eof812@gmail.com', '12345678', '9141af3df42d66761144755e35a07b3c1bf29f1481d9cd0db3f45b2ad707e5c9', b'0', 'piolasto', '986e808d-8e96-40a3-a2e1-28ca34154d47', 1, 0, NULL),
(27, 'usuario2', 'email2@gmail.com', '12345672', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'0', 'mitio2', NULL, 1, 0, NULL),
(28, 'usuario3', 'email3@gmail.com', '12345673', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'0', 'mitio3', NULL, 1, 0, NULL),
(29, 'usuario4', 'email4@gmail.com', '12345674', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'mitio9', NULL, 1, 0, NULL),
(30, 'vdvccs', 'eof0812@gmail.com', '12345678', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'0', 'ewrwrwrwr', NULL, 1, 0, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_partida`
--
ALTER TABLE `detalle_partida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `favorito`
--
ALTER TABLE `favorito`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `opinion`
--
ALTER TABLE `opinion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `stand`
--
ALTER TABLE `stand`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `detalle_partida`
--
ALTER TABLE `detalle_partida`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `favorito`
--
ALTER TABLE `favorito`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `opinion`
--
ALTER TABLE `opinion`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `stand`
--
ALTER TABLE `stand`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
