-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-08-2020 a las 09:31:09
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cod_isbn` varchar(30) NOT NULL,
  `cod_ejemp` varchar(30) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  `disponibilidad` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `nombre`, `cod_isbn`, `cod_ejemp`, `categoria`, `disponibilidad`) VALUES
(1, 'El principito', '254-145-2366', '145-2365-41', 'Infantil', 'true'),
(2, 'Java', '47-5236-58', '1458796', 'Programacion', 'true'),
(3, 'Viernes 13', '86-7412-369-8', '9652332', 'Terror', 'false'),
(4, 'El mundo', '745-8746-232', '352154', 'Sociales', 'true'),
(5, 'Citas', '985-2145-6', '320124', 'Romance', 'true'),
(6, 'El principito', '254-145-2366', '96542310', 'Infantil', 'true'),
(7, 'Redes', '745-896-332', '5-879-632', 'Tecnologia', 'true'),
(8, 'El principito', '254-145-2366', '69-8541-23', 'Infantil', 'true'),
(9, 'El principito', '254-145-2366', '98-652-3', 'Infantil', 'true'),
(10, 'Java', '47-5236-58', '145-2365-41', 'Programacion', 'true');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL,
  `cod_isbn` varchar(30) NOT NULL,
  `cod_ejemp` varchar(30) NOT NULL,
  `cedula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre` varchar(50) NOT NULL,
  `cedula` int(11) NOT NULL,
  `fecha_nac` varchar(10) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `tipo_usu` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `cant_libros_prest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `cedula`, `fecha_nac`, `sexo`, `tipo_usu`, `estado`, `cant_libros_prest`) VALUES
('Naiver', 123, '03/10/2000', 'Masculino', 'Estudiante', 'true', 0),
('Katherine', 652, '08/09/1995', 'Femenino', 'Profesor', 'true', 0),
('Daniela', 987, '14/03/1996', 'Femenino', 'Estudiante', 'true', 0),
('Cesar', 5544, '22/05/1984', 'Masculino', 'Profesor', 'false', 0),
('biblioadmin', 12345678, '00/00/0000', 'Masculino', 'Bibliotecario', 'true', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
