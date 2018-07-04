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
		XYSeries series  = new XYSeries("A");
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
		series.add(1, 1);
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
		
		/*datos.addValue(1, "Negocio", "Lunes");
		datos.addValue(2, "Negocio", "Martes");
		datos.addValue(3, "Negocio", "Miercoles");
		datos.addValue(4, "Negocio", "Jueves");
		datos.addValue(5, "Negocio", "Viernes");
		datos.addValue(6, "Negocio", "Sabado");
		datos.addValue(7, "Negocio1", "Domingo");		
		grafica = ChartFactory.createBarChart("Visitas Diarias", "Dias", "Visitas",datos, PlotOrientation.VERTICAL, true, true, false);*/
		
		
	}
}

