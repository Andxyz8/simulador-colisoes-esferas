import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Collider extends JFrame {
    // Declaração das variáveis
    private JButton jButton_AddBall;
    private JButton jButton_RemBall;
    private JButton jButton_Start;
    private JButton jButton_Stop;
    private JLabel jLabel_ArenaTitle;
    private JLabel jLabel_BallCount;
    private Arena Rinha;

    public Collider() {

    }

    public Collider(int w, int h, int n) {
        Rinha = new Arena(n);
        Rinha.setNumBall(n);

        initComponents();

        this.setSize(w, h);
        this.setResizable(false);

        jLabel_BallCount.setText(Integer.toString(Rinha.getNumBall()));

        this.setVisible(true);
    }

    public void iniciar() {
        Rinha.createBalls();
        Rinha.start();
    }

    private void initComponents() {
        // Código gerado automaticamente pelo Netbeans.
        jButton_Start = new JButton();
        jButton_Stop = new JButton();
        jButton_RemBall = new JButton();
        jButton_AddBall = new JButton();
        jLabel_BallCount = new JLabel();
        jLabel_ArenaTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ball Collider Simulator 2021");
        setName("Collisor"); // NOI18N

        Rinha.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 3));
        Rinha.setName("Arena"); // NOI18N
        Rinha.setPreferredSize(new java.awt.Dimension(780, 342));

        GroupLayout jPanel_ArenaLayout = new GroupLayout(Rinha);
        Rinha.setLayout(jPanel_ArenaLayout);
        jPanel_ArenaLayout.setHorizontalGroup(
                jPanel_ArenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        jPanel_ArenaLayout.setVerticalGroup(
                jPanel_ArenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 359, Short.MAX_VALUE));

        jButton_Start.setText("Start");
        jButton_Start.setToolTipText("Start colisions with 2 balls");
        jButton_Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_StartActionPerformed(evt);
            }
        });

        jButton_Stop.setText("Stop");
        jButton_Stop.setToolTipText("Stop ALL balls");
        jButton_Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_StopActionPerformed(evt);
            }
        });

        jButton_RemBall.setText("Rem Ball");
        jButton_RemBall.setToolTipText("Remove a ball");
        jButton_RemBall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_RemBallActionPerformed(evt);
            }
        });

        jButton_AddBall.setText("Add Ball");
        jButton_AddBall.setToolTipText("Add a ball");
        jButton_AddBall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_AddBallActionPerformed(evt);
            }
        });

        jLabel_BallCount.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel_BallCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_BallCount.setText("0");
        jLabel_BallCount.setAlignmentX(0.5F);
        jLabel_BallCount.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ball Count",
                javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new Font("Tahoma", 0, 18))); // NOI18N

        jLabel_ArenaTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ArenaTitle.setText("Collision Arena");
        jLabel_ArenaTitle.setToolTipText("This is just a title");
        jLabel_ArenaTitle.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(12, 12, 12)
                        .addComponent(Rinha, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE).addGap(12, 12, 12))
                .addGroup(layout.createSequentialGroup().addContainerGap(110, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_Start, GroupLayout.PREFERRED_SIZE, 100,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Stop, GroupLayout.PREFERRED_SIZE, 100,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_BallCount, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_AddBall, GroupLayout.PREFERRED_SIZE, 100,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_RemBall, GroupLayout.PREFERRED_SIZE, 100,
                                        GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(110, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_ArenaTitle, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(jLabel_ArenaTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rinha, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addComponent(jButton_Start).addGap(18, 18, 18)
                                        .addComponent(jButton_Stop))
                                .addComponent(jLabel_BallCount)
                                .addGroup(layout.createSequentialGroup().addComponent(jButton_AddBall)
                                        .addGap(18, 18, 18).addComponent(jButton_RemBall)))
                        .addGap(5, 5, 5)));

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton_StopActionPerformed(ActionEvent evt) {
        Rinha.stop();
    }

    private void jButton_StartActionPerformed(ActionEvent evt) {
        Rinha.start();
    }

    private void jButton_AddBallActionPerformed(ActionEvent evt) {
        Rinha.addBall();
        jLabel_BallCount.setText(Integer.toString(Rinha.getNumBall()));
    }

    private void jButton_RemBallActionPerformed(ActionEvent evt) {
        Rinha.remBall();
        jLabel_BallCount.setText(Integer.toString(Rinha.getNumBall()));
    }
}
