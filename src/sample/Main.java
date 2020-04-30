package sample;

import javafx.application.Application;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner keyboard = new Scanner(System.in);
        Lista<Club> clubs = new Lista<Club>(1);
        Lista<Trabajador> trabajadores= new Lista<Trabajador>(2);
        Lista<Ingreso> ingresos = new Lista<Ingreso>(3);
        Lista<Gasto> gastos = new Lista<Gasto>(3);
        Lista<Partido> partidos = new Lista<Partido>(1);

        //Añadiedo datos
        clubs.añadir(new Club(eEquipo.BARÇA,"a123456",1899,ePais.España));
        clubs.añadir(new Club(eEquipo.PORTO,"b123456",1900,ePais.Portugal));
        clubs.añadir(new Club(eEquipo.MANCHESTER,"c123456",1901,ePais.Inglaterra));
        clubs.añadir(new Club(eEquipo.PSG,"d123456",1902,ePais.Francia));
        clubs.añadir(new Club(eEquipo.BAYERN,"e123456",1903,ePais.Alemania));
        clubs.añadir(new Club(eEquipo.JUVENTUS,"f123456",1904,ePais.Italia));

        trabajadores.añadir(new Jugador("Lionel","Messi","41751425H",32,677884451,new Contrato(300000,3,500000),ePosicion.Delantero,10,200,50, 10,5,300));
        trabajadores.añadir(new Jugador("Anchu","Fati","32659845J",17,67615953,new Contrato(250000,8,400000),ePosicion.Delantero,11,15,2, 2,0,20));

        ingresos.añadir(new Ingreso(0, "Venta", "22/02/2020", 191000, clubs.get(0)));
        ingresos.añadir(new Ingreso(1, "Traspaso", "02/03/2019", 2000000, clubs.get(1)));
        ingresos.añadir(new Ingreso(2, "Cesión", "28/10/2018", 8000, clubs.get(2)));

        gastos.añadir(new Gasto(0,"Sueldo jugador","30/01/2020",15000,clubs.get(0)));
        gastos.añadir(new Gasto(1,"Fichaje", "10/02/2020",3000000,clubs.get(3)));
        gastos.añadir(new Gasto(2,"Sueldo entrenador","15/02/2020",12000, clubs.get(2)));

        partidos.añadir(new Partido(clubs.get(0),clubs.get(1),"1","2"));
        partidos.añadir(new Partido(clubs.get(2),clubs.get(3),"1","1"));
        int opcion = 99;
        System.out.println("----------------------------------------------------------------");
        System.out.println("Bienvenido/a.");
        System.out.println("");
        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println("");
            System.out.println("1. Mostrar la lista de clubs");
            System.out.println("2. Mostrar la lista de trabajadores");
            System.out.println("3. Mostrar la lista de partidos");
            System.out.println("4. Mostrar la lista de ingresos");
            System.out.println("5. Mostrar la lista de gastos");
            System.out.println("6. Añadir un club");
            System.out.println("7. Añadir un trabajador");
            System.out.println("8. Añadir un partido");
            System.out.println("9. Añadir un ingreso");
            System.out.println("10. Añadir un gasto");
            System.out.println("11. Mostrar XML");
            System.out.println("12. Mostrar TXT");
            System.out.println("13. Comparar contratos");
            System.out.println("14. Clonar un ingreso");
            System.out.println("15. Clonar un gasto");
            System.out.println("16. Convertir la moneda de un ingreso o gasto:");
            System.out.println("17. Abrir conversor de moneda");
            System.out.println("0. Salir del programa");
            System.out.print("Introduce una opción: ");
            opcion = keyboard.nextInt();

            switch(opcion) {
                case 0:
                    System.out.println("Cerrando el programa...");
                    System.exit(0);
                    break;
                case 1:
                    mostrarClubs(clubs);
                    break;
                case 2:
                    mostrarTrabajadores(trabajadores);
                    break;
                case 3:
                    mostrarPartidos(partidos);
                    break;
                case 4:
                    mostrarIngresos(ingresos);
                    break;
                case 5:
                    mostrarGastos(gastos);
                    break;
                case 6:
                    clubs = añadirClub(clubs);
                    break;
                case 7:
                    trabajadores = añadirTrabajador(trabajadores);
                    break;
                case 8:
                    partidos = añadirPartido(partidos, clubs);
                    break;
                case 9:
                    ingresos = añadirIngreso(ingresos, clubs);
                    break;
                case 10:
                    gastos = añadirGasto(gastos, clubs);
                    break;
                case 11:
                    escribirXML(partidos);
                    leerXML();
                    break;
                case 12:
                    escribirTXT(partidos);
                    leerTXT();
                    break;
                case 13:
                    compararContratos(trabajadores);
                    break;
                case 14:
                    ingresos = clonarIngreso(ingresos);
                    break;
                case 15:
                    gastos = clonarGastos(gastos);
                    break;
                case 16:
                    System.out.println("¿Ingreso o gasto?");
                    String op = keyboard.next().toLowerCase();
                    if(op.equals("ingreso")){
                        System.out.println("Introduce el id del ingreso: ");
                        int id = keyboard.nextInt();
                        ingresos.getHashMap().get(id).cambiarMoneda();
                    }else if(op.equals("gasto")){
                        System.out.println("Introduce el id del ingreso: ");
                        int id = keyboard.nextInt();
                        gastos.getHashMap().get(id).cambiarMoneda();
                    }
                    break;
                case 17:
                    abrirJavaFX();
                    break;
            }

        }while(opcion != 0);

    }

    public static void mostrarClubs(Lista<Club> clubs){
        clubs.getArray().forEach(n -> System.out.println(n));
    }

    public static void mostrarTrabajadores(Lista<Trabajador> trabajadores){
        for(Trabajador x : trabajadores.getHashSet()){
            System.out.println(x);
        }
    }

    public static void mostrarPartidos(Lista<Partido> partidos){
        partidos.getArray().forEach(n -> System.out.println(n));
    }

    public static void mostrarIngresos(Lista<Ingreso> ingresos){
        Iterator<Ingreso> x = ingresos.getHashMap().values().iterator();
        while (x.hasNext()) {
            System.out.println(x.next());
        }
    }

    public static void mostrarGastos(Lista<Gasto> gastos){
        Iterator<Gasto> x = gastos.getHashMap().values().iterator();
        while (x.hasNext()) {
            System.out.println(x.next());
        }
    }

    public static Lista<Club> añadirClub(Lista<Club> clubs){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nombre del club: ");
        eEquipo nombre = eEquipo.valueOf(keyboard.nextLine().toUpperCase());
        System.out.println("Cif del club: ");
        String cif = keyboard.nextLine();
        System.out.println("Año de fundación del club: ");
        int año = keyboard.nextInt();
        System.out.println("País del club: ");
        String club = keyboard.next();
        ePais pais = ePais.valueOf(club);
        clubs.añadir(new Club(nombre,cif,año,pais));

        return clubs;
    }

    public static Lista<Trabajador> añadirTrabajador(Lista<Trabajador> trabajadores){
        int x = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Tipo de trabajador: ");
            String tipo = keyboard.nextLine();
            System.out.println("Nombre del trabajador: ");
            String nombre = keyboard.nextLine();
            System.out.println("Apellidos del trabajador: ");
            String apellidos = keyboard.nextLine();
            System.out.println("DNI del trabajador: ");
            String dni = keyboard.nextLine();
            System.out.println("Edad del trabajador: ");
            int edad = keyboard.nextInt();
            System.out.println("Teléfono del trabajador: ");
            int tlf = keyboard.nextInt();
            System.out.println("Sueldo del trabajador: ");
            int sueldo = keyboard.nextInt();
            System.out.println("Duración del contrato del trabajador(en años): ");
            int duracion = keyboard.nextInt();
            System.out.println("Cláusula de rescisión del contrato del trabajador: ");
            int clausula = keyboard.nextInt();
            if (tipo.toLowerCase().equals("jugador")) {
                x=1;
                System.out.println("Posición del jugador: ");
                String g = keyboard.next();
                System.out.println("Dorsal del jugador: ");
                int dorsal = keyboard.nextInt();
                System.out.println("Número de goles del jugador: ");
                int goles = keyboard.nextInt();
                System.out.println("Número de asistencias del jugador: ");
                int asist = keyboard.nextInt();
                System.out.println("Número de tarjetas amarillas del jugador: ");
                int tA = keyboard.nextInt();
                System.out.println("Número de tarjetas rojas del jugador: ");
                int tR = keyboard.nextInt();
                System.out.println("Número de partidos del jugador: ");
                int partidos = keyboard.nextInt();
                trabajadores.añadir(new Jugador(nombre, apellidos, dni, edad, tlf, new Contrato(sueldo, duracion, clausula), ePosicion.valueOf(g), dorsal, goles, asist, tA, tR, partidos));
            } else if (tipo.toLowerCase().equals("equipo tecnico")) {
                x=1;
                System.out.println("Cargo del trabajador en el equipo técnico: ");
                String cargoEQ = keyboard.next();
                trabajadores.añadir(new EquipoTecnico(nombre, apellidos, dni, edad, tlf, new Contrato(sueldo, duracion, clausula), cargoEQ));
            } else if (tipo.toLowerCase().equals("administrador")) {
                x=1;
                System.out.println("Cargo del trabajador en la administración: ");
                String cargoA = keyboard.next();
                trabajadores.añadir(new Administrador(nombre, apellidos, dni, edad, tlf, new Contrato(sueldo, duracion, clausula), cargoA));
            } else {
                System.out.println("Tipo de trabajador no válido");
            }
        }while(x!=1);

        return trabajadores;
    }

    public static Lista<Ingreso> clonarIngreso(Lista<Ingreso> ingresos)throws CloneNotSupportedException{
        Lista<Ingreso> i = ingresos;
        Scanner keyboard = new Scanner(System.in);
        Ingreso original = null;
        Ingreso clonado;
        System.out.println("Introduce el id del ingreso a clonar: ");
        int id = keyboard.nextInt();
        for(int x = 1; x < ingresos.getHashMap().size(); x++){
            if(id == ingresos.getHashMap().get(x).getIdIngreso()){
                original = ingresos.getHashMap().get(x);
            }
        }
        clonado = original.clone();
        System.out.println("Ingreso original: "+original);
        System.out.println("Ingreso clonado: "+clonado);
        i.añadir(clonado);

        return i;
    }

    public static Lista<Gasto> clonarGastos(Lista<Gasto> gastos)throws CloneNotSupportedException{
        Lista<Gasto> g = gastos;
        Scanner keyboard = new Scanner(System.in);
        Gasto original = null;
        Gasto clonado;
        System.out.println("Introduce el id del gasto a clonar: ");
        int id = keyboard.nextInt();
        for(int x = 1; x < gastos.getHashMap().size(); x++){
            if(id == gastos.getHashMap().get(x).getIdGasto()){
                original = gastos.getHashMap().get(x);
            }
        }

        clonado = original.clone();
        System.out.println("Gasto original: "+original);
        System.out.println("Gsato clonado: "+clonado);
        g.añadir(clonado);

        return g;
    }
    public static void compararContratos(Lista<Trabajador> trabajadores){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Introduce el DNI del primer trabajador: ");
        String primero = keyboard.next();
        System.out.print("Introduce el DNI del segundo trabajador: ");
        String segundo = keyboard.next();
        int posP = 0;
        int posS = 0;

        for(int x = 0; x < trabajadores.getArray().size(); x++){
            if(primero.equals(trabajadores.get(x).getDni())){
                posP = x;
            }else if(segundo.equals(trabajadores.get(x).getDni())){
                posS = x;
            }
        }

        if(trabajadores.get(posP).getContrato().compareTo(trabajadores.get(posS).getContrato()) == 1){
            System.out.println("El primer contrato tiene un mayor sueldo");
        }else if(trabajadores.get(posP).getContrato().compareTo(trabajadores.get(posS).getContrato()) == -1){
            System.out.println("El segundo contrato tiene un mayor sueldo");
        }else{
            System.out.println("Ambos contratos tienen el mismo sueldo");
        }
    }

    public static Lista<Partido> añadirPartido(Lista<Partido> partidos, Lista<Club> clubs){
        Lista<Partido> p = partidos;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce el nombre del local: ");
        String nombreL = keyboard.next();
        System.out.println("Introduce el numero de goles del local: ");
        String golesL = keyboard.next();
        System.out.println("Introduce el nombre del visitante: ");
        String nombreV = keyboard.next();
        System.out.println("Introduce el numero de goles del visitante: ");
        String golesV = keyboard.next();
        Club local = null;
        Club visitante = null;
        for(int x = 0; x<clubs.getArray().size(); x++){
            if(eEquipo.valueOf(nombreL.toUpperCase()).equals(clubs.getArray().get(x).getNombreC())){
                local = clubs.getArray().get(x);
            }
        }
        for(int i = 0; i<clubs.getArray().size(); i++){
            if(eEquipo.valueOf(nombreV.toUpperCase()).equals(clubs.getArray().get(i).getNombreC())){
                visitante = clubs.getArray().get(i);
            }
        }
        p.añadir(new Partido(local,visitante,golesL,golesV));

        return p;
    }

    public static Lista<Ingreso> añadirIngreso(Lista<Ingreso> ingresos, Lista<Club> clubs){
        Lista<Ingreso> i = ingresos;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce el tipo/motivo del ingreso: ");
        String tipo = keyboard.next();
        System.out.println("Introduce la fecha del ingreso (dia/mes/año): ");
        String fecha = keyboard.next();
        System.out.println("Introduce la cantidad del ingreso (entero): ");
        int cantidad = keyboard.nextInt();
        System.out.println("Introduce el id del club al que quieres asociar el ingreso: ");
        int id = keyboard.nextInt();
        i.añadir(new Ingreso(ingresos.getHashMap().size(),tipo,fecha,cantidad,clubs.get(id)));
        return i;
    }

    public static Lista<Gasto> añadirGasto(Lista<Gasto> gastos, Lista<Club> clubs){
        Lista<Gasto> g = gastos;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce el tipo/motivo del gasto: ");
        String tipo = keyboard.next();
        System.out.println("Introduce la fecha del gasto (dia/mes/año): ");
        String fecha = keyboard.next();
        System.out.println("Introduce la cantidad del gasto (entero): ");
        int cantidad = keyboard.nextInt();
        System.out.println("Introduce el id del club al que quieres asociar el gasto: ");
        int club = keyboard.nextInt();
        g.añadir(new Gasto(gastos.getHashMap().size(), tipo, fecha, cantidad, clubs.getArray().get(club)));

        return g;
    }

    public static void escribirXML(Lista<Partido> partidos){

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element raiz = doc.createElement("resultados");
            doc.appendChild(raiz);
            for(int x = 0; x < partidos.getArray().size(); x++){
                Element partido = doc.createElement("partido");
                raiz.appendChild(partido);
                Element local = doc.createElement("local");
                partido.appendChild(local);
                Element nombreLocal = doc.createElement("nombre");
                Element golesLocal = doc.createElement("goles");
                nombreLocal.appendChild(doc.createTextNode(partidos.getArray().get(x).getLocal().getNombreC().toString()));
                local.appendChild(nombreLocal);
                golesLocal.appendChild(doc.createTextNode(partidos.getArray().get(x).getGolesLocal()));
                local.appendChild(golesLocal);

                Element visitante = doc.createElement("visitante");
                partido.appendChild(visitante);
                Element nombreVisitante = doc.createElement("nombre");
                Element golesVisitante = doc.createElement("goles");
                nombreVisitante.appendChild(doc.createTextNode(partidos.getArray().get(x).getVisitante().getNombreC().toString()));
                visitante.appendChild(nombreVisitante);
                golesVisitante.appendChild(doc.createTextNode(partidos.getArray().get(x).getGolesVisitante()));
                visitante.appendChild(golesVisitante);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src\\sample\\resultados.xml"));
            t.transform(source, result);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerXML(){
        File file = new File("src\\sample\\resultados.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("partido");
            System.out.println("Número de partidos: " + nList.getLength());
            for(int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Partido "+(temp+1));
                    System.out.print("Local: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println(" | goles: " + eElement.getElementsByTagName("goles").item(0).getTextContent());
                    System.out.print("Visitante: " + eElement.getElementsByTagName("nombre").item(1).getTextContent());
                    System.out.println(" | goles: " + eElement.getElementsByTagName("goles").item(1).getTextContent());
                    System.out.println("");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerTXT() {
        File fichero = new File("src\\sample\\ganadores.txt");
        Scanner s = null;

        try {
            System.out.println("GANADORES DE LOS PARTIDOS");
            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                System.out.println(linea);
            }

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }

    public static void escribirTXT(Lista<Partido> partidos) {

        FileWriter fichero = null;
        try {

            fichero = new FileWriter("src\\sample\\ganadores.txt");

            for (Partido linea : partidos.getArray()) {
                if(Integer.parseInt(linea.getGolesLocal())>Integer.parseInt(linea.getGolesVisitante())){
                    fichero.write(linea.getLocal().getNombreC() + "\n");
                }else if(Integer.parseInt(linea.getGolesLocal())<Integer.parseInt(linea.getGolesVisitante())){
                    fichero.write(linea.getVisitante().getNombreC() + "\n");
                }
            }

            fichero.close();

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    public static void abrirJavaFX(){
        new Thread(() -> Application.launch(Conversor.class)).start();
        Conversor startUpTest = Conversor.waitForStartUpTest();
        startUpTest.printSomething();
    }
}
