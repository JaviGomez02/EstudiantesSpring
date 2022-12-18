package com.jacaranda.miPrimerSpringPrueba.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.miPrimerSpringPrueba.model.Student;

@Service
public class StudentService {
	private List<Student> lista;

	public StudentService() {
		lista=new ArrayList<Student>();
		lista.add(new Student("javi", "gomez", 20));
		lista.add(new Student("migue", "yuste", 23));
		lista.add(new Student("aberto", "adame", 60));
		lista.add(new Student("sopa", "ramuire", 30));
		lista.add(new Student("angel", "pajero", 82));

	}

	public boolean addStudent(Student arg0) {
		return lista.add(arg0);
	}

	public Student getStudent(String nombre, String apellido) {
		Boolean encontrado=false;
		Student resultado=null;
		
		Iterator<Student> iterator=this.lista.iterator();
		while(iterator.hasNext() && !encontrado) {
			resultado=iterator.next();
			if (resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				encontrado=true;
			}
		}
		return resultado;
	}

	public boolean removeStudent(Student arg0) {
		return lista.remove(arg0);
	}

	public List<Student> getStudents() {
		return lista;
	}
	
	public Boolean updateStudent(String nombre, String apellido, int edad) {
		Boolean encontrado=false;
		Student resultado=null;
		
		Iterator<Student> iterator=this.lista.iterator();
		while(iterator.hasNext() && !encontrado) {
			resultado=iterator.next();
			if (resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				encontrado=true;
				resultado.setAge(edad);
			}
		}
		return encontrado;
	}
	
	
	
	

}
