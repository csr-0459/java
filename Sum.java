import java.util.Scanner;
class Sum
{
public static void main(String[] args)
{
Scanner ob=new Scanner(System.in);
    int a,b,c;
System.out.println("Enter  two numbers :  ");
  a=ob.nextInt();
b=ob.nextInt();
 c=a+b;
System.out.printf("%d + %d =%d ",a,b,c);
}
}