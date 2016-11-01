
public class WrapperClassesExample {

	static Integer i = new Integer(5);
	static Integer x = 5;

	static int j = Integer.parseInt("4");

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final Integer i = 5;

		Integer j = new Integer(5);

		j = WrapperClassesExample.j;

		System.out.println(i == 5);
		System.out.println(i == j);
		System.out.println(WrapperClassesExample.i == i);
		System.out.println(WrapperClassesExample.i == WrapperClassesExample.x);
		System.out.println(i == WrapperClassesExample.x);
		System.out.println(i == WrapperClassesExample.j);
		System.out.println(j == WrapperClassesExample.j);
	}

}
