import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int w, h, n;
        w = Integer.parseInt(JOptionPane.showInputDialog(null, args, "Largura da tela", JOptionPane.QUESTION_MESSAGE));
        h = Integer.parseInt(JOptionPane.showInputDialog(null, args, "Altura da tela", JOptionPane.QUESTION_MESSAGE));
        n = Integer.parseInt(JOptionPane.showInputDialog(null, args, "Num bolas início", JOptionPane.QUESTION_MESSAGE));

        Collider Collider = new Collider(w, h, n);
        Collider.iniciar();
    }
}
