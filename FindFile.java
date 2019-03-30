//import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;

class FindFile
{
	public static void main(String[] args) throws Exception
	{
		LinkedList<String> directories = new LinkedList<String>();
		if (args.length != 2)
			throw new Exception("The must specify two arguments, a directory and a file to search (in that order).");
		if (new File(args[0]).exists())
			directories.add(args[0]);
		else
			throw new Exception("The directory you specified does not exist.");
		String d = null;
		while ((d = directories.poll()) != null)
		{
			String[] fs = new File(d).list();
			for (String f : fs)
			{
				File temp = new File(f);
				if (temp.isDirectory())
					directories.add(f);
				else if (temp.getName().equals(args[1]))
					System.out.println(f);
			}
		}
	}

	/*private ArrayList list = new ArrayList();

	public static void main(String[] args)
	{
		String directory = args[0];
		String file = args[1];
		getMatches(directory, file);			
	}

	private static void getMatches(String d, String f)
	{
		String[] ol = new File(d).list();
		for (String o : ol)
		{
			File temp = new File(o);
			if (temp.isDirectory())
				getMatches(o, f);
			else if (temp.getName().equals(f))
				System.out.println(o);
		}
	}*/
}