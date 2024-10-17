CREATE DATABASE tareaPeliculas;
use tareaPeliculas;

-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `año` int(11) NOT NULL,
  `genero` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id`, `titulo`, `año`, `genero`) VALUES
(1, 'Origen', 2010, 'ciencia ficción'),
(2, 'El Padrino', 1972, 'drama'),
(3, 'El Caballero Oscuro', 2008, 'accion'),
(4, 'Forrest Gump', 1994, 'drama'),
(5, 'Interstellar', 2014, 'ciencia ficción'),
(6, 'Pulp Fiction', 1994, 'drama');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
