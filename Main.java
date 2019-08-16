package source;
import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main
{
	
	public static void main(String[] args)
	{
		
		Scanner entrada = new Scanner(System.in);
		int linhas =0;
		float x = 0.00f;
		float x1 = 0.00f;
		float x2 = 0.00f;
		float mo = 0.00f;
		float med = 0.00f;
		float s = 0.00f;
		float vmp1 = 0.00f;
		float vmp2 = 0.00f;
		float ic1 = 0.00f;
		float ic2 = 0.00f;
		float c = 0.00f;
		float as = 0.00f;
		float z = 1.645f;
		float licm = 0.00f;
		float hcm = 0.00f;
		float nraiz = 0.00f;
		int n = 0;
		int tab2 = 0;
		float mf = 0.00f;
		int tmf1 = 0;
		int tmf2 = 0;
		String mg = "s";
		
		System.out.println("Para inserir os dados para calculo primeiro defina o numero linhas da tabela.");
		System.out.print("Digite o numero de linhas:");
		linhas = entrada.nextInt();
		
		
		float tabela[][] = new float[8][linhas];
		
		for (int tab1 = 0; tab1 < 2; tab1++) 
		{
			
			for (tab2 = 0; tab2 < tabela[tab1].length; tab2++) 
			{
				System.out.print("Digite o " + (tab2+1) + "º valor da tabela" + (tab1+1) + ": ");
				tabela[tab1][tab2] = entrada.nextFloat();
				 
				
			}
			
			if(tab1==1)	
			{
				hcm=tabela[1][0]-tabela[0][0];
				for (tab2 = 0; tab2 < tabela[tab1].length; tab2++) 
				{
					tab1=2;	
					System.out.print("Digite a frequencia: ");
					tabela[tab1][tab2] = entrada.nextInt();
					n+=tabela[tab1][tab2];
				
					
				if(mf==0 && mf<tabela[tab1][tab2])
				{
					mf=tabela[tab1][tab2];
					tmf1=tab1;
					tmf2=tab2;
					
					
				}
					
				if(tab2==linhas-1)
				{
					tab2=0;
					System.out.println("n="+n);
					System.out.println("hcm="+hcm);
					
					
					for (tab2 = 0; tab2 < tabela[tab1].length; tab2++) 
					{
						
						tabela[3][tab2]=(tabela[0][tab2]+tabela[1][tab2])/2;
						
						x1+=tabela[2][tab2];
						tabela[4][tab2]=x1;
						
						if(tab2==linhas-1)
						{
							tab2=0;
							licm=tabela[tab1+1][tab2];
							System.out.println("licm="+licm);
							for (tab2 = 0; tab2 < tabela[tab1].length; tab2++) 
							{
								x+=tabela[3][tab2]*tabela[2][tab2];
																								
								if(tab2==linhas-1)
								{
									x=x/n;
									tab2=0;
									System.out.println("x="+x);
									for (tab2 = 0; tab2 < tabela[tab1].length; tab2++)
									{
										tabela[5][tab2]=(tabela[3][tab2]-x);
										
										if(tab2==linhas-1)
										{
											tab2=0;
											for (tab2 = 0; tab2 < tabela[tab1].length; tab2++)
											{
												tabela[6][tab2]=(tabela[5][tab2]*tabela[5][tab2]);
												
												if(tab2==linhas-1)
												{
													tab2=0;
													for (tab2 = 0; tab2 < tabela[tab1].length; tab2++)
													{
														tabela[7][tab2]=(tabela[6][tab2]*tabela[6][tab2]);
														
														if(tab2==linhas-1)
														{
															if(tmf2==0)
															{
																med= licm+(((n/2)*hcm)/tabela[tmf1][tmf2]);               
																mo= licm+(((tabela[tmf1][tmf2])*hcm)/(2*tabela[tmf1][tmf2]-tabela[tmf1][tmf2+1]));
																System.out.printf("med= %.2f %n", med);
																System.out.printf("mo= %.2f %n", mo);
															}
															else
															{
																med= licm+((((n/2)-tabela[tmf1+1][tmf2-1])*hcm)/tabela[tmf1][tmf2]);               
																mo= licm+(((tabela[tmf1][tmf2]-tabela[tmf1][tmf2-1])*hcm)/(2*tabela[tmf1][tmf2]-tabela[tmf1][tmf2-1]-tabela[tmf1][tmf2+1]));
																System.out.printf("med= %.2f %n", med);
																System.out.printf("mo= %.2f %n", mo);
															}
															tab2=0;
															for (tab2 = 0; tab2 < tabela[tab1].length; tab2++)
															{
																x1+=tabela[6][tab2];
																x2+=tabela[7][tab2];
																
																if(tab2==linhas-1)
																{
																	x1=x1/(n-1);
																	s=(float) Math.sqrt(x1);
																	System.out.printf("s= %.2f %n", s);
																	c= (x2/(n*(s*s*s*s)));
																	System.out.printf("c= %.2f %n", c);
																	vmp1=x-s;
																	System.out.printf("vmp=- %.2f %n", vmp1);
																	vmp2=x+s;
																	System.out.printf("vmp=+ %.2f %n", vmp2);
																	nraiz=(float) Math.sqrt(n);
																	ic1=x+(z*(s/nraiz));
																	System.out.printf("ic=+ %.2f %n", ic1);
																	ic2=x-(z*(s/nraiz));
																	System.out.printf("ic=- %.2f %n", ic2);
																	as=(x-mo)/s;
																	System.out.printf("as= %.2f %n", as);
																	
																	tab2=0;
																	System.out.println("intervalo \tfrequencia \txk \tFac \t(xk-x)   \t(xk-x)² \t(xk-x)");
																	for (tab2 = 0; tab2 < tabela[tab1].length; tab2++)
																	{
																		System.out.println(tabela[0][tab2]+"-"+tabela[1][tab2]+"\t"+tabela[2][tab2]+"      "
																				+ "\t"+tabela[3][tab2]+"\t"+tabela[4][tab2]+"  \t"+tabela[5][tab2]+"    "
																						+ "\t"+tabela[6][tab2]+"\t"+tabela[7][tab2]+"");
																		
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}		
					}		
				}			
				}
			}
		}
	
		
		
		
		
	
		System.out.println("Deseja exibir o grafico?");
		System.out.print("Digite S para sim e N para não:");
		mg = entrada.next();
		

		
		entrada.close();
		switch(mg)
		{
		case "s":
		case "S":
		

			
		DefaultCategoryDataset dod = new DefaultCategoryDataset();
		dod.addValue(21.21125022, "nivel da água", "24/01/2019");
		dod.addValue(20.78567613, "nivel da água", "25/01/2019");
		dod.addValue(20.27651375, "nivel da água", "26/01/2019");
		dod.addValue(21.21125022, "nivel da água", "27/01/2019");
		dod.addValue(20.95576667, "nivel da água", "28/01/2019");
		dod.addValue(20.61577068, "nivel da água", "29/01/2019");
		dod.addValue(20.19181469, "nivel da água", "30/01/2019");
		dod.addValue(19.76900847, "nivel da água", "31/01/2019");
		dod.addValue(19.26315167, "nivel da água", "01/02/2019");
		dod.addValue(18.4236971, "nivel da água", "02/02/2019");
		dod.addValue(17.58875885, "nivel da água", "03/02/2019");
		dod.addValue(16.92403415, "nivel da água", "04/02/2019");
		dod.addValue(16.51002793, "nivel da água", "05/02/2019");
		dod.addValue(15.93227838, "nivel da água", "06/02/2019");
		dod.addValue(23.44307979, "nivel da água", "25/02/2019");
		dod.addValue(24.04941785, "nivel da água", "26/02/2019");
		dod.addValue(25.97037667, "nivel da água", "27/02/2019");
		dod.addValue(27.47089144, "nivel da água", "28/02/2019");
		dod.addValue(20.36125884, "nivel da água", "19/02/2019");
		dod.addValue(20.70070029, "nivel da água", "20/02/2019");
		dod.addValue(21.12604262, "nivel da água", "21/02/2019");
		dod.addValue(21.46715204, "nivel da água", "22/02/2019");
		dod.addValue(22.49496399, "nivel da água", "23/02/2019");
		dod.addValue(23.09764772, "nivel da água", "24/02/2019");
		dod.addValue(17.1729713, "nivel da água", "13/02/2019");
		dod.addValue(18.08918201, "nivel da água", "14/02/2019");
		dod.addValue(17.83876841, "nivel da água", "15/02/2019");
		dod.addValue(18.34000068, "nivel da água", "16/02/2019");
		dod.addValue(19.09489758, "nivel da água", "17/02/2019");
		dod.addValue(19.85347797, "nivel da água", "18/02/2019");
		dod.addValue(17.75538705, "nivel da água", "07/02/2019");
		dod.addValue(18.9268254, "nivel da água", "08/02/2019");
		dod.addValue(18.67505749, "nivel da água", "09/02/2019");
		dod.addValue(18.08918201, "nivel da água", "10/02/2019");
		dod.addValue(17.58875885, "nivel da água", "11/02/2019");
		dod.addValue(16.92403415, "nivel da água", "12/02/2019");
		dod.addValue(29.43398192, "nivel da água", "01/03/2019");
		dod.addValue(31.42145224, "nivel da água", "02/03/2019");
		dod.addValue(33.34172546, "nivel da água", "03/03/2019");
		dod.addValue(35.19191601, "nivel da água", "04/03/2019");
		dod.addValue(36.8751642, "nivel da água", "05/03/2019");
		dod.addValue(38.00695583, "nivel da água", "06/03/2019");
		dod.addValue(38.95605111, "nivel da água", "07/03/2019");
		dod.addValue(39.91057955, "nivel da água", "08/03/2019");
		dod.addValue(40.6781369, "nivel da água", "09/03/2019");
		dod.addValue(41.35263292, "nivel da água", "10/03/2019");
		dod.addValue(42.0298315, "nivel da água", "11/03/2019");
		dod.addValue(43.19706137, "nivel da água", "12/03/2019");
		dod.addValue(44.07774722, "nivel da água", "13/03/2019");
		dod.addValue(43.78368244, "nivel da água", "14/03/2019");
		dod.addValue(43.49012074, "nivel da água", "15/03/2019");
		dod.addValue(43.00196715, "nivel da água", "16/03/2019");
		dod.addValue(42.70974326, "nivel da água", "17/03/2019");
		dod.addValue(42.6124465, "nivel da água", "18/03/2019");
		dod.addValue(42.22381469, "nivel da água", "19/03/2019");
		dod.addValue(41.73927192, "nivel da água", "20/03/2019");
		dod.addValue(41.25611113, "nivel da água", "21/03/2019");
		dod.addValue(40.6781369, "nivel da água", "22/03/2019");
		dod.addValue(40.29391981, "nivel da água", "23/03/2019");
		dod.addValue(39.71923757, "nivel da água", "24/03/2019");
		dod.addValue(39.2418376, "nivel da água", "25/03/2019");
		dod.addValue(38.10162185, "nivel da água", "26/03/2019");
		dod.addValue(37.25156813, "nivel da água", "27/03/2019");
		dod.addValue(36.31216416, "nivel da água", "28/03/2019");
		dod.addValue(35.28497826, "nivel da água", "29/03/2019");
		dod.addValue(34.26419575, "nivel da água", "30/03/2019");
		dod.addValue(33.24976568, "nivel da água", "31/03/2019");
		
		JFreeChart LineChart = ChartFactory.createLineChart("Represa Cachoeira", 
														"Periodo em dias", 
														"Volume de água (em %)", 
														dod, PlotOrientation.VERTICAL, 
														true, true, false);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		ChartPanel linePanel = new ChartPanel(LineChart);
		
		panel.add(linePanel, BorderLayout.CENTER);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		frame.setBounds(0, 0, 875, 600);
		break;
		case "n":
		case "N":
			break;
		}
		
	}

}
