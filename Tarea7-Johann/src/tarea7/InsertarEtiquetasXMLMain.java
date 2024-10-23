package tarea7;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class InsertarEtiquetasXMLMain {

	public static void main(String[] args) {
		// TODO

		Scanner sc = new Scanner(System.in);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			Alumno leerAlumno[] = new Alumno[2];
			for (int i = 0; i < leerAlumno.length; i++) {
				System.out.println("Introduzca la Nia del alumno: ");
				int niaAlumno = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca el nombre del alumno: ");
				String nombreAlumno = sc.nextLine();

				System.out.println("Introduzca los apellidos del alumno: ");
				String apellidosAlumno = sc.nextLine();

				System.out.println("Introduzca el genero del alumno: ");
				char generoAl = sc.nextLine().charAt(0);
				String generoAlumno = String.valueOf(generoAl);

				System.out.println("Introduzca la fecha de nacimiento del alumno(yyyy-MM-dd): ");
				String fechaNacimientoAlumno = sc.nextLine();
				LocalDate nacimientoAlumno = LocalDate.parse(fechaNacimientoAlumno);

				System.out.println("Introduzca el cliclo del alumno: ");
				String cicloAlumno = sc.nextLine();

				System.out.println("Introduzca el curso del alumno: ");
				String cursoAlumno = sc.nextLine();

				System.out.println("Introduzca el grupo del alumno: ");
				String grupoAlumno = sc.nextLine();

				DocumentBuilder builder = factory.newDocumentBuilder();
				DOMImplementation implementation = builder.getDOMImplementation();

				Document document = implementation.createDocument(null, "Alumnos", null);
				document.setXmlVersion("1.0");

				Element alumnos = document.createElement("alumnos");
				Element alumno = document.createElement("alumno");

				Element nia = document.createElement("nia");
				Text textNIA = document.createTextNode(niaAlumno + "J");
				nia.appendChild(textNIA);
				alumno.appendChild(nia);

				Element nombre = document.createElement("nombre");
				Text textnombre = document.createTextNode(nombreAlumno);
				nombre.appendChild(textnombre);
				alumno.appendChild(nombre);

				Element apellidos = document.createElement("apellidos");
				Text textapellidos = document.createTextNode(apellidosAlumno);
				apellidos.appendChild(textapellidos);
				alumno.appendChild(apellidos);

				Element genero = document.createElement("genero");
				Text textgenero = document.createTextNode(generoAlumno);
				genero.appendChild(textgenero);
				alumno.appendChild(genero);

				Element fechaNacimiento = document.createElement("fechaNacimiento");
				Text textfechaNacimiento = document.createTextNode(fechaNacimientoAlumno);
				fechaNacimiento.appendChild(textfechaNacimiento);
				alumno.appendChild(fechaNacimiento);

				Element ciclo = document.createElement("ciclo");
				Text textciclo = document.createTextNode(cicloAlumno);
				ciclo.appendChild(textciclo);
				alumno.appendChild(ciclo);

				Element curso = document.createElement("curso");
				Text textcurso = document.createTextNode(cursoAlumno);
				curso.appendChild(textcurso);
				alumno.appendChild(curso);

				Element grupo = document.createElement("grupo");
				Text textgrupo = document.createTextNode(grupoAlumno);
				grupo.appendChild(textgrupo);
				alumno.appendChild(grupo);

				alumnos.appendChild(alumno);

				document.getDocumentElement().appendChild(alumnos);

				Source source = new DOMSource(document);
				Result result = new StreamResult(new File("alumnos.xml"));

				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
			}
		} catch (TransformerException a) {
			a.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}