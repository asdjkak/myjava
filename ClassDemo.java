import java.lang.reflect.*;
/*可变参数：你要几个参数类。就写几个，到时候jvm会根据参数的个数和类型找到指定的构造函数
可变参数的好处：
1.与数组不同，可以不用同一类型
2.个数没有限制
*/
public class ClassDemo{
	public static void main(String[] args)throws Exception {
		//1.每个类有一个静态的属性叫class
		Class clazz=Student.class;
		//2.通过对象的getClass（）方法来获得
		Class clazz1=new Student().getClass();
		//3.通过Class。forName（）来获得  最多
		Class clazz2=Class.forName("Student");  //得到Student.class
		System.out.println(clazz);

		//-----------------------------------------------------------------------构造方法
		//通过无参的构造方法创建出实例对象
		Student s=(Student)clazz2.newInstance();
		System.out.println(s);
		//通过getConstructor()获取有参的构造方法
		Constructor con=clazz2.getConstructor(String.class,int.class);//必须public修饰的构造方法
		System.out.println(con);
		Object o=con.newInstance("li",20);//con类型的实例对象
		System.out.println(o);
		//通过getDeclaredConstructors()获取所有的构造方法
		Constructor[] constructor=clazz.getDeclaredConstructors();
		for (Constructor s2 :constructor ) {
			System.out.println(s2);
		}
		//通过getConstructors()获取所有的public构造方法
		Constructor[] constructor1=clazz.getConstructors();
		for (Constructor s1 :constructor1 ) {
			System.out.println(s1);
		}

		//-----------------------------------------------------------------属性
		Object oo=clazz2.newInstance();//student的实例对象
		Field f=clazz2.getDeclaredField("age");//获取指定属性名的Field对象
		System.out.println(f);//int student。age
		int age=f.getInt(oo);//属性值  静态属性的话oo可以改成clazz2
		System.out.println(age);
		//修改实例对象的属性值 
		f.set(oo,30);
		System.out.println(oo);

		//f.getModifiers()判断属性的修饰符
		//f.getType()==String.class  判断属性的类型（通过类对象的地址判断）
		Field[] fs=clazz2.getDeclaredFields();
		for (Field fi:fs) {
			if (fi.getModifiers()==Modifier.PRIVATE&&fi.getType()==String.class) {
				fi.setAccessible(true);
				String p=(String)fi.get(oo);
				String p2=p.replaceAll("a","w");
				fi.set(oo,p2);
				System.out.println(fi.get(oo));
			}
		}

		//-------------------------------------------------------方法
		Object o5=clazz1.newInstance();
		Method m=clazz1.getDeclaredMethod("study",new Class[]{});//获取无参方法
		System.out.println(m.getName());//获取无参方法名
		//调用无参的方法
		m.invoke(o5,new Object[]{});//无参 后面可以不要
		//获取有参的方法
		Method m1=clazz1.getDeclaredMethod("study",String.class);
		//调用有参的方法
		m1.invoke(o5,"java");

		Method m3=clazz1.getDeclaredMethod("run",new Class[]{});
		m3.setAccessible(true);
		m3.invoke(o5,new Object[]{});

	}
}
class Student{
	private String name="aaa";
	private String name1="2aa";
	int age=2;
	public Student(){}
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public Student(String name){
		this.name=name;
	}
	public String toString(){
		return name+age;
	}
	public void study(){
		System.out.println("学习");
	}
	public void study(String s){
		System.out.println("学习"+s);
	}
	public static void run(){
		System.out.println("pao");
	}
}