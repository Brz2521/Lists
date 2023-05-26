import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;


public class Project06 extends Frame implements ActionListener
{
	String command = "";
	int key;
	boolean found;
	Font f = new Font("SansSerif",Font.BOLD,12);
	Font f1 = new Font("SansSerif",Font.BOLD,16);
	
	OneDArray originalArray;
	TwoDArray original2DArray;
	LinkedList originalList;
	int value;
	int[] originalCopy;
	
	LinkedList list;
	
	public static void main(String[] args)
	{
		Frame frame = new Project06();	
		frame.setResizable(true);
		frame.setSize(1000,800);
		frame.setVisible(true);
	}
	
	public Project06()
	{
		setTitle("CSC 229 - Project 6 - Lists");
		
	// Create Menu
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
	//One Dimensional Array
		
		Menu actionMenu = new Menu("One Dimensional Array");
		mb.add(actionMenu);
		
		MenuItem miCreate1D = new MenuItem("Create Array");
		miCreate1D.addActionListener(this);
		actionMenu.add(miCreate1D);
		
		Menu statsMenu1D = new Menu("Statistics");
		actionMenu.add(statsMenu1D);
		
		MenuItem miMinimum1D = new MenuItem("Array Minimum");
		miMinimum1D.addActionListener(this);
		statsMenu1D.add(miMinimum1D);
		
		MenuItem miMaximum1D = new MenuItem("Array Maximum");
		miMaximum1D.addActionListener(this);
		statsMenu1D.add(miMaximum1D);
		
		MenuItem miAverage1D = new MenuItem("Array Average");
		miAverage1D.addActionListener(this);
		statsMenu1D.add(miAverage1D);
		
		
		MenuItem miSort = new MenuItem("Sort Array");
		miSort.addActionListener(this);
		actionMenu.add(miSort);
		
		MenuItem miSearch1D = new MenuItem("Search Array");
		miSearch1D.addActionListener(this);
		actionMenu.add(miSearch1D);
		
	// Linked List
		
		Menu actionMenu1 = new Menu("Linked List"); //new item to the menu bar
		mb.add(actionMenu1);
		
		MenuItem micreateList = new MenuItem("Create Linked List"); //new item under Linked List tab
		micreateList.addActionListener(this);
		actionMenu1.add(micreateList);
		
		Menu addMenu = new Menu("Add"); //Drop down menu under Linked List
		actionMenu1.add(addMenu);
		
		MenuItem miBeginning1D = new MenuItem("Beginning"); //Menu item under Add menu
		miBeginning1D.addActionListener(this);
		addMenu.add(miBeginning1D);
		
		MenuItem miEnd1D = new MenuItem("End");
		miEnd1D.addActionListener(this);
		addMenu.add(miEnd1D);
		
		Menu listStats = new Menu("List Statistics");
		actionMenu1.add(listStats);
		
		MenuItem milistMin = new MenuItem("Linked List Minimum");
		milistMin.addActionListener(this);
		listStats.add(milistMin);
		
		MenuItem milistMax = new MenuItem("Linked List Maximum");
		milistMax.addActionListener(this);
		listStats.add(milistMax);
		
		MenuItem milistAve = new MenuItem("Linked List Average");
		milistAve.addActionListener(this);
		listStats.add(milistAve);
		
		MenuItem sortList = new MenuItem("Sort List");
		sortList.addActionListener(this);
		actionMenu1.add(sortList);
		
		MenuItem searchList = new MenuItem("Search List");
		searchList.addActionListener(this);
		actionMenu1.add(searchList);
		
	//Two Dimensional array
		
		Menu array2D = new Menu("Two Dimensional Array");
		mb.add(array2D);
		
		MenuItem createArray = new MenuItem("Create 2D Array");
		createArray.addActionListener(this);
		array2D.add(createArray);
		
		Menu statsArray = new Menu("2D Array Statistics");
		array2D.add(statsArray);
		
		MenuItem minArray = new MenuItem("2D Array Minimum");
		minArray.addActionListener(this);
		statsArray.add(minArray);
		
		MenuItem maxArray = new MenuItem("2D Array Maximum");
		maxArray.addActionListener(this);
		statsArray.add(maxArray);
		
		MenuItem aveArray = new MenuItem("2D Array Average");
		aveArray.addActionListener(this);
		statsArray.add(aveArray);
		
		MenuItem searchArray = new MenuItem("Search 2D Array");
		searchArray.addActionListener(this);
		array2D.add(searchArray);
	
	
		// End program when window is closed
		
				WindowListener l = new WindowAdapter()
		{
						
			// window closed - exit program						
						public void windowClosing(WindowEvent ev)
						{
							System.exit(0);
						}
						// menu option selected - go to redraw and display method
						public void listener(WindowEvent ev)
						{
							repaint();
						}
						// window resized or refocused - redraw
						public void windowStateChanged(WindowEvent ev)
						{
							repaint();
						}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			// take action accordingly
			if("About".equals(command))
			{
				
				repaint();
			}
			else
			if("Exit".equals(command))
			{
				System.exit(0);
			}
			else
				
			//one-dimensional
				
			if("Create Array".equals(command))
			{
				originalArray = new OneDArray();
				originalArray.createArray();
				
				repaint();
			}
			else
			if("Array Minimum".equals(command))   
			   
				{
					
					repaint();
				}
			else
				if("Array Maximum".equals(command))   
					   
				{
					
					repaint();
				}
			else
				if("Array Average".equals(command))   
					   
				{
					
					repaint();
				}
			else
			if("Sort Array".equals(command))
			{
				originalCopy = originalArray.sort();
				repaint();
			}
			else
			if("Search Array".equals(command))
			{
				
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
						"Search Key",JOptionPane.QUESTION_MESSAGE);
			    key = Integer.parseInt(input);
			    found = originalArray.search(key);
				repaint();
			}
	// Linked List Operations
			
			if("Create Linked List".equals(command))
			{
				originalList = new LinkedList();
				originalList.createList();
				
				repaint();
			}
			else
				if("Linked List Minimum".equals(command))   
					   
				{
					
					repaint();
				}
			else
				if("Linked List Maximum".equals(command))   
					   
				{
					
					repaint();
				}
			else
				if("Linked List Average".equals(command))   
					   
				{
					
					repaint();
				}
			else
				if("Beginning".equals(command))   
					   
				{
					String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to add to the beginning of the linked list:",
							"Add beginning",JOptionPane.QUESTION_MESSAGE);
				    value = Integer.parseInt(input);
				    repaint();
				}
			else
				if("End".equals(command))   
					   
				{
					String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to add to the end of the linked list:",
							"Add end",JOptionPane.QUESTION_MESSAGE);
				    value = Integer.parseInt(input);
					repaint();
					
				}
			else
				if("Sort List".equals(command))   
					   
				{
					
					repaint();
				}
			else

			if("Search List".equals(command))
			{
				
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
						"Search Key",JOptionPane.QUESTION_MESSAGE);
			    key = Integer.parseInt(input);
			    found = originalList.search(key);
				repaint();
			}
			
	//Two- dimensional array
			
			else
			if("Create 2D Array".equals(command))
			{
				original2DArray = new TwoDArray();
				original2DArray.createArray();
				
				repaint();
			}
			else
				if("2D Array Minimum".equals(command))   
					   
				{
					
					repaint();
				}
			else
				if("2D Array Maximum".equals(command))   
					   
				{
					
					repaint();
				}
			else
				if("2D Array Average".equals(command))   
					   
				{
					
					repaint();
				}
			else

			if("Search 2D Array".equals(command))
			{
				
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
						"Search Key",JOptionPane.QUESTION_MESSAGE);
			    key = Integer.parseInt(input);
			    found = original2DArray.search(key);
				repaint();
			}
		}
//********************************************************
// called by repaint() to redraw the screen
	
	 	//1D PAINT METHOD
		
		public void paint(Graphics g)
		{
			
			// Check Command issued, take action accordingly
			int ww = this.getWidth();
			
			g.setFont(f);
			
			if("About".equals(command))
			{
				g.setFont(f);
				g.drawString(" Lists and Arrays ",400, 100);
				g.drawLine (350,120, 550,120); //Going left or right STAYING in one place, Y's need to be the same value
				g.drawString(" This program displays One-Dimensional and Two-Dimensional arrays as well as Linked Lists. " , 200, 140);
				g.drawString(" The program will ask the user to input values to generate the arrays and lists. " , 200, 156);
				
				g.drawString(" You will be able to create a one-dimensional and two-dimensional arrays and linked lists,", 200, 200); //going up or down STAYING in one place, X's need to be the same value
				g.drawString(" also, finding the minimum, maximum and average of both arrays and lists. ", 200, 220);
				g.drawString(" You will also be able to sort linked lists and arrays. ", 200, 240);
				g.drawString(" All can be done using the menu bar to choose from the options provided.", 200, 260);
			}
			else
			if("Create Array".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
			}
			
			else
			if("Array Minimum".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Minimum = "+Integer.toString(originalArray.getMinimum()), ww/2-50, currentY+25);
					
			}
			else
			if("Array Maximum".equals(command))
				{
					int x=100;
					int y = 100;
					int[] t = originalArray.getArray();
					int currentY = displayArray(g,t,x,y,ww,"Original Array");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Maximum = "+Integer.toString(originalArray.getMaximum()), ww/2-50, currentY+25);
						
				}
				else
				if("Array Average".equals(command))
				{
					int x=100;
					int y = 100;
					int[] t = originalArray.getArray();
					int currentY = displayArray(g,t,x,y,ww,"Original Array");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Average = "+Double.toString(originalArray.getAverage()), ww/2-50, currentY+25);
						
				}
				else
			if("Sort Array".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				originalArray.sort();
				t = originalArray.getArray(); 
				currentY = displayArray(g,t,x,currentY+100,ww,"Sorted Array");
			}
			else
			if("Search Array".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				found = originalArray.search(key);
				String f;
				if(found)
				{
					f = "Found";
				}
				else {
					f= "Not found";
				}
				g.drawString("Search Key = "+key+" "+f, ww/2-50, currentY+25);			
				
			}
			
		// Linked List Paint method
			
			if("Create Linked List".equals(command))
			{	
				int x=100;
				int y = 100;
				int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
			}
			else
				if("Linked List Minimum".equals(command))   
					   
				{
					int x=100;
					int y = 100;
					int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Minimum = "+Integer.toString(originalList.getMinimum()), ww/2-40, currentY+35);
					
				}
			else
				if("Linked List Maximum".equals(command))   
					   
				{
					int x=100;
					int y = 100;
					int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Maximum = "+Integer.toString(originalList.getMaximum()), ww/2-40, currentY+35);
					
				}
			else
				if("Linked List Average".equals(command))   
					   
				{
					int x=100;
					int y = 100;
					int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Average = "+Double.toString(originalList.getAverage()), ww/2-40, currentY+35);
					
				}
			else
				if("Beginning".equals(command))   			   
				{
					int x=100;
					int y = 100;
					int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Add to beginning = "+Integer.toString(value), ww/2-40, currentY+35);
					originalList.addBeginning(value);
					currentY = displayList(g,originalList,x,currentY+100,ww,"New Linked List");
					
				}
			else
				if("End".equals(command))   			   
				{
					int x=100;
					int y = 100;
					int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Add to end = "+Integer.toString(value), ww/2-40, currentY+35);
					originalList.addEnd(value);
					currentY = displayList(g,originalList,x,currentY+100,ww,"New Linked List");
				}
			else
				if("Sort List".equals(command))   
					   
				{
					int x=100;
					int y = 100;
					int currentY = displayList(g,originalList,x,y,ww,"Original Linked List");
					g.setFont(f1);
					g.setColor(Color.RED);
					originalList.sort();
					currentY = displayList(g,originalList,x,currentY+100,ww,"Sorted Linked List");
				}
			else
				
			if("Search List".equals(command))
			{
				int x=100;
				int y = 100;
				int currentY = displayList(g,originalList,x,y,ww," Original Linked List");
			
				g.setFont(f1);
				g.setColor(Color.RED);
				found = originalList.search(key);
				String f;
				if(found)
				{
					f = "Found";
				}
				else {
					f= "Not found";
				}
				g.drawString("Search Key = "+key+" "+f, ww/2-100, currentY+25);
				
			}
//*********************************************************************************************************************
	
			//2D ARRAY PAINT METHOD
			
			else
				if("Create 2D Array".equals(command))
				{
					
					int[][] t = original2DArray.getArray();
					int x=100;
					int y = 100;
					int currentY = display2DArray(g,t,x,y,ww,"Original Array");
				}
				else
					if("2D Array Minimum".equals(command))   
						   
					{
						int[][] t = original2DArray.getArray();
						int x=100;
						int y = 100;
						int currentY = display2DArray(g,t,x,y,ww,"Original Array");
						g.setFont(f1);
						g.setColor(Color.RED);
						g.drawString("Minimum = "+Integer.toString(original2DArray.getMinimum()), ww/2-50, currentY+25);
						
					}
				else
					if("2D Array Maximum".equals(command))   
						   
					{
						int[][] t = original2DArray.getArray();
						int x=100;
						int y = 100;
						int currentY = display2DArray(g,t,x,y,ww,"Original Array");
						g.setFont(f1);
						g.setColor(Color.RED);
						g.drawString("Maximum = "+Integer.toString(original2DArray.getMaximum()), ww/2-50, currentY+25);
						
					}
				else
					if("2D Array Average".equals(command))   
						   
					{
						int[][] t = original2DArray.getArray();
						int x=100;
						int y = 100;
						int currentY = display2DArray(g,t,x,y,ww,"Original Array");
						g.setFont(f1);
						g.setColor(Color.RED);
						g.drawString("Average = "+Double.toString(original2DArray.getAverage()), ww/2-70, currentY+15);
						
					}
				else

				if("Search 2D Array".equals(command))
				{
					int[][] t = original2DArray.getArray();
					int x=100;
					int y = 100;
					int currentY = display2DArray(g,t,x,y,ww,"Original Array");
				
					g.setFont(f1);
					g.setColor(Color.RED);
					found = original2DArray.search(key);
					String f;
					if(found)
					{
						f = "Found";
					}
					else {
						f= "Not found";
					}
					g.drawString("Search Key = "+key+" "+f, ww/2-100, currentY+25);
					
				}
		}
		
		//Display 1D Array
		
		public int displayArray(Graphics g, int[] a, int x, int y, int ww, String title)
		{
			g.setFont(f1);
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50,y-25);
			g.setFont(f);
			g.setColor(Color.BLACK);
			int xs = x;
			for (int i=0; i<a.length; i++)
			{
				g.drawString(Integer.toString(a[i]),xs,y);
				xs = xs + 35;
				if (xs > ww-100)
				{
					y = y + 20;
					xs = x;
				}
			}
			return y;
		}
		
		// display linked list
		
		public int displayList(Graphics g, LinkedList l, int x, int y, int ww, String title)
		{
			
			Node t = l.getHead();
			g.setFont(f1);
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50,y-25);
			g.setFont(f);
			g.setColor(Color.BLACK);
			int xs = x;
			while ( t != null)
			{
				g.drawString(Integer.toString(t.getData()),xs,y);
				g.drawRect(xs-8, y-14, 40, 20);
				g.drawLine(xs+32, y-4, xs+52, y-4);
				//For straight lines y must be the same
				g.drawLine(xs+44, y-8, xs+52, y-4); //arrow line 1
				g.drawLine(xs+44, y, xs+52, y-4); //arrow line 2
				if (xs > ww-160)
				{
					xs = x;
					y += 30;
				}
				else
				{
					xs = xs += 60;
				}
				
				t = t.getNext();
			}
			
			g.drawString("End", xs, y);
			
			return y;
		}
		
		//display 2d array 
		
		public int display2DArray(Graphics g, int[][]a, int x, int y, int ww, String title)
		{
			g.setFont(f1);
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50,y-25);
			g.setFont(f);
			g.setColor(Color.BLACK);
			
			for (int i=0; i<a.length; i++)
			{
				int xs = ww/2 - (a[i].length/2)*25;
				for(int j=0; j<a[i].length;j++)
				{
					g.drawString(Integer.toString(a[i][j]),xs,y);
					xs = xs + 25;
				}
					y = y + 20;
			}
			return y;
		}
	}