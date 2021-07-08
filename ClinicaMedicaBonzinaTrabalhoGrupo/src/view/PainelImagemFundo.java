package view;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PainelImagemFundo extends javax.swing.JPanel {

    private ImageIcon img;

    public PainelImagemFundo() {
        img = new ImageIcon();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public ImageIcon getImg() {
        return this.img;
    }

}
