
void main() {
    // Obtenemos el sistema operativo
    String sistemaOperativo = System.getProperty("os.name");

    System.out.println("Sistema operativo: " + sistemaOperativo);

    String comando;
    String directorio;

    // Comprobamos si estamos en Windows
    if (sistemaOperativo.toLowerCase().contains("windows")) {

        comando = "cmd /c dir";
        directorio = "C:/temp";

    } else {
        // Suponemos que estamos en Linux
        comando = "sh -c ls";
        directorio = "/tmp";
    }

    try {

        // Separamos el comando usando split("\\s")
        String[] proceso = comando.split("\\s");

        // Creamos el proceso
        ProcessBuilder pb = new ProcessBuilder(proceso);

        // Cambiamos el directorio de trabajo
        pb.directory(new java.io.File(directorio));

        // Ejecutamos el proceso
        Process p = pb.start();

        // Leemos la salida del proceso
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream())
        );

        br.lines().forEach(System.out::println);

    } catch (Exception e) {
        e.printStackTrace();
    }

}

