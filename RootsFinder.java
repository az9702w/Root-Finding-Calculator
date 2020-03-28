import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;


public class RootsFinder extends JFrame implements ActionListener, KeyListener {


    JPanel pnl = new JPanel(new FlowLayout());

    JTextField New = new JTextField(100);


    //this method defines our first equation

    public static Double f(double x) {

        double f = (Double) (x - (x * x));


        return f;
    }

    //we need derivative for newton rawphson method
    //derivative of first equation is
    public static Double fd(double x) {

        double fd = (Double) (1 - 2 * x);


        return 1 - (2 * x);
    }

    // this method defines our second equation
    public static Double f1(double x) {
        double f1 = (Double) (Math.log(x + 1) + 1);
        return f1;
    }

    // this method defines derivative for second equation
    public static Double fd1(double x) {
        double fd1 = (Double) ((1 / (x + 1)));
        return fd1;
    }

    //this method defines our third equation
    public static Double f2(double x) {
        double f2 = (Double) (Math.exp(x) - 3 * x);
        return f2;
    }

    //this method defines derivative for our third equation
    public static Double fd2(double x) {
        double fd2 = (Double) (Math.exp(x) - 3);
        return fd2;
    }


    public static void main(String[] args) {
        RootsFinder rootfinder = new RootsFinder();
//        NewtonRawphson NR = new NewtonRawphson();
//        NR.newtonrawphson();
        rootfinder.GUI();
    }


    //this method creates a beautiful GUI for us
    public void GUI() {

        Font fnt = new Font("Georgia", Font.PLAIN, 30);

        JMenuBar MB = new JMenuBar();
        JMenu allmethods = new JMenu("Methods");
        //menu allmethods being created
        allmethods = new JMenu("Methods");

        allmethods.setToolTipText("Methods");
        allmethods.setFont(fnt);
        //menu items being added in menu allmethods
        allmethods.add(makemenuitem("Secant ", "method1", "method.", fnt));
        allmethods.add(makemenuitem("x-x^2", "equation1", "click me", fnt));
        allmethods.add(makemenuitem("ln(x+1)+1", "equation2", "click me", fnt));
        allmethods.add(makemenuitem("e^x-3x", "equation3", "click me", fnt));
        allmethods.addSeparator();
        allmethods.add(makemenuitem("Newton Rawphson", "method2", "method.", fnt));
        allmethods.add(makemenuitem("x-x^2", "NRequation1", "click me", fnt));
        allmethods.add(makemenuitem("ln(x+1)+1", "NRequation2", "click me", fnt));
        allmethods.add(makemenuitem("e^x-3x", "NRequation3", "click me", fnt));
        allmethods.addSeparator();
        allmethods.add(makemenuitem("Bisection", "method3", "method.", fnt));
        allmethods.add(makemenuitem("x-x^2", "Biequation1", "click me", fnt));
        allmethods.add(makemenuitem("ln(x+1)+1", "Biequation2", "click me", fnt));
        allmethods.add(makemenuitem("e^x-3x", "Biequation3", "click me", fnt));
        allmethods.addSeparator();
        allmethods.add(makemenuitem("False Position", "method4", "method", fnt));
        allmethods.add(makemenuitem("x-x^2", "FPequation1", "click me", fnt));
        allmethods.add(makemenuitem("ln(x+1)+1", "FPequation2", "click me", fnt));
        allmethods.add(makemenuitem("e^x-3x", "FPequation3", "click me", fnt));
        //menu being added in menubar
        MB.add(allmethods);
        MB.add(makemenuitem("Exit", "Exit", "Close this program", fnt));
        this.setJMenuBar(MB);

        JPanel left = new JPanel();

//        JTextArea userguide = new JTextArea(" Hello Dear User, Welcome to my application. " + "\n");
//        userguide.append("If you click on the left top on menu " + "Method" + " all the numerical methods with equations will be listed in front of you and you can click on any equation to find out " + "\n");
//        userguide.append("roots. You must always enter valid input which is double/integer .You will be asked again and again to enter a valid value till the time you don't put integer" + "\n ");
//        userguide.append("value." + "\n" + "\n");
//        userguide.append("Secant method:" + "\n" + "\n");
//        userguide.append("Secant method is a numerical finding algorithm. In this method you always choose two values as starting points. and after every successive iteration you get " + "\n");
//        userguide.append("closer to root. Secant method does not always converges." + "\n" + "\n" + "              Formula: x3 = (x1 * fx2 - x2 * fx1)\n" +
//                "                        / (fx2 - fx1))" + "\n" + "\n");
//        userguide.append("Newton Rawphson method:" + "\n" + "\n");
//        userguide.append("Newton method is another root finding method.This method converges to its root at quite fast rate. This method works on a principle of differentiation. In " + "\n");
//        userguide.append("which we have to find derivative of function as well." + "\n" + "\n" + "              Formula: fx1 =x0-f(x0)/f'(x0)" + "\n" + "\n");
//
//        userguide.append("Bisection method:" + "\n" + "\n");
//        userguide.append("Bisection method is another numerical finding algorithm. Like secant,  this method always asks you to choose two values as starting points.This method " + "\n");
//        userguide.append("does not converge to root quickly." + "\n" + "\n");
//        userguide.append("              Formula:  x1+x2/2" + "\n" + "\n");
//
//        userguide.append("False position method:" + "\n" + "\n");
//        userguide.append("Like newton method this method has good convergence rate . In this method you always choose two values as starting points. This method is also known as  " + "\n");
//        userguide.append(" rugla falsi method." + "\n" + "\n");
//        userguide.append("               Formula: c = ((a * fb) - (b * fa)) / (fb - fa)");
//        userguide.setFont(new Font("Verdana", Font.PLAIN, 18));
//        left.add(userguide);
//        userguide.setEditable(false);
//        add(BorderLayout.EAST, left);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Finding roots of equations using different numerical methods");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);  //to make GUI visible to our users


    }


    //method defined for making menu items.

    protected JMenuItem makemenuitem(String name,
                                     String actionCommand,
                                     String toolTipText,
                                     Font fnt) {

        JMenuItem methods = new JMenuItem();
        methods.setText(name);
        methods.setActionCommand(actionCommand);
        methods.setToolTipText(toolTipText);
        methods.setFont(fnt);
        methods.addActionListener(this);
        return methods;
    }

    //method for taking user's desire starting points
    public double askForInput() {

        double c = 0;
        boolean exceptionThrown = false;
        do {
            //try and catch for checking validity of input
            try {
                String input = JOptionPane.showInputDialog("Enter a valid value i.e double value: ");
                c = Double.parseDouble(input);
                exceptionThrown = false;
            } catch (NumberFormatException e) {
                exceptionThrown = true;
            } catch (NullPointerException e) {
                exceptionThrown = true;
            }

        } while (exceptionThrown);
        return c;
    }

    // calling method which checks decimal places for users choice
    public int decimalplaces() {
        int d = 0;
        boolean exceptionThrown = false;
        do {
            //try and catch for checking validity of input
            try {
                //storing decimals upto users choice of number
                String decimal = JOptionPane.showInputDialog("Upto how many decimal places: ");
                d = Integer.parseInt(decimal);
                exceptionThrown = false;
            } catch (NumberFormatException e) {
                exceptionThrown = true;
            } catch (NullPointerException e) {
                exceptionThrown = true;
            }

        } while (exceptionThrown);
        return d;
    }


    @Override

    public void actionPerformed(ActionEvent e) {
//click on exit menu to exit program
        if ("Exit".equals(e.getActionCommand())) {
            System.exit(0);
        }

        //when user clicks first equation under secant method i.e (x -x^2) then roots will be find out by secant method
        if ("equation1".equals(e.getActionCommand())) {

            //calling askForInput method on x1 and x2. .
            double x1 = askForInput();
            double x2 = askForInput();
            double x3 = 0;

            //storing user input an array
            double[] userinput = {x1, x2};
            double fx1;
            double fx2;
            double fx3;


            //storing x1,x2,fx1,fx2 in array
            double[] x = new double[100];
            double[] fx = new double[100];
            //text area where the result is displayed
            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JPanel graph = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);


            //storing decimals upto users choice of number
            int decimal = decimalplaces();

            TA.append("Method: Secant " + "    " + "Function: x-x^2 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            int iteration = 0;
            int i = 0;
            double diff = 0;
            do {

                iteration = iteration + 1;
                fx1 = x1 - (x1 * x1);
                fx2 = x2 - (x2 * x2);

                //we are finding x3 using secant method formula
                x3 = ((x1 * fx2) - (x2 * fx1))//x
                        / (fx2 - fx1);

                fx3 = x3 - (x3 * x3);//y
                //storing x3 in array x,fx in an array
                x[i] = x3;
                fx[i] = fx3;
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is x3 = " + x3);

                String decimalFormatting = "%." + decimal + "f";

                //showing roots in from table and up to users choice of decimal places
                if (decimal >= 1 && decimal < 10) {
                    TA.append("x1= " + String.format(decimalFormatting, x1) + "       " + "fx1 = " + String.format(decimalFormatting, fx1) + "    ");
                    TA.append("x2= " + String.format(decimalFormatting, x2) + "       " + "fx2 = " + String.format(decimalFormatting, fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format(decimalFormatting, x3) + "\n");

                } else {
                    TA.append("fx1 = " + String.format("%.1f", fx1) + "     ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }


                diff = Math.abs(x3 - x1);
                //this is top make sure when denominater becomes zero program terminates
                if (fx1 == fx2) {
                    JOptionPane.showMessageDialog(null, " Solution not possible , because denominater becomes zero");
                    break;
                }
                x2 = x1;
                x1 = x3;

                i++;


            } while (diff > 0.00001);
            //if x3 is giving infinity value
            if (x3 == Double.POSITIVE_INFINITY || x3 == Double.NEGATIVE_INFINITY) {


                JOptionPane.showMessageDialog(null, "Root impossible");
            } else {

                if ((decimal == 1)) {

                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                } else if (decimal == 2) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                } else if (decimal == 3) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                } else if (decimal == 4) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                } else if (decimal == 5) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                } else if (decimal == 6) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                } else if (decimal == 7) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                }
            }
            //  JFrame cc = new JFrame();

            // Create a simple XY chart
            XYSeries series = new XYSeries("XYGraph");
            i = 0;
            while (x[i] != 0) {
                //plotting xy on graph
                series.add(x[i], fx[i]);
                i++;
            }


            // Add the series to your data set
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            // Generate the graph
            JFreeChart Chart = ChartFactory.createXYLineChart(
                    "Secant method Graph", // Title
                    "x1", // x-axis Label
                    "x2", // y-axis Label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot Orientation
                    true, // Show Legend
                    true, // Use tooltips
                    false // Configure chart to generate URLs?
            );

            ChartPanel chartPanel = new ChartPanel(Chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);

            results.add(BorderLayout.EAST, chartPanel);

            graph.add(chartPanel);

            XYPlot plot = Chart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
            results.add(graph);
            add(BorderLayout.WEST, MB);
            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);


        }

        //when user clicks second  equation under secant method i.e (ln(x+1)+1) then roots will be find out by secant method

        if ("equation2".equals(e.getActionCommand())) {
            //calling askForInput method on x1 and x2. Remember c and d are x1 and x2 in mathematical term.
            double x1 = askForInput();
            double x2 = askForInput();
            double x3 = 0;
            double fx3;
            double fx1;
            double fx2;

            //storing user input an array
            double[] userinput = {x1, x2};
            //storing x1,x2,fx1,fx2 in array
            double[] x = new double[100];
            double[] fx = new double[100];

            //text area where the result is displayed
            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JPanel graph = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);

            //storing decimals upto users choice of number
            int decimal = decimalplaces();
            TA.append("Method: Secant " + "    " + "Function: ln(x+1)+1 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");


            int iteration = 0;
            int i = 0;
            double diff = 0;
            do {

                iteration = iteration + 1;
                fx1 = (Math.log(x1 + 1) + 1);
                fx2 = (Math.log(x2 + 1) + 1);

                //we are finding x3 here using secant method formula

                x3 = ((x1 * fx2) - (x2 * fx1))
                        / (fx2 - fx1);

                fx3 = (Math.log(x3 + 1) + 1);
                //storing x3's in array x
                x[i] = x3;
                fx[i] = fx3;
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + x3);


                String decimalFormatting = "%." + decimal + "f";

                //showing roots in from table and up to users choice of decimal places
                if (decimal >= 1 && decimal < 10) {
                    TA.append("x1= " + String.format(decimalFormatting, x1) + "       " + "fx1 = " + String.format(decimalFormatting, fx1) + "    ");
                    TA.append("x2= " + String.format(decimalFormatting, x2) + "       " + "fx2 = " + String.format(decimalFormatting, fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format(decimalFormatting, x3) + "\n");

                } else {
                    TA.append("fx1 = " + String.format(decimalFormatting, fx1) + "     ");
                    TA.append("fx2 = " + String.format(decimalFormatting, fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }

                diff = Math.abs(x3 - x1);
                if (fx1 == fx2) {
                    JOptionPane.showMessageDialog(null, " Solution not possible , because denominater becomes zero");
                    break;
                }

                x2 = x1;
                x1 = x3;


                i++;


            } while (diff > 0.000001);
            if (x3 == Double.POSITIVE_INFINITY || x3 == Double.NEGATIVE_INFINITY) {


                JOptionPane.showMessageDialog(null, "Root impossible");
            } else {

                if ((decimal == 1)) {

                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                } else if (decimal == 2) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                } else if (decimal == 3) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                } else if (decimal == 4) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                } else if (decimal == 5) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                } else if (decimal == 6) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                } else if (decimal == 7) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                }
            }


            // Create a simple XY chart
            XYSeries series = new XYSeries("XYGraph");
            i = 0;
            while (x[i] != 0) {

                series.add(x[i], fx[i]);
                i++;
            }


            // Add the series to your data set
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            // Generate the graph
            JFreeChart Chart = ChartFactory.createXYLineChart(
                    "Secant method Graph", // Title
                    "x1", // x-axis Label
                    "x2", // y-axis Label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot Orientation
                    true, // Show Legend
                    true, // Use tooltips
                    false // Configure chart to generate URLs?
            );

            ChartPanel chartPanel = new ChartPanel(Chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);

            results.add(BorderLayout.EAST, chartPanel);

            graph.add(chartPanel);

            XYPlot plot = Chart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
            results.add(graph);
            add(BorderLayout.WEST, MB);
            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);


        }


        //when user clicks third equation i.e e^x-3x under secant method roots will be find out by using third equation equation
        if ("equation3".equals(e.getActionCommand())) {
            //calling askForInput method on x1 and x2. .
            double x1 = askForInput();
            double x2 = askForInput();
            double x3 = 0;

            double fx1;
            double fx2;
            double fx3;

            //storing user input an array
            double[] userinput = {x1, x2};
            //storing x1,x2,fx1,fx2 in array
            double[] x = new double[100];
            double[] fx = new double[100];
            //text area where the result is displayed
            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JPanel graph = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);

            //taking decimal places up to users choice
            int decimal = decimalplaces();
            TA.append("Method: Secant " + "    " + "Function: e^x-3x " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            int iteration = 0;
            int i = 0;
            double diff = 0;

            do {

                iteration = iteration + 1;
                fx1 = Math.exp(x1) - 3 * x1;
                fx2 = Math.exp(x2) - 3 * x2;

                //we are finding x3 here using secant method formula
                x3 = ((x1 * fx2) - (x2 * fx1))
                        / (fx2 - fx1);

                fx3 = Math.exp(x3) - 3 * x3;
                //storing x3's in array x
                x[i] = x3;
                fx[i] = fx3;

                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + x3);


                //showing roots in from table and up to users choice of decimal places
                String decimalFormatting = "%." + decimal + "f";

                //showing roots in from table and up to users choice of decimal places
                if (decimal >= 1 && decimal < 10) {
                    TA.append("x1= " + String.format(decimalFormatting, x1) + "       " + "fx1 = " + String.format(decimalFormatting, fx1) + "    ");
                    TA.append("x2= " + String.format(decimalFormatting, x2) + "       " + "fx2 = " + String.format(decimalFormatting, fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format(decimalFormatting, x3) + "\n");

                } else {
                    TA.append("fx1 = " + String.format(decimalFormatting, fx1) + "     ");
                    TA.append("fx2 = " + String.format(decimalFormatting, fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }

                diff = Math.abs(x3 - x1);
                if (fx1 <= 0 || fx2 <= 0) {
                    TA.append("ln of any -ve number or 0 gives math error.");
                    break;
                } else if (fx1 == fx2) {
                    JOptionPane.showMessageDialog(null, " Solution not possible , because denominater becomes zero");
                    break;
                }
                x2 = x1;
                x1 = x3;
                i++;


            } while (diff > 0.000001);
            if (x3 == Double.POSITIVE_INFINITY || x3 == Double.NEGATIVE_INFINITY) {


                JOptionPane.showMessageDialog(null, "Root impossible");
            } else {

                if ((decimal == 1)) {

                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                } else if (decimal == 2) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                } else if (decimal == 3) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                } else if (decimal == 4) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                } else if (decimal == 5) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                } else if (decimal == 6) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                } else if (decimal == 7) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                }
            }
            // Create a simple XY chart
            XYSeries series = new XYSeries("XYGraph");
            i = 0;
            while (x[i] != 0) {

                series.add(x[i], fx[i]);
                i++;
            }


            // Add the series to your data set
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            // Generate the graph
            JFreeChart Chart = ChartFactory.createXYLineChart(
                    "Secant method Graph", // Title
                    "x", // x-axis Label
                    "fx", // y-axis Label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot Orientation
                    true, // Show Legend
                    true, // Use tooltips
                    false // Configure chart to generate URLs?
            );

            ChartPanel chartPanel = new ChartPanel(Chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);

            results.add(BorderLayout.EAST, chartPanel);

            graph.add(chartPanel);

            XYPlot plot = Chart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
            results.add(graph);
            add(BorderLayout.WEST, MB);
            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);
        }

        //when user clicks first equation under newton method that is x - x^2 then  roots will be find out by using rawphson method
        if ("NRequation1".equals(e.getActionCommand())) {

            //creating linkedlist
            LinkedList<Double> listeq1 = new LinkedList<Double>();
            double x1 = askForInput();
            double x2 = 0;

            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);
            results.add(MB);
            add(BorderLayout.NORTH, MB);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);

            //storing decimals upto users choice of number
            int decimal = decimalplaces();
            TA.append("Method: Newton Rahpson " + "    " + "Function: x-x^2 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");
            ;

            int iteration = 0;
            double diff = 0;
            do {

                //storing elements in linked list
                listeq1.add(x1);
                listeq1.add(x2);
                iteration = iteration + 1;
                //newton-rawphson method formula
                x2 = x1 - f(x1) / fd(x1);

                String decimalFormatting = "%." + decimal + "f";

                //showing roots in from table and up to users choice of decimal places
                if (decimal >= 1 && decimal < 10) {
                    TA.append("x1 = " + String.format(decimalFormatting, x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format(decimalFormatting, x2) + "\n");
                }

                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + x2);

                diff = Math.abs(x2 - x1);
                x1 = x2;

                if (x2 == Double.POSITIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                } else if (x2 == Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                } else if (x2 == Double.NEGATIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                }

            } while (diff > 0.000001);
            // storing root in a linkedlist
            listeq1.add(x2);
            if ((decimal == 1 && !(fd(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x2, "Abd"));
            } else if ((decimal == 2 && !(fd(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x2));
            } else if ((decimal == 3 && !(fd(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x2));
            } else if (((decimal == 4 && !(fd(x1) == 0)))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x2));
            } else if ((decimal == 5 && !(fd(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x2));
            } else if ((decimal == 6 && !(fd(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x2));
            } else if ((decimal == 7 && !(fd(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x2));
            }

        }

        //when user clicks second  equation under newton method that is ln(x+1)+1 then  roots will be find out by using rawphson method
        if ("NRequation2".equals(e.getActionCommand())) {

            //creating linkedlist
            LinkedList<Double> listeq2 = new LinkedList<Double>();
            double x1 = askForInput();

            // initializing x2 because we will find out x2 using newton-rawphson method formula
            double x2 = 0;

            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);
            results.add(MB);
            add(BorderLayout.NORTH, MB);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: Newton Rahpson " + "    " + "Function: ln(x+1)+1 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            int iteration = 0;
            double diff = 0;
            do {
                //storing elements in linked list
                listeq2.add(x1);
                listeq2.add(x2);
                iteration = iteration + 1;
                //newton-rawphson method formula
                x2 = x1 - f1(x1) / fd1(x1);


                if (decimal == 1) {
                    TA.append("x1 = " + String.format("%.1f", x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x2) + "\n");
                } else if (decimal == 2) {
                    TA.append("x1 = " + String.format("%.2f", x1) + "   ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x2) + "\n");
                } else if (decimal == 3) {
                    TA.append("x1 = " + String.format("%.3f", x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x2) + "\n");
                } else if (decimal == 4) {
                    TA.append("x1 = " + String.format("%.4f", x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x2) + "\n");
                } else if (decimal == 5) {
                    TA.append("x1 = " + String.format("%.5f", x1) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x2) + "\n");
                } else if (decimal == 6) {
                    TA.append("x1 = " + String.format("%.6f", x1) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x2) + "\n");
                } else {
                    TA.append("x1 = " + String.format("%.1f", x1) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x2) + "\n");
                }


                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + x2);


                diff = Math.abs(x2 - x1);

                if (x2 == Double.POSITIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                } else if (x2 == Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                } else if (x2 == Double.NEGATIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                }
                x1 = x2;

            } while (diff > 0.000001);
            //adding x2 in a linked list
            listeq2.add(x2);
            if ((decimal == 1)) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x2, "Abd"));
            } else if ((decimal == 2 && !(fd1(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x2));
            } else if ((decimal == 3 && !(fd1(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x2));
            } else if (((decimal == 4 && !(fd1(x1) == 0)))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x2));
            } else if ((decimal == 5 && !(fd1(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x2));
            } else if ((decimal == 6 && !(fd1(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x2));
            } else if ((decimal == 7 && !(fd1(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x2));
            }

        }

        //when user clicks third equation under newton method that is e^x-3x then  roots will be find out by using rawphson method
        if ("NRequation3".equals(e.getActionCommand())) {

            //creating linkedlist
            LinkedList<Double> listeq3 = new LinkedList<Double>();
            double x1 = askForInput();
            double x2 = 0;


            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);
            results.add(MB);
            add(BorderLayout.NORTH, MB);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: Newton Rahpson " + "    " + "Function: e^x-3x " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            int iteration = 0;
            double diff = 0;
            do {
                //storing elements in linked list
                listeq3.add(x1);
                listeq3.add(x2);
                iteration = iteration + 1;
                //newton-rawphson method formula
                x2 = x1 - f2(x1) / fd2(x1);
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + x2);
                //showing roots in from table
                //upto user choice of decimalplaces
                if (decimal == 1) {
                    TA.append("x1 = " + String.format("%.1f", x1) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x2) + "\n");
                } else if (decimal == 2) {
                    TA.append("x1 = " + String.format("%.2f", x1) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x2) + "\n");
                } else if (decimal == 3) {
                    TA.append("x1 = " + String.format("%.3f", x1) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x2) + "\n");
                } else if (decimal == 4) {
                    TA.append("x1 = " + String.format("%.4f", x1) + "   ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x2) + "\n");
                } else if (decimal == 5) {
                    TA.append("x1 = " + String.format("%.5f", x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x2) + "\n");
                } else if (decimal == 6) {
                    TA.append("x1 = " + String.format("%.6f", x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x2) + "\n");
                } else {
                    TA.append("x1 = " + String.format("%.1f", x1) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x2) + "\n");
                }
                diff = Math.abs(x2 - x1);
                if (x2 == Double.POSITIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                } else if (x2 == Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                } else if (x2 == Double.NEGATIVE_INFINITY) {
                    TA.append("Solution impossible because derivative of function is zero ");
                    break;
                }
                x1 = x2;


            } while (diff > 0.000001);
            listeq3.add(x2);
            if ((decimal == 1 && !(fd2(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x2));
            } else if ((decimal == 2 && !(fd2(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x2));
            } else if ((decimal == 3 && !(fd2(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x2));
            } else if (((decimal == 4 && !(fd2(x1) == 0)))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x2));
            } else if ((decimal == 5 && !(fd2(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x2));
            } else if ((decimal == 6 && !(fd2(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x2));
            } else if ((decimal == 7 && !(fd2(x1) == 0))) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x2));
            }


        }

        //when user clicks first equation under bisection method roots will be find out using bisection method.
        if ("Biequation1".equals(e.getActionCommand())) {
            double x1 = askForInput();
            double x2 = askForInput();
            double x3 = 0;

            double fx1;
            double fx2;
            double fx3;

            double[] userinput = {x1, x2};
            //storing x1,x2,fx1,fx2 in array
            double[] x = new double[100];
            double[] fx = new double[100];

            //text area where the result is displayed
            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JPanel graph = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);


            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: Bisection " + "    " + "Function: x-x^2 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            double difference = 0;
            int i = 0;
            int iteration = 0;
            do {

                iteration = iteration + 1;
                fx1 = x1 - ((x1 * x1));
                fx2 = x2 - ((x2 * x2));
                //Bisection  method formula
                x3 = (x1 + x2) / 2.0;
                fx3 = x3 - ((x3 * x3));
                //storing x3's in array x
                x[i] = x3;
                fx[i] = fx3;

                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + fx3);
                //showing roots in from table and up to users choice of decimal places
                if (decimal == 1) {

                    TA.append("x1= " + String.format("%.1f", x1) + "       " + "fx1 = " + String.format("%.1f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.1f", x2) + "       " + "fx2 = " + String.format("%.1f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                } else if (decimal == 2) {

                    TA.append("x1= " + String.format("%.2f", x1) + "       " + " fx1 = " + String.format("%.2f", fx1) + "     ");
                    TA.append("x2= " + String.format("%.2f", x2) + "       " + "fx2 = " + String.format("%.2f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x3) + "\n");
                } else if (decimal == 3) {

                    TA.append("x1= " + String.format("%.3f", x1) + "       " + "fx1 = " + String.format("%.3f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.3f", x2) + "       " + "fx2 = " + String.format("%.3f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x3) + "\n");
                } else if (decimal == 4) {

                    TA.append("x1= " + String.format("%.4f", x1) + "       " + "fx1 = " + String.format("%.4f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.4f", x2) + "       " + "fx2 = " + String.format("%.4f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x3) + "\n");
                } else if (decimal == 5) {

                    TA.append("x1= " + String.format("%.5f", x1) + "       " + "fx1 = " + String.format("%.5f", fx1) + "   ");
                    TA.append("x2= " + String.format("%.5f", x2) + "       " + "fx2 = " + String.format("%.5f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x3) + "\n");
                } else if (decimal == 6) {

                    TA.append("x1= " + String.format("%.6f", x1) + "       " + "fx1 = " + String.format("%.6f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.6f", x2) + "       " + "fx2 = " + String.format("%.6f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x3) + "\n");
                } else {

                    TA.append("fx1 = " + String.format("%.1f", fx1) + "     ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }
                difference = Math.abs(x2 - x1) / 2;
                if ((fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0) || (fx3 == 0)) {
                    TA.append(" Solution not possible , because fx1 and fx2 have same signs.");
                    break;
                } else if (fx1 * fx3 > 0) {
                    x1 = x3;
                    fx1 = fx3;
                } else if (fx2 * fx3 > 0) {
                    x2 = x3;
                    fx2 = fx3;
                }

                i++;

            } while (difference > 0.01);
            if (x3 == Double.POSITIVE_INFINITY || (fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0) || (fx3 == 0)) {


                JOptionPane.showMessageDialog(null, "Root impossible");
            } else {

                if ((decimal == 1)) {

                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                } else if (decimal == 2) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                } else if (decimal == 3) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                } else if (decimal == 4) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                } else if (decimal == 5) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                } else if (decimal == 6) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                } else if (decimal == 7) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                }
            }


            // Create a simple XY chart
            XYSeries series = new XYSeries("XYGraph");
            i = 0;
            while (x[i] != 0) {

                series.add(x[i], fx[i]);
                i++;
            }


            // Add the series to your data set
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            // Generate the graph
            JFreeChart Chart = ChartFactory.createXYLineChart(
                    "Bisection Graph for x-x^2", // Title
                    "x", // x-axis Label
                    "fx", // y-axis Label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot Orientation
                    true, // Show Legend
                    true, // Use tooltips
                    false // Configure chart to generate URLs?
            );

            ChartPanel chartPanel = new ChartPanel(Chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);

            results.add(BorderLayout.EAST, chartPanel);

            graph.add(chartPanel);

            XYPlot plot = Chart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
            results.add(graph);
            add(BorderLayout.WEST, MB);
            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);


        }

        //when user clicks second equation under bisection method roots will be find out using bisection method.
        if ("Biequation2".equals(e.getActionCommand())) {
            double x1 = askForInput();
            double x2 = askForInput();
            double x3 = 0;

            double fx1;
            double fx2;
            double fx3;

            double[] userinput = {x1, x2};
            //storing x1,x2,fx1,fx2 in array
            double[] x = new double[100];
            double[] fx = new double[100];

            //text area where the result is displayed
            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JPanel graph = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: Bisection " + "    " + "Function: ln(x+1)+1 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            double difference = 0;
            int i = 0;
            int iteration = 0;
            do {

                iteration = iteration + 1;
                //fx1 and fx2 being calculated.
                fx1 = Math.log(x1 + 1) + 1;
                fx2 = Math.log(x2 + 1) + 1;
                //Bisection  method formula
                x3 = (x1 + x2) / 2.0;

                fx3 = Math.log(x3 + 1) + 1;

                x[i] = x3;
                fx[i] = fx3;
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + x3);
                //if starting points are less than 0 anti log gives infinity value
                if (x1 < 0 || x2 < 0) {
                    TA.append("Math error, ln of any negative number gives math error.");
                    break;
                } else if ((fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0)) {
                    TA.append(" Solution not possible , because fx1 and fx2 have same signs.");
                    break;
                }
                //rounding decimals
                //showing roots in from table and up to users choice of decimal places
                if (decimal == 1) {

                    TA.append("x1= " + String.format("%.1f", x1) + "       " + "fx1 = " + String.format("%.1f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.1f", x2) + "       " + "fx2 = " + String.format("%.1f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                } else if (decimal == 2) {

                    TA.append("x1= " + String.format("%.2f", x1) + "       " + " fx1 = " + String.format("%.2f", fx1) + "     ");
                    TA.append("x2= " + String.format("%.2f", x2) + "       " + "fx2 = " + String.format("%.2f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x3) + "\n");
                } else if (decimal == 3) {

                    TA.append("x1= " + String.format("%.3f", x1) + "       " + "fx1 = " + String.format("%.3f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.3f", x2) + "       " + "fx2 = " + String.format("%.3f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x3) + "\n");
                } else if (decimal == 4) {

                    TA.append("x1= " + String.format("%.4f", x1) + "       " + "fx1 = " + String.format("%.4f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.4f", x2) + "       " + "fx2 = " + String.format("%.4f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x3) + "\n");
                } else if (decimal == 5) {

                    TA.append("x1= " + String.format("%.5f", x1) + "       " + "fx1 = " + String.format("%.5f", fx1) + "   ");
                    TA.append("x2= " + String.format("%.5f", x2) + "       " + "fx2 = " + String.format("%.5f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x3) + "\n");
                } else if (decimal == 6) {

                    TA.append("x1= " + String.format("%.6f", x1) + "       " + "fx1 = " + String.format("%.6f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.6f", x2) + "       " + "fx2 = " + String.format("%.6f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x3) + "\n");
                } else {

                    TA.append("fx1 = " + String.format("%.1f", fx1) + "     ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }

                difference = Math.abs(x2 - x1) / 2;
                if (fx1 * fx3 > 0) {
                    x1 = x3;
                    fx1 = fx3;
                } else if (fx2 * fx3 > 0) {
                    x2 = x3;
                    fx2 = fx3;
                }
                i++;


            } while (difference > 0.01);
            {
                if (x3 == Double.NEGATIVE_INFINITY || x3 == Double.POSITIVE_INFINITY) {
                    JOptionPane.showMessageDialog(null, "Root impossible");
                } else if (fx1 == Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY || fx2 == Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY) {
                    JOptionPane.showMessageDialog(null, "Root impossible");
                } else {
                    if ((decimal == 1)) {

                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                    } else if (decimal == 2) {
                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                    } else if (decimal == 3) {
                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                    } else if (decimal == 4) {
                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                    } else if (decimal == 5) {
                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                    } else if (decimal == 6) {
                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                    } else if (decimal == 7) {
                        TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                    }
                }
            }


            // Create a simple XY chart
            XYSeries series = new XYSeries("XYGraph");
            i = 0;
            while (x[i] != 0) {

                series.add(x[i], fx[i]);
                i++;
            }


            // Add the series to your data set
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            // Generate the graph
            JFreeChart Chart = ChartFactory.createXYLineChart(
                    "Bisection Graph for ln(x+1)+1", // Title
                    "x", // x-axis Label
                    "fx", // y-axis Label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot Orientation
                    true, // Show Legend
                    true, // Use tooltips
                    false // Configure chart to generate URLs?
            );

            ChartPanel chartPanel = new ChartPanel(Chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);

            results.add(BorderLayout.EAST, chartPanel);

            graph.add(chartPanel);

            XYPlot plot = Chart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
            results.add(graph);
            add(BorderLayout.WEST, MB);
            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);


        }
        //when user clicks third equation under bisection method roots will be find out using bisection method.
        if ("Biequation3".equals(e.getActionCommand())) {
            double x1 = askForInput();
            double x2 = askForInput();
            double x3 = 0;

            double fx1;
            double fx2;
            double fx3;

            double[] userinput = {x1, x2};
            //storing x1,x2,fx1,fx2 in array
            double[] x = new double[100];
            double[] fx = new double[100];

            //text area where the result is displayed
            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JPanel graph = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: Bisection " + "    " + "Function: e^x-3x " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");


            double difference = 0;
            int i = 0;
            int iteration = 0;
            do {

                iteration = iteration + 1;

                //fx1 and fx2 being calculated.
                fx1 = Math.exp(x1) - 3 * x1;
                fx2 = Math.exp(x2) - 3 * x2;
                //Bisection  method formula
                x3 = (x1 + x2) / 2.0;
                fx3 = Math.exp(x3) - 3 * x3;

                x[i] = x3;
                fx[i] = fx3;
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is " + fx3);

                //rounding decimals
                //showing roots in from table and up to users choice of decimal places
                if (decimal == 1) {

                    TA.append("x1= " + String.format("%.1f", x1) + "       " + "fx1 = " + String.format("%.1f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.1f", x2) + "       " + "fx2 = " + String.format("%.1f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                } else if (decimal == 2) {

                    TA.append("x1= " + String.format("%.2f", x1) + "       " + " fx1 = " + String.format("%.2f", fx1) + "     ");
                    TA.append("x2= " + String.format("%.2f", x2) + "       " + "fx2 = " + String.format("%.2f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x3) + "\n");
                } else if (decimal == 3) {

                    TA.append("x1= " + String.format("%.3f", x1) + "       " + "fx1 = " + String.format("%.3f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.3f", x2) + "       " + "fx2 = " + String.format("%.3f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x3) + "\n");
                } else if (decimal == 4) {

                    TA.append("x1= " + String.format("%.4f", x1) + "       " + "fx1 = " + String.format("%.4f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.4f", x2) + "       " + "fx2 = " + String.format("%.4f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x3) + "\n");
                } else if (decimal == 5) {

                    TA.append("x1= " + String.format("%.5f", x1) + "       " + "fx1 = " + String.format("%.5f", fx1) + "   ");
                    TA.append("x2= " + String.format("%.5f", x2) + "       " + "fx2 = " + String.format("%.5f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x3) + "\n");
                } else if (decimal == 6) {

                    TA.append("x1= " + String.format("%.6f", x1) + "       " + "fx1 = " + String.format("%.6f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.6f", x2) + "       " + "fx2 = " + String.format("%.6f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x3) + "\n");
                } else {

                    TA.append("fx1 = " + String.format("%.1f", fx1) + "     ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }
                difference = Math.abs(x2 - x1) / 2;
                if ((fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0) || (fx3 == 0)) {
                    TA.append(" Solution not possible , because fx1 and fx2 have same signs.");
                    break;
                } else if (fx1 * fx3 > 0) {
                    x1 = x3;
                    fx1 = fx3;
                } else if (fx2 * fx3 > 0) {
                    x2 = x3;
                    fx2 = fx3;
                }
                i++;


            } while (difference > 0.01);

            if (x3 == Double.NEGATIVE_INFINITY || x3 == Double.POSITIVE_INFINITY) {
                JOptionPane.showMessageDialog(null, "Root impossible");
            } else {
                if ((decimal == 1)) {

                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                } else if (decimal == 2) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                } else if (decimal == 3) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                } else if (decimal == 4) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                } else if (decimal == 5) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                } else if (decimal == 6) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                } else if (decimal == 7) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                }
            }
            // Create a simple XY chart
            XYSeries series = new XYSeries("XYGraph");
            i = 0;
            while (x[i] != 0) {

                series.add(x[i], fx[i]);
                i++;
            }

            // Add the series to your data set
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            // Generate the graph
            JFreeChart Chart = ChartFactory.createXYLineChart(
                    "Bisection Graph for e^x-3x", // Title
                    "x", // x-axis Label
                    "fx", // y-axis Label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot Orientation
                    true, // Show Legend
                    true, // Use tooltips
                    false // Configure chart to generate URLs?
            );

            ChartPanel chartPanel = new ChartPanel(Chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);

            results.add(BorderLayout.EAST, chartPanel);

            graph.add(chartPanel);

            XYPlot plot = Chart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
            results.add(graph);
            add(BorderLayout.WEST, MB);
            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);


        }
        //when user clicks first equation under false position method.roots will be find out using that equation
        if ("FPequation1".equals(e.getActionCommand())) {

            //creating linkedlist
            LinkedList<Double> x = new LinkedList<Double>();
            LinkedList<Double> y = new LinkedList<Double>();
            double x1 = askForInput();
            double x2 = askForInput();

            //x3 and x4 are f(x1) and f(x2) in formula
            double fx1 = 0;
            double fx2 = 0;
            double fx3;
            //adding x1,x2 to linkledlist
            x.add(x1);
            x.add(x2);
            y.add(fx1);
            y.add(fx2);

            // x will be calculated using false position method. After first iteration
            double x3;

            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);
            results.add(MB);
            add(BorderLayout.NORTH, MB);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: False position " + "    " + "Function: x-x^2 " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            double diff = 0;
            int iteration = 0;
            do {

                iteration = iteration + 1;
                fx1 = x1 - (x1 * x1);
                fx2 = x2 - (x2 * x2);
                //false position method formula
                x3 = ((x1 * fx2) - (x2 * fx1)) / (fx2 - fx1);
                JOptionPane.showMessageDialog(null, "x3 = " + x3);
                fx3 = x3 - (x3 * x3);
                x.add(x3);
                y.add(fx3);

                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is fx3 = " + fx3);

                //showing roots in from table and up to users choice of decimal places
                if (decimal == 1) {

                    TA.append("x1= " + String.format("%.1f", x1) + "       " + "fx1 = " + String.format("%.1f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.1f", x2) + "       " + "fx2 = " + String.format("%.1f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                } else if (decimal == 2) {

                    TA.append("x1= " + String.format("%.2f", x1) + "       " + " fx1 = " + String.format("%.2f", fx1) + "     ");
                    TA.append("x2= " + String.format("%.2f", x2) + "       " + "fx2 = " + String.format("%.2f", fx2) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x3) + "\n");
                } else if (decimal == 3) {

                    TA.append("x1= " + String.format("%.3f", x1) + "       " + "fx1 = " + String.format("%.3f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.3f", x2) + "       " + "fx2 = " + String.format("%.3f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x3) + "\n");
                } else if (decimal == 4) {

                    TA.append("x1= " + String.format("%.4f", x1) + "       " + "fx1 = " + String.format("%.4f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.4f", x2) + "       " + "fx2 = " + String.format("%.4f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x3) + "\n");
                } else if (decimal == 5) {

                    TA.append("x1= " + String.format("%.5f", x1) + "       " + "fx1 = " + String.format("%.5f", fx1) + "   ");
                    TA.append("x2= " + String.format("%.5f", x2) + "       " + "fx2 = " + String.format("%.5f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x3) + "\n");
                } else if (decimal == 6) {

                    TA.append("x1= " + String.format("%.6f", x1) + "       " + "fx1 = " + String.format("%.6f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.6f", x2) + "       " + "fx2 = " + String.format("%.6f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x3) + "\n");
                } else {

                    TA.append("fx1 = " + String.format("%.1f", fx1) + "     ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "     ");
                    TA.append("Approx for iteration " + iteration + " is " + (x3) + "\n");
                }
                diff = Math.abs(x3 - x1);
                if ((fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0) || (fx3 == 0)) {
                    TA.append(" Solution not possible , because fx1 and fx2 have same signs.");
                    break;
                }
                x2 = x1;
                x1 = x3;


            } while (diff > 0.001);
            if (fx2 - fx1 == 0) {
                JOptionPane.showMessageDialog(null, "Root Impossible");
            } else {

                if (decimal == 1) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
                } else if (decimal == 2) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
                } else if (decimal == 3) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
                } else if (decimal == 4) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
                } else if (decimal == 5) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
                } else if (decimal == 6) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
                } else if (decimal == 7) {
                    TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
                }
            }
//            // Create a simple XY chart
//            XYSeries series = new XYSeries("XYGraph");
//
//
//
//            // Add the series to your data set
//            XYSeriesCollection dataset = new XYSeriesCollection();
//            dataset.addSeries(series);
//            // Generate the graph
//            JFreeChart Chart = ChartFactory.createXYLineChart(
//                    "Bisection Graph for e^x-3x", // Title
//                    "x", // x-axis Label
//                    "fx", // y-axis Label
//                    dataset, // Dataset
//                    PlotOrientation.VERTICAL, // Plot Orientation
//                    true, // Show Legend
//                    true, // Use tooltips
//                    false // Configure chart to generate URLs?
//            );

//            ChartPanel chartPanel = new ChartPanel(Chart);
//            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//            chartPanel.setBackground(Color.white);
//
//            results.add(BorderLayout.EAST, chartPanel);
//
//            graph.add(chartPanel);

//            XYPlot plot = Chart.getXYPlot();
//            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//            renderer.setSeriesPaint(0, Color.RED);
//            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//            plot.setRenderer(renderer);

            results.pack();
            results.setTitle("Line chart");
            results.setLocationRelativeTo(null);
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setVisible(true);
            results.add(MB);
//            results.add(graph);
            add(BorderLayout.WEST, MB);
//            add(BorderLayout.EAST, graph);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);


        }

        //when user clicks second  equation under false position method.roots will be find out using that equation
        if ("FPequation2".equals(e.getActionCommand())) {

            //creating linkedlist
            LinkedList<Double> eq1 = new LinkedList<Double>();

            double x1 = askForInput();
            double x2 = askForInput();

            //x3 and x4 are f(x1) and f(x2) in formula
            double fx1 = 0;
            double fx2 = 0;
            double fx3 = 0;
            // c being root using false position method. After first iteration
            double x3 = 0;


            fx1 = Math.log(x1 + 1) + 1;
            fx2 = Math.log(x2 + 1) + 1;

            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);
            results.add(MB);
            add(BorderLayout.NORTH, MB);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: False position " + "    " + "Function:ln(x+1)+1" + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            double diff = 0;
            int iteration = 0;
            do {
                //adding x1,x2 to linkledlist
                eq1.add(x1);
                eq1.add(x2);
                eq1.add(fx1);
                eq1.add(fx2);
                eq1.add(x3);
                eq1.add(fx3);
                iteration = iteration + 1;
                //false position method formula
                x3 = ((x1 * fx2) - (x2 * fx1)) / (fx2 - fx1);

                fx3 = Math.log(x3 + 1) + 1;
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is fx3 = " + fx3);

                if (decimal == 1) {
                    //rounding decimals
                    TA.append("fx1= " + String.format("%.1f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "    ");

                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                } else if (decimal == 2) {
                    TA.append("fx1 = " + String.format("%.2f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.2f", fx2) + "    ");

                } else if (decimal == 3) {
                    TA.append("fx1 = " + String.format("%.3f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.3f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x3) + "\n");
                } else if (decimal == 4) {
                    TA.append("fx1 = " + String.format("%.4f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.4f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x3) + "\n");
                } else if (decimal == 5) {
                    TA.append("fx1 = " + String.format("%.5f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.5f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x3) + "\n");
                } else if (decimal == 6) {
                    TA.append("fx1 = " + String.format("%.6f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.6f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x3 + "\n"));
                } else {
                    TA.append("fx1 = " + String.format("%.1f", fx1) + "    ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "    ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                }
                diff = Math.abs(x3 - x1);
                if ((fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0) || (fx3 == 0)) {
                    TA.append(" Solution not possible , because fx1 and fx2 have same signs.");
                    break;
                }
                x2 = x1;
                x1 = x3;

            } while (diff > 0.001);
            eq1.add(x3);
            if (decimal == 1 && (fx1 < 0 || fx2 < 0)) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
            } else if (decimal == 2) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
            } else if (decimal == 3) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
            } else if (decimal == 4) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
            } else if (decimal == 5) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
            } else if (decimal == 6) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
            } else if (decimal == 7) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
            }

        }

        //when user clicks third  equation under false position method.roots will be find out using that equation
        if ("FPequation3".equals(e.getActionCommand())) {

            //creating linkedlist
            LinkedList<Double> eq1 = new LinkedList<Double>();

            double x1 = askForInput();
            double x2 = askForInput();

            //x3 and x4 are f(x1) and f(x2) in formula
            double fx1 = 0;
            double fx2 = 0;
            double fx3 = 0;
            // x being root using false position method. After first iteration
            double x3 = 0;


            JFrame results = new JFrame();
            JPanel MB = new JPanel();
            JTextArea TA = new JTextArea(50, 50);
            MB.add(TA);
            results.add(MB);
            add(BorderLayout.NORTH, MB);
            setTitle("RESULTS");
            TA.setEditable(false);
            setVisible(true);

            //storing decimals upto users choice of number
            double decimal = decimalplaces();
            TA.append("Method: False position " + "    " + "Function: e^x-3x " + "\n");
            TA.append("Decimal Places: " + decimal + "\n");

            double diff = 0;
            int iteration = 0;
            do {
                //adding x1,x2 to linkledlist
                eq1.add(x1);
                eq1.add(x2);
                eq1.add(fx1);
                eq1.add(fx2);
                eq1.add(x3);
                eq1.add(fx3);
                iteration = iteration + 1;
                //false position method formula
                fx1 = Math.exp(x1) - 3 * x1;
                fx2 = Math.exp(x2) - 3 * x2;

                x3 = ((x1 * fx2) - (x2 * fx1)) / (fx2 - fx1);
                fx3 = Math.exp(x3) - 3 * x3;
                JOptionPane.showMessageDialog(null, "Approx for iteration " + iteration + " is fx3 = " + fx3);

                //showing roots in from table and up to users choice of decimal places
                if (decimal == 1) {

                    TA.append("x1= " + String.format("%.1f", x1) + "       " + "fx1 = " + String.format("%.1f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.1f", x2) + "       " + "fx2 = " + String.format("%.1f", fx2) + "      ");
                    TA.append("x3= " + String.format("%.1f", x3) + "       " + "fx3 = " + String.format("%.1f", fx3) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.1f", x3) + "\n");
                } else if (decimal == 2) {

                    TA.append("x1= " + String.format("%.2f", x1) + "       " + " fx1 = " + String.format("%.2f", fx1) + "     ");
                    TA.append("x2= " + String.format("%.2f", x2) + "       " + "fx2 = " + String.format("%.2f", fx2) + "      ");
                    TA.append("x3= " + String.format("%.2f", x3) + "       " + "fx3 = " + String.format("%.2f", fx3) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.2f", x3) + "\n");
                } else if (decimal == 3) {

                    TA.append("x1= " + String.format("%.3f", x1) + "       " + "fx1 = " + String.format("%.3f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.3f", x2) + "       " + "fx2 = " + String.format("%.3f", fx2) + "     ");
                    TA.append("x3= " + String.format("%.3f", x3) + "       " + "fx3 = " + String.format("%.3f", fx3) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.3f", x3) + "\n");
                } else if (decimal == 4) {

                    TA.append("x1= " + String.format("%.4f", x1) + "       " + "fx1 = " + String.format("%.4f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.4f", x2) + "       " + "fx2 = " + String.format("%.4f", fx2) + "     ");
                    TA.append("x3= " + String.format("%.4f", x3) + "       " + "fx3 = " + String.format("%.4f", fx3) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.4f", x3) + "\n");
                } else if (decimal == 5) {

                    TA.append("x1= " + String.format("%.5f", x1) + "       " + "fx1 = " + String.format("%.5f", fx1) + "   ");
                    TA.append("x2= " + String.format("%.5f", x2) + "       " + "fx2 = " + String.format("%.5f", fx2) + "    ");
                    TA.append("x3= " + String.format("%.5f", x3) + "       " + "fx3 = " + String.format("%.5f", fx3) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.5f", x3) + "\n");
                } else if (decimal == 6) {

                    TA.append("x1= " + String.format("%.6f", x1) + "       " + "fx1 = " + String.format("%.6f", fx1) + "    ");
                    TA.append("x2= " + String.format("%.6f", x2) + "       " + "fx2 = " + String.format("%.6f", fx2) + "     ");
                    TA.append("x3= " + String.format("%.6f", x3) + "       " + "fx3 = " + String.format("%.6f", fx3) + "      ");
                    TA.append("Approx for iteration " + iteration + " is " + String.format("%.6f", x3) + "\n");
                } else {

                    TA.append("fx1 = " + String.format("%.1f", fx1) + "     ");
                    TA.append("fx2 = " + String.format("%.1f", fx2) + "     ");

                    TA.append("Approx for iteration " + iteration + " is " + (fx3) + "\n");
                }
                diff = Math.abs(x3 - x1);
                if ((fx1 < 0 && fx2 < 0) || (fx1 > 0 && fx2 > 0) || (fx3 == 0)) {
                    TA.append(" Solution not possible , because fx1 and fx2 have same signs.");
                    break;
                }
                x2 = x1;
                x1 = x3;


            } while (diff > 0.01);
            eq1.add(x3);
            if (decimal == 1 && (fx1 < 0 || fx2 < 0)) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.1f", x3));
            } else if (decimal == 2) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.2f", x3));
            } else if (decimal == 3) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.3f", x3));
            } else if (decimal == 4) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.4f", x3));
            } else if (decimal == 5) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.5f", x3));
            } else if (decimal == 6) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.6f", x3));
            } else if (decimal == 7) {
                TA.append(" Root to " + decimal + " decimal places is " + String.format("%.7f", x3));
            }


        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}




