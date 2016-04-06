public class AnonymousClassDemo{
	interface HelloWorld{
		public void greet();
		public void greetSomeone(String someone);
	}

	public void sayHello(){
		class EnglishGreeting implements HelloWorld {
			String name = "world";
			public void greet(){
			    greetSomeone("world");
			}
			public void greetSomeone(String someone){
				name = someone;
				System.out.println("Hello "+name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting();
		//expression is like the invocation of a constructor, 
		//except that there is a class definition contained in a block of code.
		HelloWorld frenchGreeting = new HelloWorld(){
			String name = "tout le monde";
			public void greet(){
				greetSomeone("tout le monde");
			}
			public void greetSomeone(String someone){
				name = someone;
				System.out.println("Sault "+name);
			}
		};
		englishGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
	}

    public static void main(String ... args){
    	AnonymousClassDemo myapp = new AnonymousClassDemo();
    	myapp.sayHello();
    }
}