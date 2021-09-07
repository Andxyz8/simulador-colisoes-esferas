import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int w = Integer
                .parseInt(JOptionPane.showInputDialog(null, args, "Largura da tela", JOptionPane.QUESTION_MESSAGE));
        int h = Integer
                .parseInt(JOptionPane.showInputDialog(null, args, "Altura da tela", JOptionPane.QUESTION_MESSAGE));
        int n = Integer
                .parseInt(JOptionPane.showInputDialog(null, args, "Num bolas início", JOptionPane.QUESTION_MESSAGE));

        Collider Collider = new Collider(w, h, n);
        Collider.iniciar();
    }
}
