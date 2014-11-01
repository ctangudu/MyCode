package my.java;

import java.io.IOException;

public class OverrideCls {

	public static void main(String[] args) {
		ParentCls parent = new ParentCls();
		ParentCls child = new ChildCls();
		parent.someFunction("Test");
		child.someFunction("Test2");
	}
}

class ParentCls{
	void someFunction(String string){
		System.out.println("someFunction in parent");
	}
}

class ChildCls extends ParentCls{
	@Override
   void someFunction(String string){
		System.out.println("someFunction in Child");
	}
	
	void someFunction(StringBuilder string) throws IOException{
		
	}
}