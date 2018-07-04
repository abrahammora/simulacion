import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.text.DefaultCaret;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafica {

	private JFrame frame;
	private JFreeChart grafica;
	DefaultCategoryDataset datos = new DefaultCategoryDataset();
	private RKCuarto RK;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica window = new Grafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Grafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		RK =  new RKCuarto();
		int n = 800;
		int m = 2;
		double a = 0;
		double b =200;				
		//Condiciones iniciales
		double[] alfa = {40,9};
		RK.setn(n);
		RK.setm(m);
		double[] aux = RK.valorx(a, b);
		RK.setx(aux);
		double[][] aux2 = RK.RungeKutta(a, b, alfa);
		
		XYSeries series  = new XYSeries("Presas");
		XYSeries depredador = new XYSeries("Depredadores");
		JButton btnGrafica = new JButton("Grafica");
		btnGrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChartPanel Panel = new ChartPanel(grafica);
				JFrame Ventana = new JFrame("JFreeChart");
				Ventana.getContentPane().add(Panel);
				Ventana.pack();
				Ventana.setVisible(true);
				Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnGrafica.setBounds(159, 112, 89, 23);
		frame.getContentPane().add(btnGrafica);
		for (int i = 0; i < aux.length; i++) {
			series.add(aux[i],aux2[i][0]);			
			depredador.add(aux[i],aux2[i][1]);
			//System.out.println(aux[i]);
		}
		
		  XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(depredador);
	        //dataset.addSeries(depredador);	        	        
	        grafica = ChartFactory.createXYLineChart(
	                "Presas", // Título
	                "Tiempo (x)", // Etiqueta Coordenada X
	                "Poblacion", // Etiqueta Coordenada Y
	                dataset, // Datos
	                PlotOrientation.VERTICAL,
	                true, // Muestra la leyenda de los productos (Producto A)
	                false,
	                false
	      );
	       
	     
		/*series.add(1, 1);
        series.add(2, 6);
        series.add(3, 3);
        series.add(4, 10);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        grafica = ChartFactory.createXYLineChart(
                "Ventas 2014", // Título
                "Tiempo (x)", // Etiqueta Coordenada X
                "Cantidad", // Etiqueta Coordenada Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Muestra la leyenda de los productos (Producto A)
                false,
                false
        );
		
		datos.addValue(1, "Negocio", "Lunes");
		datos.addValue(2, "Negocio", "Martes");
		datos.addValue(3, "Negocio", "Miercoles");
		datos.addValue(4, "Negocio", "Jueves");
		datos.addValue(5, "Negocio", "Viernes");
		datos.addValue(6, "Negocio", "Sabado");
		datos.addValue(7, "Negocio1", "Domingo");		
		grafica = ChartFactory.createBarChart("Visitas Diarias", "Dias", "Visitas",datos, PlotOrientation.VERTICAL, true, true, false);*/
		
		
	}
}

