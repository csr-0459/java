class Sumcmdargs
{ 
 static public void main(String args[])
{
 	int a,b,c,len;
	len=args.length;
	if(len>=2)
	{
		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);
		c=a+b;
		System.out.printf("%d + %d = %d",a,b,c);
	}
	else
	{
	 System.out.println("PLZ Enter TWO COMMAND LINE ARGUMENTS ");	
	}
}
}