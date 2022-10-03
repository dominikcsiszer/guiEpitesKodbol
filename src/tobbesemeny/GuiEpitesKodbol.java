package tobbesemeny;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class RajzPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        int piros = (int)(Math.random() * 255);
        int zold = (int)(Math.random() * 255);
        int kek = (int)(Math.random() * 255);
        Color kezdoSzin = new Color(piros, zold, kek);
        
        piros = (int)(Math.random() * 255);
        zold = (int)(Math.random() * 255);
        kek = (int)(Math.random() * 255);
        Color vegzoSzin = new Color(piros, zold, kek);
        GradientPaint szinatmenet = new GradientPaint(50, 50, kezdoSzin, 150, 150, vegzoSzin);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(szinatmenet);
        g2d.fillOval(55, 55, 80, 80);
    }
   
    
}

        public class GuiEpitesKodbol{

    private JFrame frame;
    private JButton btnKitoltes, btnKeret;
    private RajzPanel panel;
    private JLabel cimke;
    
    public GuiEpitesKodbol(){
        ini();
    }
    public void ini(){
        frame = new JFrame("GUI elrendezéssel");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnKitoltes = new JButton("Új kitöltés");
        
        btnKeret = new JButton("keret");
        
        cimke = new JLabel("<html><p style='color:red;'>Van</p> keret</html>");
        
        panel = new RajzPanel();
        
        panel.setBorder(new TitledBorder("Kör"));
        
        frame.getContentPane().add(btnKitoltes, BorderLayout.SOUTH);
        frame.getContentPane().add(btnKeret, BorderLayout.EAST);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(cimke, BorderLayout.WEST);
        
        frame.setVisible(true);
    }
    
    class KitoltesListener implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent e) {
            frame.repaint();
    
        
    }
    }
    class KeretListener implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent e) {
        String s = "<html><p style='color:red;'>";
            if(panel.getBorder() instanceof TitledBorder){
                panel.setBorder(null);
            }else{
                panel.setBorder(new TitledBorder("Kör"));
                s += "Van";
            }
            s += "</p> keret</html>";
            cimke.setText(s);
            
        }
    }
    
    public static void main(String[] args) {
        new GuiEpitesKodbol();
        
        
    }

    
    }
