
--
-- Database: documentos
--

-- --------------------------------------------------------

--
-- Table structure for table administrador
--

CREATE TABLE IF NOT EXISTS administrador (
  login INTEGER NOT NULL,
  clave INTEGER NOT NULL,
  numero_documento INTEGER NOT NULL,
  nombres INTEGER NOT NULL,
  apellido1 varchar(50) NOT NULL,
  apellido2 varchar(50) NOT NULL,
  PRIMARY KEY (numero_documento)
) ;

-- --------------------------------------------------------

--
-- Table structure for table denuncia
--

CREATE TABLE IF NOT EXISTS denuncia (
  id_denuncia INTEGER NOT NULL,
  fecha_denuncia date NOT NULL,
  fecha_perdida date NOT NULL,
  hora_perdida time NOT NULL,
  PRIMARY KEY (id_denuncia)
) ;

-- --------------------------------------------------------

--
-- Table structure for table documento
--

CREATE TABLE IF NOT EXISTS documento (
  id_documento INTEGER NOT NULL,
  no_documento varchar(30) NOT NULL,
  id_tipo_documento INTEGER NOT NULL,
  id_denuncia INTEGER NOT NULL,
  documento_funcionario varchar(20) NOT NULL,
  documento_usuario_reporta varchar(20) NOT NULL,
  documento_usuario_denuncia varchar(20) NOT NULL,
  id_estado INTEGER NOT NULL,
  PRIMARY KEY (id_documento)
) ;

-- --------------------------------------------------------

--
-- Table structure for table estado
--

CREATE TABLE IF NOT EXISTS estado (
  id_estado INTEGER NOT NULL,
  nombre varchar(40) NOT NULL,
  PRIMARY KEY (id_estado)
) ;

-- --------------------------------------------------------

--
-- Table structure for table funcionario
--

CREATE TABLE IF NOT EXISTS funcionario (
  numero_documento varchar(20) NOT NULL,
  nombres varchar(50) NOT NULL,
  apellido1 varchar(50) NOT NULL,
  apellido2 varchar(50) NOT NULL,
  clave varchar(20) NOT NULL,
  PRIMARY KEY (numero_documento)
) ;

-- --------------------------------------------------------

--
-- Table structure for table tipo_documento
--

CREATE TABLE IF NOT EXISTS tipo_documento (
  id_tipo INTEGER NOT NULL,
  nombre INTEGER NOT NULL,
  descripcion INTEGER NOT NULL,
  PRIMARY KEY (id_tipo)
) ;

-- --------------------------------------------------------

--
-- Table structure for table usuario_denuncia
--

CREATE TABLE IF NOT EXISTS usuario_denuncia (
  documento_usuario_denuncia varchar(20) NOT NULL,
  nombres INTEGER NOT NULL,
  apellido1 INTEGER NOT NULL,
  apellido2 INTEGER NOT NULL,
  fecha_nacimiento date NOT NULL,
  direccion varchar(100) NOT NULL,
  telefono varchar(50) NOT NULL,
  correo varchar(50) NOT NULL,
  PRIMARY KEY (documento_usuario_denuncia)
) ;

-- --------------------------------------------------------

--
-- Table structure for table usuario_reporta
--

CREATE TABLE IF NOT EXISTS usuario_reporta (
  documento_usuario_reporta varchar(20) NOT NULL,
  nombres INTEGER NOT NULL,
  apellido1 INTEGER NOT NULL,
  apellido2 INTEGER NOT NULL,
  direccion varchar(100) NOT NULL,
  telefono varchar(50) NOT NULL,
  correo varchar(50) NOT NULL,
  PRIMARY KEY (documento_usuario_reporta)
) ;

--
-- CONSTRAINT for dumped tables
--

--
-- CONSTRAINT for table documento
--
ALTER TABLE documento
  ADD CONSTRAINT documento_ibfk_4 FOREIGN KEY (documento_funcionario) REFERENCES funcionario (numero_documento),
  ADD CONSTRAINT documento_ibfk_2 FOREIGN KEY (documento_usuario_reporta) REFERENCES usuario_reporta (documento_usuario_reporta),
  ADD CONSTRAINT documento_ibfk_3 FOREIGN KEY (documento_usuario_denuncia) REFERENCES usuario_denuncia (documento_usuario_denuncia);

