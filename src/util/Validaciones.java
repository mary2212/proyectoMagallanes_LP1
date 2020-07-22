package util;

public class Validaciones
{
	public static final String TEXTO = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}";
	public static final String NOMBRE = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,50}";
	public static final String ESTADO = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{6,9}";
	public static final String CELULAR = "\\d{9}";
	public static final String TELEFONO = "\\d{7}";
	public static final String RUC = "\\d{11}";
	public static final String FECHA = "((20)\\d\\d)[-/](0?[1-9]|1[012])[-/](0?[1-9]|[12][0-9]|3[01])";
}
