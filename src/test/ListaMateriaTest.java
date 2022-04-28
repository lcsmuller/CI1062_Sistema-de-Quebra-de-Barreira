package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ListaMateria;
import main.Materia;

class ListaMateriaTest {

	@Test
	void testProcurarMateria() {
		ListaMateria lista = new ListaMateria();

		lista.inserir(new Materia("foo", 1, "foo", "foo", 1, "foo", 1));
		assertEquals(1, lista.procurarMateria("foo").size());
		lista.inserir(new Materia("bar", 2, "bar", "bar", 2, "bar", 2));
		assertEquals(1, lista.procurarMateria("bar").size());
		lista.inserir(new Materia("bar", 3, "bar", "bar", 3, "bar", 3));
		assertEquals(2, lista.procurarMateria("bar").size());
	}
}